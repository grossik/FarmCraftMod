package cz.grossik.farmcraft.block.crop;

import cz.grossik.farmcraft.handler.ItemHandler;
import net.minecraft.block.BlockPotato;
import net.minecraft.item.Item;

public class Block_Pineapple extends BlockPotato {

    public Block_Pineapple() {

    }

    protected Item func_149866_i() {
        return ItemHandler.PineappleSeeds;
    }

    protected Item func_149865_P() {
        return ItemHandler.Pineapple;
    }
}