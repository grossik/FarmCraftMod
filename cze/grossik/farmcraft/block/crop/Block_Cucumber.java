package cze.grossik.farmcraft.block.crop;

import net.minecraft.block.BlockPotato;
import net.minecraft.item.Item;
import cze.grossik.farmcraft.FarmCraft;
import cze.grossik.farmcraft.handler.ItemHandler;

public class Block_Cucumber extends BlockPotato {

    public Block_Cucumber() {

    }

    protected Item func_149866_i() {
        return FarmCraft.CucumberSeeds;
    }

    protected Item func_149865_P() {
        return FarmCraft.Cucumber;
    }
}