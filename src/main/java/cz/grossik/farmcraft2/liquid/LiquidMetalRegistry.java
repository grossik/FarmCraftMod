package cz.grossik.farmcraft2.liquid;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cz.grossik.farmcraft2.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class LiquidMetalRegistry implements IFluidRegistry
{
  private Map<String,FluidLiquidMetal> registry;
  
  static public LiquidMetalRegistry instance = new LiquidMetalRegistry();
  
  private LiquidMetalRegistry()
  {
    registry = new HashMap<String,FluidLiquidMetal>();
    MinecraftForge.EVENT_BUS.register(this);
  }

  public FluidLiquidMetal registerLiquidMetal(String metal_name,int temperature,int luminosity)
  {
    return registerLiquidMetal(metal_name,temperature,luminosity,"liquid" + metal_name,0xFFFFFF);
  }

  static public ItemStack getModItemFromOreDictionary(String modid,String orename)
  {
    return getModItemFromOreDictionary(modid, orename, 1);
  }

  static public ItemStack getModItemFromOreDictionary(String modid,String orename, int amount)
  {
    modid = modid.toLowerCase();
    for(ItemStack is:OreDictionary.getOres(orename))
    {
      if(is.getItem().getRegistryName().getResourceDomain().equals(modid))
      {
        is = is.copy();
        is.stackSize = amount;
        return is;
      }
    }
    return null;
  }
  
  public FluidLiquidMetal registerLiquidMetal(String metal_name,int temperature,int luminosity,String texture,int color)
  {
    FluidLiquidMetal fluid = new FluidLiquidMetal("liquid" + metal_name,
        new ResourceLocation("farmcraft2","blocks/" + texture + "_still"),
        new ResourceLocation("farmcraft2","blocks/" + texture + "_flow"),
        color, false, temperature,luminosity);
    FluidRegistry.registerFluid(fluid);

    String block_name = "block" + metal_name;
    Object solid = getModItemFromOreDictionary("substratum", block_name);
    if(solid == null)
    {
      solid = block_name;
    }

    Block liquid_block = new BlockLiquidMetal(fluid, "liquid" + metal_name, solid);
    GameRegistry.register(liquid_block);
    GameRegistry.register(new ItemBlock(liquid_block).setRegistryName(liquid_block.getRegistryName())); 

    fluid.setBlock(liquid_block);
    
    registry.put(metal_name, fluid);
    return fluid;
  }

  @Override
  public FluidLiquidMetal getFluid(String name)
  {
    return registry.get(name);
  }

  public Map<String,FluidLiquidMetal> getFluids()
  {
    return Collections.unmodifiableMap(registry);
  }

  public Set<String> getFluidNames()
  {
    return Collections.unmodifiableSet(registry.keySet());
  }
}