package com.avatar.models.mappers;

import com.avatar.models.dto.EventDto;
import com.avatar.models.dto.PreviewDto;
import com.avatar.models.entities.Event;
import com.avatar.models.entities.Preview;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PreviewMapper {
    PreviewMapper INSTANCE = Mappers.getMapper(PreviewMapper.class);

    @Mapping(source = "announcement", target = "shortDescription")
//    @Mapping(source = "description", target = "description")
    @Mapping(source = "aim", target = "purpose")
//    @Mapping(source = "tasks", target = "tasks")
//    @Mapping(source = "participants", target = )
//    @Mapping(source = "organisers", target = )
//    @Mapping(source = "contact_person", target = )
//    @Mapping(source = "", target = "site")
//    @Mapping(source = "comment", target = "comment")
    PreviewDto PreviewToPreviewDto (Preview preview);
}
