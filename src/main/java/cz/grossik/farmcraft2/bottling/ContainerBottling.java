package cz.grossik.farmcraft2.bottling;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerBottling extends Container
{
  private TileEntityBottling te_alloyfurnace;
  
  // Slot numbers
  public static final int SLOTS_TE = 0;
  public static final int SLOTS_TE_SIZE = 3;
  
  public static final int SLOTS_INVENTORY = 3;
  public static final int SLOTS_HOTBAR = 3 + 3 * 9;

  private static final int SLOT_INVENTORY_X = 8;
  private static final int SLOT_INVENTORY_Y = 84;

  private static final int SLOT_HOTBAR_X = 8;
  private static final int SLOT_HOTBAR_Y = 142;

  public ContainerBottling(TileEntityBottling furnace, EntityPlayer player)
  {
    te_alloyfurnace = furnace;
    te_alloyfurnace.openInventory(player);
    int i,j;

    
    addSlotToContainer(new Slot(te_alloyfurnace,TileEntityBottling.SLOT_INPUT_A,56,17));
    addSlotToContainer(new Slot(te_alloyfurnace,TileEntityBottling.SLOT_INPUT_B,56,53));
    addSlotToContainer(new SlotOutput(te_alloyfurnace,TileEntityBottling.SLOT_OUTPUT,116,35));

    for(i = 0; i < 3; ++i)
    {
      for(j = 0; j < 9; ++j)
      {
        addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, SLOT_INVENTORY_X + j * 18, SLOT_INVENTORY_Y + i * 18));
      }
    }
    for(i = 0; i < 9; ++i)
    {
      addSlotToContainer(new Slot(player.inventory, i, SLOT_HOTBAR_X + i * 18, SLOT_HOTBAR_Y));
    }
  }

  public boolean canInteractWith(EntityPlayer par1EntityPlayer)
  {
    return te_alloyfurnace.isUseableByPlayer(par1EntityPlayer);
  }

  public ItemStack transferStackInSlot(EntityPlayer player, int slot_index)
  {
    ItemStack slot_stack = null;
    Slot slot = (Slot) inventorySlots.get(slot_index);

    if (slot != null && slot.getHasStack())
    {
      ItemStack stack = slot.getStack();
      slot_stack = stack.copy();

      if (slot_index >= SLOTS_INVENTORY && slot_index < SLOTS_HOTBAR)
      {
        if(TileEntityFurnace.isItemFuel(stack))
        {
          int s = SLOTS_TE;
          if(!mergeItemStack(stack, s, s + 1, false))
          {
            return null;
          } 
        } else if(!mergeItemStack(stack, SLOTS_TE, SLOTS_TE + TileEntityBottling.SLOT_INPUT_B + 1, false))
        {
          return null;
        }
      } else if (slot_index >= SLOTS_HOTBAR && slot_index < SLOTS_HOTBAR + 9)
      {
        if (!mergeItemStack(stack, SLOTS_INVENTORY, SLOTS_INVENTORY + 3 * 9, false))
        {
          return null;
        }
      } else if (!mergeItemStack(stack, SLOTS_INVENTORY, SLOTS_HOTBAR + 9, false))
      {
        return null;
      }

      if (stack.stackSize == 0)
      {
        slot.putStack((ItemStack) null);
      } else
      {
        slot.onSlotChanged();
      }

      if (stack.stackSize == slot_stack.stackSize)
      {
        return null;
      }

      slot.onPickupFromSlot(player, stack);
    }

    return slot_stack;
  }

  @Override
  public void onContainerClosed(EntityPlayer player)
  {
    super.onContainerClosed(player);
    te_alloyfurnace.closeInventory(player);
  }
}