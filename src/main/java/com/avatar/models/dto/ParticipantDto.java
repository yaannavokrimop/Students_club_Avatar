package com.avatar.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantDto {
    private UUID id;
    private String number;
    private String name;
    private String role;
    private String comment;
}
