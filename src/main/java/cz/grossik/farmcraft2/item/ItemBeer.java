package cz.grossik.farmcraft2.item;

import javax.annotation.Nullable;

import cz.grossik.farmcraft2.handler.ItemHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemBeer extends ItemFood{

	public ItemBeer(int amount, boolean isWolfFood) {
        super(amount, 0.4F, isWolfFood);
	}
	
	@Override
    @Nullable
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        --stack.stackSize;

        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            entityplayer.getFoodStats().addStats(this, stack);
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.getObjectUseStats(this));
            
            if (entityplayer == null || !entityplayer.capabilities.isCreativeMode)
            {
                if (stack.stackSize <= 0)
                {
                    return new ItemStack(ItemHandler.Bottle);
                }

                if (entityplayer != null)
                {
                    entityplayer.inventory.addItemStackToInventory(new ItemStack(ItemHandler.Bottle));
                }
            }
        }

        return stack;
    }
    
	@Override
	protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entity){
	    super.onFoodEaten(itemStack, world, entity);        
	        if (!world.isRemote)
	        	entity.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 500, 4));	 
	        	entity.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 400, 5));	    	        
	}
}