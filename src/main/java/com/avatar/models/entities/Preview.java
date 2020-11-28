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
public class Preview {
    @Id
    private UUID eventId;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private Event event;

    private String announcement;
    private String description;
    private String aim;
    private String tasks;
    private String participants;
    private String organisers;
    private String contactPerson;
    private String comment;

    public Preview (Event event) {
        this.event = event;
    }
}
