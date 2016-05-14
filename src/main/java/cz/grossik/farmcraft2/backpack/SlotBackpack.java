package cz.grossik.farmcraft2.backpack;

import cz.grossik.farmcraft2.handler.ItemHandler;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotBackpack extends Slot {

	public SlotBackpack(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack par1ItemStack) {
		if(par1ItemStack.getItem() != ItemHandler.backpack){
        	return true;
        }
        else{
        	return false;
        }
	}
}
