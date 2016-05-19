package cz.grossik.farmcraft2;

import cz.grossik.farmcraft2.boiling.TileEntityBoiling;
import cz.grossik.farmcraft2.bottling.TileEntityBottling;
import cz.grossik.farmcraft2.crushing.TileEntityCrushing;
import cz.grossik.farmcraft2.fermentingbarrel.TileEntityFermentingBarrel;
import cz.grossik.farmcraft2.juicer.TileEntityJuicer;
import cz.grossik.farmcraft2.mashtun.TileEntityMashTun;
import cz.grossik.farmcraft2.spigot.TileEntitySpigot;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ProxyCommon {

    public void registerRenderer() {
    }

    public void registerTileEntities() {
    	GameRegistry.registerTileEntity(TileEntityJuicer.class, "TileEntityJuicer");
    	GameRegistry.registerTileEntity(TileEntityCrushing.class, "TileEntityCrushing");
    	GameRegistry.registerTileEntity(TileEntityFermentingBarrel.class, "TileEntityFermentingBarrel");
    	GameRegistry.registerTileEntity(TileEntityBottling.class, "TileEntityBottling");
    	GameRegistry.registerTileEntity(TileEntityMashTun.class, "TileEntityMashTun");
    	GameRegistry.registerTileEntity(TileEntityBoiling.class, "TileEntityBoiling");
    	GameRegistry.registerTileEntity(TileEntitySpigot.class, "TileEntitySpigot");
    }

	public void preInit() {		
	}

	public boolean isClient() {
		return false;
	}
}