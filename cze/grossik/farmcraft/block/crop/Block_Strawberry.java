package cze.grossik.farmcraft.block.crop;

import net.minecraft.block.BlockPotato;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import cze.grossik.farmcraft.FarmCraft;
import cze.grossik.farmcraft.handler.BlockHandler;

public class Block_Strawberry extends BlockPotato {
    public Block_Strawberry() {

    }

    protected Item func_149866_i() {
        return null;
    }

    protected Item func_149865_P() {
        return FarmCraft.Strawberry;
    }

    public boolean setBlockStrawberry(World par1World, int par2, int par3, int par4) {
        return par1World.setBlock(par2, par3, par4, BlockHandler.StrawberryBlock);
    }

    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer p5EP) {
        this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 7);
        this.setBlockStrawberry(par1World, par2, par3, par4);
    }
}