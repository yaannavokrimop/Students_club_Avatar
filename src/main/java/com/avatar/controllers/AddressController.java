package com.avatar.controllers;

import com.avatar.models.dto.AddressDto;
import com.avatar.models.entities.Address;
import com.avatar.repositories.AddressRepo;
import com.avatar.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.DateTimeException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/address")
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/all/{id}")
    public ResponseEntity getAddresses (@PathVariable("id") UUID eventId) {
        try {
            List<AddressDto> addresses = addressService.getAddresses(eventId);
            return ResponseEntity.ok(addresses);
        } catch (NullPointerException ex) {
            return ResponseEntity.badRequest().body("Мероприятие не найдено.");
        }
    }

    @PostMapping("/add/{id}")
    public ResponseEntity addAddress(@PathVariable("id") UUID eventId, @RequestBody AddressDto addressDto) {
        try {
            addressService.addAddress(addressDto, eventId);
            return ResponseEntity.ok("Адрес сохранен успешно.");
        } catch (NullPointerException ex) {
            return ResponseEntity.badRequest().body("Мероприятие не найдено.");
        } catch (ParseException | DateTimeException ex) {
            return ResponseEntity.badRequest().body("Дата введена неверно.");
        }
    }
}
