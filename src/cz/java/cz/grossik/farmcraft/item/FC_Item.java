package cz.grossik.farmcraft.item;

import net.minecraft.item.Item;
import cz.grossik.farmcraft.FarmCraft;

public class FC_Item extends Item {
    public FC_Item() {
        super();
        this.setMaxStackSize(64);
        this.setCreativeTab(FarmCraft.FarmCraftTab);
    }
}