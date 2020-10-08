package com.avatar.services;

import com.avatar.models.bean.SearchParam;
import com.avatar.models.dto.EventDto;
import com.avatar.models.entities.Event;
import com.avatar.models.enums.EventStatus;
import com.avatar.repositories.EventRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EventService {
    private final EventRepo eventRepo;

    public UUID create(Event event) {
        event.setEventStatus(EventStatus.DRAFT);
        return eventRepo.save(event).getId();
    }

    public Event updateEvent(Event inputEvent, UUID eventId) {
        Event dbEvent = eventRepo.findById(eventId).orElseThrow(NullPointerException::new);
        BeanUtils.copyProperties(inputEvent, dbEvent, "id", "organiserId", "eventStatus");
        return eventRepo.save(dbEvent);
    }

    public Page<Event> getPageOfEvents(SearchParam params) {
        List<EventStatus> eventStatuses;
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
        eventList.forEach(event -> eventDtoList.add(transformToEventDto(event)));
        return eventDtoList;
    }

    public EventDto transformToEventDto(Event event) {
        return new EventDto(event.getId(), event.getName(), event.getDateTimeStart(), event.getDateTimeFinish(), event.getEventStatus());
    }
}
