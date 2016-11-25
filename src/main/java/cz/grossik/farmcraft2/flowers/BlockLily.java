package cz.grossik.farmcraft2.flowers;

import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import cz.grossik.farmcraft2.Main;
import cz.grossik.farmcraft2.handler.BlockHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockLily extends BlockBush
{
    protected PropertyEnum<BlockLily.EnumFlowerType> type;

    public BlockLily()
    {
        this.setDefaultState(this.blockState.getBaseState().withProperty(this.getTypeProperty(), this.getBlockType() == BlockLily.EnumFlowerColor.RED ? BlockLily.EnumFlowerType.WHITE : BlockLily.EnumFlowerType.WHITE));
        this.setCreativeTab(Main.FarmCraft2Tab);
    }

    public int damageDropped(IBlockState state)
    {
        return ((BlockLily.EnumFlowerType)state.getValue(this.getTypeProperty())).getMeta();
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (BlockLily.EnumFlowerType blockflower$enumflowertype : BlockLily.EnumFlowerType.getTypes(this.getBlockType()))
        {
            list.add(new ItemStack(itemIn, 1, blockflower$enumflowertype.getMeta()));
        }
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(this.getTypeProperty(), BlockLily.EnumFlowerType.getType(this.getBlockType(), meta));
    }

    public abstract BlockLily.EnumFlowerColor getBlockType();

    public IProperty<BlockLily.EnumFlowerType> getTypeProperty()
    {
        if (this.type == null)
        {
            this.type = PropertyEnum.<BlockLily.EnumFlowerType>create("type", BlockLily.EnumFlowerType.class, new Predicate<BlockLily.EnumFlowerType>()
            {
                public boolean apply(@Nullable BlockLily.EnumFlowerType p_apply_1_)
                {
                    return p_apply_1_.getBlockType() == BlockLily.this.getBlockType();
                }
            });
        }

        return this.type;
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((BlockLily.EnumFlowerType)state.getValue(this.getTypeProperty())).getMeta();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {this.getTypeProperty()});
    }

    @SideOnly(Side.CLIENT)
    public Block.EnumOffsetType getOffsetType()
    {
        return Block.EnumOffsetType.XZ;
    }

    public static enum EnumFlowerColor
    {
        YELLOW,
        RED;
    }

    public static enum EnumFlowerType implements IStringSerializable
    {
        WHITE(BlockLily.EnumFlowerColor.YELLOW, 0, "white_lily"),
        ORANGE(BlockLily.EnumFlowerColor.YELLOW, 1, "orange_lily"),
        BLUE(BlockLily.EnumFlowerColor.YELLOW, 2, "blue_lily");

        private static final BlockLily.EnumFlowerType[][] TYPES_FOR_BLOCK = new BlockLily.EnumFlowerType[BlockLily.EnumFlowerColor.values().length][];
        private final BlockLily.EnumFlowerColor blockType;
        private final int meta;
        private final String name;
        private final String unlocalizedName;

        private EnumFlowerType(BlockLily.EnumFlowerColor blockType, int meta, String name)
        {
            this(blockType, meta, name, name);
        }

        private EnumFlowerType(BlockLily.EnumFlowerColor blockType, int meta, String name, String unlocalizedName)
        {
            this.blockType = blockType;
            this.meta = meta;
            this.name = name;
            this.unlocalizedName = unlocalizedName;
        }

        public BlockLily.EnumFlowerColor getBlockType()
        {
            return this.blockType;
        }

        public int getMeta()
        {
            return this.meta;
        }

        public static BlockLily.EnumFlowerType getType(BlockLily.EnumFlowerColor blockType, int meta)
        {
            BlockLily.EnumFlowerType[] ablockflower$enumflowertype = TYPES_FOR_BLOCK[blockType.ordinal()];

            if (meta < 0 || meta >= ablockflower$enumflowertype.length)
            {
                meta = 0;
            }

            return ablockflower$enumflowertype[meta];
        }

        @SideOnly(Side.CLIENT)
        public static BlockLily.EnumFlowerType[] getTypes(BlockLily.EnumFlowerColor flowerColor)
        {
            return TYPES_FOR_BLOCK[flowerColor.ordinal()];
        }

        public String toString()
        {
            return this.name;
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
            for (final BlockLily.EnumFlowerColor blockflower$enumflowercolor : BlockLily.EnumFlowerColor.values())
            {
                Collection<BlockLily.EnumFlowerType> collection = Collections2.<BlockLily.EnumFlowerType>filter(Lists.newArrayList(values()), new Predicate<BlockLily.EnumFlowerType>()
                {
                    public boolean apply(@Nullable BlockLily.EnumFlowerType p_apply_1_)
                    {
                        return p_apply_1_.getBlockType() == blockflower$enumflowercolor;
                    }
                });
                TYPES_FOR_BLOCK[blockflower$enumflowercolor.ordinal()] = (BlockLily.EnumFlowerType[])collection.toArray(new BlockLily.EnumFlowerType[collection.size()]);
            }
        }
    }
}