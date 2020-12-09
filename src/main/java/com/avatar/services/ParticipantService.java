package com.avatar.services;

import com.avatar.models.dto.MemberDto;
import com.avatar.models.dto.ParticipantDto;
import com.avatar.models.entities.Event;
import com.avatar.models.entities.Participant;
import com.avatar.models.entities.Preview;
import com.avatar.models.mappers.MemberMapper;
import com.avatar.models.mappers.ParticipantMapper;
import com.avatar.repositories.EventRepo;
import com.avatar.repositories.ParticipantRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ParticipantService {
    final private EventRepo eventRepo;
    final private ParticipantRepo participantRepo;

    public MemberDto getMembersInfo(UUID eventId) {
        Event event = eventRepo.findById(eventId).orElseThrow(NullPointerException::new);
        Preview preview = Optional.ofNullable(event.getPreview()).orElse(new Preview(event));
        List<Participant> participants = Optional.ofNullable(event.getParticipants()).orElse(new ArrayList<>());
        return MemberMapper.INSTANCE.ParticipantToMemberDto(preview, participantsToDto(participants));
    }

    public void updateMembersInfo(UUID eventId, MemberDto memberDto) {
        Event event = eventRepo.findById(eventId).orElseThrow(NullPointerException::new);
        Preview preview = Optional.ofNullable(event.getPreview()).orElse(new Preview(event));
        if (!StringUtils.isEmpty(memberDto.getInvited())) preview.setParticipants(memberDto.getInvited());
        if (!StringUtils.isEmpty(memberDto.getContact())) preview.setContactPerson(memberDto.getContact());
        if (!StringUtils.isEmpty(memberDto.getOrganisers())) preview.setOrganisers(memberDto.getSideOrganizers());
        event.setPreview(preview);
        if (!CollectionUtils.isEmpty(memberDto.getOrganisers())) {
            List<Participant> participants = participantDtosToParticipants(memberDto.getOrganisers(), event);
            addEventParticipants(participants);
        }
        eventRepo.save(event);
    }

    public void addEventParticipants (List<Participant> participants) {
        participants.forEach(participant -> {
            if (participant.getId() == null) {
                participantRepo.save(participant);
            }});

    }

    private List<ParticipantDto> participantsToDto(List<Participant> participants) {
        if (CollectionUtils.isEmpty(participants)) return new ArrayList<>();
        List<ParticipantDto> participantDtos = new ArrayList<>();
        participants.forEach(participant -> participantDtos.add(ParticipantMapper.INSTANCE.participantToDto(participant)));
        return participantDtos;
    }

    private List<Participant> participantDtosToParticipants(List<ParticipantDto> participantDtos, Event event) {
        if (CollectionUtils.isEmpty(participantDtos)) return new ArrayList<>();
        List<Participant> participants = new ArrayList<>();
        participantDtos.forEach(participantDto -> participants.add(ParticipantMapper.INSTANCE.participantDtoToParticipant(participantDto, event)));
        return participants;
    }

}
