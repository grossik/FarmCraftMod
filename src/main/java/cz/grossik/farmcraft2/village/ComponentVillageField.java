package cz.grossik.farmcraft2.village;

import java.util.List;
import java.util.Random;

import cz.grossik.farmcraft2.handler.BlockHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;

public class ComponentVillageField extends StructureVillagePieces.Field2{
	
    /** First crop type for this field. */
    private Block cropTypeA;
    /** Second crop type for this field. */
    private Block cropTypeB;

    public ComponentVillageField()
    {
    }

    public ComponentVillageField(StructureVillagePieces.Start start, int p_i45569_2_, Random rand, StructureBoundingBox p_i45569_4_, EnumFacing facing)
    {
        super(start, p_i45569_2_, rand, p_i45569_4_, facing);
        this.func_186164_a(facing);
        this.boundingBox = p_i45569_4_;
        this.cropTypeA = this.func_151560_a(rand);
        this.cropTypeB = this.func_151560_a(rand);
    }

    /**
     * (abstract) Helper method to write subclass data to NBT
     */
    protected void writeStructureToNBT(NBTTagCompound tagCompound)
    {
        super.writeStructureToNBT(tagCompound);
        tagCompound.setInteger("CA", Block.blockRegistry.getIDForObject(this.cropTypeA));
        tagCompound.setInteger("CB", Block.blockRegistry.getIDForObject(this.cropTypeB));
    }

    /**
     * (abstract) Helper method to read subclass data from NBT
     */
    protected void readStructureFromNBT(NBTTagCompound tagCompound)
    {
        super.readStructureFromNBT(tagCompound);
        this.cropTypeA = Block.getBlockById(tagCompound.getInteger("CA"));
        this.cropTypeB = Block.getBlockById(tagCompound.getInteger("CB"));
    }

    private Block func_151560_a(Random rand)
    {
        switch (rand.nextInt(5)) {
        case 0:
            return BlockHandler.TomatoBlock;
        case 1:
            return BlockHandler.RadishBlock;
        case 2:
            return BlockHandler.BroccoliBlock;
        case 3:
            return BlockHandler.CucumberBlock;
        case 4:
            return BlockHandler.RiceBlock;
        case 5:
            return BlockHandler.CapsicumBlock;
        case 6:
            return BlockHandler.CabbageBlock;
        case 7:
            return BlockHandler.StrawberryBlock;
        case 8:
            return BlockHandler.HopsBlock;
        case 9:
            return BlockHandler.BarleyBlock;
        case 10:
            return BlockHandler.BlueberryBlock;
        case 11:
            return BlockHandler.Corn;
        case 12:
            return BlockHandler.WineBlock;
        default:
            return BlockHandler.PineappleBlock;
    }
}

    public static ComponentVillageField func_175852_a(StructureVillagePieces.Start start, List<StructureComponent> p_175852_1_, Random rand, int p_175852_3_, int p_175852_4_, int p_175852_5_, EnumFacing facing, int p_175852_7_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175852_3_, p_175852_4_, p_175852_5_, 0, 0, 0, 7, 4, 9, facing);
        return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_175852_1_, structureboundingbox) == null ? new ComponentVillageField(start, p_175852_7_, rand, structureboundingbox, facing) : null;
    }

    /**
     * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
     * Mineshafts at the end, it adds Fences...
     */
    public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
    {
        if (this.field_143015_k < 0)
        {
            this.field_143015_k = this.getAverageGroundLevel(worldIn, structureBoundingBoxIn);

            if (this.field_143015_k < 0)
            {
                return true;
            }

            this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 4 - 1, 0);
        }

        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 1, 0, 6, 4, 8, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 0, 1, 2, 0, 7, Blocks.farmland.getDefaultState(), Blocks.farmland.getDefaultState(), false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 0, 1, 5, 0, 7, Blocks.farmland.getDefaultState(), Blocks.farmland.getDefaultState(), false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 0, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 0, 0, 6, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 0, 0, 5, 0, 0, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 0, 8, 5, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 3, 0, 1, 3, 0, 7, Blocks.water.getDefaultState(), Blocks.water.getDefaultState(), false);

        for (int i = 1; i <= 7; ++i)
        {
            int j = ((BlockCrops)this.cropTypeA).func_185526_g();
            int k = j / 3;
            this.setBlockState(worldIn, this.cropTypeA.getStateFromMeta(MathHelper.getRandomIntegerInRange(randomIn, k, j)), 1, 1, i, structureBoundingBoxIn);
            this.setBlockState(worldIn, this.cropTypeA.getStateFromMeta(MathHelper.getRandomIntegerInRange(randomIn, k, j)), 2, 1, i, structureBoundingBoxIn);
            int l = ((BlockCrops)this.cropTypeB).func_185526_g();
            int i1 = l / 3;
            this.setBlockState(worldIn, this.cropTypeB.getStateFromMeta(MathHelper.getRandomIntegerInRange(randomIn, i1, l)), 4, 1, i, structureBoundingBoxIn);
            this.setBlockState(worldIn, this.cropTypeB.getStateFromMeta(MathHelper.getRandomIntegerInRange(randomIn, i1, l)), 5, 1, i, structureBoundingBoxIn);
        }

        for (int j1 = 0; j1 < 9; ++j1)
        {
            for (int k1 = 0; k1 < 7; ++k1)
            {
                this.clearCurrentPositionBlocksUpwards(worldIn, k1, 4, j1, structureBoundingBoxIn);
                this.replaceAirAndLiquidDownwards(worldIn, Blocks.dirt.getDefaultState(), k1, -1, j1, structureBoundingBoxIn);
            }
        }

        return true;
    }
}