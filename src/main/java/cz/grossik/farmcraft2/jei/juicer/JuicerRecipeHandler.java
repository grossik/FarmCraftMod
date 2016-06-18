package cz.grossik.farmcraft2.jei.juicer;

import javax.annotation.Nonnull;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.util.ErrorUtil;
import mezz.jei.util.Log;

public class JuicerRecipeHandler implements IRecipeHandler<JuicerRecipe> {

	@Override
	@Nonnull
	public Class<JuicerRecipe> getRecipeClass() {
		return JuicerRecipe.class;
	}

	@Nonnull
	@Override
	public String getRecipeCategoryUid() {
		return "juiceroff";
	}

	@Override
	@Nonnull
	public IRecipeWrapper getRecipeWrapper(@Nonnull JuicerRecipe recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(@Nonnull JuicerRecipe recipe) {
		if (recipe.getInputs().isEmpty()) {
			String recipeInfo = ErrorUtil.getInfoFromBrokenRecipe(recipe, this);
			Log.error("Recipe has no inputs. {}", recipeInfo);
		}
		if (recipe.getOutputs().isEmpty()) {
			String recipeInfo = ErrorUtil.getInfoFromBrokenRecipe(recipe, this);
			Log.error("Recipe has no outputs. {}", recipeInfo);
		}
		return true;
	}

}