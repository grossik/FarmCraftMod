package cz.grossik.farmcraft2.jei.mashtun;

import javax.annotation.Nonnull;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.util.ErrorUtil;
import mezz.jei.util.Log;

public class MashTunRecipeHandler implements IRecipeHandler<MashTunRecipe> {

	@Override
	@Nonnull
	public Class<MashTunRecipe> getRecipeClass() {
		return MashTunRecipe.class;
	}

	@Nonnull
	@Override
	public String getRecipeCategoryUid() {
		return "mashtunoff";
	}

	@Override
	@Nonnull
	public IRecipeWrapper getRecipeWrapper(@Nonnull MashTunRecipe recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(@Nonnull MashTunRecipe recipe) {
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