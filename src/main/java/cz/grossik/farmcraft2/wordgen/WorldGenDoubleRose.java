package cz.grossik.farmcraft2.wordgen;

import java.util.Random;

import cz.grossik.farmcraft2.flowers.BlockRose;
import cz.grossik.farmcraft2.handler.BlockHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDoubleRose extends WorldGenerator
{
    private BlockRose.EnumRoseType plantType;

    public void setPlantType(BlockRose.EnumRoseType plantTypeIn)
    {
        this.plantType = plantTypeIn;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        boolean flag = false;

        for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.getHasNoSky() || blockpos.getY() < 254) && BlockHandler.Rose.canPlaceBlockAt(worldIn, blockpos))
            {
                BlockHandler.Rose.placeAt(worldIn, blockpos, this.plantType, 2);
                flag = true;
            }
        }

        return flag;
    }
}