package com.avatar.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "participants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participant {
    @Id
    @GeneratedValue
    @JsonIgnore
    private UUID id;

    private String isuId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="event_id")
    @JsonIgnore
    private Event event;

    private String role;
    private String comment;
}
