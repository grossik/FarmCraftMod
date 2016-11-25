package cz.grossik.farmcraft2.item;

import cz.grossik.farmcraft2.Main;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Item_Bucket extends Item {
    public Item_Bucket() {
        super();
        this.setMaxStackSize(16);
        this.setCreativeTab(Main.FarmCraft2Tab);
    }

    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 32;
    }
}