package com.avatar.controllers.claims;

import com.avatar.models.dto.AddressDto;
import com.avatar.models.entities.claims.Transport;
import com.avatar.services.claims.TransportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.DateTimeException;
import java.util.UUID;

@RestController
@RequestMapping("/api/claim/transport")
@AllArgsConstructor
public class TransportController {
    private final TransportService transportService;

    @PostMapping("/add/{id}")
    public ResponseEntity addTransportClaim(@PathVariable("id") UUID eventId, @RequestBody Transport transportClaim) {
        try {
            transportService.addTransportClaim(transportClaim, eventId);
            return ResponseEntity.ok("Заявка на транспорт создана успешно.");
        } catch (NullPointerException ex) {
            return ResponseEntity.badRequest().body("Мероприятие не найдено.");
        } /*catch (ParseException | DateTimeException ex) {
            return ResponseEntity.badRequest().body("Дата введена неверно.");
        }*/
    }


}
