package com.avatar.models.entities.claims;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

@Entity
@Data
@Table(name = "claim_transport")
public class Transport {
    @Id
    @GeneratedValue
    @JsonIgnore
    UUID id;

    String organiser;
    String contactInfo;
    String aim;
    String car;
    String cargoType;
    Date date;
    Time timeStart;
    Time timeFinish;
    String route;
}
