package cze.grossik.farmcraft.block.crop;

import net.minecraft.block.BlockPotato;
import net.minecraft.item.Item;
import cze.grossik.farmcraft.FarmCraft;
import cze.grossik.farmcraft.handler.ItemHandler;

public class Block_Capsicum extends BlockPotato {

    public Block_Capsicum() {

    }

    protected Item func_149866_i() {
        return FarmCraft.CapsicumSeeds;
    }

    protected Item func_149865_P() {
        return FarmCraft.Capsicum;
    }
}