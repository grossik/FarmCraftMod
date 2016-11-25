package cz.grossik.farmcraft2.village;

import java.util.List;
import java.util.Random;

import cz.grossik.farmcraft2.handler.BlockHandler;
import cz.grossik.farmcraft2.spigot.Block_Spigot;
import cz.grossik.farmcraft2.util.BlockFC2SidedMachine;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;

public class ComponentVillagePub extends StructureVillagePieces.Hall{

        public ComponentVillagePub()
        {
        }

        public ComponentVillagePub(StructureVillagePieces.Start start, int type, Random rand, StructureBoundingBox p_i45567_4_, EnumFacing facing)
        {
            super();
            this.setCoordBaseMode(facing);
            this.boundingBox = p_i45567_4_;
        }

        public static ComponentVillagePub createPiece(StructureVillagePieces.Start start, List<StructureComponent> p_175857_1_, Random rand, int p_175857_3_, int p_175857_4_, int p_175857_5_, EnumFacing facing, int p_175857_7_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175857_3_, p_175857_4_, p_175857_5_, -1, 0, -1, 14, 7, 18, facing);
            return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_175857_1_, structureboundingbox) == null ? new ComponentVillagePub(start, p_175857_7_, rand, structureboundingbox, facing) : null;
        }

        public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
        {
            if (this.averageGroundLvl < 0)
            {
                this.averageGroundLvl = this.getAverageGroundLevel(worldIn, structureBoundingBoxIn);

                if (this.averageGroundLvl < 0)
                {
                    return true;
                }

                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 7 - 1, 0);
            }

            IBlockState iblockstate = this.getBiomeSpecificBlockState(Blocks.COBBLESTONE.getDefaultState());
            IBlockState iblockstate1 = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH));
            IBlockState iblockstate2 = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.SOUTH));
            IBlockState iblockstate3 = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.WEST));
            IBlockState iblockstate4 = this.getBiomeSpecificBlockState(Blocks.PLANKS.getDefaultState());
            IBlockState iblockstate5 = this.getBiomeSpecificBlockState(Blocks.LOG.getDefaultState());
            IBlockState iblockstate6 = this.getBiomeSpecificBlockState(Blocks.OAK_FENCE.getDefaultState());
            IBlockState iblockstate9 = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.EAST));
            IBlockState iblockstate10 = this.getBiomeSpecificBlockState(Blocks.WOODEN_PRESSURE_PLATE.getDefaultState());

            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 0, 1, 14, 0, 9, iblockstate, iblockstate, false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 4, 1, 14, 4, 9, iblockstate, iblockstate, false);

            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 1, 1, 14, 1, 1, iblockstate, iblockstate, false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 1, 9, 14, 1, 9, iblockstate, iblockstate, false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 1, 1, 1, 1, 9, iblockstate, iblockstate, false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 14, 1, 1, 14, 1, 9, iblockstate, iblockstate, false);

            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 2, 1, 1, 4, 1, iblockstate, iblockstate, false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 2, 9, 1, 4, 9, iblockstate, iblockstate, false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 14, 2, 1, 14, 4, 1, iblockstate, iblockstate, false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 14, 2, 9, 14, 4, 9, iblockstate, iblockstate, false);
            
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 5, 2, 14, 5, 8, iblockstate, iblockstate, false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 6, 3, 14, 6, 7, iblockstate, iblockstate, false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 7, 4, 14, 7, 6, iblockstate, iblockstate, false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 8, 5, 14, 8, 5, iblockstate4, iblockstate4, false);

            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 4, 0, 14, 4, 0, iblockstate1, iblockstate1, false); 
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 5, 1, 14, 5, 1, iblockstate1, iblockstate1, false); 
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 6, 2, 14, 6, 2, iblockstate1, iblockstate1, false); 
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 7, 3, 14, 7, 3, iblockstate1, iblockstate1, false); 
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 8, 4, 14, 8, 4, iblockstate1, iblockstate1, false); 

            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 4, 10, 14, 4, 10, iblockstate2, iblockstate2, false); 
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 5, 9, 14, 5, 9, iblockstate2, iblockstate2, false); 
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 6, 8, 14, 6, 8, iblockstate2, iblockstate2, false); 
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 7, 7, 14, 7, 7, iblockstate2, iblockstate2, false); 
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 8, 6, 14, 8, 6, iblockstate2, iblockstate2, false); 
            
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 2, 2, 1, 3, 8, iblockstate4, iblockstate4, false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 2, 1, 13, 3, 1, iblockstate4, iblockstate4, false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 14, 2, 2, 14, 3, 8, iblockstate4, iblockstate4, false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 2, 9, 13, 3, 9, iblockstate4, iblockstate4, false);

            this.setBlockState(worldIn, iblockstate9, 0, 0, 2, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate9, 0, 0, 3, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate6, -1, 0, 2, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate6, -1, 0, 3, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate10, -1, 1, 2, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate10, -1, 1, 3, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate9, 0, 0, 5, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate9, 0, 0, 7, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate9, 0, 0, 8, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate6, -1, 0, 7, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate6, -1, 0, 8, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate10, -1, 1, 7, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate10, -1, 1, 8, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate2, 3, 0, 10, structureBoundingBoxIn);

            this.setBlockState(worldIn, Blocks.AIR.getDefaultState(), 1, 1, 5, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.AIR.getDefaultState(), 1, 2, 5, structureBoundingBoxIn);
            this.func_189927_a(worldIn, structureBoundingBoxIn, randomIn, 1, 1, 5, EnumFacing.WEST);

            this.setBlockState(worldIn, Blocks.AIR.getDefaultState(), 3, 1, 9, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.AIR.getDefaultState(), 3, 2, 9, structureBoundingBoxIn);
            this.func_189927_a(worldIn, structureBoundingBoxIn, randomIn, 3, 1, 9, EnumFacing.NORTH);

            this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 1, 2, 3, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 1, 2, 7, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 5, 2, 9, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 6, 2, 9, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 9, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 9, 2, 9, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 11, 2, 9, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 12, 2, 9, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 14, 2, 4, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 14, 2, 6, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 3, 2, 1, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 4, 2, 1, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 7, 2, 1, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 1, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 11, 2, 1, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 12, 2, 1, structureBoundingBoxIn);
            
            //VENEK
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 0, 10, 1, 0, 18, iblockstate6, iblockstate6, false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 12, 0, 10, 12, 0, 18, iblockstate6, iblockstate6, false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 0, 18, 12, 0, 18, iblockstate6, iblockstate6, false);

            this.setBlockState(worldIn, iblockstate2, 5, 0, 10, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate2, 6, 0, 10, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate2, 9, 0, 10, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate2, 10, 0, 10, structureBoundingBoxIn);
 
            this.setBlockState(worldIn, iblockstate6, 5, 0, 11, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate6, 5, 0, 12, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate6, 6, 0, 11, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate6, 6, 0, 12, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate10, 5, 1, 11, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate10, 5, 1, 12, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate10, 6, 1, 11, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate10, 6, 1, 12, structureBoundingBoxIn);            
            this.setBlockState(worldIn, iblockstate9, 7, 0, 11, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate9, 7, 0, 12, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate9, 11, 0, 11, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate9, 11, 0, 12, structureBoundingBoxIn); 
            this.setBlockState(worldIn, iblockstate6, 9, 0, 11, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate6, 9, 0, 12, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate6, 10, 0, 11, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate6, 10, 0, 12, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate10, 9, 1, 11, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate10, 9, 1, 12, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate10, 10, 1, 11, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate10, 10, 1, 12, structureBoundingBoxIn);         
            this.setBlockState(worldIn, iblockstate1, 9, 0, 13, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate1, 10, 0, 13, structureBoundingBoxIn);

            this.setBlockState(worldIn, iblockstate9, 11, 0, 15, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate9, 11, 0, 16, structureBoundingBoxIn); 
            this.setBlockState(worldIn, iblockstate1, 9, 0, 17, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate1, 10, 0, 17, structureBoundingBoxIn);     
            this.setBlockState(worldIn, iblockstate6, 10, 0, 15, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate6, 10, 0, 16, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate6, 9, 0, 15, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate6, 9, 0, 16, structureBoundingBoxIn);          
            this.setBlockState(worldIn, iblockstate10, 10, 1, 15, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate10, 10, 1, 16, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate10, 9, 1, 15, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate10, 9, 1, 16, structureBoundingBoxIn);
            
            this.setBlockState(worldIn, iblockstate3, 2, 0, 15, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate3, 2, 0, 16, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate1, 3, 0, 17, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate1, 4, 0, 17, structureBoundingBoxIn);               
            this.setBlockState(worldIn, iblockstate9, 5, 0, 15, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate9, 5, 0, 16, structureBoundingBoxIn);                     
            this.setBlockState(worldIn, iblockstate6, 3, 0, 15, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate6, 3, 0, 16, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate6, 4, 0, 15, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate6, 4, 0, 16, structureBoundingBoxIn);          
            this.setBlockState(worldIn, iblockstate10, 3, 1, 15, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate10, 3, 1, 16, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate10, 4, 1, 15, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate10, 4, 1, 16, structureBoundingBoxIn);
                        
            this.setBlockState(worldIn, Blocks.TORCH.getDefaultState(), 1, 1, 10, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.TORCH.getDefaultState(), 1, 1, 18, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.TORCH.getDefaultState(), 12, 1, 10, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.TORCH.getDefaultState(), 12, 1, 18, structureBoundingBoxIn);

            this.func_189926_a(worldIn, EnumFacing.EAST, 2, 3, 2, structureBoundingBoxIn);
            this.func_189926_a(worldIn, EnumFacing.NORTH, 3, 3, 2, structureBoundingBoxIn);            
            this.func_189926_a(worldIn, EnumFacing.NORTH, 12, 3, 2, structureBoundingBoxIn);
            this.func_189926_a(worldIn, EnumFacing.WEST, 13, 3, 2, structureBoundingBoxIn);
            this.func_189926_a(worldIn, EnumFacing.EAST, 2, 3, 7, structureBoundingBoxIn);
            this.func_189926_a(worldIn, EnumFacing.SOUTH, 2, 3, 8, structureBoundingBoxIn);
            this.func_189926_a(worldIn, EnumFacing.SOUTH, 3, 3, 8, structureBoundingBoxIn);
            this.func_189926_a(worldIn, EnumFacing.SOUTH, 12, 3, 8, structureBoundingBoxIn);
            this.func_189926_a(worldIn, EnumFacing.WEST, 13, 3, 8, structureBoundingBoxIn);
            
            this.setBlockState(worldIn, iblockstate6, 5, 1, 8, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate6, 6, 1, 8, structureBoundingBoxIn);
            this.setBlockState(worldIn, BlockHandler.FermentingBarrelOff.getDefaultState(), 5, 2, 8, structureBoundingBoxIn);
            this.setBlockState(worldIn, BlockHandler.FermentingBarrelOff.getDefaultState(), 6, 2, 8, structureBoundingBoxIn);
            
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 11, 1, 2, 11, 1, 8, iblockstate6, iblockstate6, false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 11, 2, 3, 11, 2, 5, iblockstate10, iblockstate10, false);
            this.setBlockState(worldIn, iblockstate4, 11, 1, 2, structureBoundingBoxIn);            
            this.setBlockState(worldIn, Blocks.OAK_FENCE_GATE.getDefaultState().withRotation(Rotation.CLOCKWISE_90), 11, 1, 7, structureBoundingBoxIn);           
            this.setBlockState(worldIn, BlockHandler.spigot.getDefaultState(), 11, 2, 2, structureBoundingBoxIn);

            this.setBlockState(worldIn, iblockstate3, 10, 1, 3, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate3, 10, 1, 4, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate3, 10, 1, 5, structureBoundingBoxIn);

            this.setBlockState(worldIn, iblockstate3, 2, 1, 2, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate3, 2, 1, 3, structureBoundingBoxIn);

            this.setBlockState(worldIn, iblockstate2, 3, 1, 2, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate2, 4, 1, 2, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate2, 5, 1, 2, structureBoundingBoxIn);

            this.setBlockState(worldIn, iblockstate9, 5, 1, 2, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate9, 5, 1, 3, structureBoundingBoxIn);
            
            this.setBlockState(worldIn, iblockstate3, 6, 1, 3, structureBoundingBoxIn);

            this.setBlockState(worldIn, iblockstate2, 7, 1, 2, structureBoundingBoxIn);

            this.setBlockState(worldIn, iblockstate9, 8, 1, 3, structureBoundingBoxIn);

            this.setBlockState(worldIn, iblockstate1, 7, 1, 4, structureBoundingBoxIn);

            this.setBlockState(worldIn, iblockstate6, 3, 1, 3, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate6, 4, 1, 3, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate6, 7, 1, 3, structureBoundingBoxIn);
            
            this.setBlockState(worldIn, iblockstate10, 3, 2, 3, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate10, 4, 2, 3, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate10, 7, 2, 3, structureBoundingBoxIn);

            return true;
        }
    }