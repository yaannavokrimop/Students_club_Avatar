package com.avatar.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreviewDto {
//    @JsonIgnore
//    private EventDto eventDto;
    private String shortDescription;
    private String description;
    private String purpose;
    private String tasks;
    private String site;
    private String comment;
}
