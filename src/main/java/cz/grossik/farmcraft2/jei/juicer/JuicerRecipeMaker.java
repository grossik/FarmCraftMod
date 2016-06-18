package cz.grossik.farmcraft2.jei.juicer;

import javax.annotation.Nonnull;

import cz.grossik.farmcraft2.juicer.JuicerRecipes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.minecraft.item.ItemStack;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;

public class JuicerRecipeMaker {

	@Nonnull
	public static List<JuicerRecipe> getFurnaceRecipes(IJeiHelpers helpers) {
		IStackHelper stackHelper = helpers.getStackHelper();
		JuicerRecipes furnaceRecipes = JuicerRecipes.instance();
		Map<ItemStack, ItemStack> smeltingMap = furnaceRecipes.getSmeltingList();

		List<JuicerRecipe> recipes = new ArrayList<>();

		for (Map.Entry<ItemStack, ItemStack> itemStackItemStackEntry : smeltingMap.entrySet()) {
			ItemStack input = itemStackItemStackEntry.getKey();
			ItemStack fuel = itemStackItemStackEntry.getKey();
			ItemStack output = itemStackItemStackEntry.getValue();

			float experience = furnaceRecipes.getSmeltingExperience(output);

			List<ItemStack> inputs = stackHelper.getSubtypes(input);
			List<ItemStack> fuels = stackHelper.getSubtypes(fuel);
			JuicerRecipe recipe = new JuicerRecipe(inputs, fuels, output, experience);
			recipes.add(recipe);
		}

		return recipes;
	}

}