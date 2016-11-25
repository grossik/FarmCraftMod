package cz.grossik.farmcraft2.pan;

import cz.grossik.farmcraft2.handler.ItemHandler;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotPan extends Slot {
		
	public SlotPan(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	
    public boolean isItemValid(ItemStack stack)
    {    	
    	if(stack.getItem() == ItemHandler.DfPancakes)
    	{ 
    		return true;
    	}
    	
        return false;
    }
}