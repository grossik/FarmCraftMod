package cz.grossik.farmcraft2.pan;

import java.util.Random;

import javax.annotation.Nullable;

import cz.grossik.farmcraft2.Main;
import cz.grossik.farmcraft2.crushing.TileEntityCrushing;
import cz.grossik.farmcraft2.handler.BlockHandler;
import cz.grossik.farmcraft2.handler.FC2_GuiHandler;
import cz.grossik.farmcraft2.handler.ItemHandler;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPan extends BlockContainer
{
    private static boolean keepInventory;

    public BlockPan()
    {
        super(Material.ROCK);
        setUnlocalizedName("pan");
        setCreativeTab(Main.FarmCraft2Tab);
        setHardness(2f);
        setResistance(10f);
    }

    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityPan();
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public static void setState(boolean active, World worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        keepInventory = true;

        if (active)
        {
            worldIn.setBlockState(pos, BlockHandler.Pan.getDefaultState(), 3);
            worldIn.setBlockState(pos, BlockHandler.Pan.getDefaultState(), 3);
        }
        else
        {
            worldIn.setBlockState(pos, BlockHandler.Pan.getDefaultState(), 3);
            worldIn.setBlockState(pos, BlockHandler.Pan.getDefaultState(), 3);
        }

        keepInventory = false;

        if (tileentity != null)
        {
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
    }
    
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        TileEntityPan te = (TileEntityPan) world.getTileEntity(pos);
        return te == null || !te.isBurning() ? 0 : 14;
    }

    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return true;
    }

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
       TileEntityPan te = (TileEntityPan) world.getTileEntity(pos);
       Container container = te.createContainer(player.inventory, player);
       Slot slot = (Slot)container.inventorySlots.get(0);
       Slot slot2 = (Slot)container.inventorySlots.get(2);

       ItemStack is_p = slot.getStack();
       
           if(heldItem != null && heldItem.getItem().equals(ItemHandler.DfPancakes) && !te.isBurning() && is_p == null)
           {
        	   ItemStack is = heldItem.splitStack(1);
               slot.putStack(is);
           }                    
           else {
               if(!world.isRemote){
            	   player.openGui(Main.MODID, FC2_GuiHandler.PANGUI, world, pos.getX(), pos.getY(), pos.getZ());
               }
           }
       
       return true;
    }
    
    private void spawnParticle(World world, BlockPos pos, Random rand, boolean isFire)
    {
        double x = pos.getX() + 0.5F + (rand.nextFloat() * 0.6F -0.3F);
        double y = pos.getY() + 0.15F;
        double z = pos.getZ() + 0.5F + (rand.nextFloat() * -0.6F - -0.3F);
        EnumParticleTypes type;
        if(isFire)
            type = EnumParticleTypes.FLAME;
        else
            type = EnumParticleTypes.SMOKE_NORMAL;
        world.spawnParticle(type, x, y, z, 0, 0, 0, new int[0]);
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        if (stack.hasDisplayName())
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityCrushing)
            {
                ((TileEntityPan)tileentity).setCustomInventoryName(stack.getDisplayName());
            }
        }
    }    
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World worldIn, BlockPos pos, Random rand)
    {
        worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
        worldIn.checkLightFor(EnumSkyBlock.BLOCK, pos);

        boolean cooking = ((TileEntityPan) worldIn.getTileEntity(pos)).isBurning();
        if(cooking)
        {
            for(int i = 0; i < rand.nextInt(10); i++)
            {
                spawnParticle(worldIn, pos, rand, true);
            }
            for(int i = 1; i < rand.nextInt(10); i++)
            {
                spawnParticle(worldIn, pos, rand, false);
            }
        }
    }
    
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!keepInventory)
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityPan)
            {
                InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityPan)tileentity);
                worldIn.updateComparatorOutputLevel(pos, this);
            }
        }

        super.breakBlock(worldIn, pos, state);
    }

    public boolean hasComparatorInputOverride(IBlockState state)
    {
        return true;
    }

    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return Container.calcRedstone(worldIn.getTileEntity(pos));
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(BlockHandler.Pan);
    }
}