package my.app.cookbook.controllers;

import my.app.cookbook.model.Ingredient;
import my.app.cookbook.model.Recipe;
import my.app.cookbook.services.impl.IngredientServiceImpl;
import my.app.cookbook.services.impl.RecipeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping("/cooking")
public class CookController {
    private RecipeServiceImpl recipeService;
    private IngredientServiceImpl ingredientService;

    public CookController(RecipeServiceImpl recipeService, IngredientServiceImpl ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @GetMapping("/recipes")
    public void recipe(@RequestParam String name, @RequestParam String cookingTime, @RequestParam LinkedList<String> steps, @RequestParam LinkedList<Ingredient> ingredients) {
        recipeService.addRecipe(new Recipe(name, cookingTime, steps, ingredients));
    }

    @GetMapping("/recipes/{id}")
    public Recipe showRecipe(@PathVariable long id) {
        return recipeService.getRecipe(id);
    }

    @GetMapping("/ingredients")
    public void ingredient(@RequestParam String name, @RequestParam int quantity, @RequestParam String measureUnit) {
        ingredientService.addIngredient(new Ingredient(name, quantity, measureUnit));
    }

    @GetMapping("/ingredients/{id}")
    public Ingredient showIngredient(@PathVariable long id) {
        return ingredientService.getIngredient(id);
    }


}
