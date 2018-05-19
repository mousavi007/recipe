package com.example.recipe.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToMany(mappedBy = "category")
    private Set<Recipe> recipes;

}
