package com.avatar.models.dto;

import com.avatar.models.enums.EventStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateFrom;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateTo;
    private boolean dateFlag;
    private EventStatus systemStatus;

    public EventDto(String name, Date dateTimeStart, Date dateTimeFinish, boolean dateFlag) {
        this.name = name;
        this.dateFrom = dateTimeStart;
        this.dateTo = dateTimeFinish;
    }
}