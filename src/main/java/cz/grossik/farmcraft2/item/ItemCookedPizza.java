package cz.grossik.farmcraft2.item;

import java.util.List;

import cz.grossik.farmcraft2.type.PizzaType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCookedPizza extends ItemFood {

	public ItemCookedPizza(int amount, boolean isWolfFood) {
		super(amount, isWolfFood);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
	}

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        for (PizzaType itempizza$pizzatype : PizzaType.values())
        {
        	subItems.add(new ItemStack(itemIn, 1, itempizza$pizzatype.getMetadata()));
        }
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        PizzaType itempizza$pizzatype = PizzaType.byCookedItemStack(stack);
        return this.getUnlocalizedName() + "." + itempizza$pizzatype.getUnlocalizedName();
    }	
}
