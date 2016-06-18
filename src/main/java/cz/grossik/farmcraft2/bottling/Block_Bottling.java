package cz.grossik.farmcraft2.bottling;

import cz.grossik.farmcraft2.Main;
import cz.grossik.farmcraft2.block.BlockFC2SidedMachine;
import cz.grossik.farmcraft2.handler.FC2_GuiHandler;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class Block_Bottling extends BlockFC2SidedMachine
{
	  public enum EnumMachineLevel implements IStringSerializable
	  {
		  
	    NE(0, "0"),
	    JO(1, "1");

	    public final int id;
	    public final String name;

	    private EnumMachineLevel(int id, String name)
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

	    static public EnumMachineLevel fromID(int num)
	    {
	      for(EnumMachineLevel m : values())
	      {
	        if(m.id == num)
	        {
	          return m;
	        }
	      }
	      return null;
	    }
	  }
	  
  public static final PropertyEnum<EnumMachineLevel> LEVEL = PropertyEnum.create("level", EnumMachineLevel.class);

  public Block_Bottling()
  {
    super(Material.rock);
    this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL, EnumMachineLevel.NE));
  }
  
  public EnumBlockRenderType getRenderType(IBlockState state)
  {
      return EnumBlockRenderType.MODEL;
  }
  
  public BlockStateContainer createBlockState()
  {
    return new BlockStateContainer(this, STATE, FACING, LEVEL);
  }
  
  public IBlockState getStateFromMeta(int meta)
  {
    return getDefaultState().withProperty(FACING, EnumMachineFacing.fromID(meta & 3)).withProperty(STATE, EnumMachineState.fromID((meta >>> 2) & 1)).withProperty(LEVEL, EnumMachineLevel.fromID((meta >>> 2) & 1));
  }

  @Override
  public int getMetaFromState(IBlockState state)
  {
    EnumMachineState fstate = (EnumMachineState) state.getValue(STATE);
    EnumMachineFacing facing = (EnumMachineFacing) state.getValue(FACING);
    EnumMachineLevel flevel = (EnumMachineLevel) state.getValue(LEVEL);
    return fstate.id << 2 | facing.id |flevel.id << 2; 
  }


  /**@Override
  public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
  {
      return true;
  }

  @Override
  public boolean isOpaqueCube(IBlockState state)
  {
      return false;
  }**/
  

  @Override
  public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hit_x, float hit_y, float hit_z)
  {
	  
    if(world.isRemote)
    {
      return true;
    } else
    {
      player.openGui(Main.instance, FC2_GuiHandler.BOTTLING_GUI, world, pos.getX(), pos.getY(), pos.getZ());
      return true;
    }
  }

  public void setLevel(World worldIn, BlockPos pos, IBlockState state, int level)
  {
      worldIn.setBlockState(pos, state.withProperty(LEVEL, EnumMachineLevel.fromID(MathHelper.clamp_int(level, 0, 3))), 2);
      worldIn.updateComparatorOutputLevel(pos, this);
  }
  
  @Override
  public TileEntity createNewTileEntity(World world, int meta)
  {
    return new TileEntityBottling();
  }
}