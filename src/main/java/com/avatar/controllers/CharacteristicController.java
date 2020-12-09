package com.avatar.controllers;

import com.avatar.models.dto.CharacteristicDto;
import com.avatar.models.entities.Characteristic;
import com.avatar.services.CharacteristicService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/characteristic")
@AllArgsConstructor
public class CharacteristicController {
    private final CharacteristicService characteristicService;

    @PostMapping("/add/{id}")
    public ResponseEntity addCharacteristics(@PathVariable("id") UUID eventId, @RequestBody CharacteristicDto characteristicDto) {
        try {
            characteristicService.addCharacteristics(characteristicDto, eventId);
            return ResponseEntity.ok("Характеристики сохранены успешно.");
        } catch (NullPointerException ex) {
            return ResponseEntity.badRequest().body("Мероприятие не найдено.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getCharacteristic(@PathVariable("id") UUID eventId) {
        try {
            CharacteristicDto response = characteristicService.getCharacteristic(eventId);
            return ResponseEntity.ok(response);
        } catch (NullPointerException ex) {
            return ResponseEntity.badRequest().body("Мероприятие не найдено.");
        }
    }
}
