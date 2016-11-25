package cz.grossik.farmcraft2.type;

import java.util.Map;

import com.google.common.collect.Maps;

import cz.grossik.farmcraft2.item.ItemCookedPizza;
import cz.grossik.farmcraft2.item.ItemDonuts;
import cz.grossik.farmcraft2.item.ItemPancakesJam;
import cz.grossik.farmcraft2.item.ItemPizza;
import net.minecraft.item.ItemStack;

public enum PancakesJamType
{   
    PEAR(0, "pear"),
    STRAWBERRY(1, "strawberry"),
    APPLE(2, "apple"),
    PLUM(3, "plum"),
    CHERRY(4, "cherry");

	public static Map<Integer, PancakesJamType> META_LOOKUP = Maps.<Integer, PancakesJamType>newHashMap();
	public int meta;
	public String unlocalizedName;

	PancakesJamType(int meta, String unlocalizedName)
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

	public static PancakesJamType byMetadata(int meta)
	{
		PancakesJamType itempizza$pizzatype = (PancakesJamType)META_LOOKUP.get(Integer.valueOf(meta));
		return itempizza$pizzatype == null ? PEAR : itempizza$pizzatype;
	}

	public static PancakesJamType byItemStack(ItemStack stack)
	{
		return stack.getItem() instanceof ItemPancakesJam ? byMetadata(stack.getMetadata()) : PEAR;
	}
	
	static
	{
		for (PancakesJamType itempizza$pizzatype : values())
		{
			META_LOOKUP.put(Integer.valueOf(itempizza$pizzatype.getMetadata()), itempizza$pizzatype);
		}
	}  
}