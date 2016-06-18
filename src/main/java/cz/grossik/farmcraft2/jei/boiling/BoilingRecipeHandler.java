package cz.grossik.farmcraft2.jei.boiling;

import javax.annotation.Nonnull;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.util.ErrorUtil;
import mezz.jei.util.Log;

public class BoilingRecipeHandler implements IRecipeHandler<BoilingRecipe> {

	@Override
	@Nonnull
	public Class<BoilingRecipe> getRecipeClass() {
		return BoilingRecipe.class;
	}

	@Nonnull
	@Override
	public String getRecipeCategoryUid() {
		return "boilingoff";
	}

	@Override
	@Nonnull
	public IRecipeWrapper getRecipeWrapper(@Nonnull BoilingRecipe recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(@Nonnull BoilingRecipe recipe) {
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