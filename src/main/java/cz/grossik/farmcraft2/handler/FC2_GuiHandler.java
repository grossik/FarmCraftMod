package cz.grossik.farmcraft2.handler;

import cz.grossik.farmcraft2.backpack.ContainerBackpack;
import cz.grossik.farmcraft2.backpack.GuiBackpack;
import cz.grossik.farmcraft2.block.boiling.ContainerBoiling;
import cz.grossik.farmcraft2.block.boiling.GuiBoiling;
import cz.grossik.farmcraft2.block.boiling.TileEntityBoiling;
import cz.grossik.farmcraft2.block.mashtun.ContainerMashTun;
import cz.grossik.farmcraft2.block.mashtun.GuiMashTun;
import cz.grossik.farmcraft2.block.mashtun.TileEntityMashTun;
import cz.grossik.farmcraft2.bottling.ContainerBottling;
import cz.grossik.farmcraft2.bottling.GuiBottling;
import cz.grossik.farmcraft2.bottling.TileEntityBottling;
import cz.grossik.farmcraft2.crushing.ContainerCrushing;
import cz.grossik.farmcraft2.crushing.GuiCrushing;
import cz.grossik.farmcraft2.crushing.TileEntityCrushing;
import cz.grossik.farmcraft2.fermentingbarrel.ContainerFermentingBarrel;
import cz.grossik.farmcraft2.fermentingbarrel.GuiFermentingBarrel;
import cz.grossik.farmcraft2.fermentingbarrel.TileEntityFermentingBarrel;
import cz.grossik.farmcraft2.juicer.ContainerJuicer;
import cz.grossik.farmcraft2.juicer.GuiJuicer;
import cz.grossik.farmcraft2.juicer.TileEntityJuicer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class FC2_GuiHandler implements IGuiHandler {

	public static final int JUICER_GUI = 0;
	public static final int CRUSHING_GUI = 1;
	public static final int FERMENTINGBARREL_GUI = 2;
	public static final int BOTTLING_GUI = 3;
	public static final int BACKPACK_GUI = 4;
	public static final int MASHTUN_GUI = 5;
	public static final int BOILING_GUI = 6;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	    BlockPos pos = new BlockPos(x,y,z);
		
		if(ID == JUICER_GUI)
			return new ContainerJuicer(player.inventory, ((TileEntityJuicer)world.getTileEntity(new BlockPos(x, y, z))));
		
		if(ID == CRUSHING_GUI)
			return new ContainerCrushing(player.inventory, ((TileEntityCrushing)world.getTileEntity(new BlockPos(x, y, z))));
		
		if(ID == FERMENTINGBARREL_GUI)
			return new ContainerFermentingBarrel(player.inventory, ((TileEntityFermentingBarrel)world.getTileEntity(new BlockPos(x, y, z))));
		
		if(ID == BOTTLING_GUI)
	        return new ContainerBottling((TileEntityBottling)world.getTileEntity(pos),player);
		
		
		if(ID == MASHTUN_GUI)
			return new ContainerMashTun(player.inventory, ((TileEntityMashTun)world.getTileEntity(new BlockPos(x, y, z))));
		
		if(ID == BOILING_GUI)
			return new ContainerBoiling(player.inventory, ((TileEntityBoiling)world.getTileEntity(new BlockPos(x, y, z))));
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	    BlockPos pos = new BlockPos(x,y,z);

		if(ID == JUICER_GUI)
			return new GuiJuicer(player.inventory, ((TileEntityJuicer)world.getTileEntity(new BlockPos(x, y, z))));
		
		if(ID == CRUSHING_GUI)
			return new GuiCrushing(player.inventory, ((TileEntityCrushing)world.getTileEntity(new BlockPos(x, y, z))));
		
		if(ID == FERMENTINGBARREL_GUI)
			return new GuiFermentingBarrel(player.inventory, ((TileEntityFermentingBarrel)world.getTileEntity(new BlockPos(x, y, z))));
		
		if(ID == BOTTLING_GUI)
	      {
	        TileEntityBottling te = (TileEntityBottling)world.getTileEntity(pos);
	        return new GuiBottling(te,player);
	      }
		
		if(ID == MASHTUN_GUI)
			return new GuiMashTun(player.inventory, ((TileEntityMashTun)world.getTileEntity(new BlockPos(x, y, z))));
			
		if(ID == BOILING_GUI)
			return new GuiBoiling(player.inventory, ((TileEntityBoiling)world.getTileEntity(new BlockPos(x, y, z))));
		
		return null;
	}

}
