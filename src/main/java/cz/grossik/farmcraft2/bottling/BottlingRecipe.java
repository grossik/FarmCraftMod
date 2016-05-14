package cz.grossik.farmcraft2.bottling;

import net.minecraft.item.ItemStack;

/*
 * Alloy Mixer recipe manager
 */
public class BottlingRecipe implements IBottlingRecipe
{
  
  public IItemMatcher input_a;
  public IItemMatcher input_b;
  public ItemStack output;

  @Override
  public IItemMatcher getInputA()
  {
    return input_a;
  }

  @Override
  public IItemMatcher getInputB()
  {
    return input_b;
  }

  @Override
  public ItemStack getOutput()
  {
    return output.copy();
  }
  
  public BottlingRecipe(ItemStack out,IItemMatcher in_a,IItemMatcher in_b)
  {
    if(out == null)
    {
      throw new IllegalArgumentException("Alloy recipe output cannot be null");
    }
    output = out.copy();

    input_a = in_a;
    input_b = in_b;
  }

  @Override
  public boolean matchesRecipe(ItemStack in_a,ItemStack in_b)
  {
    return input_a.apply(in_a) && input_b.apply(in_b);
  }
}