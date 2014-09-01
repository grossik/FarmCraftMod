package cz.grossik.farmcraft.block.crop;

import cz.grossik.farmcraft.handler.ItemHandler;
import net.minecraft.block.BlockPotato;
import net.minecraft.item.Item;

public class Block_Cabbage extends BlockPotato {

    public Block_Cabbage() {

    }

    protected Item func_149866_i() {
        return ItemHandler.CabbageSeeds;
    }

    protected Item func_149865_P() {
        return ItemHandler.Cabbage;
    }
}