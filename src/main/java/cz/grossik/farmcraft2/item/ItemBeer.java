package cz.grossik.farmcraft2.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemBeer extends ItemFood{

	public ItemBeer(int amount, boolean isWolfFood) {
        super(amount, 0.4F, isWolfFood);
	}
	
	@Override
	protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entity){
	    super.onFoodEaten(itemStack, world, entity);
        
	        if (!world.isRemote)
	        	entity.addPotionEffect(new PotionEffect(MobEffects.confusion, 500, 4));	   
        	    entity.addPotionEffect(new PotionEffect(MobEffects.blindness, 400, 5));	    
	}
}