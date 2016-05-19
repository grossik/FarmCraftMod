package cz.grossik.farmcraft2.spigot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cz.grossik.farmcraft2.bottling.IItemMatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class SpigotRecipeManager implements ISpigotRecipeManager
{
  public List<ISpigotRecipe> recipes;
  public List<ItemStack> molds;

  public static final SpigotRecipeManager instance = new SpigotRecipeManager();

  private SpigotRecipeManager()
  {
    recipes = new ArrayList<ISpigotRecipe>();
    molds = new ArrayList<ItemStack>();
  }

  @Override
  public void addRecipe(IItemMatcher result,FluidStack in_fluid,ItemStack in_mold,IItemMatcher in_extra,int cast_speed)
  {
	  ISpigotRecipe recipe = new SpigotRecipe(result,in_fluid,in_mold,in_extra,cast_speed);
    if(recipe.requiresExtra())
    {
      recipes.add(0,recipe);
    } else
    {
      recipes.add(recipe);
    }
  }

  @Override
  public void addRecipe(IItemMatcher result,FluidStack in_fluid,ItemStack in_mold,IItemMatcher in_extra)
  {
    addRecipe(result,in_fluid,in_mold,in_extra,100);
  }

  @Override
  public ISpigotRecipe findRecipe(FluidStack fluid,ItemStack mold,ItemStack extra)
  {
    if(mold == null || fluid == null || fluid.amount == 0)
    {
      return null;
    }
    for(ISpigotRecipe cr:recipes)
    {
      if(cr.matchesRecipe(mold, fluid, extra))
      {
        return cr;
      }
    }
    return null;
  }
  
  @Override
  public void addMold(ItemStack mold)
  {
    molds.add(mold.copy());
  }

  @Override
  public boolean isItemMold(ItemStack stack)
  {
    if(stack == null)
    {
      return false;
    }
    for(ItemStack m:molds)
    {
      if(m.isItemEqual(stack))
      {
        return true;
      }
    }
    return false;
  }

  @Override
  public List<ISpigotRecipe> getRecipes()
  {
    return Collections.unmodifiableList(recipes);
  }

  @Override
  public List<ItemStack> getMolds()
  {
    return Collections.unmodifiableList(molds);
  }

  @Override
  public void removeRecipe(ISpigotRecipe recipe)
  {
    recipes.remove(recipe);
  }
}