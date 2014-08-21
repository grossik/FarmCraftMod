package cz.grossik.farmcraft;

import cz.grossik.farmcraft.boiling.TileEntityBoiling;
import cz.grossik.farmcraft.bottling.TileEntityBottling;
import cz.grossik.farmcraft.juicer.TileEntityJuicer;
import cz.grossik.farmcraft.mashtun.TileEntityMashTun;
import cpw.mods.fml.common.registry.GameRegistry;

public class FCProxyCommon {

    public void initSounds() {

    }

    public void initRenderers() {

    }

    public void registerRenderer() {

    }

    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityJuicer.class, "TileEntityJuicer");
        GameRegistry.registerTileEntity(TileEntityMashTun.class, "TileEntityMashTun");
        GameRegistry.registerTileEntity(TileEntityBoiling.class, "TileEntityBoiling");
        GameRegistry.registerTileEntity(TileEntityBottling.class, "TileEntityBottling");

    }

}