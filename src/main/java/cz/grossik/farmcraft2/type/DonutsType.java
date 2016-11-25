package cz.grossik.farmcraft2.type;

import java.util.Map;

import com.google.common.collect.Maps;

import cz.grossik.farmcraft2.item.ItemCookedPizza;
import cz.grossik.farmcraft2.item.ItemDonuts;
import cz.grossik.farmcraft2.item.ItemPizza;
import net.minecraft.item.ItemStack;

public enum DonutsType
{   
    CHOCOLATE(0, "chocolate"),
    STRAWBERRY(1, "strawberry"),
    BANANA(2, "banana");

	public static Map<Integer, DonutsType> META_LOOKUP = Maps.<Integer, DonutsType>newHashMap();
	public int meta;
	public String unlocalizedName;

	DonutsType(int meta, String unlocalizedName)
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

	public static DonutsType byMetadata(int meta)
	{
		DonutsType itempizza$pizzatype = (DonutsType)META_LOOKUP.get(Integer.valueOf(meta));
		return itempizza$pizzatype == null ? CHOCOLATE : itempizza$pizzatype;
	}

	public static DonutsType byItemStack(ItemStack stack)
	{
		return stack.getItem() instanceof ItemDonuts ? byMetadata(stack.getMetadata()) : CHOCOLATE;
	}
	
	static
	{
		for (DonutsType itempizza$pizzatype : values())
		{
			META_LOOKUP.put(Integer.valueOf(itempizza$pizzatype.getMetadata()), itempizza$pizzatype);
		}
	}  
}