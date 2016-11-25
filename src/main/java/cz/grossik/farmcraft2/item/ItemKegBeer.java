package cz.grossik.farmcraft2.item;

import java.util.List;
import java.util.Map;

import cz.grossik.farmcraft2.Main;
import cz.grossik.farmcraft2.fluid.FC2Fluid;
import cz.grossik.farmcraft2.handler.BlockHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemKegBeer extends Item implements IFluidContainerItem
{
  public final int capacity;

  public ItemKegBeer(int container_capacity)
  {
    super();
    capacity = container_capacity;
    setCreativeTab(Main.FarmCraft2Tab);
    setMaxStackSize(1);
    setHasSubtypes(true);

    MinecraftForge.EVENT_BUS.register(this);
  }

  @SubscribeEvent
  public void playerInteract(PlayerInteractEvent.RightClickBlock event)
  {
    ItemStack stack = event.getEntityPlayer().getHeldItem(event.getHand());
    if(stack != null && stack.getItem() == this)
    {
      event.setCanceled(true);
    }
  }

  private void setFluid(ItemStack is, FluidStack fluid)
  {
    if(fluid != null)
    {
      NBTTagCompound tag = is.getTagCompound();
      if(tag == null)
      {
        tag = new NBTTagCompound();
        is.setTagCompound(tag);
      }
      fluid.writeToNBT(tag);
    } else
    {
      is.setTagCompound(null);
    }
  }

  private ItemStack fromFluidStack(FluidStack fluid)
  {
    ItemStack stack = new ItemStack(this, 1, 0);
    if(fluid == null)
    {
      return stack;
    }
    if(fluid.amount > capacity)
    {
      fluid = new FluidStack(fluid, capacity);
    }
    fill(stack, fluid, true);
    return stack;
  }

  @SuppressWarnings("unchecked")
  @Override
  @SideOnly(Side.CLIENT)
  public void getSubItems(Item item,CreativeTabs tabs, @SuppressWarnings("rawtypes") List list)
  {
    list.add(fromFluidStack(null));
    Map<String, Fluid> fluids = FluidRegistry.getRegisteredFluids();
    for(Fluid f : fluids.values())
    {
        if(f == FC2Fluid.liquid_beer)
        {
            list.add(fromFluidStack(new FluidStack(f, capacity)));
        }
        else
        {
          return;
        }
    }
  }

  @Override
  @SideOnly(Side.CLIENT)
  public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean par4)
  {
    FluidStack fluid = getFluid(stack);
    if(fluid == null)
    {
      list.add(TextFormatting.BLUE + "Empty");
    } else
    {
      list.add(TextFormatting.BLUE + fluid.getLocalizedName());
      list.add(TextFormatting.BLUE + String.valueOf(fluid.amount) + " / " + String.valueOf(capacity) + " mB");
    }
  }

  private boolean splitStack(ItemStack stack,EntityPlayer player)
  {
    if(stack.stackSize == 1)
    {
      return true;
    }
    if(player.capabilities.isCreativeMode)
    {
      return false;
    }
    
    ItemStack rest_stack = stack.copy();
    rest_stack.stackSize--;
    int slot = player.inventory.getFirstEmptyStack();
    if(slot >= 0)
    {
      player.inventory.setInventorySlotContents(slot, rest_stack);
      player.inventory.markDirty();
      stack.stackSize = 1;
      return true;
    }
    return false;
  }

  protected RayTraceResult rayTrace(BlockPos pos, Vec3d start, Vec3d end, AxisAlignedBB boundingBox){
	return null;
  }
  
  @Override
  public FluidStack getFluid(ItemStack stack)
  {
    if(stack.getTagCompound() == null)
    {
      return null;
    }
    return FluidStack.loadFluidStackFromNBT(stack.getTagCompound());
  }

  @Override
  public int getCapacity(ItemStack container)
  {
    return capacity;
  }

  @SuppressWarnings("deprecation")
  private int fill(ItemStack stack, FluidStack fluid, boolean do_fill,boolean ignore_stacksize)
  {
    if(!ignore_stacksize && stack.stackSize > 1)
    {
      return 0;
    }
    FluidStack container_fluid = getFluid(stack);

    if(!do_fill)
    {
      if(container_fluid == null)
      {
        return Math.min(FluidContainerRegistry.BUCKET_VOLUME, fluid.amount);
      }

      if(!container_fluid.isFluidEqual(fluid))
      {
        return 0;
      }

      return Math.min(FluidContainerRegistry.BUCKET_VOLUME - container_fluid.amount, fluid.amount);
    }

    if(container_fluid == null)
    {
      container_fluid = new FluidStack(fluid, Math.min(FluidContainerRegistry.BUCKET_VOLUME, fluid.amount));

      setFluid(stack, container_fluid);
      return container_fluid.amount;
    }

    if(!container_fluid.isFluidEqual(fluid))
    {
      return 0;
    }
    int filled = FluidContainerRegistry.BUCKET_VOLUME - container_fluid.amount;

    if(fluid.amount < filled)
    {
      container_fluid.amount += fluid.amount;
      filled = fluid.amount;
    } else
    {
      container_fluid.amount = FluidContainerRegistry.BUCKET_VOLUME;
    }
    setFluid(stack, container_fluid);
    return filled;
  }

  @Override
  public int fill(ItemStack container, FluidStack resource, boolean doFill)
  {
    return fill(container, resource, doFill, false);
  }
  
  @Override
  public FluidStack drain(ItemStack stack, int amount, boolean do_drain)
  {
    if(stack.stackSize > 1)
    {
      return null;
    }
    FluidStack fluid = getFluid(stack);

    if(fluid == null)
    {
      return null;
    }

    int drained = amount;
    if(fluid.amount < drained)
    {
      drained = fluid.amount;
    }

    FluidStack drain_fluid = new FluidStack(fluid, drained);
    if(do_drain)
    {
      fluid.amount -= drained;
      if(fluid.amount <= 0)
      {
        fluid = null;
      }
      setFluid(stack, fluid);

    }
    return drain_fluid;
  }
  
  @Override
  public int getItemStackLimit(ItemStack stack)
  {
    FluidStack fluid = getFluid(stack);
    if(fluid == null)
    {
      return 1;
    }
    return 1;
  }
  
  public ItemStack empty(int stack_size)
  {
    ItemStack stack = new ItemStack(this,stack_size,0);
    setFluid(stack, null);
    return stack;
  }
}