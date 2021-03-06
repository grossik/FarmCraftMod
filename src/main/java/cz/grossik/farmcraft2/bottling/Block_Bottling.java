package cz.grossik.farmcraft2.bottling;

import cz.grossik.farmcraft2.Main;
import cz.grossik.farmcraft2.handler.FC2_GuiHandler;
import cz.grossik.farmcraft2.util.BlockFC2SidedMachine;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Block_Bottling extends BlockFC2SidedMachine
{
  public Block_Bottling()
  {
    super(Material.ROCK);
  }
  
  @Override
  public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
  {
      return true;
  }

  @Override
  public boolean isOpaqueCube(IBlockState state)
  {
      return false;
  }

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
  
  @Override
  public TileEntity createNewTileEntity(World world, int meta)
  {
    return new TileEntityBottling();
  }
}