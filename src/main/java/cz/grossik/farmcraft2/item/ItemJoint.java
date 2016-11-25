package cz.grossik.farmcraft2.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemJoint extends ItemFood {

	public ItemJoint(int amount, boolean isWolfFood) {
		super(amount, isWolfFood);
	}

	@Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
		playerIn.setActiveHand(hand);
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }
    
	@Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }
	
	@Override
	protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entity){
	    super.onFoodEaten(itemStack, world, entity);        
	        if (!world.isRemote)
	        	entity.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 300, 4));	 
	        	entity.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 300, 5));	    
	        	entity.addPotionEffect(new PotionEffect(MobEffects.SPEED, 300, 1));	  
	        	entity.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 200, 2));	    	        
	}
}