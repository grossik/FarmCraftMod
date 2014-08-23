package cze.grossik.farmcraft;

import cze.grossik.farmcraft.block.tree.Block_SaplingCherry;
import cze.grossik.farmcraft.block.tree.Block_SaplingPear;
import cze.grossik.farmcraft.block.tree.Block_SaplingPlum;
import cze.grossik.farmcraft.handler.BlockHandler;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class EventClass {
    /**
     * Used to make the sapling grow the tree *
     */
    public void bonemealUsed(BonemealEvent event) {
        if (event.world.getBlock(event.x, event.y, event.z) == BlockHandler.SaplingPear) {
            ((Block_SaplingPear) BlockHandler.SaplingPear).growTree(event.world, event.x, event.y, event.z, event.world.rand);

        }
        if (event.world.getBlock(event.x, event.y, event.z) == BlockHandler.SaplingCherry) {
            ((Block_SaplingCherry) BlockHandler.SaplingCherry).growTree(event.world, event.x, event.y, event.z, event.world.rand);

        }
        if (event.world.getBlock(event.x, event.y, event.z) == BlockHandler.SaplingPlum) {
            ((Block_SaplingPlum) BlockHandler.SaplingPlum).growTree(event.world, event.x, event.y, event.z, event.world.rand);

        }
    }

}