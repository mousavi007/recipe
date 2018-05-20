package com.example.recipe.Controllers;

import org.springframework.stereotype.Controller;
import com.example.recipe.services.recipeServise;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    private final recipeServise recipeServise;


    public RecipeController(com.example.recipe.services.recipeServise recipeServise) {
        this.recipeServise = recipeServise;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("recipe", recipeServise.findById(new Long(id)));
        return "recipe/show";
    }
}
