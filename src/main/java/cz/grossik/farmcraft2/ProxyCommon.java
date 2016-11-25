package cz.grossik.farmcraft2;

import cz.grossik.farmcraft2.boiling.TileEntityBoiling;
import cz.grossik.farmcraft2.bottling.TileEntityBottling;
import cz.grossik.farmcraft2.crushing.TileEntityCrushing;
import cz.grossik.farmcraft2.fermentingbarrel.TileEntityFermentingBarrel;
import cz.grossik.farmcraft2.juicer.TileEntityJuicer;
import cz.grossik.farmcraft2.mashtun.TileEntityMashTun;
import cz.grossik.farmcraft2.pan.TileEntityPan;
import cz.grossik.farmcraft2.spigot.TileEntitySpigot;
import cz.grossik.farmcraft2.treetap.TileEntityTreetap;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.LoaderState;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ProxyCommon {

    public void registerRenderer() { }

	public void preInitRenders() {}

	public void registerEntities() { }
	
    public void registerTileEntities() {
    	GameRegistry.registerTileEntity(TileEntityJuicer.class, "TileEntityJuicer");
    	GameRegistry.registerTileEntity(TileEntityCrushing.class, "TileEntityCrushing");
    	GameRegistry.registerTileEntity(TileEntityFermentingBarrel.class, "TileEntityFermentingBarrel");
    	GameRegistry.registerTileEntity(TileEntityBottling.class, "TileEntityBottling");
    	GameRegistry.registerTileEntity(TileEntityMashTun.class, "TileEntityMashTun");
    	GameRegistry.registerTileEntity(TileEntityBoiling.class, "TileEntityBoiling");
    	GameRegistry.registerTileEntity(TileEntitySpigot.class, "TileEntitySpigot");
    	GameRegistry.registerTileEntity(TileEntityTreetap.class, "TileEntityTreetap");
    	GameRegistry.registerTileEntity(TileEntityPan.class, "TileEntityPan");
     }

	public void preInit() {	}
	
	public boolean isClient() {
		return false;
	}
}