package com.avatar.services;

import com.avatar.models.bean.SearchParam;
import com.avatar.models.dto.EventDto;
import com.avatar.models.entities.Event;
import com.avatar.models.enums.EventStatus;
import com.avatar.models.mappers.EventMapper;
import com.avatar.repositories.EventRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EventService {
    private final EventRepo eventRepo;

    public UUID create(EventDto eventDto) {
        Event event = new Event();
        event.setEventStatus(EventStatus.DRAFT);
        event.setName(eventDto.getName());
        event.setDateTimeStart(eventDto.getDateFrom());
        event.setDateTimeFinish(eventDto.getDateTo());
        event.setDateApproximate(eventDto.isDateFlag());
        return eventRepo.save(event).getId();
    }

    public EventDto getEventMainInfoById(UUID eventID) {
        Event event = eventRepo.findById(eventID).orElseThrow(NullPointerException::new);
        EventDto eventDto = EventMapper.INSTANCE.EventToEventDto(event);
//        EventDto eventDto = transformToEventDto(event);
//        eventDto.setShortName(event.getShortName());
//        eventDto.setStatus(event.getStatus());
//        eventDto.setType(event.getType());
//        eventDto.setTypeOfActivity(event.getActivityType());
        return eventDto;
    }

    public Event updateEventMainInfo(EventDto eventDto, UUID eventId) {
        Event dbEvent = eventRepo.findById(eventId).orElseThrow(NullPointerException::new);
        Event inputEvent = transformToEvent(eventDto);
        BeanUtils.copyProperties(inputEvent, dbEvent, "id", "organiserId", "eventStatus", "characteristics", "preRelease");
        return eventRepo.save(dbEvent);
    }

    public Page<Event> getPageOfEvents(SearchParam params) {
        List<EventStatus> eventStatuses;
        if (params == null) {
            return eventRepo.findAll(Pageable.unpaged());
        }
        if (CollectionUtils.isEmpty(params.getStatusList())) {
            eventStatuses = null;
        } else {
            eventStatuses = params.getStatusList();
        }
        Integer organiserId;
// change organiserId
        if (params.getOnlyPersonal()) {
            organiserId = 225077;
        } else organiserId = null;
        Date dateStart = params.getDateStart();
        if (params.getDateStart() == null) {
            dateStart = new Date(-2201817600L); //ITMO creation date
        }
        if (params.getDateFinish() == null) {
// add page
            return eventRepo.findAllByParams(eventStatuses, dateStart, organiserId, Pageable.unpaged());
        } else {
// add page
            return eventRepo.findAllByParamsAndDateTimeFinish(eventStatuses, dateStart, params.getDateFinish(), organiserId, Pageable.unpaged());
        }

    }

    public List<EventDto> transformToEventDtoList(List<Event> eventList) {
        List<EventDto> eventDtoList = new ArrayList<>();
        eventList.forEach(event -> eventDtoList.add(EventMapper.INSTANCE.EventToEventDto(event)));
        return eventDtoList;
    }

//    public EventDto transformToEventDto(Event event) {
//        EventDto eventDto = new EventDto(event.getName(), event.getDateTimeStart(), event.getDateTimeFinish(), event.isDateApproximate());
//        eventDto.setId(event.getId());
//        eventDto.setEventStatus(event.getEventStatus());
//        return eventDto;
//    }

    public Event transformToEvent(EventDto eventDto) {
        Event event = new Event(eventDto.getName(), eventDto.getDateFrom(), eventDto.getDateTo());
        event.setShortName(eventDto.getShortName());
        event.setStatus(eventDto.getStatus());
        event.setType(eventDto.getType());
        event.setActivityType(eventDto.getTypeOfActivity());
        return event;
    }
}
