package com.avatar.services;

import com.avatar.models.dto.MemberDto;
import com.avatar.models.entities.Event;
import com.avatar.models.entities.Participant;
import com.avatar.models.entities.Preview;
import com.avatar.models.mappers.MemberMapper;
import com.avatar.repositories.EventRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ParticipantService {
    final private EventRepo eventRepo;

    public MemberDto getParticipantInfo(UUID eventId) {
        Event event = eventRepo.findById(eventId).orElseThrow(NullPointerException::new);
        Preview preview = Optional.ofNullable(event.getPreview()).orElse(new Preview(event));
        List<Participant> participants = Optional.ofNullable(event.getParticipants()).orElse(new ArrayList<>());
        return MemberMapper.INSTANCE.ParticipantToMemberDto(preview, participants);
    }

    public void updateParticipantInfo(UUID eventId, MemberDto memberDto) {
        Event event = eventRepo.findById(eventId).orElseThrow(NullPointerException::new);
        Preview preview = Optional.ofNullable(event.getPreview()).orElse(new Preview(event));
        preview.setParticipants(memberDto.getInvited());
        preview.setContactPerson(memberDto.getContact());
        preview.setOrganisers(memberDto.getSideOrganizers());
        event.setParticipants(memberDto.getOrganisers());
        eventRepo.save(event);
    }
}
