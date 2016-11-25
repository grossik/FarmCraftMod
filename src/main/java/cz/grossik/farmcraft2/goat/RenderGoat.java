package cz.grossik.farmcraft2.goat;

import cz.grossik.farmcraft2.Main;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGoat extends RenderLiving<EntityGoat>
{
	private static final ResourceLocation jayTexture = new ResourceLocation(Main.MODID + ":textures/entity/goat.png");
	
	public RenderGoat(RenderManager rendermanager)
	{
        super(rendermanager, new ModelGoat(), 0.5F);
	}

    public ModelGoat getMainModel()
    {
        return (ModelGoat) super.getMainModel();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGoat entity)
    {
    	return jayTexture;
    }

    @Override
    protected void preRenderCallback(EntityGoat entitylivingbaseIn, float partialTickTime)
    {
        float f = 0.9375F;

        if (entitylivingbaseIn.getGrowingAge() < 0)
        {
            f = (float)((double)f * 0.5D);
            this.shadowSize = 0.25F;
        }
        else
        {
            this.shadowSize = 0.5F;
        }
        
        GlStateManager.rotate(-90, 0.0F, 1.0F, 0.0F);
        
        GlStateManager.scale(f, f, f);
    }
}