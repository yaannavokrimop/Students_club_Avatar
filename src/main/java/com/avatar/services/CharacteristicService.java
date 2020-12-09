package com.avatar.services;

import com.avatar.models.dto.CharacteristicDto;
import com.avatar.models.entities.Characteristic;
import com.avatar.models.entities.Event;
import com.avatar.models.mappers.CharacteristicMapper;
import com.avatar.repositories.CharacteristicRepo;
import com.avatar.repositories.EventRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CharacteristicService {
    private  final EventRepo eventRepo;
    private final CharacteristicRepo characteristicRepo;

    public void addCharacteristics (CharacteristicDto characteristicDto, UUID eventId) {
        Event event = eventRepo.findById(eventId).orElseThrow(NullPointerException::new);
        Characteristic characteristic = CharacteristicMapper.INSTANCE.CharacteristicDtoToCharacteristic(characteristicDto, event);
        characteristicRepo.save(characteristic);
    }

    public CharacteristicDto getCharacteristic(UUID eventId) {
        Event event = eventRepo.findById(eventId).orElseThrow(NullPointerException::new);
        Characteristic characteristic = event.getCharacteristic();
        return CharacteristicMapper.INSTANCE.CharacteristicToDto(characteristic);
    }
}
