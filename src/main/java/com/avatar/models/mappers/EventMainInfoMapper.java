package com.avatar.models.mappers;

import com.avatar.models.dto.EventMainInfoDto;
import com.avatar.models.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Date;

@Mapper
public interface EventMainInfoMapper {
    EventMainInfoMapper INSTANCE = Mappers.getMapper(EventMainInfoMapper.class);

    @Mapping(source = "event.activityType", target = "typeOfActivity")
    @Mapping(source = "dateFrom", target = "dateFrom")
    @Mapping(source = "dateTo", target = "dateTo")
    @Mapping(dateFormat = "HH:mm", source = "event.dateTimeStart", target = "timeFrom")
    @Mapping(source = "timeTo", target = "timeTo")
    @Mapping(source = "event.dateApproximate", target = "dateFlag")
    @Mapping(source = "event.eventStatus", target = "systemStatus")
    EventMainInfoDto EventToEventMainInfoDto (Event event, String dateFrom, String dateTo, String timeFrom, String timeTo);

    @Mapping(source = "dto.typeOfActivity", target = "activityType")
    @Mapping(source = "dateFrom", target = "dateTimeStart")
    @Mapping(source = "dateTo", target = "dateTimeFinish")
    @Mapping(source = "dto.dateFlag", target = "dateApproximate")
    @Mapping(source = "dto.systemStatus", target = "eventStatus")
    @Mapping(target = "dto.organiserId", ignore = true)
    @Mapping(target = "dto.site", ignore = true)
    @Mapping(target = "dto.preview", ignore = true)
    @Mapping(target = "dto.participants", ignore = true)
    Event EventMainInfoDtoToEvent (EventMainInfoDto dto, Date dateFrom, Date dateTo);
}
