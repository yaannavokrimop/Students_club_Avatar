package com.avatar.controllers;

import com.avatar.models.dto.MemberDto;
import com.avatar.services.ParticipantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/member")
@AllArgsConstructor
public class ParticipantController {
    private final ParticipantService participantService;

    @GetMapping("/event/{id}")
    public ResponseEntity getParticipantInfo(@PathVariable("id")UUID eventId){
        try {
            MemberDto memberDto = participantService.getParticipantInfo(eventId);
            return ResponseEntity.ok(memberDto);
        } catch (NullPointerException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Мероприятие не найдено.");
        }
    }

    @PutMapping("/event/{id}")
    public ResponseEntity updateParticipantInfo(@PathVariable("id") UUID eventId, @RequestBody MemberDto memberDto) {
        try {
            participantService.updateParticipantInfo(eventId, memberDto);
            return ResponseEntity.ok("Данные сохранены успешно.");
        } catch (NullPointerException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Мероприятие не найдено.");
        }
    }
}
