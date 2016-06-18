package cz.grossik.farmcraft2.jei.boiling;

import javax.annotation.Nonnull;

import cz.grossik.farmcraft2.boiling.BoilingRecipes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.minecraft.item.ItemStack;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;

public class BoilingRecipeMaker {

	@Nonnull
	public static List<BoilingRecipe> getFurnaceRecipes(IJeiHelpers helpers) {
		IStackHelper stackHelper = helpers.getStackHelper();
		BoilingRecipes furnaceRecipes = BoilingRecipes.instance();
		Map<ItemStack, ItemStack> smeltingMap = furnaceRecipes.getSmeltingList();

		List<BoilingRecipe> recipes = new ArrayList<>();

		for (Map.Entry<ItemStack, ItemStack> itemStackItemStackEntry : smeltingMap.entrySet()) {
			ItemStack input = itemStackItemStackEntry.getKey();
			ItemStack fuel = itemStackItemStackEntry.getKey();
			ItemStack output = itemStackItemStackEntry.getValue();

			float experience = furnaceRecipes.getSmeltingExperience(output);

			List<ItemStack> inputs = stackHelper.getSubtypes(input);
			List<ItemStack> fuels = stackHelper.getSubtypes(fuel);
			BoilingRecipe recipe = new BoilingRecipe(inputs, fuels, output, experience);
			recipes.add(recipe);
		}

		return recipes;
	}

}