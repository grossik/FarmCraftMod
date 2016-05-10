package cz.grossik.farmcraft2.block.crop;

import cz.grossik.farmcraft2.handler.BlockHandler;
import cz.grossik.farmcraft2.handler.ItemHandler;
import net.minecraft.block.BlockCarrot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class Block_Grape extends BlockCarrot {
    public Block_Grape() {

    }

    protected Item func_149866_i() {
        return ItemHandler.WineSeeds;
    }

    protected Item func_149865_P() {
        return ItemHandler.Wine;
    }
}