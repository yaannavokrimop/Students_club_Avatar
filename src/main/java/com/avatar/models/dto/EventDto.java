package com.avatar.models.dto;

import com.avatar.models.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private UUID id;
    private String name;
    private String shortName;
    private String status;
    private String type;
    private String typeOfActivity;
    private Date dateFrom;
    private Date dateTo;
    private EventStatus eventStatus;

    public EventDto(String name, Date dateTimeStart, Date dateTimeFinish) {
        this.name = name;
        this.dateFrom = dateTimeStart;
        this.dateTo = dateTimeFinish;
    }
}