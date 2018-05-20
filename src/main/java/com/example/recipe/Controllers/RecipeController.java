package com.example.recipe.Controllers;

import com.example.recipe.Domain.Recipe;
import com.example.recipe.commands.RecipeCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import com.example.recipe.services.recipeServise;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class RecipeController {

    private final recipeServise recipeServise;


    public RecipeController(com.example.recipe.services.recipeServise recipeServise) {
        this.recipeServise = recipeServise;
    }

    @GetMapping
    @RequestMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("recipe", recipeServise.findById(new Long(id)));
        return "recipe/show";
    }

    @GetMapping
    @RequestMapping("recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe",new RecipeCommand());

        return "recipe/recipeform";
    }

    @GetMapping
    @RequestMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id,Model model){

        model.addAttribute("recipe",recipeServise.findCommandById(Long.valueOf(id)));

        return "recipe/recipeform";
    }

    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command){
        RecipeCommand savedRecipeCommand=recipeServise.saveRecipeCommand(command);

        return "redirect:/recipe/" + savedRecipeCommand.getId() + "/show";
    }

    @GetMapping
    @RequestMapping("recipe/{id}/delete")
    public String deleteById(@PathVariable String id){

        recipeServise.deletedById( Long.valueOf(id));
        log.debug("Deleting id: " + id);
        return "redirect:/";
    }
}
