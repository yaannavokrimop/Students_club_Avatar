package com.avatar.models.mappers;

import com.avatar.models.dto.AddressDto;
import com.avatar.models.entities.Address;
import com.avatar.models.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Date;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(source = "date", target = "date")
    @Mapping(source = "timeFrom", target = "timeFrom")
    @Mapping(source = "timeTo", target = "timeTo")
    AddressDto AddressToDto (Address address, String date, String timeFrom, String timeTo);

    @Mapping(source = "dateFrom", target = "dateFrom")
    @Mapping(source = "dateTo", target = "dateTo")
    @Mapping(source="event", target = "event")
    Address AddressDtoToAddress(AddressDto dto, Date dateFrom, Date dateTo, Event event);
}
