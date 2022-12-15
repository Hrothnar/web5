package my.app.cookbook.services;

import my.app.cookbook.model.Recipe;

public interface RecipeService {

    void addRecipe(Recipe recipe);

    Recipe getRecipe(long key);

}
