package cz.grossik.farmcraft2;

import cz.grossik.farmcraft2.block.Block_Scarecrow;
import cz.grossik.farmcraft2.fermentingbarrel.RendererFermentingBarrel;
import cz.grossik.farmcraft2.fermentingbarrel.TileEntityFermentingBarrel;
import cz.grossik.farmcraft2.handler.BlockHandler;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ProxyClient extends ProxyCommon {

    @Override
    public void registerRenderer() {
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFermentingBarrel.class, new RendererFermentingBarrel());
    }
    
    @Override
	public void preInit() {
    	ModelLoader.setCustomStateMapper(BlockHandler.leavesPearNormal, new StateMap.Builder().ignore(new IProperty[] {BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE}).build());
    	ModelLoader.setCustomStateMapper(BlockHandler.leavesPearSH, new StateMap.Builder().ignore(new IProperty[] {BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE}).build());
    	ModelLoader.setCustomStateMapper(BlockHandler.SaplingPear, new StateMap.Builder().ignore(new IProperty[] {BlockSapling.TYPE}).build());
		ModelLoader.setCustomStateMapper(BlockHandler.Scarecrow, (new StateMap.Builder()).ignore(new IProperty[] {Block_Scarecrow.POWERED}).build());
    	ModelLoader.setCustomStateMapper(BlockHandler.leavesCherryNormal, new StateMap.Builder().ignore(new IProperty[] {BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE}).build());
    	ModelLoader.setCustomStateMapper(BlockHandler.leavesCherryST, new StateMap.Builder().ignore(new IProperty[] {BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE}).build());
    	ModelLoader.setCustomStateMapper(BlockHandler.SaplingCherry, new StateMap.Builder().ignore(new IProperty[] {BlockSapling.TYPE}).build());    
    	ModelLoader.setCustomStateMapper(BlockHandler.leavesPlumNormal, new StateMap.Builder().ignore(new IProperty[] {BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE}).build());
    	ModelLoader.setCustomStateMapper(BlockHandler.leavesPlumSS, new StateMap.Builder().ignore(new IProperty[] {BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE}).build());
    	ModelLoader.setCustomStateMapper(BlockHandler.SaplingPlum, new StateMap.Builder().ignore(new IProperty[] {BlockSapling.TYPE}).build());         
    }
}