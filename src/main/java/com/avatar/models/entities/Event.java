package com.avatar.models.entities;

import com.avatar.models.enums.EventStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@ToString(exclude = {"preview", "participants"})
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private int organiserId;

    @Column(nullable = false)
    private String name;

    private String shortName;

    private String type;

    private String status;

    private String activityType;

    @Column(nullable = false)

    private Date dateTimeStart;

    @Column(nullable = false)

    private Date dateTimeFinish;

    @Column(nullable = false)
    private boolean isDateApproximate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;

    private String site;

    /*@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Characteristic> characteristics;*/

    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private Preview preview;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Participant> participants;

    public Event(String name, Date dateFrom, Date dateTo, boolean isDateApproximate) {
        this.name = name;
        this.dateTimeStart = dateFrom;
        this.dateTimeFinish = dateTo;
        this.isDateApproximate = isDateApproximate;
    }
}
