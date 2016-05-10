package cz.grossik.farmcraft2.block;

import java.util.Random;

import cz.grossik.farmcraft2.handler.BlockHandler;
import cz.grossik.farmcraft2.handler.ItemHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Block_Scarecrow extends Block
{

	public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public static final PropertyBool OPEN = PropertyBool.create("open");
    public static final PropertyEnum<Block_Scarecrow.EnumHingePosition> HINGE = PropertyEnum.<Block_Scarecrow.EnumHingePosition>create("hinge", Block_Scarecrow.EnumHingePosition.class);
    public static final PropertyBool POWERED = PropertyBool.create("powered");
    public static final PropertyEnum<Block_Scarecrow.EnumDoorHalf> HALF = PropertyEnum.<Block_Scarecrow.EnumDoorHalf>create("half", Block_Scarecrow.EnumDoorHalf.class);
    protected static final AxisAlignedBB field_185658_f = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.1875D);
    protected static final AxisAlignedBB field_185659_g = new AxisAlignedBB(0.0D, 0.0D, 0.8125D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB field_185656_B = new AxisAlignedBB(0.8125D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB field_185657_C = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.1875D, 1.0D, 1.0D);

    public Block_Scarecrow(Material materialIn)
    {
        super(materialIn);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(OPEN, Boolean.valueOf(false)).withProperty(HINGE, Block_Scarecrow.EnumHingePosition.LEFT).withProperty(POWERED, Boolean.valueOf(false)).withProperty(HALF, Block_Scarecrow.EnumDoorHalf.LOWER));
    }
    
    
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        state = state.getActualState(source, pos);
        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
        boolean flag = !((Boolean)state.getValue(OPEN)).booleanValue();
        boolean flag1 = state.getValue(HINGE) == Block_Scarecrow.EnumHingePosition.RIGHT;

        switch (enumfacing)
        {
            case EAST:
            default:
                return flag ? field_185657_C : (flag1 ? field_185659_g : field_185658_f);
            case SOUTH:
                return flag ? field_185658_f : (flag1 ? field_185657_C : field_185656_B);
            case WEST:
                return flag ? field_185656_B : (flag1 ? field_185658_f : field_185659_g);
            case NORTH:
                return flag ? field_185659_g : (flag1 ? field_185656_B : field_185657_C);
        }
    }

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return isOpen(combineMetadata(worldIn, pos));
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    private int func_185654_e()
    {
        return this.blockMaterial == Material.wood ? 1011 : 1012;
    }

    private int func_185655_g()
    {
        return this.blockMaterial == Material.wood ? 1005 : 1006;
    }

    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        if (state.getValue(HALF) == Block_Scarecrow.EnumDoorHalf.UPPER)
        {
            BlockPos blockpos = pos.down();
            IBlockState iblockstate = worldIn.getBlockState(blockpos);

            if (iblockstate.getBlock() != this)
            {
                worldIn.setBlockToAir(pos);
            }
            else if (neighborBlock != this)
            {
                this.onNeighborBlockChange(worldIn, blockpos, iblockstate, neighborBlock);
            }
        }
        else
        {
            boolean flag1 = false;
            BlockPos blockpos1 = pos.up();
            IBlockState iblockstate1 = worldIn.getBlockState(blockpos1);

            if (iblockstate1.getBlock() != this)
            {
                worldIn.setBlockToAir(pos);
                flag1 = true;
            }

            if (!worldIn.getBlockState(pos.down()).isFullyOpaque())
            {
                worldIn.setBlockToAir(pos);
                flag1 = true;

                if (iblockstate1.getBlock() == this)
                {
                    worldIn.setBlockToAir(blockpos1);
                }
            }

            if (flag1)
            {
                if (!worldIn.isRemote)
                {
                    this.dropBlockAsItem(worldIn, pos, state, 0);
                }
            }
        }
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return state.getValue(HALF) == Block_Scarecrow.EnumDoorHalf.UPPER ? null : this.getItem();
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return pos.getY() >= worldIn.getHeight() - 1 ? false : worldIn.getBlockState(pos.down()).isSideSolid(worldIn,  pos.down(), EnumFacing.UP) && super.canPlaceBlockAt(worldIn, pos) && super.canPlaceBlockAt(worldIn, pos.up());
    }

    public EnumPushReaction getMobilityFlag(IBlockState state)
    {
        return EnumPushReaction.DESTROY;
    }

    public static int combineMetadata(IBlockAccess worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        int i = iblockstate.getBlock().getMetaFromState(iblockstate);
        boolean flag = isTop(i);
        IBlockState iblockstate1 = worldIn.getBlockState(pos.down());
        int j = iblockstate1.getBlock().getMetaFromState(iblockstate1);
        int k = flag ? j : i;
        IBlockState iblockstate2 = worldIn.getBlockState(pos.up());
        int l = iblockstate2.getBlock().getMetaFromState(iblockstate2);
        int i1 = flag ? i : l;
        boolean flag1 = (i1 & 1) != 0;
        boolean flag2 = (i1 & 2) != 0;
        return removeHalfBit(k) | (flag ? 8 : 0) | (flag1 ? 16 : 0) | (flag2 ? 32 : 0);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(this.getItem());
    }

    private Item getItem()
    {
        return this == BlockHandler.Scarecrow ? ItemHandler.ScarecrowItem : ItemHandler.ScarecrowItem;
    }

    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        BlockPos blockpos = pos.down();
        BlockPos blockpos1 = pos.up();

        if (player.capabilities.isCreativeMode && state.getValue(HALF) == Block_Scarecrow.EnumDoorHalf.UPPER && worldIn.getBlockState(blockpos).getBlock() == this)
        {
            worldIn.setBlockToAir(blockpos);
        }

        if (state.getValue(HALF) == Block_Scarecrow.EnumDoorHalf.LOWER && worldIn.getBlockState(blockpos1).getBlock() == this)
        {
            if (player.capabilities.isCreativeMode)
            {
                worldIn.setBlockToAir(pos);
            }

            worldIn.setBlockToAir(blockpos1);
        }
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        if (state.getValue(HALF) == Block_Scarecrow.EnumDoorHalf.LOWER)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos.up());

            if (iblockstate.getBlock() == this)
            {
                state = state.withProperty(HINGE, iblockstate.getValue(HINGE)).withProperty(POWERED, iblockstate.getValue(POWERED));
            }
        }
        else
        {
            IBlockState iblockstate1 = worldIn.getBlockState(pos.down());

            if (iblockstate1.getBlock() == this)
            {
                state = state.withProperty(FACING, iblockstate1.getValue(FACING)).withProperty(OPEN, iblockstate1.getValue(OPEN));
            }
        }

        return state;
    }

    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.getValue(HALF) != Block_Scarecrow.EnumDoorHalf.LOWER ? state : state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return (meta & 8) > 0 ? this.getDefaultState().withProperty(HALF, Block_Scarecrow.EnumDoorHalf.UPPER).withProperty(HINGE, (meta & 1) > 0 ? Block_Scarecrow.EnumHingePosition.RIGHT : Block_Scarecrow.EnumHingePosition.LEFT).withProperty(POWERED, Boolean.valueOf((meta & 2) > 0)) : this.getDefaultState().withProperty(HALF, Block_Scarecrow.EnumDoorHalf.LOWER).withProperty(FACING, EnumFacing.getHorizontal(meta & 3).rotateYCCW()).withProperty(OPEN, Boolean.valueOf((meta & 4) > 0));
    }

    public int getMetaFromState(IBlockState state)
    {
        int i = 0;

        if (state.getValue(HALF) == Block_Scarecrow.EnumDoorHalf.UPPER)
        {
            i = i | 8;

            if (state.getValue(HINGE) == Block_Scarecrow.EnumHingePosition.RIGHT)
            {
                i |= 1;
            }

            if (((Boolean)state.getValue(POWERED)).booleanValue())
            {
                i |= 2;
            }
        }
        else
        {
            i = i | ((EnumFacing)state.getValue(FACING)).rotateY().getHorizontalIndex();

            if (((Boolean)state.getValue(OPEN)).booleanValue())
            {
                i |= 4;
            }
        }

        return i;
    }

    protected static int removeHalfBit(int meta)
    {
        return meta & 7;
    }

    public static boolean isOpen(IBlockAccess worldIn, BlockPos pos)
    {
        return isOpen(combineMetadata(worldIn, pos));
    }

    public static EnumFacing getFacing(IBlockAccess worldIn, BlockPos pos)
    {
        return getFacing(combineMetadata(worldIn, pos));
    }

    public static EnumFacing getFacing(int combinedMeta)
    {
        return EnumFacing.getHorizontal(combinedMeta & 3).rotateYCCW();
    }

    protected static boolean isOpen(int combinedMeta)
    {
        return (combinedMeta & 4) != 0;
    }

    protected static boolean isTop(int meta)
    {
        return (meta & 8) != 0;
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {HALF, FACING, OPEN, HINGE, POWERED});
    }

    public static enum EnumDoorHalf implements IStringSerializable
    {
        UPPER,
        LOWER;

        public String toString()
        {
            return this.getName();
        }

        public String getName()
        {
            return this == UPPER ? "upper" : "lower";
        }
    }

    public static enum EnumHingePosition implements IStringSerializable
    {
        LEFT,
        RIGHT;

        public String toString()
        {
            return this.getName();
        }

        public String getName()
        {
            return this == LEFT ? "left" : "right";
        }
    }
}