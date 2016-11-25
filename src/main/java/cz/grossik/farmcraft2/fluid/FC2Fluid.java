package cz.grossik.farmcraft2.fluid;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import cz.grossik.farmcraft2.handler.ItemHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.UniversalBucket;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FC2Fluid
{
  public static FluidFC2 liquid_beer;

  private static Map<String,FluidFC2> material_fluids;
  static public FC2Fluid instance = new FC2Fluid();

  public FC2Fluid(){
	  material_fluids = new HashMap<String,FluidFC2>();
	  MinecraftForge.EVENT_BUS.register(this);
  }
  
  static private FluidFC2 register(Material material,String name,int temperature,int luminosity)
  {
	  FluidFC2 fluid = new FluidFC2(material, name,
        new ResourceLocation("farmcraft2","blocks/" + name + "_still"),
        new ResourceLocation("farmcraft2","blocks/" + name + "_flow"),
        temperature, luminosity);
    FluidRegistry.registerFluid(fluid);
    FluidRegistry.addBucketForFluid(fluid);
    
    FluidRegistry.enableUniversalBucket();
        
    Block liquid_block = new BlockFluid(fluid, name);
    GameRegistry.registerBlock(liquid_block);

    fluid.setBlock(liquid_block);

    material_fluids.put(name, fluid);
    
    return fluid;
  }
  
  static public void registerFluids()
  {
    liquid_beer = register(Material.WATER, "liquidBeer", 800, 4);
  }
}