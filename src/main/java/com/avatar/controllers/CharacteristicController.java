package com.avatar.controllers;

import com.avatar.models.entities.Characteristic;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/characteristic")
public class CharacteristicController {

    @PostMapping("/add/{id}")
    public ResponseEntity addCharacteristics(@PathVariable("id") UUID eventId, @RequestBody List<Characteristic> characteristics) {

        return ResponseEntity.ok(eventId);
    }
}
