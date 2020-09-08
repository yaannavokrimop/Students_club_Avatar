package com.avatar.models.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue
    private long Id;

    private String Name;

    private String ShortName;

    private int TypeId;

    private int StatusId;

    private int MainLanguageId;
}
