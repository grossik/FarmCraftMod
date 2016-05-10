package cz.grossik.farmcraft2.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemGlassSW extends ItemFood{

	public ItemGlassSW(int amount, boolean isWolfFood) {
        super(amount, 0.2F, isWolfFood);
	}
	
	@Override
	protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entity){
	    super.onFoodEaten(itemStack, world, entity);
        
	        if (!world.isRemote)
	        	entity.addPotionEffect(new PotionEffect(MobEffects.confusion, 300, 3));	   
        	    entity.addPotionEffect(new PotionEffect(MobEffects.blindness, 200, 4));	    
	}
}
