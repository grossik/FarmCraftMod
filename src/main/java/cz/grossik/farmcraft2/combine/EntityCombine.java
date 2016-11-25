package cz.grossik.farmcraft2.combine;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import cz.grossik.farmcraft2.FC2Sounds;
import cz.grossik.farmcraft2.block.crop.Block_Corn;
import cz.grossik.farmcraft2.handler.ItemHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IJumpingMount;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventoryChangedListener;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

enum Type
{
    VEHICLE("combine", null, null, null, null);

    private final TextComponentTranslation name;
    private final SoundEvent hurtSound;
    private final SoundEvent ambientSound;
    private final SoundEvent deathSound;
    private final ResourceLocation lootTable;

    private Type(String p_i46798_3_, SoundEvent ambientSound, SoundEvent hurtSoundIn, SoundEvent deathSoundIn, ResourceLocation lootTableIn)
    {
        this.name = new TextComponentTranslation("entity." + p_i46798_3_ + ".name", new Object[0]);
        this.hurtSound = hurtSoundIn;
        this.ambientSound = ambientSound;
        this.deathSound = deathSoundIn;
        this.lootTable = lootTableIn;
    }

    public SoundEvent getAmbientSound()
    {
        return this.ambientSound;
    }

    public SoundEvent getHurtSound()
    {
        return this.hurtSound;
    }

    public SoundEvent getDeathSound()
    {
        return this.deathSound;
    }

    /**
     * Gets the default name for horses of this type
     */
    public TextComponentTranslation getDefaultName()
    {
        return this.name;
    }

    public boolean isUndead()
    {
        return this != VEHICLE;
    }

    public boolean isVehicle()
    {
        return this == VEHICLE;
    }

    public int getOrdinal()
    {
        return this.ordinal();
    }

    public static Type getArmorType(int armorID)
    {
        return values()[armorID];
    }

    public ResourceLocation getLootTable()
    {
        return this.lootTable;
    }
}

public class EntityCombine extends EntityLiving implements IInventoryChangedListener, IJumpingMount
{
    private static final Predicate<Entity> IS_HORSE_BREEDING = new Predicate<Entity>()
    {
        public boolean apply(@Nullable Entity p_apply_1_)
        {
            return p_apply_1_ instanceof EntityCombine && ((EntityCombine)p_apply_1_).isBreeding();
        }
    };
    private static final DataParameter<Byte> STATUS = EntityDataManager.<Byte>createKey(EntityCombine.class, DataSerializers.BYTE);
    private static final DataParameter<Integer> TYPE = EntityDataManager.<Integer>createKey(EntityCombine.class, DataSerializers.VARINT);
    private int jumpRearingCounter;
    public int tailCounter;
    public int sprintCounter;
    protected int temper;
    private boolean allowStandSliding;
    private float rearingAmount;
    private int gallopTime;
    
    @SideOnly(Side.CLIENT)
    
    public EntityCombine(World worldIn)
    {
        super(worldIn);
        this.setSize(3.0F, 4.5F);
        this.isImmuneToFire = true;
        this.stepHeight = 1.0F;
    }
    
    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(STATUS, Byte.valueOf((byte)0));
        this.dataManager.register(TYPE, Integer.valueOf(Type.VEHICLE.getOrdinal()));
    }

    public void setType(Type armorType)
    {
        this.dataManager.set(TYPE, Integer.valueOf(armorType.getOrdinal()));
    }

    public Type getType()
    {
        return Type.getArmorType(((Integer)this.dataManager.get(TYPE)).intValue());
    }

    public String getName()
    {
        return this.hasCustomName() ? this.getCustomNameTag() : this.getType().getDefaultName().getUnformattedText();
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        SoundType soundtype = blockIn.getSoundType(worldObj.getBlockState(pos), worldObj, pos, this);

        if (this.worldObj.getBlockState(pos.up()).getBlock() == Blocks.SNOW_LAYER)
        {
            soundtype = Blocks.SNOW_LAYER.getSoundType();
        }

        if (!blockIn.getDefaultState().getMaterial().isLiquid())
        {
            Type horsetype = this.getType();

            if (this.isBeingRidden())
            {
                ++this.gallopTime;

                if (this.gallopTime > 5 && this.gallopTime % 3 == 0)
                {
                    this.playSound(FC2Sounds.kombajn, soundtype.getVolume() * 0.15F, soundtype.getPitch());

                    if (horsetype == Type.VEHICLE && this.rand.nextInt(10) == 0)
                    {
                        this.playSound(FC2Sounds.kombajn, soundtype.getVolume() * 0.15F, soundtype.getPitch());
                    }
                }
                else if (this.gallopTime <= 5)
                {
                    this.playSound(FC2Sounds.kombajn, soundtype.getVolume() * 0.15F, soundtype.getPitch());
                }
            }
            else if (soundtype == SoundType.WOOD)
            {
                this.playSound(FC2Sounds.kombajn, soundtype.getVolume() * 0.15F, soundtype.getPitch());
            }
            else
            {
                this.playSound(FC2Sounds.kombajn, soundtype.getVolume() * 0.15F, soundtype.getPitch());
            }
        }
    }
    
    protected boolean canDespawn()
    {
        return false;
    }
    
    private boolean getHorseWatchableBoolean(int p_110233_1_)
    {
        return (((Byte)this.dataManager.get(STATUS)).byteValue() & p_110233_1_) != 0;
    }

    private void setHorseWatchableBoolean(int p_110208_1_, boolean p_110208_2_)
    {
        byte b0 = ((Byte)this.dataManager.get(STATUS)).byteValue();

        if (p_110208_2_)
        {
            this.dataManager.set(STATUS, Byte.valueOf((byte)(b0 | p_110208_1_)));
        }
        else
        {
            this.dataManager.set(STATUS, Byte.valueOf((byte)(b0 & ~p_110208_1_)));
        }
    }

    //zustane
    @Override
    public boolean isChild()
    {
        return false;
    }
    
    //zustane
    public boolean isAdultHorse()
    {
        return !this.isChild();
    }

    public boolean isTame()
    {
        return this.getHorseWatchableBoolean(2);
    }
  
    public boolean isRidable()
    {
        return this.isAdultHorse();
    }

    public boolean canBeLeashedTo(EntityPlayer player)
    {
        return !this.getType().isUndead() && super.canBeLeashedTo(player);
    }

    public boolean isEatingHaystack()
    {
        return this.getHorseWatchableBoolean(32);
    }

    public boolean isRearing()
    {
        return this.getHorseWatchableBoolean(64);
    }

    public boolean isBreeding()
    {
        return this.getHorseWatchableBoolean(16);
    }

    public void setBreeding(boolean breeding)
    {
        this.setHorseWatchableBoolean(16, breeding);
    }

    public int getTemper()
    {
        return this.temper;
    }

    public void setTemper(int temperIn)
    {
        this.temper = temperIn;
    }

    public int increaseTemper(int p_110198_1_)
    {
        int i = MathHelper.clamp_int(this.getTemper() + p_110198_1_, 0, this.getMaxTemper());
        this.setTemper(i);
        return i;
    }

    public boolean attackEntityFrom(DamageSource source, float amount)
    {
    	Entity entity = source.getEntity();
        return this.isBeingRidden() && entity != null && this.isRidingOrBeingRiddenBy(entity) ? false : super.attackEntityFrom(source, amount);
    }

    public boolean prepareChunkForSpawn()
    {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posZ);
        this.worldObj.getBiomeGenForCoords(new BlockPos(i, 0, j));
        return true;
    }

    //zustane
    public void fall(float distance, float damageMultiplier)
    { }

    //zustane
    public void onInventoryChanged(InventoryBasic invBasic)
    { }

    public boolean getCanSpawnHere()
    {
        this.prepareChunkForSpawn();
        return super.getCanSpawnHere();
    }

    protected EntityCombine getClosestHorse(Entity entityIn, double distance)
    {
        double d0 = Double.MAX_VALUE;
        Entity entity = null;

        for (Entity entity1 : this.worldObj.getEntitiesInAABBexcluding(entityIn, entityIn.getEntityBoundingBox().addCoord(distance, distance, distance), IS_HORSE_BREEDING))
        {
            double d1 = entity1.getDistanceSq(entityIn.posX, entityIn.posY, entityIn.posZ);

            if (d1 < d0)
            {
                entity = entity1;
                d0 = d1;
            }
        }

        return (EntityCombine)entity;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
    }

    public int getMaxTemper()
    {
        return 100;
    }

    protected float getSoundVolume()
    {
        return 0.8F;
    }

    public int getTalkInterval()
    {
        return 400;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasLayeredTextures()
    {
        return this.getType() == Type.VEHICLE;
    }

    public boolean processInteract(EntityPlayer player, EnumHand hand, @Nullable ItemStack stack)
    {
        if (stack != null)
        {
            return super.processInteract(player, hand, stack);
        }
        else if (!this.isTame() && this.getType().isUndead())
        {
            return false;
        }
        else if (this.isTame() && this.isAdultHorse() && player.isSneaking())
        {
            return true;
        }
        else if (this.isRidable() && this.isBeingRidden())
        {
            return super.processInteract(player, hand, stack);
        }
        else
        {
            if (this.isRidable() && !this.isBeingRidden())
            {
                this.mountTo(player);
				return true;
            }
            else
            {
                return super.processInteract(player, hand, stack);
            }
        }
    }

    private void mountTo(EntityPlayer player)
    {
        player.rotationYaw = this.rotationYaw;
        player.rotationPitch = this.rotationPitch;

        if (!this.worldObj.isRemote)
        {
            player.startRiding(this);
        }
    }

    protected boolean isMovementBlocked()
    {
        return this.isBeingRidden() ? true : this.isEatingHaystack() || this.isRearing();
    }

    public boolean isBreedingItem(@Nullable ItemStack stack)
    {
        return false;
    }

    private void moveTail()
    {
        this.tailCounter = 1;
    }
    
    @Override
    protected void onDeathUpdate()
    {
        this.setDead();
    }
    
    protected SoundEvent getDeathSound()
    {
        return this.getType().getDeathSound();
    }

    protected SoundEvent getHurtSound()
    {
        return this.getType().getHurtSound();
    }
    
    protected SoundEvent getAmbientSound()
    {
        return this.getType().getAmbientSound();
    }
    
    //zustane
    @Override
    public void onDeath(DamageSource cause)
    {
        this.dropItem(ItemHandler.ItemCombine, 1);
    }

    public void onLivingUpdate()
    {
        if (this.rand.nextInt(200) == 0)
        {
            this.moveTail();
        }

        super.onLivingUpdate();

        if (!this.worldObj.isRemote)
        {
            if (this.rand.nextInt(900) == 0 && this.deathTime == 0)
            {
                this.heal(1.0F);
            }

            if (this.isBreeding() && !this.isAdultHorse() && !this.isEatingHaystack())
            {
                EntityCombine entityhorse = this.getClosestHorse(this, 16.0D);

                if (entityhorse != null && this.getDistanceSqToEntity(entityhorse) > 4.0D)
                {
                    this.navigator.getPathToEntityLiving(entityhorse);
                }
            }
            
            int RADII = 3;            
    		for(BlockPos pos : BlockPos.getAllInBox(getPosition().add(-RADII, -RADII, -RADII), getPosition().add(RADII, RADII, RADII))){
    			Block block = worldObj.getBlockState(pos).getBlock();
    			if(block instanceof BlockCrops){
                    this.worldObj.destroyBlock(pos, true);
    			}
    			if(block instanceof Block_Corn){
                    this.worldObj.destroyBlock(pos, true);
    			}
    			if(block instanceof BlockBush){    				
                    this.worldObj.destroyBlock(pos, true);
    			}
    		}
        }
    }
	
    public void onUpdate()
    {
        super.onUpdate();

        if (this.worldObj.isRemote && this.dataManager.isDirty())
        {
            this.dataManager.setClean();
        }

        if (this.canPassengerSteer() && this.jumpRearingCounter > 0 && ++this.jumpRearingCounter > 20)
        {
            this.jumpRearingCounter = 0;
        }

        if (this.tailCounter > 0 && ++this.tailCounter > 8)
        {
            this.tailCounter = 0;
        }

        if (this.sprintCounter > 0)
        {
            ++this.sprintCounter;

            if (this.sprintCounter > 300)
            {
                this.sprintCounter = 0;
            }
        }
    }
    
    //zustane
    public void moveEntityWithHeading(float strafe, float forward)
    {
        if (this.isBeingRidden() && this.canBeSteered())
        {
            EntityLivingBase entitylivingbase = (EntityLivingBase)this.getControllingPassenger();
            this.rotationYaw = entitylivingbase.rotationYaw;
            this.prevRotationYaw = this.rotationYaw;
            this.rotationPitch = entitylivingbase.rotationPitch * 0.5F;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.renderYawOffset = this.rotationYaw;
            this.rotationYawHead = this.renderYawOffset;
            strafe = entitylivingbase.moveStrafing * 0.5F;
            forward = entitylivingbase.moveForward;

            if (forward <= 0.0F)
            {
                forward *= 0.25F;
                this.gallopTime = 0;
            }

            if (this.onGround && this.isRearing() && !this.allowStandSliding)
            {
                strafe = 0.0F;
                forward = 0.0F;
            }

            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

            if (this.canPassengerSteer())
            {
                this.setAIMoveSpeed((float)this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
                super.moveEntityWithHeading(strafe, forward);
            }
            else if (entitylivingbase instanceof EntityPlayer)
            {
                this.motionX = 0.0D;
                this.motionY = 0.0D;
                this.motionZ = 0.0D;
            }
            
            this.prevLimbSwingAmount = this.limbSwingAmount;
            double d1 = this.posX - this.prevPosX;
            double d0 = this.posZ - this.prevPosZ;
            float f2 = MathHelper.sqrt_double(d1 * d1 + d0 * d0) * 4.0F;

            if (f2 > 1.0F)
            {
                f2 = 1.0F;
            }

            this.limbSwingAmount += (f2 - this.limbSwingAmount) * 0.4F;
            this.limbSwing += this.limbSwingAmount;
        }
        else
        {
            this.jumpMovementFactor = 0.02F;
            super.moveEntityWithHeading(strafe, forward);
        }
    }

    //zustane
    public boolean canBeSteered()
    {
        Entity entity = this.getControllingPassenger();
        return entity instanceof EntityLivingBase;
    }

    //zustane
    @SideOnly(Side.CLIENT)
    public void setJumpPower(int jumpPowerIn)
    { }
    
    //zustane
    public boolean canJump()
    {
        return false;
    }

    //zustane
    public void handleStartJump(int p_184775_1_)
    { }

    //zustane
    public void handleStopJump()
    { }

    //zustane
    public boolean isOnLadder()
    {
        return false;
    }

    //zustane
    @Override
    public float getEyeHeight()
    {
        return this.height;
    }

    //zustane
    @Nullable
    public Entity getControllingPassenger()
    {
        return this.getPassengers().isEmpty() ? null : (Entity)this.getPassengers().get(0);
    }
}