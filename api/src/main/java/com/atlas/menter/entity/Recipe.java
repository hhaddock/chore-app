package com.atlas.menter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recipe")
@Getter
@Setter
public class Recipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    public String name;
    @Column(name = "description")
    public String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "recipe", cascade = CascadeType.ALL)
    public Set<Ingredient> ingredients = new HashSet<>();

    public Recipe(){}

    public Recipe(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        ingredients.forEach(ingredient -> {
            ingredient.setRecipe(this);
            this.ingredients.add(ingredient);
        });
    }

//    @Override
//    public String toString(){
//        return "["+this.id+"] "+ this.name + " : " + this.description;
//    }
}
