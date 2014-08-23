package cze.grossik.farmcraft.block.crop;

import net.minecraft.block.BlockPotato;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import cze.grossik.farmcraft.FarmCraft;
import cze.grossik.farmcraft.handler.BlockHandler;
import cze.grossik.farmcraft.handler.ItemHandler;

public class Block_Hops extends BlockPotato {
    public Block_Hops() {

    }

    protected Item func_149866_i() {
        return null;
    }

    protected Item func_149865_P() {
        return FarmCraft.Hops;
    }

    public boolean setBlockHops(World par1World, int par2, int par3, int par4) {
        return par1World.setBlock(par2, par3, par4, BlockHandler.HopsBlock);
    }

    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer p5EP) {
        this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 7);
        this.setBlockHops(par1World, par2, par3, par4);
    }
}