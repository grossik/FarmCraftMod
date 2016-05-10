package cz.grossik.farmcraft2.backpack;

import cz.grossik.farmcraft2.Main;
import cz.grossik.farmcraft2.handler.FC2_GuiHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Item_Backpack extends Item {

	public Item_Backpack() {
		super();
		this.maxStackSize = 1;
	}

	/**@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int indexInventory, boolean isCurrentItem) {

		if (world.isRemote || !isCurrentItem) {
			return;
		}
		if (ContainerBackpack.notify) {
			ContainerBackpack.saveToNBT(itemStack);
			ContainerBackpack.notify = false;
		}
	}**/

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer entityPlayer) {
		if (!par2World.isRemote) {
			entityPlayer.openGui(Main.instance, FC2_GuiHandler.BACKPACK_GUI, entityPlayer.worldObj, (int) entityPlayer.posX, (int) entityPlayer.posY, (int) entityPlayer.posZ);
		}
		return par1ItemStack;
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}
}
