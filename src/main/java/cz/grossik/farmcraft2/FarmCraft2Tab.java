package cz.grossik.farmcraft2;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FarmCraft2Tab extends CreativeTabs {

    public FarmCraft2Tab(String tabLabel) {
        super(tabLabel);
    }
    @SideOnly(Side.CLIENT)
    public String getTranslatedTabLabel()
    {
        return "FarmCraft 2 Tab";
    }
    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return cz.grossik.farmcraft2.handler.ItemHandler.TomatoSeeds;
    }

}