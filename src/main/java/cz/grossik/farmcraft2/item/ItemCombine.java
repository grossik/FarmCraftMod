package cz.grossik.farmcraft2.item;

import cz.grossik.farmcraft2.Main;
import cz.grossik.farmcraft2.combine.EntityCombine;
import cz.grossik.farmcraft2.handler.BlockHandler;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemCombine extends Item {

	public ItemCombine(){
		this.setCreativeTab(Main.FarmCraft2Tab);
		this.maxStackSize = 1;
	}
	
    /**public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!playerIn.canPlayerEdit(pos.offset(facing), facing, stack))
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            if (facing != EnumFacing.DOWN && facing != EnumFacing.UP)
            {
                pos = pos.offset(facing);
                		
                if (worldIn.isAirBlock(pos))
                {
                	Entity entity = new EntityCombine(worldIn);
                    worldIn.spawnEntityInWorld(entity);

                    if (!playerIn.capabilities.isCreativeMode)
                    {
                        --stack.stackSize;
                    }
                }
                return EnumActionResult.SUCCESS;
            }        	
        }
		return EnumActionResult.PASS;
    }**/
    
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (facing != EnumFacing.UP)
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();

            if (!block.isReplaceable(worldIn, pos))
            {
                pos = pos.offset(facing);
            }

            if (playerIn.canPlayerEdit(pos, facing, stack))
            {
            	if (!worldIn.isRemote)
            	{
            		Entity entity = new EntityCombine(worldIn);
            		entity.setPosition(pos.getX(), pos.getY(), pos.getZ());
            		worldIn.spawnEntityInWorld(entity);

            		--stack.stackSize;
            	}
        		return EnumActionResult.SUCCESS;
            }
            else
            {
                return EnumActionResult.FAIL;
            }
        }
    }
}
