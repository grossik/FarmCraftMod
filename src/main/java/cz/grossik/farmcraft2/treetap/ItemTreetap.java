package cz.grossik.farmcraft2.treetap;

import javax.annotation.Nullable;

import cz.grossik.farmcraft2.Main;
import cz.grossik.farmcraft2.handler.BlockHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;

public class ItemTreetap extends Item
{
	public ItemTreetap()
    {
        this.maxStackSize = 1;
        this.setCreativeTab(Main.FarmCraft2Tab);
    }

    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!playerIn.canPlayerEdit(pos.offset(facing), facing, stack))
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();

            BlockPos pos2 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
            IBlockState iblockstate2 = worldIn.getBlockState(pos2);
            Block block2 = iblockstate2.getBlock();
            
            BlockPos pos3 = new BlockPos(pos.getX(), pos.getY() + 4, pos.getZ());
            IBlockState iblockstate3 = worldIn.getBlockState(pos3);
            Block block3 = iblockstate3.getBlock();
            
            BlockPos pos4 = new BlockPos(pos.getX(), pos.getY() + 2, pos.getZ());
            IBlockState iblockstate4 = worldIn.getBlockState(pos4);
            Block block4 = iblockstate4.getBlock();
            
            BlockPos pos5 = new BlockPos(pos.getX(), pos.getY() + 3, pos.getZ());
            IBlockState iblockstate5 = worldIn.getBlockState(pos5);
            Block block5 = iblockstate5.getBlock();
            
            BlockPos pos6 = new BlockPos(pos.getX(), pos.getY() + 5, pos.getZ());
            IBlockState iblockstate6 = worldIn.getBlockState(pos6);
            Block block6 = iblockstate6.getBlock();           
            
            if (block == BlockHandler.MapleWood && block2 == BlockHandler.MapleWood && block3 == BlockHandler.MapleWood && block4 == BlockHandler.MapleWood && block5 == BlockHandler.MapleWood && block6 == BlockHandler.MapleLeaves)
            {
                if (facing != EnumFacing.DOWN && facing != EnumFacing.UP)
                {
                    pos = pos.offset(facing);
                    BlockPos pos1 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
                    		
                    if (worldIn.isAirBlock(pos) && worldIn.isAirBlock(pos1))
                    {
                        IBlockState iblockstate1 = BlockHandler.Treetap.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, 0, playerIn);
                        worldIn.setBlockState(pos, iblockstate1, 10);

                        if (!playerIn.capabilities.isCreativeMode)
                        {
                            --stack.stackSize;
                        }
                    }

                    return EnumActionResult.SUCCESS;
                }

                return EnumActionResult.FAIL;
            }
            return EnumActionResult.PASS;

        }
    }
}