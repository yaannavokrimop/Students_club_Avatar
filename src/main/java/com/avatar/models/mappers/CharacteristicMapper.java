package com.avatar.models.mappers;

import com.avatar.models.dto.CharacteristicDto;
import com.avatar.models.entities.Characteristic;
import com.avatar.models.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CharacteristicMapper {
    CharacteristicMapper INSTANCE = Mappers.getMapper(CharacteristicMapper.class);

    @Mapping(source = "characteristic.event.id", target = "eventId")
    CharacteristicDto CharacteristicToDto (Characteristic characteristic);

    @Mapping(source = "event", target = "event")
    Characteristic CharacteristicDtoToCharacteristic (CharacteristicDto dto, Event event);
}
