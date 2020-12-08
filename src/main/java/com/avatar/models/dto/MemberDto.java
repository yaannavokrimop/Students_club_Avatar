package com.avatar.models.dto;

import com.avatar.models.entities.Participant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private String invited;
    private String contact;
    private String sideOrganizers;
    private List<Participant> organisers;
}
