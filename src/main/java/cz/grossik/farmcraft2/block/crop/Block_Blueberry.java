package cz.grossik.farmcraft2.block.crop;

import cz.grossik.farmcraft2.handler.BlockHandler;
import cz.grossik.farmcraft2.handler.ItemHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCarrot;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Block_Blueberry extends BlockCarrot {
    public Block_Blueberry() {

    }

    protected Item func_149866_i() {
        return null;
    }

    protected Item func_149865_P() {
        return ItemHandler.Blueberry;
    }
    
    public boolean setBlockBlueberry(World par1World, BlockPos pos) {
        return par1World.setBlockState(pos, BlockHandler.BlueberryBlock.getDefaultState());
    }

    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        this.dropBlockAsItem(worldIn, pos, worldIn.getBlockState(pos), 7);
        this.setBlockBlueberry(worldIn, pos);
    }
}