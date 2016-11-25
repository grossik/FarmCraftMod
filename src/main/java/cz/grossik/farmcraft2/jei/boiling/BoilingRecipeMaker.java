package cz.grossik.farmcraft2.jei.boiling;

import javax.annotation.Nonnull;

import com.google.common.collect.Lists;

import cz.grossik.farmcraft2.boiling.BoilingRecipes;
import cz.grossik.farmcraft2.handler.ItemHandler;
import cz.grossik.farmcraft2.jei.mashtun.MashTunRecipeMaker.Wrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IStackHelper;

public class BoilingRecipeMaker {

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
		        ResourceLocation furnaceBackgroundLocation = new ResourceLocation("farmcraft2", "textures/gui/container/boiling.png");

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
		BoilingRecipes furnaceRecipes = BoilingRecipes.instance();
		Map<ItemStack, ItemStack> smeltingMap = furnaceRecipes.getSmeltingList();

		List<Wrapper> recipes = new ArrayList<Wrapper>();

		for (Map.Entry<ItemStack, ItemStack> itemStackItemStackEntry : smeltingMap.entrySet()) {
			ItemStack input = itemStackItemStackEntry.getKey();
			ItemStack output = itemStackItemStackEntry.getValue();

			float experience = furnaceRecipes.getSmeltingExperience(output);

			List<ItemStack> inputs = stackHelper.getSubtypes(input);
		    List<ItemStack> fuels = new ArrayList<ItemStack>();
		    fuels.add(new ItemStack(ItemHandler.Mash));
		    
			recipes.add(new Wrapper(helpers, Lists.newArrayList(output), Lists.newArrayList(inputs, fuels)));
		}

		return recipes;
	}

}