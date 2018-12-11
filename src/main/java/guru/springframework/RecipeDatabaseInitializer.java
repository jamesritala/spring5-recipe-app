package guru.springframework;

import guru.springframework.domain.*;
import guru.springframework.repositories.RecipeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
public class RecipeDatabaseInitializer implements CommandLineRunner {
    RecipeRepository recipeRepository;
    Category category = new Category();
    Recipe recipe= new Recipe();
    Set<Ingredient> ingredients = new HashSet<>();
    Ingredient ingredient= new Ingredient();
    Notes notes = new Notes();
    UnitOfMeasure unitOfMeasure = new UnitOfMeasure();

    public RecipeDatabaseInitializer(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadRecipesData();
    }

    private void loadRecipesData(){
        recipe.setDescription("Perfect Guacamole");
        //category.setDescription();
       // category.setRecipes(recipe);


       // recipe.setCategories(category.);
        recipe.setCookTime(10);
        recipe.setDifficulty(Difficulty.MODERATE);
        recipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half.");
        //recipe.setImage();

        //1...
        ingredient.setAmount(BigDecimal.valueOf(2));
        ingredient.setDescription("Avocado");
        ingredient.setRecipe(recipe);
        unitOfMeasure.setDescription("");
        ingredient.setUom(unitOfMeasure);

        ingredients.add(ingredient);
        //2...
        ingredient.setAmount(BigDecimal.valueOf(1.5));
        ingredient.setDescription("Kosher salt");

        unitOfMeasure.setDescription("Teaspoon");
        ingredient.setUom(unitOfMeasure);
        ingredients.add(ingredient);
        //3...
        ingredient.setAmount(BigDecimal.valueOf(1));
        ingredient.setDescription("fresh lime juice or lemon juice");
        ingredient.setRecipe(recipe);
        unitOfMeasure.setDescription("Tbsp");
        ingredient.setUom(unitOfMeasure);
        ingredients.add(ingredient);
        //4...
        ingredient.setAmount(BigDecimal.valueOf(2));
        ingredient.setDescription("cilantro finely chopped");
        ingredient.setRecipe(recipe);
        unitOfMeasure.setDescription("tablespoons");
        ingredient.setUom(unitOfMeasure);
        ingredients.add(ingredient);


        recipe.setIngredients(ingredients);

        notes.setRecipe(recipe);
        notes.setRecipeNotes("Guacamole, a dip made from avocados, is originally from Mexico. The name is derived from two Aztec Nahuatl words—ahuacatl (avocado) and molli (sauce).");
        recipe.setNotes(notes);

        recipe.setPrepTime(10);
        recipe.setServings(2);
        recipe.setSource("Mexioo");
        recipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");


        recipeRepository.save(recipe);


    }
}
