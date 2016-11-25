package cz.grossik.farmcraft2.treetap;

import javax.annotation.Nullable;

import cz.grossik.farmcraft2.handler.BlockHandler;
import cz.grossik.farmcraft2.handler.ItemHandler;
import cz.grossik.farmcraft2.juicer.JuicerRecipes;
import cz.grossik.farmcraft2.juicer.SlotJuicerFuel;
import cz.grossik.farmcraft2.util.TileEntityFC;
import cz.grossik.farmcraft2.util.TileEntityFC.ContainerSlot;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TileEntityTreetap extends TileEntityLockable implements ITickable, ISidedInventory
{
    private String furnaceCustomName;
    private ItemStack[] furnaceItemStacks = new ItemStack[3];
    private double pocetSirupu = 0;
    private int MaxPocetSirupu = 10000;
    
	public int getSizeInventory() {
        return this.furnaceItemStacks.length;
	}

	@Nullable
	public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.furnaceItemStacks, index);
	}

	public int getInventoryStackLimit() {
		return 64;
	}
	
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        
        compound.setDouble("PocetSirupu", this.pocetSirupu);
		
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.furnaceItemStacks.length; ++i)
        {
            if (this.furnaceItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                this.furnaceItemStacks[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }

        compound.setTag("Items", nbttaglist);
        
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        NBTTagList nbttaglist = compound.getTagList("Items", 10);
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound.getByte("Slot");

            if (j >= 0 && j < this.furnaceItemStacks.length)
            {
                this.furnaceItemStacks[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }
        
        this.pocetSirupu = compound.getDouble("PocetSirupu");
    }
    
	public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
	}

	public void openInventory(EntityPlayer player) {}

	public void closeInventory(EntityPlayer player) {}

    public static int getItemBurnTime(ItemStack p_145952_0_)
    {
        if (p_145952_0_ == null)
        {
            return 0;
        }
        else
        {
            Item item = p_145952_0_.getItem();
            return net.minecraftforge.fml.common.registry.GameRegistry.getFuelValue(p_145952_0_);
        }
    }
    
    public static boolean isItemFuel(ItemStack p_145954_0_)
    {
        return getItemBurnTime(p_145954_0_) > 0;
    }
    
	public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (index == 2)
        {
            return false;
        }
        else if (index != 1)
        {
            return true;
        }
        else
        {
            ItemStack itemstack = this.furnaceItemStacks[1];
            return isItemFuel(stack) || SlotJuicerFuel.isBucket(stack) && (itemstack == null || itemstack.getItem() != Items.BUCKET);
        }
   }

	public int getField(int id) {
	    switch (id)
        {
        	case 0:
        		return (int) this.pocetSirupu;
	    	default:
	    		return 0;
	    }
    }

	public void setField(int id, int value) {	
        switch (id)
        {
            case 0:
                this.pocetSirupu = value;
        }
	}

	public int getFieldCount() {
		return 1;
	}

	public void clear() {	
        for (int i = 0; i < this.furnaceItemStacks.length; ++i)
        {
            this.furnaceItemStacks[i] = null;
        }
	}

    public String getName()
    {
        return this.hasCustomName() ? this.furnaceCustomName : "Treetap";
    }
    
    public boolean hasCustomName()
    {
        return this.furnaceCustomName != null && !this.furnaceCustomName.isEmpty();
    }
    
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return new ContainerTreetap(playerInventory, this);
	}

	public String getGuiID() {
		return "8";
	}

	public int[] getSlotsForFace(EnumFacing side) {
		return null;
	}

	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
        return this.isItemValidForSlot(index, itemStackIn);
	}

	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
	       if (direction == EnumFacing.DOWN && index == 1)
	        {
	            Item item = stack.getItem();

	            if (item != Items.WATER_BUCKET && item != Items.BUCKET)
	            {
	                return false;
	            }
	        }
	       return true;
	}

	public void update() {	
		
        boolean flag1 = false;

		if (!this.worldObj.isRemote)
        {
			if(this.pocetSirupu < this.MaxPocetSirupu)
			{
				this.pocetSirupu += 0.05F; 
			}

			flag1 = true;
    			
        	if(canSmelt()){
        		if(this.pocetSirupu >= 1000 )
        			this.smeltItem();
			}
        }
        
        if (flag1)
        {
            this.markDirty();
        }

        IBlockState iblockstate = this.worldObj.getBlockState(pos);

        EnumFacing enumfacing = (EnumFacing)BlockHandler.Treetap.getActualState(iblockstate, worldObj, pos).getValue(BlockTreetap.FACING);

        BlockPos pos0 = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        IBlockState iblockstate0 = this.worldObj.getBlockState(pos0.offset(enumfacing.getOpposite()));
        Block block0 = iblockstate0.getBlock();
        
        BlockPos pos1 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
        IBlockState iblockstate1 = this.worldObj.getBlockState(pos1.offset(enumfacing.getOpposite()));
        Block block1 = iblockstate1.getBlock();
        
        BlockPos pos2 = new BlockPos(pos.getX(), pos.getY() + 2, pos.getZ());
        IBlockState iblockstate2 = this.worldObj.getBlockState(pos2.offset(enumfacing.getOpposite()));
        Block block2 = iblockstate2.getBlock();

        BlockPos pos3 = new BlockPos(pos.getX(), pos.getY() + 3, pos.getZ());
        IBlockState iblockstate3 = this.worldObj.getBlockState(pos3.offset(enumfacing.getOpposite()));
        Block block3 = iblockstate3.getBlock();
        
        BlockPos pos4 = new BlockPos(pos.getX(), pos.getY() + 4, pos.getZ());
        IBlockState iblockstate4 = this.worldObj.getBlockState(pos4.offset(enumfacing.getOpposite()));
        Block block4 = iblockstate4.getBlock();
        
        BlockPos pos5 = new BlockPos(pos.getX(), pos.getY() + 5, pos.getZ());
        IBlockState iblockstate5 = this.worldObj.getBlockState(pos5.offset(enumfacing.getOpposite()));
        Block block5 = iblockstate5.getBlock();
                
        if(block0 != BlockHandler.MapleWood || 
           block1 != BlockHandler.MapleWood || 
           block2 != BlockHandler.MapleWood ||
           block3 != BlockHandler.MapleWood ||
           block4 != BlockHandler.MapleWood ||
           block5 != BlockHandler.MapleLeaves)
        {
        	BlockHandler.Treetap.dropBlockAsItem(worldObj, pos, iblockstate, 0);
            this.worldObj.setBlockToAir(pos);
        }
	}

	public void setCustomInventoryName(String p_145951_1_)
	{
		this.furnaceCustomName = p_145951_1_;
	}

    public ItemStack getStackInSlot(int index)
    {
        return this.furnaceItemStacks[index];
    }

    @Nullable
    public ItemStack decrStackSize(int index, int count)
    {
        return ItemStackHelper.getAndSplit(this.furnaceItemStacks, index, count);
    }
    
	public void setInventorySlotContents(int index, ItemStack stack) {
        boolean flag = stack != null && stack.isItemEqual(this.furnaceItemStacks[index]) && ItemStack.areItemStackTagsEqual(stack, this.furnaceItemStacks[index]);
        this.furnaceItemStacks[index] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }	
	}

    private boolean canSmelt()
    {
        if (this.furnaceItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = new ItemStack(Items.BUCKET);
            if (itemstack == null) return false;
            if (this.furnaceItemStacks[2] == null) return true;
            if (!this.furnaceItemStacks[2].isItemEqual(itemstack)) return false;
            int result = furnaceItemStacks[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[2].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }
    
	public void smeltItem()
	{
        if (this.canSmelt())
        {
        	if(this.furnaceItemStacks[0].getItem() == Items.BUCKET){
				this.furnaceItemStacks[2] = new ItemStack(ItemHandler.SapBucket);
				--this.furnaceItemStacks[0].stackSize;
				this.pocetSirupu -= 1000;
			}	
			
			if (this.furnaceItemStacks[0].stackSize <= 0)
			{
				this.furnaceItemStacks[0] = null;
			}
        }
	}
}