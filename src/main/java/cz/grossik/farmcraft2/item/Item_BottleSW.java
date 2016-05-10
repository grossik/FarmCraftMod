package cz.grossik.farmcraft2.item;

import cz.grossik.farmcraft2.Main;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class Item_BottleSW extends ItemFood
{
    private PotionEffect potionId;
    private float potionEffectProbability;

    public Item_BottleSW(int amount, boolean isWolfFood)
    {
        super (amount, 0.2F, isWolfFood);
    	this.setMaxStackSize(1);
        this.setCreativeTab(Main.FarmCraft2Tab);   
		this.setMaxDamage(2);
    } 
    
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack)
    {    	
      return false;
    }

    @Override
    public boolean getShareTag()
    {
        return true;
    }
    public boolean hasContainerItem(ItemStack itemStack)
    {
       return true;
    }
    
    @Override
    public ItemStack getContainerItem(ItemStack itemStack)
    {
        ItemStack stack = itemStack.copy();

        stack.setItemDamage(stack.getItemDamage() + 1);

        return stack;
    }
}