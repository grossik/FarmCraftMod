package cz.grossik.farmcraft2.jei.fermentingbarrel;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IStackHelper;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.util.Translator;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import cz.grossik.farmcraft2.handler.ItemHandler;

public class FermentingBarrelSmeltingCategory extends FermentingBarrelRecipeCategory {
	@Nonnull
	private final IDrawable background;
	@Nonnull
	private final String localizedName;
    
    private final IJeiHelpers helpers;
	
	public FermentingBarrelSmeltingCategory(IJeiHelpers helpers) {
		super(helpers);
	    this.helpers = helpers;
	    IGuiHelper guiHelper = helpers.getGuiHelper();
		ResourceLocation location = new ResourceLocation("farmcraft2", "textures/gui/container/fermentbarrel.png");
		background = guiHelper.createDrawable(location, 55, 16, 82, 54);
		localizedName = Translator.translateToLocal("Fermenting Barrel");
	}

	@Override
	@Nonnull
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public void drawAnimations(@Nonnull Minecraft minecraft) {
		arrow.draw(minecraft, 24, 18);
	}

	@Nonnull
	@Override
	public String getTitle() {
		return localizedName;
	}

	@Nonnull
	@Override
	public String getUid() {
		return "fermentingbarreloff";
	}

	@Override
	public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull IRecipeWrapper recipeWrapper) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
	    IStackHelper stack_helper = helpers.getStackHelper();

		guiItemStacks.init(inputSlot, true, 0, 0);
		guiItemStacks.init(fuelSlot, true, 0, 36);
		guiItemStacks.init(outputSlot, false, 60, 18);
	      
		guiItemStacks.setFromRecipe(inputSlot, stack_helper.toItemStackList(recipeWrapper.getInputs().get(0)));	
		guiItemStacks.setFromRecipe(fuelSlot, stack_helper.toItemStackList(recipeWrapper.getInputs().get(1)));
		guiItemStacks.setFromRecipe(outputSlot, recipeWrapper.getOutputs());
	}
}