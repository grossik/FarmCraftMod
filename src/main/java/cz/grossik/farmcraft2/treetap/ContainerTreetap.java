package cz.grossik.farmcraft2.treetap;

import cz.grossik.farmcraft2.bottling.SlotOutput;
import cz.grossik.farmcraft2.crushing.CrushingRecipes;
import cz.grossik.farmcraft2.crushing.TileEntityCrushing;
import cz.grossik.farmcraft2.juicer.JuicerRecipes;
import cz.grossik.farmcraft2.juicer.TileEntityJuicer;
import cz.grossik.farmcraft2.spigot.SlotFluidContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerTreetap extends Container {

    private final IInventory tileFurnace;
    private int PocetSirupu;
    
    public ContainerTreetap(InventoryPlayer playerInventory, TileEntityTreetap te)
    {
        this.tileFurnace = te;
        this.addSlotToContainer(new SlotTreetapContainer(te, 0, 48, 35));
        this.addSlotToContainer(new SlotOutput(te, 2, 107, 35));

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; ++k)
        {
            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
        }
    }

    public void addListener(IContainerListener listener)
    {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.tileFurnace);
    }
    
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.listeners.size(); ++i)
        {
            IContainerListener icontainerlistener = (IContainerListener)this.listeners.get(i);
            
            if (this.PocetSirupu != this.tileFurnace.getField(0))
            {
            	icontainerlistener.sendProgressBarUpdate(this, 0, this.tileFurnace.getField(0));
            }
        }
          
        this.PocetSirupu = this.tileFurnace.getField(0);
    }
    
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.tileFurnace.setField(id, data);
    }
    
	public boolean canInteractWith(EntityPlayer playerIn) {
        return this.tileFurnace.isUseableByPlayer(playerIn);
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
}