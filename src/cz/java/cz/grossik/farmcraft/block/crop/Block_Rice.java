package cz.grossik.farmcraft.block.crop;

import cz.grossik.farmcraft.handler.ItemHandler;
import net.minecraft.block.BlockPotato;
import net.minecraft.item.Item;

public class Block_Rice extends BlockPotato {

    public Block_Rice() {

    }

    protected Item func_149866_i() {
        return ItemHandler.RiceSeeds;
    }

    protected Item func_149865_P() {
        return ItemHandler.Rice;
    }
}