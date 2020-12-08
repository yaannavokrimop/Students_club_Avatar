package com.avatar.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacteristicDto {
    private int membersNumber;
    private String periodicity;
    private String category;
    private String publicity;
    private String format;
    private String language;
}
