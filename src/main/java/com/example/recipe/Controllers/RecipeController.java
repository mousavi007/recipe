package com.example.recipe.Controllers;

import com.example.recipe.exceptions.NotFoundExceptions;
import com.example.recipe.commands.RecipeCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import com.example.recipe.services.recipeServise;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class RecipeController {

    private final recipeServise recipeServise;


    public RecipeController(com.example.recipe.services.recipeServise recipeServise) {
        this.recipeServise = recipeServise;
    }

    @GetMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("recipe", recipeServise.findById(new Long(id)));

        return "recipe/show";
    }

    @GetMapping("recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe",new RecipeCommand());

        return "recipe/recipeform";
    }

    @GetMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id,Model model){

        model.addAttribute("recipe",recipeServise.findCommandById(Long.valueOf(id)));

        return "recipe/recipeform";
    }

    @PostMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command){
        RecipeCommand savedRecipeCommand=recipeServise.saveRecipeCommand(command);

        return "redirect:/recipe/" + savedRecipeCommand.getId() + "/show";
    }


    @GetMapping("recipe/{id}/delete")
    public String deleteById(@PathVariable String id){

        recipeServise.deletedById( Long.valueOf(id));
        log.debug("Deleting id: " + id);
        return "redirect:/";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundExceptions.class)
    public ModelAndView handleNotFound(Exception exception){

        log.error("Handling not found exception");
        log.error(exception.getMessage());
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("404error");
        modelAndView.addObject("exception",exception);

        return modelAndView;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleNumberFormat(Exception exception){

        log.error("Handling Number Format exception");
        log.error(exception.getMessage());
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("400error");
        modelAndView.addObject("exception",exception);

        return modelAndView;
    }

}
