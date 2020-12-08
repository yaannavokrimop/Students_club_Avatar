package com.avatar.models.mappers;

import com.avatar.models.dto.EventDto;
import com.avatar.models.dto.PreviewDto;
import com.avatar.models.entities.Event;
import com.avatar.models.entities.Preview;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper
public interface PreviewMapper {
    PreviewMapper INSTANCE = Mappers.getMapper(PreviewMapper.class);

    @Mapping(source = "preview.announcement", target = "shortDescription")
//    @Mapping(source = "description", target = "description")
    @Mapping(source = "preview.aim", target = "purpose")
//    @Mapping(source = "tasks", target = "tasks")
//    @Mapping(source = "participants", target = )
//    @Mapping(source = "organisers", target = )
//    @Mapping(source = "contact_person", target = )
    @Mapping(source = "preview.event.site", target = "site")
//    @Mapping(source = "comment", target = "comment")
    PreviewDto PreviewToPreviewDto (Preview preview);


    @Mapping(source = "event", target = "event")
//    @Mapping(source = "", target = "participants")
//    @Mapping(source = "", target = "organisers")
//    @Mapping(source = "event.id", target = "eventId")
//    @Mapping(source = "", target = "contactPerson")
    @Mapping(source = "dto.shortDescription", target = "announcement")
    @Mapping(source = "dto.purpose", target = "aim")
//    @Mapping(source = "dto.site", target = "event.site")
    Preview PreviewDtoToPreview (PreviewDto dto, Event event);
}
