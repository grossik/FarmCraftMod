package cz.grossik.farmcraft.block.crop;

import cz.grossik.farmcraft.handler.ItemHandler;
import net.minecraft.block.BlockPotato;
import net.minecraft.item.Item;

public class Block_Radish extends BlockPotato {

    public Block_Radish() {

    }

    protected Item func_149866_i() {
        return ItemHandler.RadishSeeds;
    }

    protected Item func_149865_P() {
        return ItemHandler.Radish;
    }
}