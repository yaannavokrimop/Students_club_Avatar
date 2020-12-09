package com.avatar.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacteristicDto {
    private UUID eventId;
    private int membersNumber;
    private String periodicity;
    private String category;
    private String publicity;
    private String format;
    private String language;
}
