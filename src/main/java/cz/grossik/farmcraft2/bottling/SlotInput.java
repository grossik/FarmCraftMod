package cz.grossik.farmcraft2.bottling;

import cz.grossik.farmcraft2.bottling.Block_Bottling.EnumMachineLevel;
import cz.grossik.farmcraft2.handler.ItemHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SlotInput extends Slot
{
    private int slotIndex;
        
    public SlotInput(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition)
    {
        super(inventoryIn, slotIndex, xPosition, yPosition);
    }

    public void onSlotChange(ItemStack p_75220_1_, ItemStack p_75220_2_)
    {
        if (p_75220_1_ != null && p_75220_2_ != null)
        {
            if (p_75220_1_.getItem() == p_75220_2_.getItem())
            {
                int i = p_75220_2_.stackSize - p_75220_1_.stackSize;

                if (i > 0)
                {
                    this.onCrafting(p_75220_1_, i);
                }
            }
        }
    }

    protected void onCrafting(ItemStack stack, int amount)
    {
    }

    protected void onCrafting(ItemStack stack)
    {
    }

    public void onPickupFromSlot(EntityPlayer playerIn, ItemStack stack)
    {
        this.onSlotChanged();
    }

    public boolean isItemValid(ItemStack stack)
    {
    	if(stack.getItem() == ItemHandler.Bottle) {
    		return true;
    	}
		return false;
    }

    public ItemStack getStack()
    {
        return this.inventory.getStackInSlot(this.slotIndex);
    }

    public boolean getHasStack()
    {
        return this.getStack() != null;
    }

    public void putStack(ItemStack stack)
    {
        this.inventory.setInventorySlotContents(this.slotIndex, stack);
        this.onSlotChanged();
    }

    public void onSlotChanged()
    {
        this.inventory.markDirty();
    }

    public int getSlotStackLimit()
    {
        return this.inventory.getInventoryStackLimit();
    }

    public int getItemStackLimit(ItemStack stack)
    {
        return this.getSlotStackLimit();
    }

    @SideOnly(Side.CLIENT)
    public String getSlotTexture()
    {
        return backgroundName;
    }

    public ItemStack decrStackSize(int amount)
    {
        return this.inventory.decrStackSize(this.slotIndex, amount);
    }

    public boolean isHere(IInventory inv, int slotIn)
    {
        return inv == this.inventory && slotIn == this.slotIndex;
    }

    public boolean canTakeStack(EntityPlayer playerIn)
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public boolean canBeHovered()
    {
        return true;
    }

    protected String backgroundName = null;
    protected net.minecraft.util.ResourceLocation backgroundLocation = null;
    protected Object backgroundMap;

    @SideOnly(Side.CLIENT)
    public net.minecraft.util.ResourceLocation getBackgroundLocation()
    {
        return (backgroundLocation == null ? net.minecraft.client.renderer.texture.TextureMap.locationBlocksTexture : backgroundLocation);
    }


    @SideOnly(Side.CLIENT)
    public void setBackgroundLocation(net.minecraft.util.ResourceLocation texture)
    {
        this.backgroundLocation = texture;
    }

    public void setBackgroundName(String name)
    {
        this.backgroundName = name;
    }

    @SideOnly(Side.CLIENT)
    public net.minecraft.client.renderer.texture.TextureAtlasSprite getBackgroundSprite()
    {
        String name = getSlotTexture();
        return name == null ? null : getBackgroundMap().getAtlasSprite(name);
    }

    @SideOnly(Side.CLIENT)
    protected net.minecraft.client.renderer.texture.TextureMap getBackgroundMap()
    {
        if (backgroundMap == null) backgroundMap = net.minecraft.client.Minecraft.getMinecraft().getTextureMapBlocks();
        return (net.minecraft.client.renderer.texture.TextureMap)backgroundMap;
    }

    public int getSlotIndex()
    {
        return slotIndex;
    }
}