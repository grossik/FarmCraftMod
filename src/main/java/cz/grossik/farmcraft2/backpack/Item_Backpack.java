package cz.grossik.farmcraft2.backpack;

import java.util.List;

import cz.grossik.farmcraft2.Main;
import cz.grossik.farmcraft2.handler.FC2_GuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Item_Backpack extends Item {

	public Item_Backpack() {
		super();
		this.maxStackSize = 1;
	}

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
		playerIn.openGui(Main.instance, FC2_GuiHandler.BACKPACK_GUI, worldIn, playerIn.inventory.currentItem, 0, 0);
    	return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
    }
    
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
    	par3List.add("One backpack on player!");
    }
}
