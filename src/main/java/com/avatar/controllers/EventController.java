package com.avatar.controllers;

import com.avatar.models.dto.EventDto;
import com.avatar.models.dto.EventMainInfoDto;
import com.avatar.models.entities.Event;
import com.avatar.services.DateService;
import com.avatar.services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
            UUID eventId = eventService.create(eventDto);
            return ResponseEntity.ok(eventId);
        } catch (DateTimeException | ParseException ex) {
            return ResponseEntity.badRequest().body("Дата указана неверно.");
        }
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
            EventMainInfoDto eventMainInfoDto = eventService.getEventMainInfoById(eventId);
            return ResponseEntity.ok(eventMainInfoDto);
        } catch (NullPointerException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Мероприятие не найдено.");
        }
    }

    @PostMapping("/mainInfo/{id}")
    public ResponseEntity<String> updateEventMainInfo (@RequestBody EventMainInfoDto inputEvent, @PathVariable("id") UUID eventId) {
        try {
            eventService.updateEventMainInfo(inputEvent, eventId);
            return ResponseEntity.ok("Изменения сохранены успешно.");
        } catch (NullPointerException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Указан неверный Id мероприятия. Мероприятие не найдено.");
        } catch (DateTimeException | ParseException ex) {
            return ResponseEntity.badRequest().body("Дата указана неверно.");
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity deleteEvent(@PathVariable("id") UUID eventId) {
        try {
            eventService.deleteEvent(eventId);
            return ResponseEntity.ok("Черновик удалён.");
        }catch (NullPointerException ex) {
            return ResponseEntity.badRequest().body("Такого мероприятия нет.");
        }
    }

    /*@PostMapping("/search")
    public ResponseEntity<List<EventDto>> getEventList(@RequestBody SearchParam params) {
        Page<Event> eventPage = eventService.getPageOfEvents(params);
        List<EventDto> eventDtoList= eventService.transformToEventDtoList(eventPage.getContent());
        return ResponseEntity.ok(eventDtoList);
    }*/
}
