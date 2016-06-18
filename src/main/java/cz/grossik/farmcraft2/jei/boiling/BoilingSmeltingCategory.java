package cz.grossik.farmcraft2.jei.boiling;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.util.Translator;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

import cz.grossik.farmcraft2.handler.ItemHandler;

public class BoilingSmeltingCategory extends BoilingRecipeCategory {
	@Nonnull
	private final IDrawable background;
	@Nonnull
	private final String localizedName;

	public BoilingSmeltingCategory(IGuiHelper guiHelper) {
		super(guiHelper);
		ResourceLocation location = new ResourceLocation("farmcraft2", "textures/gui/container/boiling.png");
		background = guiHelper.createDrawable(location, 25, 16, 112, 54);
		localizedName = Translator.translateToLocal("Boiling");
	}

	@Override
	@Nonnull
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public void drawAnimations(@Nonnull Minecraft minecraft) {
		arrow.draw(minecraft, 54, 19);
	}

	@Nonnull
	@Override
	public String getTitle() {
		return localizedName;
	}

	@Nonnull
	@Override
	public String getUid() {
		return "boilingoff";
	}

	@Override
	public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull IRecipeWrapper recipeWrapper) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

		guiItemStacks.init(inputSlot, true, 30, 17);
		guiItemStacks.init(fuelSlot, true, 0, 17);
		guiItemStacks.init(outputSlot, false, 90, 18);

		guiItemStacks.setFromRecipe(inputSlot, recipeWrapper.getInputs());
		guiItemStacks.setFromRecipe(fuelSlot, new ItemStack(ItemHandler.Mash));
		guiItemStacks.setFromRecipe(outputSlot, recipeWrapper.getOutputs());
	}
}