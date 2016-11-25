package cz.grossik.farmcraft2.wordgen;

import java.util.Random;

import cz.grossik.farmcraft2.flowers.BlockLily;
import cz.grossik.farmcraft2.flowers.BlockRose;
import cz.grossik.farmcraft2.handler.BlockHandler;
import cz.grossik.farmcraft2.wordgen.tree.WorldGenBananaTree;
import cz.grossik.farmcraft2.wordgen.tree.WorldGenMapleTree;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.world.biome.BiomeForest.Type;
import net.minecraft.world.biome.BiomeJungle;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenDoublePlant;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WordGen implements IWorldGenerator {

	private WorldGenerator gen_ore_cooper;
	private WorldGenerator gen_banana_tree;
	private WorldGenerator gen_maple_tree;
	private WorldGenDoubleRose DOUBLE_PLANT_GENERATOR;
	private WorldGenLily gen_white_lily = new WorldGenLily(BlockHandler.Lily);

	public WordGen(){
		this.gen_ore_cooper = new WorldGenMinable(BlockHandler.OreCopper.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.STONE));
		this.gen_banana_tree = new WorldGenBananaTree(true);
		this.DOUBLE_PLANT_GENERATOR = new WorldGenDoubleRose();
		this.gen_maple_tree = new WorldGenMapleTree(true);
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {		
        Biome biome = world.getBiomeGenForCoords(new BlockPos(chunkX, 0, chunkZ));
        
		switch(world.provider.getDimension()) {	
		case 0: //OverWorld
			this.runGenerator(this.gen_ore_cooper, world, random, chunkX, chunkZ, 16, 10, 70);
			
			if(biome == Biomes.JUNGLE || biome == Biomes.JUNGLE_EDGE || biome == Biomes.JUNGLE_HILLS){	
				this.runGenerator(this.gen_banana_tree, world, random, chunkX, chunkZ, 20, 50, 120);
			}
			
			if(biome == Biomes.COLD_TAIGA || biome == Biomes.TAIGA || biome == Biomes.COLD_TAIGA_HILLS){	
				this.runGenerator(this.gen_maple_tree, world, random, chunkX, chunkZ, 1, 50, 120);
			}
			
			if(biome == Biomes.PLAINS || biome == Biomes.MUTATED_PLAINS){
				gen_white_lily.generate(world, random, world.getHeight(getRandXZInChunk(random, chunkX, chunkZ)));
			}
			
			if(biome == Biomes.FOREST || biome == Biomes.MUTATED_FOREST){	
				
	            int j = random.nextInt(6);

	            if (j == 0)
	            	DOUBLE_PLANT_GENERATOR.setPlantType(BlockRose.EnumRoseType.PINK_ROSE);
	            
	            if(j == 1)
	            	DOUBLE_PLANT_GENERATOR.setPlantType(BlockRose.EnumRoseType.WHITE_ROSE);

	            if(j == 2)
	            	DOUBLE_PLANT_GENERATOR.setPlantType(BlockRose.EnumRoseType.BLUE_ROSE);
	            
	            if(j == 3)
	            	DOUBLE_PLANT_GENERATOR.setPlantType(BlockRose.EnumRoseType.BLACK_ROSE);
	            
	            if(j == 4)
	            	DOUBLE_PLANT_GENERATOR.setPlantType(BlockRose.EnumRoseType.YELLOW_ROSE);
	            
	            if(j == 5)
	            	DOUBLE_PLANT_GENERATOR.setPlantType(BlockRose.EnumRoseType.PURPLE_ROSE);
	            
				int minHeight = 50;
				int maxHeight = 256;
				
				int heightDiff = maxHeight - minHeight + 1;

				int x = chunkX * 16 + random.nextInt(16);
				int y = minHeight + random.nextInt(heightDiff);
				int z = chunkZ * 16 + random.nextInt(16);
				DOUBLE_PLANT_GENERATOR.generate(world, random, new BlockPos(x, y, z));
			}
			
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
	
    private BlockPos getRandXZInChunk(Random random, int chunkX, int chunkZ)
    {
        return getRandXZInChunk(random, chunkX, 0, chunkZ);
    }

    private BlockPos getRandXZInChunk(Random random, int chunkX, int y, int chunkZ)
    {
        return new BlockPos(chunkX * 16 + random.nextInt(16), y, chunkZ * 16 + random.nextInt(16));
    }
}