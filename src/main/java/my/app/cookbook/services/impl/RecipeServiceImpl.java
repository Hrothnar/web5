package my.app.cookbook.services.impl;

import my.app.cookbook.model.Recipe;
import my.app.cookbook.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static Map<Long, Recipe> recipes = new TreeMap<>();
    private static long recipeId = 1;

    @Override
    public long addRecipe(Recipe recipe) {
        recipes.put(recipeId, recipe);
        return recipeId++;
    }

    @Override
    public Recipe getRecipe(long key) {
        return recipes.get(key);
    }

    @Override
    public Recipe editRecipe(Recipe recipe, long id) {
        if (recipes.containsKey(id)) {
            recipes.put(id, recipe);
            return recipe;
        }
        return null;
    }

    @Override
    public boolean removeRecipe(long id) {
        Recipe recipe = recipes.remove(id);
        return recipe != null;
    }

    @Override
    public Map<Long, Recipe> getAllRecipes() {
        return recipes;
    }

    @Override
    public Map<Long, Recipe> getRecipesByIngredientId(Long id1, Long id2) {
        Map<Long, Recipe> recipesContainsIngredient = new TreeMap<>();
        if (id2 == null) {
            for (Map.Entry<Long, Recipe> one : recipes.entrySet()) {
                if (one.getValue().getIngredients().containsKey(id1)) {
                    recipesContainsIngredient.put(one.getKey(), one.getValue());
                }
            }
        } else {
            for (Map.Entry<Long, Recipe> one : recipes.entrySet()) {
                if (one.getValue().getIngredients().containsKey(id1) && one.getValue().getIngredients().containsKey(id2)) {
                    recipesContainsIngredient.put(one.getKey(), one.getValue());
                }
            }
        }
        return recipesContainsIngredient;
    }


}
