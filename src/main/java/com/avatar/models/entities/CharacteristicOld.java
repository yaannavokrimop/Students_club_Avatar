/*
package com.avatar.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="characteristics")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Characteristic {
    @Id
    @GeneratedValue
    @JsonIgnore
    private UUID id;

    @OneToMany(mappedBy = "characteristic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EventCharacteristic> events;

    private String name;

    @Type(type = "list-array")
    @Column(name = "values", columnDefinition = "varchar(255)[]")
    private List<String> values;

    private boolean required;
}

*/
