package com.avatar.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventMainInfoDto extends EventDto{

    private String shortName;
    private String status;
    private String type;
    private String typeOfActivity;

    @JsonFormat(pattern = "HH:mm")
    private String timeFrom;

    @JsonFormat(pattern = "HH:mm")
    private String timeTo;
}