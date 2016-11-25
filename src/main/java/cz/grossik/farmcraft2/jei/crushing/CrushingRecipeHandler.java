package cz.grossik.farmcraft2.jei.crushing;

import javax.annotation.Nonnull;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.util.ErrorUtil;
import mezz.jei.util.Log;

public class CrushingRecipeHandler implements IRecipeHandler<CrushingRecipe> {

	@Override
	@Nonnull
	public Class<CrushingRecipe> getRecipeClass() {
		return CrushingRecipe.class;
	}

	@Nonnull
	@Override
	public String getRecipeCategoryUid() {
		return "crushingoff";
	}

	@Override
	@Nonnull
	public IRecipeWrapper getRecipeWrapper(@Nonnull CrushingRecipe recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(@Nonnull CrushingRecipe recipe) {
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

	@Override
	public String getRecipeCategoryUid(CrushingRecipe arg0) {
		return "crushingoff";

	}

}