package com.avatar.models.mappers;

import com.avatar.models.dto.ParticipantDto;
import com.avatar.models.entities.Event;
import com.avatar.models.entities.Participant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParticipantMapper {
    ParticipantMapper INSTANCE = Mappers.getMapper(ParticipantMapper.class);

    @Mapping(source = "isuId", target = "number")
    ParticipantDto participantToDto (Participant participant);

    @Mapping(source = "dto.number", target = "isuId")
    @Mapping(source = "event", target = "event")
    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.id", target = "id")
    Participant participantDtoToParticipant (ParticipantDto dto, Event event);
}
