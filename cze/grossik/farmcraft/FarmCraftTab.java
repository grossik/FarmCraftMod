package cze.grossik.farmcraft;

import cze.grossik.farmcraft.handler.ItemHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FarmCraftTab extends CreativeTabs {

    public FarmCraftTab(String tabLabel) {
        super(tabLabel);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return FarmCraft.TomatoSeeds;
    }

}