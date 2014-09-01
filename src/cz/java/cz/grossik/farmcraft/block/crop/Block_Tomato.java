package cz.grossik.farmcraft.block.crop;

import cz.grossik.farmcraft.handler.ItemHandler;
import net.minecraft.block.BlockPotato;
import net.minecraft.item.Item;

public class Block_Tomato extends BlockPotato {
    public Block_Tomato() {

    }

    protected Item func_149866_i() {
        return ItemHandler.TomatoSeeds;
    }

    protected Item func_149865_P() {
        return ItemHandler.Tomato;
    }
}