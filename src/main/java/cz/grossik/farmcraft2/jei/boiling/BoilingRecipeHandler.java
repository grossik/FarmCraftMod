package cz.grossik.farmcraft2.jei.boiling;

import javax.annotation.Nonnull;

import cz.grossik.farmcraft2.jei.boiling.BoilingRecipeMaker.Wrapper;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.util.ErrorUtil;
import mezz.jei.util.Log;

public class BoilingRecipeHandler implements IRecipeHandler<Wrapper> {

	@Override
	@Nonnull
	public Class<Wrapper> getRecipeClass() {
		return Wrapper.class;
	}

	@Nonnull
	@Override
	public String getRecipeCategoryUid() {
		return "boilingoff";
	}

	@Override
	@Nonnull
	public IRecipeWrapper getRecipeWrapper(@Nonnull Wrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(@Nonnull Wrapper recipe) {
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
	public String getRecipeCategoryUid(Wrapper arg0) {
		return "boilingoff";
	}

}