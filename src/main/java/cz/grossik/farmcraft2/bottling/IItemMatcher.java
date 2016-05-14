package cz.grossik.farmcraft2.bottling;

import java.util.List;

import com.google.common.base.Predicate;

import net.minecraft.item.ItemStack;

public interface IItemMatcher extends Predicate<ItemStack>
{
  public int getAmount();

  public ItemStack getItem();

  public List<ItemStack> getItems();
}