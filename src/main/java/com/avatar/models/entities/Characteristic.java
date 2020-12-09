package com.avatar.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Characteristic {
    @Id
    private UUID eventId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private int membersNumber;
    private String periodicity;
    private String category;
    private String publicity;
    private String format;
    private String language;
}
