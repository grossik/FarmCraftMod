package cz.grossik.farmcraft2.item;

import java.util.List;

import cz.grossik.farmcraft2.type.DonutsType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDonuts extends ItemFood {

	public ItemDonuts(int amount, boolean isWolfFood) {
		super(amount, isWolfFood);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
	}

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        for (DonutsType donutstype : DonutsType.values())
        {
        	subItems.add(new ItemStack(itemIn, 1, donutstype.getMetadata()));
        }
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        DonutsType donutstype = DonutsType.byItemStack(stack);
        return this.getUnlocalizedName() + "." + donutstype.getUnlocalizedName();
    }
}