package cz.grossik.farmcraft2.jei;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;

import com.google.common.collect.Lists;

import cz.grossik.farmcraft2.bottling.GuiBottling;
import cz.grossik.farmcraft2.handler.ItemHandler;
import cz.grossik.farmcraft2.treetap.GuiTreetap;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IStackHelper;
import mezz.jei.util.Translator;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;

public class TreetapJEI {

	  static public class Wrapper implements IRecipeWrapper {
		  
		    @Nonnull
		    protected final IDrawableStatic flame_drawable;
		    @Nonnull
		    private final List<List<ItemStack>> input;
		    @Nonnull
		    private final List<ItemStack> output;
		    
		    private final String potreba;
		    
		    public Wrapper(IJeiHelpers helpers, List<ItemStack> output, @Nonnull List<List<ItemStack>> input)
		    {
		        IGuiHelper guiHelper = helpers.getGuiHelper();
		        ResourceLocation furnaceBackgroundLocation = new ResourceLocation("farmcraft2", "textures/gui/container/treetap.png");

		        flame_drawable = guiHelper.createDrawable(furnaceBackgroundLocation, 176, 0, 14, 14);
		        this.input = input;
		        this.output = output;
		        
		        potreba = Translator.translateToLocalFormatted("1000 mB");
		    }

		    @Override
		    public void drawAnimations(Minecraft minecraft, int recipeWidth, int recipeHeight)
		    {

		    }

		    @Override
		    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY)
		    {
				minecraft.fontRendererObj.drawString(potreba, 17, 9, Color.gray.getRGB());
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
	  
	  static public class Category implements IRecipeCategory
	  {
		    protected final ResourceLocation background_location;
		    @Nonnull
		    private final IDrawable background;
		    @Nonnull
		    private final String localized_name;
		    		    
		    private final IJeiHelpers helpers;
		    
		    public Category(IJeiHelpers helpers)
		    {
		        this.helpers = helpers;
		        IGuiHelper guiHelper = helpers.getGuiHelper();
		        background_location = new ResourceLocation("farmcraft2", "textures/gui/container/treetap.png");

		        ResourceLocation location = new ResourceLocation("farmcraft2", "textures/gui/container/treetap.png");
		        
		        background = guiHelper.createDrawable(location, 30, 16, 110, 54);
		        localized_name = Translator.translateToLocal("Treetap");						        
		    }
		    
			public static void register(IModRegistry registry, IGuiHelper guiHelper) {
				registry.addRecipeClickArea(GuiTreetap.class, 71, 35, 22, 16, "treetap");
			}
		    
		    @Override
		    @Nonnull
		    public IDrawable getBackground()
		    {
		      return background;
		    }
		    
		    @Override
		    public void drawExtras(Minecraft minecraft)
		    {

		    }

		    @Override
		    public void drawAnimations(Minecraft minecraft)
		    {
		    	
		    }
		    
		    @Nonnull
		    @Override
		    public String getTitle()
		    {
		      return localized_name;
		    }

		    @Nonnull
		    @Override
		    public String getUid()
		    {
		      return "treetap";
		    }
		    
		    @Override
		    public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull IRecipeWrapper recipeWrapper)
		    {
		        IGuiItemStackGroup gui_items = recipeLayout.getItemStacks();
		        IStackHelper stack_helper = helpers.getStackHelper();

		        gui_items.init(0, true, 17, 18);
		        gui_items.init(1, false, 76, 18);
		        
			      List<ItemStack> output = new ArrayList<ItemStack>();
			      output.add(new ItemStack(ItemHandler.SapBucket));
			      
			      List<ItemStack> input_a = new ArrayList<ItemStack>();
			      input_a.add(new ItemStack(Items.BUCKET));
			      
		        gui_items.setFromRecipe(0, input_a);
		        gui_items.setFromRecipe(1, output);
		    }
	  }
	  
	  public static class Handler implements IRecipeHandler<Wrapper>
	  {
		    @Override
		    @Nonnull
		    public Class<Wrapper> getRecipeClass()
		    {
		      return Wrapper.class;
		    }

		    @Nonnull
		    @Override
		    public String getRecipeCategoryUid()
		    {
		      return "treetap";
		    }

		    @Override
		    @Nonnull
		    public IRecipeWrapper getRecipeWrapper(@Nonnull Wrapper recipe)
		    {
		      return recipe;
		    }

		    @Override
		    public boolean isRecipeValid(@Nonnull Wrapper recipe)
		    {
		      return true;
		    }

			@Override
			public String getRecipeCategoryUid(Wrapper arg0) {
			      return "treetap";
			}
	  }
	  
	  @SuppressWarnings("unchecked")
	  static public List<Wrapper> getRecipes(IJeiHelpers helpers)
	  {
		  List<Wrapper> recipes = new ArrayList<Wrapper>();

	      List<ItemStack> output = new ArrayList<ItemStack>();
	      output.add(new ItemStack(ItemHandler.SapBucket));
	      
	      List<ItemStack> input_a = new ArrayList<ItemStack>();
	      input_a.add(new ItemStack(Items.BUCKET));
	      
		  recipes.add(new Wrapper(helpers, Lists.newArrayList(output), Collections.singletonList(input_a)));
		  
		  return recipes;
	  }
}