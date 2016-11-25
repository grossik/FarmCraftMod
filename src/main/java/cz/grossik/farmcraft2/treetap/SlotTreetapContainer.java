package cz.grossik.farmcraft2.treetap;

import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotTreetapContainer extends Slot
{
  public SlotTreetapContainer(IInventory inventory, int par2, int par3, int par4)
  {
    super(inventory, par2, par3, par4);
  }
  
  @Override
  public boolean isItemValid(ItemStack stack)
  {
	  if(stack.getItem() == Items.BUCKET){
		  return true;
	  }
	  return false;
  }

  @Override
  public int getSlotStackLimit()
  {
    return 1;
  }
}