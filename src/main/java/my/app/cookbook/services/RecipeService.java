package my.app.cookbook.services;

import my.app.cookbook.model.Recipe;

import java.util.Map;

public interface RecipeService {
    long addRecipe(Recipe recipe);

    Recipe getRecipe(long key);

    Recipe editRecipe(Recipe recipe, long id);

    boolean removeRecipe(long id);

    Map<Long, Recipe> getAllRecipes();

    Map<Long, Recipe> getRecipesByIngredientId(long id1, long id2);
}
