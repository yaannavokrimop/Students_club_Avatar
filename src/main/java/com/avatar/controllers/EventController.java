package com.avatar.controllers;

import com.avatar.models.bean.SearchParam;
import com.avatar.models.dto.EventDto;
import com.avatar.models.entities.Event;
import com.avatar.services.DateService;
import com.avatar.services.EventService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/event")
@AllArgsConstructor
public class EventController {
    private final EventService eventService;
    private final DateService dateService;

    @PostMapping("/create")
    public ResponseEntity createEvent(@RequestBody EventDto eventDto) {
        try {
            dateService.checkDate(eventDto.getDateFrom(), eventDto.getDateTo());
        } catch (DateTimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
            UUID eventId = eventService.create(eventDto);
            return ResponseEntity.ok(eventId);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EventDto>> getAllEvent() {
        Page<Event> events = eventService.getPageOfEvents(null);
        List<EventDto> eventDtoList = eventService.transformToEventDtoList(events.getContent());
        return ResponseEntity.ok(eventDtoList);
    }

    @GetMapping("/mainInfo/{id}")
    public ResponseEntity getEventMainInfo(@PathVariable("id") UUID eventId) {
        try {
            EventDto eventDto = eventService.getEventMainInfoById(eventId);
            return ResponseEntity.ok(eventDto);
        } catch (NullPointerException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Мероприятие не найдено.");
        }
    }

    /*@PostMapping("/search")
    public ResponseEntity<List<EventDto>> getEventList(@RequestBody SearchParam params) {
        Page<Event> eventPage = eventService.getPageOfEvents(params);
        List<EventDto> eventDtoList= eventService.transformToEventDtoList(eventPage.getContent());
        return ResponseEntity.ok(eventDtoList);
    }*/

    @PutMapping("/mainInfo/{id}")
    public ResponseEntity<String> updateEventMainInfo (@RequestBody EventDto inputEvent, @PathVariable("id") UUID eventId) {
        try {
            eventService.updateEventMainInfo(inputEvent, eventId);
            return ResponseEntity.ok("Изменения сохранены успешно.");
        } catch (NullPointerException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Указан неверный Id мероприятия. Мероприятие не найдено.");
        }
    }
}
