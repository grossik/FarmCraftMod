package cz.grossik.farmcraft2.jei.crushing;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.recipe.BlankRecipeCategory;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

import cz.grossik.farmcraft2.crushing.GuiCrushing;

public abstract class CrushingRecipeCategory extends BlankRecipeCategory {
	protected static final int inputSlot = 0;
	protected static final int outputSlot = 2;

	protected final ResourceLocation backgroundLocation;
	@Nonnull
	protected final IDrawableAnimated arrow;

	public CrushingRecipeCategory(IGuiHelper guiHelper) {
		backgroundLocation = new ResourceLocation("farmcraft2", "textures/gui/container/crushing.png");

		IDrawableStatic arrowDrawable = guiHelper.createDrawable(backgroundLocation, 176, 14, 24, 17);
		this.arrow = guiHelper.createAnimatedDrawable(arrowDrawable, 200, IDrawableAnimated.StartDirection.LEFT, false);
	}
	
	public static void register(IModRegistry registry, IGuiHelper guiHelper) {
		registry.addRecipeClickArea(GuiCrushing.class, 80, 35, 22, 16, "crushingoff");
	}
}