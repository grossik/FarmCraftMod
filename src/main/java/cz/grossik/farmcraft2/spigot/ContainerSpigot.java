package cz.grossik.farmcraft2.spigot;

import cz.grossik.farmcraft2.bottling.SlotOutput;
import cz.grossik.farmcraft2.juicer.JuicerRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSpigot extends Container
{
  private TileEntitySpigot te_caster;
  
  // Slot numbers
  public static final int SLOTS_TE = 0;
  public static final int SLOTS_TE_SIZE = 4;
  public static final int SLOTS_INVENTORY = 14;
  private static final int SLOTS_HOTBAR = 14 + 3 * 9;

  private static final int SLOT_INVENTORY_X = 8;
  private static final int SLOT_INVENTORY_Y = 84;

  private static final int SLOT_HOTBAR_X = 8;
  private static final int SLOT_HOTBAR_Y = 142;

  private static final int SLOT_STORAGE_X = 116;
  private static final int SLOT_STORAGE_Y = 21;

  public ContainerSpigot(TileEntitySpigot caster, EntityPlayer player)
  {
    te_caster = caster;
    te_caster.openInventory(player);
    int i,j;

    addSlotToContainer(new SlotOutput(te_caster, TileEntitySpigot.INVENTORY_OUTPUT, 86, 51));
    addSlotToContainer(new Slot(te_caster, TileEntitySpigot.INVENTORY_INPUT, 86, 21));
    addSlotToContainer(new SlotFluidContainer(te_caster, TileEntitySpigot.INVENTORY_CONTAINER_DRAIN, 11, 21));
    addSlotToContainer(new SlotFluidContainer(te_caster, TileEntitySpigot.INVENTORY_CONTAINER_FILL, 11, 51));

    //Player Inventory
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
    return te_caster.isUseableByPlayer(par1EntityPlayer);
  }


  public ItemStack transferStackInSlot(EntityPlayer player, int slot_index)
  {
    ItemStack slot_stack = null;
    Slot slot = (Slot) inventorySlots.get(slot_index);

    if (slot != null && slot.getHasStack())
    {
      ItemStack stack = slot.getStack();
      slot_stack = stack.copy();

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
    te_caster.closeInventory(player);
  }
}