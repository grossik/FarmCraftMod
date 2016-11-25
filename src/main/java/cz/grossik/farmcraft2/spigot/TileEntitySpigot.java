package cz.grossik.farmcraft2.spigot;

import cz.grossik.farmcraft2.util.TileEntityFC;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TileEntitySpigot extends TileEntityFC implements ISidedInventory,IFluidHandler
{
  public static final int CAST_TIME = 40000000;
    
  public static final int INVENTORY_OUTPUT = 0;
  public static final int INVENTORY_INPUT = 1;
  public static final int INVENTORY_CONTAINER_DRAIN = 2;
  public static final int INVENTORY_CONTAINER_FILL = 3;
  private FluidTank tank;
  private FluidTankInfo[] tank_info;
  ISpigotRecipe current_recipe;
  
  private int progress;

  public TileEntitySpigot()
  {
    super();

    tank = new FluidTank(1000);
    
    tank_info = new FluidTankInfo[1];
    tank_info[0] = new FluidTankInfo(tank);
    progress = -1;
    
    current_recipe = null;
    
    addContainerSlot(new ContainerSlot(0,INVENTORY_CONTAINER_DRAIN,false));
    addContainerSlot(new ContainerSlot(0,INVENTORY_CONTAINER_FILL,true));
  }
  
  
  @Override
  public void readFromNBT(NBTTagCompound compund)
  {
    super.readFromNBT(compund);
    
    if(compund.hasKey("progress"))
    {
      progress = compund.getInteger("progress");
    }
  }


  @Override
  public NBTTagCompound writeToNBT(NBTTagCompound compound)
  {
    if(compound == null)
    {
      compound = new NBTTagCompound();
    }
    super.writeToNBT(compound);
    compound.setInteger("progress", progress);
    return compound;
  }

  @Override
  public int getSizeInventory()
  {
    return 4;
  }

  public int getProgress()
  {
    return progress;
  }

  static private final int[] INSERT_SLOTS = { INVENTORY_OUTPUT };
  static private final int[] EXTRACT_SLOTS = { INVENTORY_OUTPUT };
  static private final int[] INPUT_SLOTS = { INVENTORY_INPUT };

  private static final int[] slotsTop = new int[] {1};
  private static final int[] slotsBottom = new int[] {0};
  private static final int[] slotsSides = new int[] {2};

  @Override
  public boolean isItemValidForSlot(int slot, ItemStack itemstack)
  {
    return slot == INVENTORY_INPUT;
  }

  @Override
  public int[] getSlotsForFace(EnumFacing side)
  {
      return (side == EnumFacing.DOWN ? slotsBottom : (side == EnumFacing.UP ? slotsTop : slotsSides));
  }

  @Override
  public boolean canInsertItem(int slot, ItemStack itemstack, EnumFacing side)
  {
    return isItemValidForSlot(slot, itemstack);
  }

  @Override
  public boolean canExtractItem(int slot, ItemStack itemstack, EnumFacing side)
  {
    return slot == INVENTORY_OUTPUT;
  }

  @Override
  public int fill(EnumFacing from, FluidStack resource, boolean doFill)
  {
    return fillTank(0, resource, doFill);
  }

  @Override
  public FluidStack drain(EnumFacing from, FluidStack resource, boolean doDrain)
  {
    return drainTank(0, resource, doDrain);
  }

  @Override
  public FluidStack drain(EnumFacing from, int maxDrain, boolean doDrain)
  {
    return drainTank(0, maxDrain, doDrain);
  }

  @Override
  public boolean canFill(EnumFacing from, Fluid fluid)
  {
    return true;
  }

  @Override
  public boolean canDrain(EnumFacing from, Fluid fluid)
  {
    return true;
  }

  @Override
  public FluidTankInfo[] getTankInfo(EnumFacing from)
  {
    return tank_info;
  }

  @Override protected void updateClient() { }
  
  private void checkCurrentRecipe()
  {
    if(current_recipe == null)
    {
      progress = -1;
      return;
    }

    if(!current_recipe.matchesRecipe(inventory[INVENTORY_INPUT], tank.getFluid(),inventory[INVENTORY_INPUT]))
    {
      progress = -1;
      current_recipe = null;
      return;
    }
  }
  
  private void beginCasting()
  {
    if(current_recipe != null && canCastCurrentRecipe())
    {
      progress = 0;
    }
  }
  
  private boolean canCastCurrentRecipe()
  {
    if(current_recipe.requiresExtra())
    {
      if(!current_recipe.containsExtra(inventory[INVENTORY_INPUT]))
      {
        return false;
      }
    }
    
    ItemStack recipe_output = current_recipe.getOutput();

    ItemStack inv_output = inventory[INVENTORY_OUTPUT];
    if(inv_output != null && (!inv_output.isItemEqual(recipe_output) || inv_output.stackSize + recipe_output.stackSize > inv_output.getMaxStackSize()))
    {
      return false;
    }
    return true;
  }

  @Override
  protected void updateServer()
  {
    int last_progress = progress;
    
    checkCurrentRecipe();
    
    if(current_recipe == null)
    {
      current_recipe = SpigotRecipeManager.instance.findRecipe(tank.getFluid(), inventory[INVENTORY_INPUT],inventory[INVENTORY_INPUT]);
      progress = -1;
    }
    
    if(progress < 0)
    {
          beginCasting();
    } else
    {
      if(canCastCurrentRecipe())
      {
        FluidStack input_fluid = current_recipe.getInput();
        int increment = 18000 * current_recipe.getCastingSpeed() / input_fluid.amount;
        if(increment > CAST_TIME / 4)
        {
          increment = CAST_TIME / 4;
        }
        if(increment < 1)
        {
          increment = 1;
        }
        progress += increment;
        
        if(progress >= CAST_TIME)
        {
          progress = -1;
          tank.drain(input_fluid.amount, true);
          if(current_recipe.requiresExtra())
          {
            decrStackSize(INVENTORY_INPUT, current_recipe.getInputExtra().getAmount());
            updateInventoryItem(INVENTORY_INPUT);
          }
          
          decrStackSize(INVENTORY_INPUT, current_recipe.getInputMold().stackSize);
          updateInventoryItem(INVENTORY_INPUT);
          
          if(inventory[INVENTORY_OUTPUT] == null)
          {
            inventory[INVENTORY_OUTPUT] = current_recipe.getOutput();
          } else
          {
            inventory[INVENTORY_OUTPUT].stackSize += current_recipe.getOutput().stackSize;
          }
          updateInventoryItem(INVENTORY_OUTPUT);
          updateTank(0);
          markDirty();
        }
      } else
      {
        progress = -1;
      }
    }
    
    if(last_progress != progress)
    {
      updateValue("progress",progress);
    }
  }

  @Override
  public FluidTank getTank(int slot)
  {
    if(slot != 0)
    {
      return null;
    }
    return tank;
  }

  @Override
  public int getTankCount()
  {
    return 1;
  }

  @Override protected void onInitialize() { }
}