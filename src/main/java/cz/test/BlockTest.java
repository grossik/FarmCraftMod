package cz.test;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBanner;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTest extends Block
{
    public static final PropertyInteger LEVEL = PropertyInteger.create("level", 0, 1);

    public BlockTest(Material material)
    {
        super(material);
        this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL, Integer.valueOf(0)));
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
    
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return FULL_BLOCK_AABB;
    }

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        int i = ((Integer)state.getValue(LEVEL)).intValue();
        float f = (float)pos.getY() + (6.0F + (float)(3 * i)) / 16.0F;

        if (!worldIn.isRemote && entityIn.isBurning() && i > 0 && entityIn.getEntityBoundingBox().minY <= (double)f)
        {
            entityIn.extinguish();
            this.setWaterLevel(worldIn, pos, state, i - 1);
        }
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (heldItem == null)
        {
            return true;
        }
        else
        {
            int i = ((Integer)state.getValue(LEVEL)).intValue();
            Item item = heldItem.getItem();

            if (item == Items.water_bucket)
            {

                   this.setWaterLevel(worldIn, pos, state, 1);
                

                return true;
            }
            else if (item == Items.bucket)
            {
                if (i == 1 && !worldIn.isRemote)
                {
                    if (!playerIn.capabilities.isCreativeMode)
                    {
                        --heldItem.stackSize;

                        if (heldItem.stackSize == 0)
                        {
                            playerIn.setHeldItem(hand, new ItemStack(Items.water_bucket));
                        }
                        else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.water_bucket)))
                        {
                            playerIn.dropPlayerItemWithRandomChoice(new ItemStack(Items.water_bucket), false);
                        }
                    }

                    playerIn.addStat(StatList.cauldronUsed);
                    this.setWaterLevel(worldIn, pos, state, 0);
                }

                return true;
            }
            else if (item == Items.glass_bottle)
            {
                if (i > 0 && !worldIn.isRemote)
                {
                    if (!playerIn.capabilities.isCreativeMode)
                    {
                        ItemStack itemstack1 = PotionUtils.addPotionToItemStack(new ItemStack(Items.potionitem), PotionTypes.water);
                        playerIn.addStat(StatList.cauldronUsed);

                        if (--heldItem.stackSize == 0)
                        {
                            playerIn.setHeldItem(hand, itemstack1);
                        }
                        else if (!playerIn.inventory.addItemStackToInventory(itemstack1))
                        {
                            playerIn.dropPlayerItemWithRandomChoice(itemstack1, false);
                        }
                        else if (playerIn instanceof EntityPlayerMP)
                        {
                            ((EntityPlayerMP)playerIn).sendContainerToPlayer(playerIn.inventoryContainer);
                        }
                    }

                    this.setWaterLevel(worldIn, pos, state, i - 1);
                }

                return true;
            }
            else
            {
                if (i > 0 && item instanceof ItemArmor)
                {
                    ItemArmor itemarmor = (ItemArmor)item;

                    if (itemarmor.getArmorMaterial() == ItemArmor.ArmorMaterial.LEATHER && itemarmor.hasColor(heldItem) && !worldIn.isRemote)
                    {
                        itemarmor.removeColor(heldItem);
                        this.setWaterLevel(worldIn, pos, state, i - 1);
                        playerIn.addStat(StatList.armorCleaned);
                        return true;
                    }
                }

                if (i > 0 && item instanceof ItemBanner)
                {
                    if (TileEntityBanner.getPatterns(heldItem) > 0 && !worldIn.isRemote)
                    {
                        ItemStack itemstack = heldItem.copy();
                        itemstack.stackSize = 1;
                        TileEntityBanner.removeBannerData(itemstack);
                        playerIn.addStat(StatList.bannerCleaned);

                        if (!playerIn.capabilities.isCreativeMode)
                        {
                            --heldItem.stackSize;
                        }

                        if (heldItem.stackSize == 0)
                        {
                            playerIn.setHeldItem(hand, itemstack);
                        }
                        else if (!playerIn.inventory.addItemStackToInventory(itemstack))
                        {
                            playerIn.dropPlayerItemWithRandomChoice(itemstack, false);
                        }
                        else if (playerIn instanceof EntityPlayerMP)
                        {
                            ((EntityPlayerMP)playerIn).sendContainerToPlayer(playerIn.inventoryContainer);
                        }

                        if (!playerIn.capabilities.isCreativeMode)
                        {
                            this.setWaterLevel(worldIn, pos, state, i - 1);
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
    }

    public void setWaterLevel(World worldIn, BlockPos pos, IBlockState state, int level)
    {
        worldIn.setBlockState(pos, state.withProperty(LEVEL, Integer.valueOf(MathHelper.clamp_int(level, 0, 3))), 2);
        worldIn.updateComparatorOutputLevel(pos, this);
    }

    public boolean hasComparatorInputOverride(IBlockState state)
    {
        return true;
    }

    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return ((Integer)blockState.getValue(LEVEL)).intValue();
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(LEVEL, Integer.valueOf(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(LEVEL)).intValue();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {LEVEL});
    }

    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return true;
    }
}