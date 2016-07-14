package cz.grossik.farmcraft2;

import cz.grossik.farmcraft2.block.Block_Scarecrow;
import cz.grossik.farmcraft2.bottling.RendererBottling;
import cz.grossik.farmcraft2.bottling.TileEntityBottling;
import cz.grossik.farmcraft2.crushing.RendererCrushing;
import cz.grossik.farmcraft2.crushing.TileEntityCrushing;
import cz.grossik.farmcraft2.fermentingbarrel.RendererFermentingBarrel;
import cz.grossik.farmcraft2.fermentingbarrel.TileEntityFermentingBarrel;
import cz.grossik.farmcraft2.handler.BlockHandler;
import cz.grossik.farmcraft2.spigot.RendererSpigot;
import cz.grossik.farmcraft2.spigot.TileEntitySpigot;
import cz.grossik.farmcraft2.village.ComponentVillageField;
import cz.grossik.farmcraft2.village.VillageFieldHandler;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class ProxyClient extends ProxyCommon {

    @Override
    public void registerRenderer() {
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFermentingBarrel.class, new RendererFermentingBarrel());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBottling.class, new RendererBottling());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySpigot.class, new RendererSpigot());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrushing.class, new RendererCrushing());
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

        VillagerRegistry.instance().registerVillageCreationHandler(new VillageFieldHandler());
        MapGenStructureIO.registerStructureComponent(ComponentVillageField.class, "FieldFC2");
    }
}