package cz.grossik.farmcraft2.type;

import java.util.Map;

import com.google.common.collect.Maps;

import cz.grossik.farmcraft2.item.ItemCookedPizza;
import cz.grossik.farmcraft2.item.ItemPizza;
import net.minecraft.item.ItemStack;

public enum PizzaType
{   
    MUSHROOM(0, "mushroom"),
    CHEESE(1, "cheese"),
    HAWAI(2, "hawai"),
    HAM(3, "ham");

	public static Map<Integer, PizzaType> META_LOOKUP = Maps.<Integer, PizzaType>newHashMap();
	public int meta;
	public String unlocalizedName;

	PizzaType(int meta, String unlocalizedName)
	{
		this.meta = meta;
		this.unlocalizedName = unlocalizedName;  		
	}

	public int getMetadata()
	{
		return this.meta;
	}

	public String getUnlocalizedName()
	{
		return this.unlocalizedName;
	}

	public static PizzaType byMetadata(int meta)
	{
		PizzaType itempizza$pizzatype = (PizzaType)META_LOOKUP.get(Integer.valueOf(meta));
		return itempizza$pizzatype == null ? MUSHROOM : itempizza$pizzatype;
	}

	public static PizzaType byItemStack(ItemStack stack)
	{
		return stack.getItem() instanceof ItemPizza ? byMetadata(stack.getMetadata()) : MUSHROOM;
	}
	
	public static PizzaType byCookedItemStack(ItemStack stack)
	{
		return stack.getItem() instanceof ItemCookedPizza ? byMetadata(stack.getMetadata()) : MUSHROOM;
	}
	
	static
	{
		for (PizzaType itempizza$pizzatype : values())
		{
			META_LOOKUP.put(Integer.valueOf(itempizza$pizzatype.getMetadata()), itempizza$pizzatype);
		}
	}  
}