package cz.grossik.farmcraft2.jei.fermentingbarrel;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.recipe.BlankRecipeCategory;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public abstract class FermentingBarrelRecipeCategory extends BlankRecipeCategory {
	protected static final int inputSlot = 0;
	protected static final int fuelSlot = 1;
	protected static final int outputSlot = 2;

	protected final ResourceLocation backgroundLocation;
	@Nonnull
	protected final IDrawableAnimated flame;
	@Nonnull
	protected final IDrawableAnimated arrow;
	@Nonnull
	protected final IJeiHelpers helpers;

	public FermentingBarrelRecipeCategory(IJeiHelpers helpers) {
	      this.helpers = helpers;
	      IGuiHelper guiHelper = helpers.getGuiHelper();
		backgroundLocation = new ResourceLocation("farmcraft2", "textures/gui/container/fermentbarrel.png");

		IDrawableStatic flameDrawable = guiHelper.createDrawable(backgroundLocation, 177, 0, 14, 14);
		flame = guiHelper.createAnimatedDrawable(flameDrawable, 70, IDrawableAnimated.StartDirection.TOP, true);

		IDrawableStatic arrowDrawable = guiHelper.createDrawable(backgroundLocation, 176, 14, 24, 17);
		this.arrow = guiHelper.createAnimatedDrawable(arrowDrawable, 300, IDrawableAnimated.StartDirection.LEFT, false);
	}
}