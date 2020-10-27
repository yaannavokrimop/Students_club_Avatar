package com.avatar.models.dto;

import com.avatar.models.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class EventDto {
    UUID id;
    String name;
    Date dateTimeStart;
    Date dateTimeFinish;
    EventStatus status;
}
