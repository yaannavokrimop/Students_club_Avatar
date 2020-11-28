package com.avatar.controllers;

import com.avatar.models.dto.PreviewDto;
import com.avatar.services.PreviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/preview")
@AllArgsConstructor
public class PreviewController {
    public final PreviewService previewService;

    @GetMapping("/{id}")
    public ResponseEntity getPreview(@PathVariable("id") UUID eventId) {
        try {
            PreviewDto previewDto = previewService.getPreview(eventId);
            return ResponseEntity.ok(previewDto);
        } catch (NullPointerException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Мероприятие не найдено.");
        }
    }
}
