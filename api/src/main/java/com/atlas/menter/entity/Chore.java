package com.atlas.menter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "chore")
@Getter
@Setter
public class Chore implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    public String name;

    @Column(name = "description")
    public String description;

    // Type --> Kitchen, Bathroom, Bedroom
    @Column(name = "type")
    public String type;

    // Frequency --> Daily, Weekly, Monthly
    @Column(name = "frequency")
    public String frequency;
}
