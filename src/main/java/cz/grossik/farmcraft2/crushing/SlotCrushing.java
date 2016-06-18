package cz.grossik.farmcraft2.crushing;

import cz.grossik.farmcraft2.handler.ItemHandler;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCrushing extends Slot {
	
	public SlotCrushing(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	
    public boolean isItemValid(ItemStack stack)
    {    	
    	if(stack.getItem() == ItemHandler.Wine)
    	return true;
    	
        return false;
    }
    
    public void update() {
    	
    }
}
