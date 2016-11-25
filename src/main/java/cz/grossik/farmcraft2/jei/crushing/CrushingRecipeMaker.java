package cz.grossik.farmcraft2.jei.crushing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import cz.grossik.farmcraft2.crushing.CrushingRecipes;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

public class CrushingRecipeMaker {

	@Nonnull
	public static List<CrushingRecipe> getFurnaceRecipes(IJeiHelpers helpers) {
		IStackHelper stackHelper = helpers.getStackHelper();
		CrushingRecipes furnaceRecipes = CrushingRecipes.instance();
		Map<ItemStack, ItemStack> smeltingMap = furnaceRecipes.getSmeltingList();

		List<CrushingRecipe> recipes = new ArrayList<CrushingRecipe>();

		for (Map.Entry<ItemStack, ItemStack> itemStackItemStackEntry : smeltingMap.entrySet()) {
			ItemStack input = itemStackItemStackEntry.getKey();
			ItemStack output = itemStackItemStackEntry.getValue();

			float experience = furnaceRecipes.getSmeltingExperience(output);

			List<ItemStack> inputs = stackHelper.getSubtypes(input);
			CrushingRecipe recipe = new CrushingRecipe(inputs, null, output, experience);
			recipes.add(recipe);
		}

		return recipes;
	}

}