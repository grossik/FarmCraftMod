package cz.grossik.farmcraft2.jei.fermentingbarrel;

import javax.annotation.Nonnull;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.util.ErrorUtil;
import mezz.jei.util.Log;

public class FermentingBarrelRecipeHandler implements IRecipeHandler<FermentingBarrelRecipe> {

	@Override
	@Nonnull
	public Class<FermentingBarrelRecipe> getRecipeClass() {
		return FermentingBarrelRecipe.class;
	}

	@Nonnull
	@Override
	public String getRecipeCategoryUid() {
		return "fermentingbarreloff";
	}

	@Override
	@Nonnull
	public IRecipeWrapper getRecipeWrapper(@Nonnull FermentingBarrelRecipe recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(@Nonnull FermentingBarrelRecipe recipe) {
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