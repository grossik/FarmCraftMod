package cz.grossik.farmcraft2.goat;

import java.util.Random;

import javax.annotation.Nullable;

import cz.grossik.farmcraft2.FC2Sounds;
import cz.grossik.farmcraft2.handler.ItemHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class EntityGoat extends EntityAnimal
{
	Random random;

    public EntityGoat(World worldIn)
    {
        super(worldIn);
        this.setSize(0.8f, 1.0f);
    }

    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.WHEAT, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
    }

    protected SoundEvent getAmbientSound()
    {
        return FC2Sounds.goat_ambient;
    }

    protected SoundEvent getHurtSound()
    {
        return FC2Sounds.goat_ambient;
    }

    protected SoundEvent getDeathSound()
    {
        return FC2Sounds.goat_ambient;
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
    }

    protected float getSoundVolume()
    {
        return 0.4F;
    }

    public boolean processInteract(EntityPlayer player, EnumHand hand, @Nullable ItemStack stack)
    {
        if (stack != null && stack.getItem() == Items.BUCKET && !player.capabilities.isCreativeMode && !this.isChild())
        {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);

            if (--stack.stackSize == 0)
            {
                player.setHeldItem(hand, new ItemStack(ItemHandler.GoatMilkBucket));
            }
            else if (!player.inventory.addItemStackToInventory(new ItemStack(ItemHandler.GoatMilkBucket)))
            {
                player.dropItem(new ItemStack(ItemHandler.GoatMilkBucket), false);
            }

            return true;
        }
        else
        {
            return super.processInteract(player, hand, stack);
        }
    }

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return null;
    }
    
    @Override
    public void onDeath(DamageSource cause)
    {
    	int cislo = (int) (Math.random()* 3);
        this.dropItem(Items.LEATHER, cislo);
    }
    
    public EntityGoat createChild(EntityAgeable ageable)
    {
        return new EntityGoat(this.worldObj);
    }

    public float getEyeHeight()
    {
        return this.isChild() ? this.height : 1.3F;
    }
}