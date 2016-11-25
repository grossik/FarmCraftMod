package cz.grossik.farmcraft2.block.crop;

import cz.grossik.farmcraft2.handler.BlockHandler;
import cz.grossik.farmcraft2.handler.ItemHandler;
import net.minecraft.block.BlockCarrot;
import net.minecraft.block.BlockCrops;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Block_Hops extends BlockCrops {
    public Block_Hops() {

    }

    protected Item func_149866_i() {
        return null;
    }

    protected Item func_149865_P() {
        return ItemHandler.Hops;
    }
    
    public boolean setBlockHops(World par1World, BlockPos pos) {
        return par1World.setBlockState(pos, BlockHandler.HopsBlock.getDefaultState());
    }

    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        int i = this.getAge(worldIn.getBlockState(pos));

    	if(i == this.getMaxAge()){        
    		this.dropBlockAsItem(worldIn, pos, worldIn.getBlockState(pos), 7);
    		this.setBlockHops(worldIn, pos);
    	}
    }
}