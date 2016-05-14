package cz.grossik.farmcraft2.bottling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.item.ItemStack;

public class BottlingRecipeManager implements IBottlingRecipeManager
{
  public List<IBottlingRecipe> recipes;

  public static final BottlingRecipeManager instance = new BottlingRecipeManager();
  
  private BottlingRecipeManager()
  {
    recipes = new ArrayList<IBottlingRecipe>();
  }
  
  @Override
  public void addRecipe(ItemStack out, IItemMatcher in_a,IItemMatcher in_b)
  {
    recipes.add(new BottlingRecipe(out,in_a,in_b));
  }

  @Override
  public IBottlingRecipe findRecipe(ItemStack in_a,ItemStack in_b)
  {
    for(IBottlingRecipe r:recipes)
    {
      if(r.matchesRecipe(in_a,in_b))
      {
        return r;
      }
    }
    return null;
  }

  @Override
  public List<IBottlingRecipe> getRecipes()
  {
    return Collections.unmodifiableList(recipes);
  }

  @Override
  public void addRecipe(ItemStack out, IItemMatcher[] in_a, IItemMatcher[] in_b)
  {
    for(IItemMatcher a:in_a)
    {
      for(IItemMatcher b:in_b)
      {
        addRecipe(out, a, b);
      }
    }
  }

  @Override
  public void removeRecipe(IBottlingRecipe recipe)
  {
    recipes.remove(recipe);    
  }
}