package cze.grossik.farmcraft;

import cze.grossik.farmcraft.boiling.TileEntityBoiling;
import cze.grossik.farmcraft.bottling.TileEntityBottling;
import cze.grossik.farmcraft.juicer.TileEntityJuicer;
import cze.grossik.farmcraft.mashtun.TileEntityMashTun;
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