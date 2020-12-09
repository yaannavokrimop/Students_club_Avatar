package com.avatar.models.mappers;

import com.avatar.models.dto.PreviewDto;
import com.avatar.models.entities.Event;
import com.avatar.models.entities.Preview;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PreviewMapper {
    PreviewMapper INSTANCE = Mappers.getMapper(PreviewMapper.class);

    @Mapping(source = "preview.announcement", target = "shortDescription")
    @Mapping(source = "preview.aim", target = "purpose")
    @Mapping(source = "preview.event.site", target = "site")
    PreviewDto PreviewToPreviewDto (Preview preview);


    @Mapping(source = "event", target = "event")
    @Mapping(source = "event.preview.participants", target = "participants")
    @Mapping(target = "organisers", ignore = true)
    @Mapping(source = "event.id", target = "eventId")
    @Mapping(target = "contactPerson", ignore = true)
    @Mapping(source = "dto.shortDescription", target = "announcement")
    @Mapping(source = "dto.purpose", target = "aim")
    Preview PreviewDtoToPreview (PreviewDto dto, Event event);
}
