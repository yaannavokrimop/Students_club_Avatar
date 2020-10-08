package com.avatar.models.entities;

import com.avatar.models.enums.EventStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
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

    private String mainLanguage;

    private String activityType;

    private String category;

    private String publicity;

    private String format;

    @Column(nullable = false)
    private Date dateTimeStart;

    @Column(nullable = false)
    private Date dateTimeFinish;

    @Column(nullable = false)
    private boolean isDateApproximate;

    private String comment;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;
}
