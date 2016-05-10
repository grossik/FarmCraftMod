package cz.grossik.farmcraft2.wordgen;

import java.util.Random;

import cz.grossik.farmcraft2.handler.BlockHandler;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WordGen implements IWorldGenerator {

	private WorldGenerator gen_ore_cooper;
	
	public WordGen(){
		this.gen_ore_cooper = new WorldGenMinable(BlockHandler.OreCopper.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.stone));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()) {
		case 0: //OverWorld
			this.runGenerator(this.gen_ore_cooper, world, random, chunkX, chunkZ, 20, 0, 64);
			break;
		case -1: //Nether
			
			break;
		case 1: //End
			
			break;
		}
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random random, int chunk_X, int chunk_Z, int changeToSpawn, int minHeight, int maxHeight){
		if(minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arquments fot WorldGenerator");
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < changeToSpawn; i++) {
			int x = chunk_X * 16 + random.nextInt(16);
			int y = minHeight + random.nextInt(heightDiff);
			int z = chunk_Z * 16 + random.nextInt(16);
			generator.generate(world, random, new BlockPos(x, y, z));
		}
	}

}
