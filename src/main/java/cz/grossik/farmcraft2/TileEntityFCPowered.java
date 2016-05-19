package cz.grossik.farmcraft2;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

//public abstract class TileEntityFCPowered extends TileEntityFC implements IEnergyReceiver
public abstract class TileEntityFCPowered extends TileEntityFC 
{
  protected boolean update_energy;
  protected boolean update_energy_tick;
  
  public abstract int getFoundryEnergyCapacity();
  
  public TileEntityFCPowered()
  {
    super();    
    
    update_energy = false;
    update_energy_tick = true;
  }

  static public int RATIO_RF = 10;
  static public int RATIO_EU = 40;
  
  private int energy_stored;
  
  private int receiveFoundryEnergy(int en,boolean do_receive, boolean allow_overflow)
  {
    if(!allow_overflow)
    {
      int needed = getFoundryEnergyCapacity() - energy_stored;
      if(en > needed)
      {
        en = needed;
      }
    }
    if(do_receive)
    {
      energy_stored += en;
      if(en > 0)
      {
        if(update_energy && !worldObj.isRemote)
        {
          update_energy_tick = true;
        }
      }
    }
    return en;
  }
  
  private int receiveRF(int rf,boolean do_receive)
  {
    return receiveFoundryEnergy(rf * RATIO_RF,do_receive,false) / RATIO_RF;
  }
  
//  private double receiveEU(double eu,boolean do_receive)
//  {
//    return (double)receiveFoundryEnergy((int)(eu * RATIO_EU),do_receive,true) / RATIO_EU;
//  }
  
  public int useFoundryEnergy(int amount,boolean do_use)
  {
    if(amount > energy_stored)
    {
      amount = energy_stored;
    }
    if(do_use)
    {
      energy_stored -= amount;
      updateFoundryEnergy();
    }
    return amount;
  }
  
  public int getStoredFoundryEnergy()
  {
    int capacity = getFoundryEnergyCapacity();
    if(energy_stored > capacity)
    {
      return capacity;
    } else
    {
      return energy_stored;
    }
  }

  @Override
  public void readFromNBT(NBTTagCompound compound)
  {
    super.readFromNBT(compound);
    if(compound.hasKey("energy"))
    {
      energy_stored = compound.getInteger("energy");
    }
  }
  
  
  @Override
  public void writeToNBT(NBTTagCompound compound)
  {
    super.writeToNBT(compound);
    compound.setInteger("energy", energy_stored);
  }

  protected void onInitialize()
  {
    update_energy_tick = true;
  }
  
//  @Override
//  public void updateEntity()
//  {
//    if(!added_enet)
//    {
//      try
//      {
//        getClass().getMethod("LoadEnet").invoke(this);
//      } catch(IllegalAccessException e)
//      {
//        throw new RuntimeException(e);
//      } catch(IllegalArgumentException e)
//      {
//        throw new RuntimeException(e);
//      } catch(InvocationTargetException e)
//      {
//        throw new RuntimeException(e);
//      } catch(NoSuchMethodException e)
//      {
//        if(Loader.isModLoaded("IC2"))
//        {
//          throw new RuntimeException(e);
//        }
//      } catch(SecurityException e)
//      {
//        throw new RuntimeException(e);
//      }
//    }
//    super.updateEntity();
//  }
  
  private void updateFoundryEnergy()
  {
    if(update_energy)
    {
      updateValue("energy",energy_stored);
    }
  }
  
  @Override
  protected void updateServer()
  {
    if(update_energy_tick)
    {
      updateFoundryEnergy();
      update_energy_tick = false;
    }
  }
  
  public void updateRedstone()
  {
    redstone_signal = worldObj.isBlockIndirectlyGettingPowered(getPos()) > 0;
  }
  
  /**@Override
  public int receiveEnergy(EnumFacing from, int maxReceive, boolean simulate)
  {
    return receiveRF(maxReceive, !simulate);
  }

  @Override
  public boolean canConnectEnergy(EnumFacing from)
  {
    return true;
  }

  @Override
  public int getEnergyStored(EnumFacing from)
  {
    return getStoredFoundryEnergy() / RATIO_RF;
  }

  @Override
  public int getMaxEnergyStored(EnumFacing from)
  {
    return getFoundryEnergyCapacity() / RATIO_RF;
  }**/
}