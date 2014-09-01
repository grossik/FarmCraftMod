package cz.grossik.farmcraft;

import cz.grossik.farmcraft.boiling.ContainerBoiling;
import cz.grossik.farmcraft.boiling.GuiBoiling;
import cz.grossik.farmcraft.boiling.TileEntityBoiling;
import cz.grossik.farmcraft.bottling.ContainerBottling;
import cz.grossik.farmcraft.bottling.GuiBottling;
import cz.grossik.farmcraft.bottling.TileEntityBottling;
import cz.grossik.farmcraft.juicer.ContainerJuicer;
import cz.grossik.farmcraft.juicer.GuiJuicer;
import cz.grossik.farmcraft.juicer.TileEntityJuicer;
import cz.grossik.farmcraft.mashtun.ContainerMashTun;
import cz.grossik.farmcraft.mashtun.GuiMashTun;
import cz.grossik.farmcraft.mashtun.TileEntityMashTun;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class FC_GuiHandler implements IGuiHandler {

    public FC_GuiHandler() {

    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        if (ID == 0) {
            TileEntityJuicer tileEntityFurnace = (TileEntityJuicer) world.getTileEntity(x, y, z);
            return new ContainerJuicer(player.inventory, tileEntityFurnace);
        }
        if (ID == 1) {
            TileEntityMashTun tileEntityMashTun = (TileEntityMashTun) world.getTileEntity(x, y, z);
            return new ContainerMashTun(player.inventory, tileEntityMashTun);
        }
        if (ID == 2) {
            TileEntityBoiling tileEntityMashTun = (TileEntityBoiling) world.getTileEntity(x, y, z);
            return new ContainerBoiling(player.inventory, tileEntityMashTun);
        }
        if (ID == 3) {
            TileEntityBottling tileEntityMashTun = (TileEntityBottling) world.getTileEntity(x, y, z);
            return new ContainerBottling(player.inventory, tileEntityMashTun);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        if (ID == 0) {
            TileEntityJuicer tileEntityJuicerContainer = (TileEntityJuicer) world.getTileEntity(x, y, z);
            return new GuiJuicer(player.inventory, tileEntityJuicerContainer);
        }
        if (ID == 1) {
            TileEntityMashTun tileEntityMashTunContainer = (TileEntityMashTun) world.getTileEntity(x, y, z);
            return new GuiMashTun(player.inventory, tileEntityMashTunContainer);
        }
        if (ID == 2) {
            TileEntityBoiling tileEntityMashTunContainer = (TileEntityBoiling) world.getTileEntity(x, y, z);
            return new GuiBoiling(player.inventory, tileEntityMashTunContainer);
        }
        if (ID == 3) {
            TileEntityBottling tileEntityMashTunContainer = (TileEntityBottling) world.getTileEntity(x, y, z);
            return new GuiBottling(player.inventory, tileEntityMashTunContainer);
        }
        return null;
    }

}