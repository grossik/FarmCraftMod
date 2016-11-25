package cz.grossik.farmcraft2.flowers;

import java.util.List;

import cz.grossik.farmcraft2.Main;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockLily extends ItemBlock
{
	public ItemBlockLily(Block block) 
	{
		super(block);
		this.setCreativeTab(Main.FarmCraft2Tab);
		this.setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int damage)
    {
        return damage;
    }
	
    public String getUnlocalizedName(ItemStack stack)
    {
        return this.block.getUnlocalizedName() + "." + stack.getMetadata();
    }
}