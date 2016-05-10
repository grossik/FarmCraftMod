package cz.grossik.farmcraft2.bottling;

import cz.grossik.farmcraft2.handler.ItemHandler;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotBottlingFuel extends Slot
{
	public static boolean wine = false;
	public static boolean beer = false;
	
    public SlotBottlingFuel(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition)
    {
        super(inventoryIn, slotIndex, xPosition, yPosition);
    }

    public boolean isItemValid(ItemStack stack)
    {   
     	if(stack.getItem() == ItemHandler.FermentedWine)
     	{
     		beer = false;
     		wine = true; 
     	}
     	if(stack.getItem() == ItemHandler.BeerBucket)
     	{
     		wine = false;
     		beer = true;
     	}
     	
        return TileEntityBottling.isItemFuel(stack) || isBucket(stack);
    }

    public int getItemStackLimit(ItemStack stack)
    {
        return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
    }

    public static boolean isBucket(ItemStack stack)
    {
        return stack != null && stack.getItem() != null && stack.getItem() == Items.bucket;
    }
}