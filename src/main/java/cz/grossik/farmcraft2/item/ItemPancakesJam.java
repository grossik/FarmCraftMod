package cz.grossik.farmcraft2.item;

import java.util.List;

import cz.grossik.farmcraft2.type.PancakesJamType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPancakesJam extends ItemFood {

	public ItemPancakesJam(int amount, boolean isWolfFood) {
		super(amount, isWolfFood);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
	}

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        for (PancakesJamType donutstype : PancakesJamType.values())
        {
        	subItems.add(new ItemStack(itemIn, 1, donutstype.getMetadata()));
        }
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
    	PancakesJamType donutstype = PancakesJamType.byItemStack(stack);
        return this.getUnlocalizedName() + "." + donutstype.getUnlocalizedName();
    }
}