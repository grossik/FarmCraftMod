package cz.test;

import cz.grossik.farmcraft2.handler.BlockHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, version = Main.VERSION, name = "Test")
public class Main
{
    public static final String MODID = "test";
    public static final String VERSION = "1.0";

    public static Block test = new BlockTest(Material.glass).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("test");
    
    public Main(){ 
    	GameRegistry.registerBlock(test, "test");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(test), 0, new ModelResourceLocation(MODID + ":" + "test", "inventory"));
    }
    
    @EventHandler
    public static void PreLoad(FMLPreInitializationEvent PreEvent) {
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {       
      
    }
}