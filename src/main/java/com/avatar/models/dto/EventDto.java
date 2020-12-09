package com.avatar.models.dto;

import com.avatar.models.enums.EventStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private UUID id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String dateFrom;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String dateTo;
    private boolean dateFlag;
    private EventStatus systemStatus;
}
