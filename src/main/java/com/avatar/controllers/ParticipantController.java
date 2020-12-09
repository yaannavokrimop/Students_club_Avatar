package com.avatar.controllers;

import com.avatar.models.dto.MemberDto;
import com.avatar.services.ParticipantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/members")
@AllArgsConstructor
public class ParticipantController {
    private final ParticipantService participantService;

    @GetMapping("/event/{id}")
    public ResponseEntity getParticipantInfo(@PathVariable("id")UUID eventId){
        try {
            MemberDto memberDto = participantService.getMembersInfo(eventId);
            return ResponseEntity.ok(memberDto);
        } catch (NullPointerException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Мероприятие не найдено.");
        }
    }

    @PostMapping("/event/{id}")
    public ResponseEntity updateParticipantInfo(@PathVariable("id") UUID eventId, @RequestBody MemberDto memberDto) {
        try {
            participantService.updateMembersInfo(eventId, memberDto);
            return ResponseEntity.ok("Данные сохранены успешно.");
        } catch (NullPointerException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Мероприятие не найдено.");
        }
    }
}
