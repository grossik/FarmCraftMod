package cz.grossik.farmcraft2.jei.juicer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import com.google.common.collect.Lists;

import cz.grossik.farmcraft2.handler.ItemHandler;
import cz.grossik.farmcraft2.juicer.JuicerRecipes;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IStackHelper;
import mezz.jei.util.Translator;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;

public class JuicerRecipeMaker {

	  static public class Wrapper implements IRecipeWrapper {
		  
		    @Nonnull
		    protected final IDrawableStatic flame_drawable;
		    @Nonnull
		    private final List<List<ItemStack>> input;
		    @Nonnull
		    private final List<ItemStack> output;
		    		    
		    public Wrapper(IJeiHelpers helpers, List<ItemStack> output, @Nonnull List<List<ItemStack>> input)
		    {
		        IGuiHelper guiHelper = helpers.getGuiHelper();
		        ResourceLocation furnaceBackgroundLocation = new ResourceLocation("farmcraft2", "textures/gui/container/juicer.png");

		        flame_drawable = guiHelper.createDrawable(furnaceBackgroundLocation, 176, 0, 14, 14);
		        this.input = input;
		        this.output = output;		        
		    }

		    @Override
		    public void drawAnimations(Minecraft minecraft, int recipeWidth, int recipeHeight)
		    {

		    }

		    @Override
		    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY)
		    {
		    }
		    
		    @Override
		    public List<FluidStack> getFluidInputs()
		    {
		      return Collections.emptyList();
		    }

		    @Override
		    public List<FluidStack> getFluidOutputs()
		    {
		      return Collections.emptyList();
		    }

		    @Nonnull
		    public List<List<ItemStack>> getInputs()
		    {
		      return input;
		    }

		    @Nonnull
		    public List<ItemStack> getOutputs()
		    {
		      return output;
		    }

		    @Override
		    public List<String> getTooltipStrings(int mouseX, int mouseY)
		    {
		      return null;
		    }
		    
		    @Override
		    public boolean handleClick(Minecraft minecraft, int mouseX, int mouseY, int mouseButton)
		    {
		      return false;
		    }
	  }
	  
	@Nonnull
	public static List<Wrapper> getFurnaceRecipes(IJeiHelpers helpers) {
		IStackHelper stackHelper = helpers.getStackHelper();
		JuicerRecipes furnaceRecipes = JuicerRecipes.instance();
		Map<ItemStack, ItemStack> smeltingMap = furnaceRecipes.getSmeltingList();

		List<Wrapper> recipes = new ArrayList<Wrapper>();

		for (Map.Entry<ItemStack, ItemStack> itemStackItemStackEntry : smeltingMap.entrySet()) {
			ItemStack input = itemStackItemStackEntry.getKey();
			ItemStack output = itemStackItemStackEntry.getValue();

			float experience = furnaceRecipes.getSmeltingExperience(output);

			List<ItemStack> inputs = stackHelper.getSubtypes(input);
			List<ItemStack> input_a = new ArrayList<ItemStack>();
		    input_a.add(new ItemStack(ItemHandler.GlassFJ));
		    
			recipes.add(new Wrapper(helpers, Lists.newArrayList(output), Lists.newArrayList(inputs, input_a)));
		}
		return recipes;
	}

}