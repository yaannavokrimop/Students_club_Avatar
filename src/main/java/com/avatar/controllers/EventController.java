package com.avatar.controllers;

import com.avatar.models.bean.SearchParam;
import com.avatar.models.dto.EventDto;
import com.avatar.models.entities.Event;
import com.avatar.services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/event")
@AllArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping
    public ResponseEntity<UUID> createEvent(@RequestBody Event event) {
        UUID eventId = eventService.create(event);
        return ResponseEntity.ok(eventId);
    }

    @PostMapping("/list")
    public ResponseEntity<List<EventDto>> getEventList(@RequestBody SearchParam params) {
        Page<Event> eventPage = eventService.getPageOfEvents(params);
        List<EventDto> eventDtoList= eventService.transformToEventDtoList(eventPage.getContent());
        return ResponseEntity.ok(eventDtoList);
    }

    @PutMapping("/main/{id}")
    public ResponseEntity<String> updateEventMainInfo (@RequestBody Event inputEvent, @PathVariable("id") UUID eventId) {
        try {
            eventService.updateEvent(inputEvent, eventId);
            return ResponseEntity.ok("Изменения сохранены успешно.");
        } catch (NullPointerException ex) {
            return ResponseEntity.badRequest().body("Указан неверный Id мероприятия.");
        }
    }
}
