package cz.grossik.farmcraft2.wordgen;

import net.minecraft.block.BlockBush;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenLily extends WorldGenerator
{
    private BlockBush block;
    private int size;

    public WorldGenLily(BlockBush blockToSpawn)
    {
        this(blockToSpawn, 4);
    }

    public WorldGenLily(BlockBush blockToSpawn, int groupSize)
    {
        block = blockToSpawn;
        size = groupSize;
    }

    private BlockPos getNearestValidPlantPos(World world, BlockPos pos)
    {
        int maxHeight = world.provider.getDimension() == -1 ? 127 : 255;
        int minY = pos.getY() - 10 < 1 ? 1 : pos.getY() - 10;
        int maxY = pos.getY() + 10 > maxHeight ? maxHeight : pos.getY() + 10;
        for(int y = minY; y <= maxY; y++)
        {
            BlockPos newPos = new BlockPos(pos.getX(), y, pos.getZ());
            if(world.isAirBlock(newPos) && world.getBlockState(newPos.down()).isOpaqueCube())
                return newPos;
        }
        return pos;
    }

    public boolean generate(World world, Random rand, BlockPos position)
    {
        boolean isNether = world.provider.getDimension() == -1;
        int maxHeight = isNether ? 127 : 255;

        for (int i = 0; i < size; ++i)
        {
        	int m = rand.nextInt(3);
        	
            BlockPos pos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if(world.isAirBlock(pos) && (!world.provider.getHasNoSky() || pos.getY() < 255) && block.canBlockStay(world, pos, block.getDefaultState()))
                world.setBlockState(pos, block.getStateFromMeta(m), 3);
            else if(isNether)
            {
                int minY = pos.getY() - 10 < 1 ? 1 : pos.getY() - 10;
                int maxY = pos.getY() + 10 > maxHeight ? maxHeight : pos.getY() + 10;
                for(int y = minY; y <= maxY; y++)
                {
                    BlockPos newPos = new BlockPos(pos.getX(), y, pos.getZ());
                    if(world.isAirBlock(newPos) && block.canBlockStay(world, newPos, block.getStateFromMeta(m)))
                    {
                        world.setBlockState(newPos, block.getStateFromMeta(m), 3);
                        break;
                    }
                }
            }
        }

        return true;
    }
}