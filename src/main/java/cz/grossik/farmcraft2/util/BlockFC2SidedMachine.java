package cz.grossik.farmcraft2.util;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public abstract class BlockFC2SidedMachine extends BlockContainer
{
  private final Random rand = new Random();

  public enum EnumMachineState implements IStringSerializable
  {
	  
    OFF(0, "off"),
    ON(1, "on");

    public final int id;
    public final String name;

    private EnumMachineState(int id, String name)
    {
      this.id = id;
      this.name = name;
    }

    @Override
    public String getName()
    {
      return name;
    }
    
    @Override
    public String toString()
    {
      return getName();
    }

    static public EnumMachineState fromID(int num)
    {
      for(EnumMachineState m : values())
      {
        if(m.id == num)
        {
          return m;
        }
      }
      return null;
    }
  }

  public static final PropertyEnum<EnumMachineState> STATE = PropertyEnum.create("state", EnumMachineState.class);
  public static PropertyEnum<EnumFacing> FACING = PropertyEnum.create("facing", EnumFacing.class);

  public BlockFC2SidedMachine(Material material)
  {
    super(material);
  }

  
  public BlockStateContainer createBlockState()
  {
    return new BlockStateContainer(this, STATE, FACING );
  }

  
  public IBlockState getStateFromMeta(int meta)
  {
    return getDefaultState().withProperty(FACING, EnumFacing.NORTH);
  }

  @Override
  public int getMetaFromState(IBlockState state)
  {
      return ((EnumFacing)state.getValue(FACING)).getIndex();

  }

  public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
  {
      this.setDefaultFacing(worldIn, pos, state);
  }

  private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
  {
      if (!worldIn.isRemote)
      {
          IBlockState iblockstate = worldIn.getBlockState(pos.north());
          IBlockState iblockstate1 = worldIn.getBlockState(pos.south());
          IBlockState iblockstate2 = worldIn.getBlockState(pos.west());
          IBlockState iblockstate3 = worldIn.getBlockState(pos.east());
          EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

          if (enumfacing == EnumFacing.NORTH && iblockstate.isFullBlock() && !iblockstate1.isFullBlock())
          {
              enumfacing = EnumFacing.SOUTH;
          }
          else if (enumfacing == EnumFacing.SOUTH && iblockstate1.isFullBlock() && !iblockstate.isFullBlock())
          {
              enumfacing = EnumFacing.NORTH;
          }
          else if (enumfacing == EnumFacing.EAST && iblockstate2.isFullBlock() && !iblockstate3.isFullBlock())
          {
              enumfacing = EnumFacing.WEST;
          }
          else if (enumfacing == EnumFacing.WEST && iblockstate3.isFullBlock() && !iblockstate2.isFullBlock())
          {
              enumfacing = EnumFacing.EAST;
          }

          worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
      }
  }


  public void setMachineState(World world, BlockPos pos, IBlockState state, boolean is_on)
  {
    world.setBlockState(pos, state.withProperty(STATE, is_on ? EnumMachineState.ON : EnumMachineState.OFF));
  }

  @Override
  public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack item)
  {
    int dir = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

    EnumFacing facing = EnumFacing.NORTH;
    if(dir == 0)
    {
      facing = EnumFacing.NORTH;
    }
    if(dir == 1)
    {
      facing = EnumFacing.WEST;
    }
    if(dir == 2)
    {
      facing = EnumFacing.SOUTH;
    }
    if(dir == 3)
    {
      facing = EnumFacing.EAST;
    }
    world.setBlockState(pos, state.withProperty(FACING, facing));
  }

  @Override
  public void breakBlock(World world, BlockPos pos, IBlockState state)
  {
    TileEntity te = world.getTileEntity(pos);

    if(te != null && (te instanceof TileEntityFC) && !world.isRemote)
    {
      TileEntityFC tef = (TileEntityFC) te;
      int i;
      for(i = 0; i < tef.getSizeInventory(); i++)
      {
        ItemStack is = tef.getStackInSlot(i);

        if(is != null && is.stackSize > 0)
        {
          double drop_x = (rand.nextFloat() * 0.3) + 0.35;
          double drop_y = (rand.nextFloat() * 0.3) + 0.35;
          double drop_z = (rand.nextFloat() * 0.3) + 0.35;
          EntityItem entityitem = new EntityItem(world, pos.getX() + drop_x, pos.getY() + drop_y, pos.getZ() + drop_z, is);
          entityitem.setPickupDelay(10);

          world.spawnEntityInWorld(entityitem);
        }
      }
    }
    world.removeTileEntity(pos);
    super.breakBlock(world, pos, state);
  }

  
  @Override
  public boolean hasComparatorInputOverride(IBlockState state)
  {
    return true;
  }

  @Override
  public int getComparatorInputOverride(IBlockState state, World world, BlockPos pos)
  {
    return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(pos));
  }
}