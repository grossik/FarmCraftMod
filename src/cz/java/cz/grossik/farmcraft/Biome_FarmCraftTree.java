package cz.grossik.farmcraft;

import net.minecraft.world.biome.BiomeGenBase;

public class Biome_FarmCraftTree extends BiomeGenBase {

    public Biome_FarmCraftTree(int p_i1986_1_) {
        super(p_i1986_1_);
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.flowersPerChunk = 4;
        this.theBiomeDecorator.grassPerChunk = 10;
    }
}