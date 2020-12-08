package com.avatar.models.mappers;

import com.avatar.models.dto.MemberDto;
import com.avatar.models.entities.Participant;
import com.avatar.models.entities.Preview;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    @Mapping(source = "preview.participants", target = "invited")
    @Mapping(source = "preview.contactPerson", target = "contact")
    @Mapping(source = "preview.organisers", target = "sideOrganizers")
    @Mapping(source = "participants", target = "organisers")
    MemberDto ParticipantToMemberDto (Preview preview, List<Participant> participants);
}
