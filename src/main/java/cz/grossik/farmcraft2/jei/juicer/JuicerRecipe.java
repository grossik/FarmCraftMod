package cz.grossik.farmcraft2.jei.juicer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.Color;
import java.util.Collections;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;

import mezz.jei.plugins.vanilla.VanillaRecipeWrapper;
import mezz.jei.util.Translator;

public class JuicerRecipe extends VanillaRecipeWrapper {
	@Nonnull
	private final List<List<ItemStack>> input;
	@Nonnull
	private final List<List<ItemStack>> fuel;
	@Nonnull
	private final List<ItemStack> outputs;

	@Nullable
	private final String experienceString;

	public JuicerRecipe(@Nonnull List<ItemStack> input, @Nonnull List<ItemStack> fuel, @Nonnull ItemStack output, float experience) {
		this.input = Collections.singletonList(input);
		this.fuel = Collections.singletonList(fuel);
		this.outputs = Collections.singletonList(output);

		if (experience > 0.0) {
			experienceString = Translator.translateToLocalFormatted("Juicer", experience);
		} else {
			experienceString = null;
		}
	}

	@Nonnull
	public List<List<ItemStack>> getInputs() {
		return input;
	}
	
	@Nonnull
	public List<List<ItemStack>> getFuel() {
		return fuel;
	}

	@Nonnull
	public List<ItemStack> getOutputs() {
		return outputs;
	}

	@Override
	public void drawInfo(@Nonnull Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
		if (experienceString != null) {
			FontRenderer fontRendererObj = minecraft.fontRendererObj;
			int stringWidth = fontRendererObj.getStringWidth(experienceString);
			fontRendererObj.drawString(experienceString, recipeWidth - stringWidth, 0, Color.gray.getRGB());
		}
	}
}