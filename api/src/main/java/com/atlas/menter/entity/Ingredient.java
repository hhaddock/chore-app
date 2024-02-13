package com.atlas.menter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import java.io.Serializable;

@Entity
@Table(name = "ingredient")
@Getter
@Setter
public class Ingredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name="recipe_id", nullable=false)
    @JsonIgnore
    private Recipe recipe;

    @Column(name = "name")
    private String name;

    @Column(name = "units")
    private String units;

    @Column(name = "amount")
    private Double amount;

    public Ingredient(){}

    public Ingredient(String name, String units, Double amount){
        this.name = name;
        this.units = units;
        this.amount = amount;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
