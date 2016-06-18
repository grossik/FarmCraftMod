package cz.grossik.farmcraft2.jei.boiling;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.recipe.BlankRecipeCategory;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public abstract class BoilingRecipeCategory extends BlankRecipeCategory {
	protected static final int inputSlot = 0;
	protected static final int fuelSlot = 1;
	protected static final int outputSlot = 2;

	protected final ResourceLocation backgroundLocation;
	@Nonnull
	protected final IDrawableAnimated flame;
	@Nonnull
	protected final IDrawableAnimated arrow;

	public BoilingRecipeCategory(IGuiHelper guiHelper) {
		backgroundLocation = new ResourceLocation("farmcraft2", "textures/gui/container/boiling.png");

		IDrawableStatic flameDrawable = guiHelper.createDrawable(backgroundLocation, 177, 0, 14, 14);
		flame = guiHelper.createAnimatedDrawable(flameDrawable, 1200, IDrawableAnimated.StartDirection.TOP, true);

		IDrawableStatic arrowDrawable = guiHelper.createDrawable(backgroundLocation, 176, 14, 24, 17);
		this.arrow = guiHelper.createAnimatedDrawable(arrowDrawable, 1200, IDrawableAnimated.StartDirection.LEFT, false);
	}
}