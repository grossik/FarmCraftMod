package cz.grossik.farmcraft2;

import java.util.Random;

import cz.grossik.farmcraft2.wordgen.tree.WorldGenCherryTree;
import cz.grossik.farmcraft2.wordgen.tree.WorldGenPearTree;
import cz.grossik.farmcraft2.wordgen.tree.WorldGenPlumTree;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTrees;

public class BiomeGenFC2Tree extends BiomeGenBase
{
	private WorldGenAbstractTree WorldGenCherryTrees;
	private WorldGenAbstractTree WorldGenPlumTrees;
	private WorldGenAbstractTree WorldGenPearTrees;

    protected boolean field_150628_aC;

    public BiomeGenFC2Tree(boolean p_i46699_1_, BiomeGenBase.BiomeProperties properties)
    {
        super(properties);
        this.field_150628_aC = p_i46699_1_;
        WorldGenCherryTrees = new WorldGenCherryTree(false);
        WorldGenPlumTrees = new WorldGenPlumTree(false);
        WorldGenPearTrees = new WorldGenPearTree(false);
        this.theBiomeDecorator.treesPerChunk = 2;
        this.theBiomeDecorator.flowersPerChunk = 1;
        this.theBiomeDecorator.grassPerChunk = 8;
    }
    
	@Override
	public WorldGenAbstractTree genBigTreeChance(Random par1Random)
	{
		return (WorldGenAbstractTree)(par1Random.nextInt(10) == 0 ? WorldGenCherryTrees : (par1Random.nextInt(10) == 0 ? WorldGenPlumTrees : WorldGenPearTrees));
	}
}