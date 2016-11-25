package cz.grossik.farmcraft2.flowers;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;

import cz.grossik.farmcraft2.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockRose extends BlockBush implements IGrowable, net.minecraftforge.common.IShearable
{
    public static final PropertyEnum<BlockRose.EnumRoseType> VARIANT = PropertyEnum.<BlockRose.EnumRoseType>create("variant", BlockRose.EnumRoseType.class);
    public static final PropertyEnum<BlockRose.EnumBlockHalf> HALF = PropertyEnum.<BlockRose.EnumBlockHalf>create("half", BlockRose.EnumBlockHalf.class);
    public static final PropertyEnum<EnumFacing> FACING = BlockHorizontal.FACING;

    public BlockRose()
    {
        super(Material.VINE);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockRose.EnumRoseType.WHITE_ROSE).withProperty(HALF, BlockRose.EnumBlockHalf.LOWER).withProperty(FACING, EnumFacing.NORTH));
        this.setHardness(0.0F);
        this.setSoundType(SoundType.PLANT);
        this.setUnlocalizedName("fc_rose");
        this.setCreativeTab(Main.FarmCraft2Tab);
    }	

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return FULL_BLOCK_AABB;
    }

    private BlockRose.EnumRoseType getType(IBlockAccess blockAccess, BlockPos pos, IBlockState state)
    {
        if (state.getBlock() == this)
        {
            state = state.getActualState(blockAccess, pos);
            return (BlockRose.EnumRoseType)state.getValue(VARIANT);
        }
        else
        {
            return BlockRose.EnumRoseType.WHITE_ROSE;
        }
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return super.canPlaceBlockAt(worldIn, pos) && worldIn.isAirBlock(pos.up());
    }

    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);

        if (iblockstate.getBlock() != this)
        {
            return true;
        }
        else
        {
            BlockRose.EnumRoseType blockdoubleplant$EnumRoseType = (BlockRose.EnumRoseType)iblockstate.getActualState(worldIn, pos).getValue(VARIANT);
            return blockdoubleplant$EnumRoseType == BlockRose.EnumRoseType.WHITE_ROSE;
        }
    }

    protected void checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!this.canBlockStay(worldIn, pos, state))
        {
            boolean flag = state.getValue(HALF) == BlockRose.EnumBlockHalf.UPPER;
            BlockPos blockpos = flag ? pos : pos.up();
            BlockPos blockpos1 = flag ? pos.down() : pos;
            Block block = (Block)(flag ? this : worldIn.getBlockState(blockpos).getBlock());
            Block block1 = (Block)(flag ? worldIn.getBlockState(blockpos1).getBlock() : this);

            if (!flag) this.dropBlockAsItem(worldIn, pos, state, 0); //Forge move above the setting to air.

            if (block == this)
            {
                worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 2);
            }

            if (block1 == this)
            {
                worldIn.setBlockState(blockpos1, Blocks.AIR.getDefaultState(), 3);
            }
        }
    }

    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        if (state.getBlock() != this) return super.canBlockStay(worldIn, pos, state); //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
        if (state.getValue(HALF) == BlockRose.EnumBlockHalf.UPPER)
        {
            return worldIn.getBlockState(pos.down()).getBlock() == this;
        }
        else
        {
            IBlockState iblockstate = worldIn.getBlockState(pos.up());
            return iblockstate.getBlock() == this && super.canBlockStay(worldIn, pos, iblockstate);
        }
    }

    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        if (state.getValue(HALF) == BlockRose.EnumBlockHalf.UPPER)
        {
            return null;
        }
        else
        {
            BlockRose.EnumRoseType blockdoubleplant$EnumRoseType = (BlockRose.EnumRoseType)state.getValue(VARIANT);
            return Item.getItemFromBlock(this);
        }
    }

    public int damageDropped(IBlockState state)
    {
        return state.getValue(HALF) != BlockRose.EnumBlockHalf.UPPER && state.getValue(VARIANT) != BlockRose.EnumRoseType.WHITE_ROSE ? ((BlockRose.EnumRoseType)state.getValue(VARIANT)).getMeta() : 0;
    }

    public void placeAt(World worldIn, BlockPos lowerPos, BlockRose.EnumRoseType variant, int flags)
    {
        worldIn.setBlockState(lowerPos, this.getDefaultState().withProperty(HALF, BlockRose.EnumBlockHalf.LOWER).withProperty(VARIANT, variant), flags);
        worldIn.setBlockState(lowerPos.up(), this.getDefaultState().withProperty(HALF, BlockRose.EnumBlockHalf.UPPER), flags);
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos.up(), this.getDefaultState().withProperty(HALF, BlockRose.EnumBlockHalf.UPPER), 2);
    }

    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, @Nullable ItemStack stack)
    {
        {
            super.harvestBlock(worldIn, player, pos, state, te, stack);
        }
    }

    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        if (state.getValue(HALF) == BlockRose.EnumBlockHalf.UPPER)
        {
            if (worldIn.getBlockState(pos.down()).getBlock() == this)
            {
                if (player.capabilities.isCreativeMode)
                {
                    worldIn.setBlockToAir(pos.down());
                }
                else
                {
                    IBlockState iblockstate = worldIn.getBlockState(pos.down());
                    BlockRose.EnumRoseType blockdoubleplant$EnumRoseType = (BlockRose.EnumRoseType)iblockstate.getValue(VARIANT);
                    
                    if (worldIn.isRemote)
                    {
                        worldIn.setBlockToAir(pos.down());
                    }
                    else if (player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() == Items.SHEARS)
                    {
                        this.onHarvest(worldIn, pos, iblockstate, player);
                        worldIn.setBlockToAir(pos.down());
                    }
                    else
                    {
                        worldIn.destroyBlock(pos.down(), true);
                    }
                }
            }
        }
        else if (worldIn.getBlockState(pos.up()).getBlock() == this)
        {
            worldIn.setBlockState(pos.up(), Blocks.AIR.getDefaultState(), 2);
        }

        super.onBlockHarvested(worldIn, pos, state, player);
    }

    private boolean onHarvest(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        BlockRose.EnumRoseType blockdoubleplant$EnumRoseType = (BlockRose.EnumRoseType)state.getValue(VARIANT);

        if (blockdoubleplant$EnumRoseType != BlockRose.EnumRoseType.WHITE_ROSE)
        {
            return false;
        }
        else
        {
            player.addStat(StatList.getBlockStats(this));
            return true;
        }
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (BlockRose.EnumRoseType blockdoubleplant$EnumRoseType : BlockRose.EnumRoseType.values())
        {
            list.add(new ItemStack(itemIn, 1, blockdoubleplant$EnumRoseType.getMeta()));
        }
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(this, 1, this.getType(worldIn, pos, state).getMeta());
    }

    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
        BlockRose.EnumRoseType blockdoubleplant$EnumRoseType = this.getType(worldIn, pos, state);
        return blockdoubleplant$EnumRoseType != BlockRose.EnumRoseType.WHITE_ROSE;
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        return true;
    }

    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        spawnAsEntity(worldIn, pos, new ItemStack(this, 1, this.getType(worldIn, pos, state).getMeta()));
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return (meta & 8) > 0 ? this.getDefaultState().withProperty(HALF, BlockRose.EnumBlockHalf.UPPER) : this.getDefaultState().withProperty(HALF, BlockRose.EnumBlockHalf.LOWER).withProperty(VARIANT, BlockRose.EnumRoseType.byMetadata(meta & 7));
    }

    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        if (state.getValue(HALF) == BlockRose.EnumBlockHalf.UPPER)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos.down());

            if (iblockstate.getBlock() == this)
            {
                state = state.withProperty(VARIANT, iblockstate.getValue(VARIANT));
            }
        }

        return state;
    }

    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(HALF) == BlockRose.EnumBlockHalf.UPPER ? 8 | ((EnumFacing)state.getValue(FACING)).getHorizontalIndex() : ((BlockRose.EnumRoseType)state.getValue(VARIANT)).getMeta();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {HALF, VARIANT, FACING});
    }

    @SideOnly(Side.CLIENT)
    public Block.EnumOffsetType getOffsetType()
    {
        return Block.EnumOffsetType.XZ;
    }

    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos)
    {
        IBlockState state = world.getBlockState(pos);
        EnumRoseType type = (EnumRoseType)state.getValue(VARIANT);
        return state.getValue(HALF) == EnumBlockHalf.LOWER;
    }

    @Override
    public java.util.List<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        java.util.List<ItemStack> ret = new java.util.ArrayList<ItemStack>();
        EnumRoseType type = (EnumRoseType)world.getBlockState(pos).getValue(VARIANT);
        return ret;
    }

    @Override
    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest)
    {
        if (state.getBlock() ==  this && state.getValue(HALF) == EnumBlockHalf.LOWER && world.getBlockState(pos.up()).getBlock() == this)
            world.setBlockToAir(pos.up());
        return world.setBlockToAir(pos);
    }

    public static enum EnumBlockHalf implements IStringSerializable
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

    public enum EnumRoseType implements IStringSerializable
    {
        WHITE_ROSE(0, "double_white_rose", "white_rose"),
        PINK_ROSE(1, "double_pink_rose", "pink_rose"),
        BLUE_ROSE(2, "double_blue_rose", "blue_rose"),
        BLACK_ROSE(3, "double_black_rose", "black_rose"),
        YELLOW_ROSE(4, "double_yellow_rose", "yellow_rose"),
        PURPLE_ROSE(5, "double_purple_rose", "purple_rose");
    	
    	public static Map<Integer, EnumRoseType> META_LOOKUP = Maps.<Integer, EnumRoseType>newHashMap();
        public int meta;
        public String name;
        public String unlocalizedName;

        EnumRoseType(int meta, String name, String unlocalizedName)
        {
            this.meta = meta;
            this.name = name;
            this.unlocalizedName = unlocalizedName;
        }

        public int getMeta()
        {
            return this.meta;
        }

        public String toString()
        {
            return this.name;
        }

    	public static EnumRoseType byMetadata(int meta)
    	{
    		EnumRoseType itempizza$pizzatype = (EnumRoseType)META_LOOKUP.get(Integer.valueOf(meta));
    		return itempizza$pizzatype == null ? WHITE_ROSE : itempizza$pizzatype;
    	}

        public String getName()
        {
            return this.name;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }

        static
        {
            for (BlockRose.EnumRoseType blockdoubleplant$EnumRoseType : values())
            {
    			META_LOOKUP.put(Integer.valueOf(blockdoubleplant$EnumRoseType.getMeta()), blockdoubleplant$EnumRoseType);
            }
        }
    }
}