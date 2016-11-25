package cz.grossik.farmcraft2.combine;

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
public class RenderCombine extends RenderLiving<EntityCombine>
{
	private static final ResourceLocation jayTexture = new ResourceLocation(Main.MODID + ":textures/entity/kombajn.png");

	public RenderCombine(RenderManager rendermanager)
	{
        super(rendermanager, new ModelCombine(), 0.5F);
	}

    public ModelCombine getMainModel()
    {
        return (ModelCombine) super.getMainModel();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityCombine entity)
    {
    	return jayTexture;
    }

    @Override
    protected void preRenderCallback(EntityCombine entitylivingbaseIn, float partialTickTime)
    {
        GlStateManager.translate(-1.45F, 2.5F, 0.0F);
        GlStateManager.scale(5.0F, 4.0F, 5.0F);
    }
}