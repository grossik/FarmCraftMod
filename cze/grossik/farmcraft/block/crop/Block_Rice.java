package cze.grossik.farmcraft.block.crop;

import net.minecraft.block.BlockPotato;
import net.minecraft.item.Item;
import cze.grossik.farmcraft.FarmCraft;

public class Block_Rice extends BlockPotato {

    public Block_Rice() {

    }

    protected Item func_149866_i() {
        return FarmCraft.RiceSeeds;
    }

    protected Item func_149865_P() {
        return FarmCraft.Rice;
    }
}