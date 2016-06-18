package cz.grossik.farmcraft2.jei.mashtun;

import javax.annotation.Nonnull;

import cz.grossik.farmcraft2.boiling.BoilingRecipes;
import cz.grossik.farmcraft2.mashtun.MashTunRecipes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.minecraft.item.ItemStack;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;

public class MashTunRecipeMaker {

	@Nonnull
	public static List<MashTunRecipe> getFurnaceRecipes(IJeiHelpers helpers) {
		IStackHelper stackHelper = helpers.getStackHelper();
		MashTunRecipes furnaceRecipes = MashTunRecipes.instance();
		Map<ItemStack, ItemStack> smeltingMap = furnaceRecipes.getSmeltingList();

		List<MashTunRecipe> recipes = new ArrayList<>();

		for (Map.Entry<ItemStack, ItemStack> itemStackItemStackEntry : smeltingMap.entrySet()) {
			ItemStack input = itemStackItemStackEntry.getKey();
			ItemStack fuel = itemStackItemStackEntry.getKey();
			ItemStack output = itemStackItemStackEntry.getValue();

			float experience = furnaceRecipes.getSmeltingExperience(output);

			List<ItemStack> inputs = stackHelper.getSubtypes(input);
			List<ItemStack> fuels = stackHelper.getSubtypes(fuel);
			MashTunRecipe recipe = new MashTunRecipe(inputs, fuels, output, experience);
			recipes.add(recipe);
		}

		return recipes;
	}

}