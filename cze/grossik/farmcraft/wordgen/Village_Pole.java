package cze.grossik.farmcraft.wordgen;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureVillagePieces.Start;
import cze.grossik.farmcraft.handler.BlockHandler;

public class Village_Pole extends StructureVillagePieces.Field2 {
    private static final String __OBFID = "CL_00000518";
    /**
     * First crop type for this field.
     */
    private Block cropTypeA;
    /**
     * Second crop type for this field.
     */
    private Block cropTypeB;
    /**
     * Third crop type for this field.
     */
    private Block cropTypeC;
    /**
     * Fourth crop type for this field.
     */
    private Block cropTypeD;

    public Village_Pole() {
    }


    public Village_Pole(StructureVillagePieces.Start p_i2095_1_, int p_i2095_2_, Random p_i2095_3_, StructureBoundingBox p_i2095_4_, int p_i2095_5_) {
        super();
        this.coordBaseMode = p_i2095_5_;
        this.boundingBox = p_i2095_4_;
        this.cropTypeA = this.func_151559_a(p_i2095_3_);
        this.cropTypeB = this.func_151559_a(p_i2095_3_);
        this.cropTypeC = this.func_151559_a(p_i2095_3_);
        this.cropTypeD = this.func_151559_a(p_i2095_3_);
    }

    public static Village_Pole buildComponent(Start villagePiece, List pieces, Random random, int p1, int p2, int p3, int p4, int p5) {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p1, p2, p3, 0, 0, 0, 7, 6, 7, p4);
        return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null ? new Village_Pole(villagePiece, p5, random,
                structureboundingbox, p4) : null;
    }

    public static StructureVillagePieces.Field2 func_74902_a(StructureVillagePieces.Start p_74902_0_, List p_74902_1_, Random p_74902_2_, int p_74902_3_, int p_74902_4_, int p_74902_5_, int p_74902_6_, int p_74902_7_) {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74902_3_, p_74902_4_, p_74902_5_, 0, 0, 0, 7, 4, 9, p_74902_6_);
        return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_74902_1_, structureboundingbox) == null ? new StructureVillagePieces.Field2(p_74902_0_, p_74902_7_, p_74902_2_, structureboundingbox, p_74902_6_) : null;
    }

    protected void func_143012_a(NBTTagCompound p_143012_1_) {
        super.func_143012_a(p_143012_1_);
        p_143012_1_.setInteger("CA", Block.blockRegistry.getIDForObject(this.cropTypeA));
        p_143012_1_.setInteger("CB", Block.blockRegistry.getIDForObject(this.cropTypeB));
        p_143012_1_.setInteger("CC", Block.blockRegistry.getIDForObject(this.cropTypeC));
        p_143012_1_.setInteger("CD", Block.blockRegistry.getIDForObject(this.cropTypeD));
    }

    protected void func_143011_b(NBTTagCompound p_143011_1_) {
        super.func_143011_b(p_143011_1_);
        this.cropTypeA = Block.getBlockById(p_143011_1_.getInteger("CA"));
        this.cropTypeB = Block.getBlockById(p_143011_1_.getInteger("CB"));
        this.cropTypeC = Block.getBlockById(p_143011_1_.getInteger("CC"));
        this.cropTypeD = Block.getBlockById(p_143011_1_.getInteger("CD"));
    }

    private Block func_151559_a(Random p_151559_1_) {
        switch (p_151559_1_.nextInt(5)) {
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
            default:
                return BlockHandler.PineappleBlock;
        }
    }

    public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
        if (this.field_143015_k < 0) {
            this.field_143015_k = this.getAverageGroundLevel(p_74875_1_, p_74875_3_);

            if (this.field_143015_k < 0) {
                return true;
            }

            this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 4 - 1, 0);
        }

        this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 4, 0, 6, 4, 8, Blocks.air, Blocks.air, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 2, 1, 2, 2, 7, Blocks.farmland, Blocks.farmland, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 2, 1, 5, 2, 7, Blocks.farmland, Blocks.farmland, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 2, 8, Blocks.log, Blocks.log, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 6, 2, 0, 6, 2, 8, Blocks.log, Blocks.log, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 2, 0, 5, 2, 0, Blocks.log, Blocks.log, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 2, 8, 5, 2, 8, Blocks.log, Blocks.log, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 2, 1, 3, 2, 7, Blocks.water, Blocks.water, false);
        int i;

        for (i = 1; i <= 7; ++i) {
            this.placeBlockAtCurrentPosition(p_74875_1_, this.cropTypeA, MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 7), 1, 3, i, p_74875_3_);
            this.placeBlockAtCurrentPosition(p_74875_1_, this.cropTypeA, MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 7), 2, 3, i, p_74875_3_);
            this.placeBlockAtCurrentPosition(p_74875_1_, this.cropTypeB, MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 7), 4, 3, i, p_74875_3_);
            this.placeBlockAtCurrentPosition(p_74875_1_, this.cropTypeB, MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 7), 5, 3, i, p_74875_3_);
        }

        for (i = 0; i < 9; ++i) {
            for (int j = 0; j < 7; ++j) {
                this.clearCurrentPositionBlocksUpwards(p_74875_1_, j, 4, i, p_74875_3_);
                this.func_151554_b(p_74875_1_, Blocks.dirt, 0, j, -1, i, p_74875_3_);
            }
        }

        return true;
    }
}