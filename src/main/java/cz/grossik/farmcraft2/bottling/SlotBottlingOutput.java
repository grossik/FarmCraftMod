package cz.grossik.farmcraft2.bottling;

import cz.grossik.farmcraft2.handler.ItemHandler;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.math.MathHelper;

public class SlotBottlingOutput extends Slot
{
    private EntityPlayer thePlayer;
    private int field_75228_b;

    public SlotBottlingOutput(EntityPlayer player, IInventory inventoryIn, int slotIndex, int xPosition, int yPosition)
    {
        super(inventoryIn, slotIndex, xPosition, yPosition);
        this.thePlayer = player;
    }

    public boolean isItemValid(ItemStack stack)
    {
     	if(stack.getItem() == ItemHandler.BottleSW)
     	{
     		SlotBottlingFuel.wine = false; 
     	}
     	if(stack.getItem() == ItemHandler.KegOfBeer)
     	{
     		SlotBottlingFuel.beer = false;
     	}	
        return false;
    }

    public ItemStack decrStackSize(int amount)
    {
        if (this.getHasStack())
        {
            this.field_75228_b += Math.min(amount, this.getStack().stackSize);
        }

        return super.decrStackSize(amount);
    }

    public void onPickupFromSlot(EntityPlayer playerIn, ItemStack stack)
    {
        this.onCrafting(stack);
        super.onPickupFromSlot(playerIn, stack);
    }

    protected void onCrafting(ItemStack stack, int amount)
    {
        this.field_75228_b += amount;
        this.onCrafting(stack);
    }

    protected void onCrafting(ItemStack stack)
    {
        stack.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.field_75228_b);

        if (!this.thePlayer.worldObj.isRemote)
        {
            int i = this.field_75228_b;
            float f = BottlingRecipes.instance().getSmeltingExperience(stack);

            if (f == 0.0F)
            {
                i = 0;
            }
            else if (f < 1.0F)
            {
                int j = MathHelper.floor_float((float)i * f);

                if (j < MathHelper.ceiling_float_int((float)i * f) && Math.random() < (double)((float)i * f - (float)j))
                {
                    ++j;
                }

                i = j;
            }

            while (i > 0)
            {
                int k = EntityXPOrb.getXPSplit(i);
                i -= k;
                this.thePlayer.worldObj.spawnEntityInWorld(new EntityXPOrb(this.thePlayer.worldObj, this.thePlayer.posX, this.thePlayer.posY + 0.5D, this.thePlayer.posZ + 0.5D, k));
            }
        }

        this.field_75228_b = 0;

        net.minecraftforge.fml.common.FMLCommonHandler.instance().firePlayerSmeltedEvent(thePlayer, stack);

        if (stack.getItem() == Items.iron_ingot)
        {
            this.thePlayer.addStat(AchievementList.acquireIron);
        }

        if (stack.getItem() == Items.cooked_fish)
        {
            this.thePlayer.addStat(AchievementList.cookFish);
        }
    }
}