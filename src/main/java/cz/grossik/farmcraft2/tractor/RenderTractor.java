package cz.grossik.farmcraft2.tractor;

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
public class RenderTractor extends RenderLiving<EntityTractor>
{
	private static final ResourceLocation Texture = new ResourceLocation(Main.MODID + ":textures/entity/tractor.png");

	public RenderTractor(RenderManager rendermanager)
	{
        super(rendermanager, new ModelTractor(), 0.5F);
	}

    public ModelTractor getMainModel()
    {
        return (ModelTractor) super.getMainModel();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityTractor entity)
    {
    	return Texture;
    }

    @Override
    protected void preRenderCallback(EntityTractor entitylivingbaseIn, float partialTickTime)
    {
        GlStateManager.translate(-1.40F, 1.6F, -1.45F);
        GlStateManager.scale(4.0F, 3.0F, 3.0F);
    }
}