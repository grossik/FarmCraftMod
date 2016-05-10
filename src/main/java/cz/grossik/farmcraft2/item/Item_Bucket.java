package cz.grossik.farmcraft2.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Item_Bucket extends Item {
    public Item_Bucket() {
        super();
        this.setMaxStackSize(16);
    }

    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 32;
    }
}