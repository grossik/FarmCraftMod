package cz.grossik.farmcraft2.bottling;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBottling extends Container
{
  private TileEntityBottling te_alloyfurnace;

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
    
    addSlotToContainer(new SlotInput(te_alloyfurnace,TileEntityBottling.SLOT_INPUT_A,56,17));
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
      ItemStack itemstack = null;
      Slot slot = (Slot)this.inventorySlots.get(slot_index);

      if (slot != null && slot.getHasStack())
      {
          ItemStack itemstack1 = slot.getStack();
          itemstack = itemstack1.copy();

          if (slot_index == 2)
          {
              if (!this.mergeItemStack(itemstack1, 3, 39, true))
              {
                  return null;
              }

              slot.onSlotChange(itemstack1, itemstack);
          }
          else if (slot_index != 1 && slot_index != 0)
          {
              if (BottlingRecipeManager.instance.getRecipes() != null)
              {
                  if (!this.mergeItemStack(itemstack1, 0, 1, false))
                  {
                      return null;
                  }
              }
              else if (TileEntityBottling.isItemFuel(itemstack1))
              {
                  if (!this.mergeItemStack(itemstack1, 1, 2, false))
                  {
                      return null;
                  }
              }
              else if (slot_index >= 3 && slot_index < 30)
              {
                  if (!this.mergeItemStack(itemstack1, 30, 39, false))
                  {
                      return null;
                  }
              }
              else if (slot_index >= 30 && slot_index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
              {
                  return null;
              }
          }
          else if (!this.mergeItemStack(itemstack1, 3, 39, false))
          {
              return null;
          }

          if (itemstack1.stackSize == 0)
          {
              slot.putStack((ItemStack)null);
          }
          else
          {
              slot.onSlotChanged();
          }

          if (itemstack1.stackSize == itemstack.stackSize)
          {
              return null;
          }

          slot.onPickupFromSlot(player, itemstack1);
      }

      return itemstack;
  }
  
  
  @Override
  public void onContainerClosed(EntityPlayer player)
  {
    super.onContainerClosed(player);
    te_alloyfurnace.closeInventory(player);
  }
}