package cz.grossik.farmcraft2.fluid;

import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidFC2 extends Fluid
{
  public final Material material;
  
  public FluidFC2(Material material,String fluidName, ResourceLocation still, ResourceLocation flowing, int temperature, int luminosity)
  {
    super(fluidName, still, flowing);
    this.material = material;
    setUnlocalizedName(fluidName);
    setTemperature(temperature);
    setLuminosity(luminosity);
  }
}