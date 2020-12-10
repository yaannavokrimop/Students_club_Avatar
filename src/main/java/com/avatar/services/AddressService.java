package com.avatar.services;

import com.avatar.models.dto.AddressDto;
import com.avatar.models.dto.ParticipantDto;
import com.avatar.models.entities.Address;
import com.avatar.models.entities.Event;
import com.avatar.models.entities.Participant;
import com.avatar.models.mappers.AddressMapper;
import com.avatar.models.mappers.ParticipantMapper;
import com.avatar.repositories.AddressRepo;
import com.avatar.repositories.EventRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.*;

@Service
@AllArgsConstructor
public class AddressService {
    private final DateService dateService;
    private final EventRepo eventRepo;
    private final AddressRepo addressRepo;

    public UUID addAddress (AddressDto addressDto, UUID eventId) throws ParseException {
        Event event = eventRepo.findById(eventId).orElseThrow(NullPointerException::new);
        Address address = addressDtoToAddress(addressDto, event);
        return addressRepo.save(address).getId();
    }

    public List<AddressDto> getAddresses(UUID eventId) {
        Event event = eventRepo.findById(eventId).orElseThrow(NullPointerException::new);
        List<Address> addresses = Optional.ofNullable(event.getAddresses()).orElse(new ArrayList<>());
        return addressesToDtos(addresses);
    }

    private AddressDto addressToDto(Address address) {
        String date = dateService.extractDate(address.getDateFrom());
        String timeFrom = dateService.extractTime(address.getDateFrom());
        String timeTo = dateService.extractTime(address.getDateTo());
        return AddressMapper.INSTANCE.AddressToDto(address, date, timeFrom, timeTo);
    }

    private Address addressDtoToAddress(AddressDto addressDto, Event event) throws ParseException {
        Date dateFrom = dateService.sumDateTime(addressDto.getDate(), addressDto.getTimeFrom());
        Date dateTo = dateService.sumDateTime(addressDto.getDate(), addressDto.getTimeTo());
        dateService.checkDate(dateFrom, dateTo);
        return AddressMapper.INSTANCE.AddressDtoToAddress(addressDto, dateFrom, dateTo, event);
    }

    private List<AddressDto> addressesToDtos(List<Address> addresses) {
        if (CollectionUtils.isEmpty(addresses)) return new ArrayList<>();
        List<AddressDto> addressDtos = new ArrayList<>();
        addresses.forEach(address -> addressDtos.add(addressToDto(address)));
        return addressDtos;
    }
}
