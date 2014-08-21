package cz.grossik.farmcraft.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cz.grossik.farmcraft.FarmCraft;

public class Item_Bucket extends Item {
    public Item_Bucket() {
        super();
        this.setMaxStackSize(16);
        this.setCreativeTab(FarmCraft.FarmCraftTab);
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 32;
    }
}