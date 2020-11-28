package com.avatar.models.mappers;

import com.avatar.models.dto.EventDto;
import com.avatar.models.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventMapper {
    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    @Mapping(source = "activityType", target = "typeOfActivity")
    @Mapping(source = "dateTimeStart", target = "dateFrom")
    @Mapping(source = "dateTimeFinish", target = "dateTo")
    @Mapping(source = "dateApproximate", target = "dateFlag")
    EventDto EventToEventDto (Event event);

    @Mapping(source = "typeOfActivity", target = "activityType")
    @Mapping(source = "dateFrom", target = "dateTimeStart")
    @Mapping(source = "dateTo", target = "dateTimeFinish")
    @Mapping(source = "dateFlag", target = "dateApproximate")
    Event EventDtoToEvent (EventDto eventDto);
}
