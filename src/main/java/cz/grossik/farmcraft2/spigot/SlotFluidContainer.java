package cz.grossik.farmcraft2.spigot;

import cz.grossik.farmcraft2.handler.ItemHandler;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.IFluidContainerItem;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

public class SlotFluidContainer extends Slot
{
  public SlotFluidContainer(IInventory inventory, int par2, int par3, int par4)
  {
    super(inventory, par2, par3, par4);
  }
  
  @Override
  public boolean isItemValid(ItemStack stack)
  {
	  if(stack.getItem() == ItemHandler.KegOfBeer)
		  return true;
	  else
		  return false;
  }

  @Override
  public int getSlotStackLimit()
  {
    return 1;
  }
}