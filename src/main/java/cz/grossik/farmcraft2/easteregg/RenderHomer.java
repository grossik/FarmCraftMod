package cz.grossik.farmcraft2.easteregg;

import cz.grossik.farmcraft2.Main;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import java.awt.*;

@SideOnly(Side.CLIENT)
public class RenderHomer extends RenderBiped<EntityHomer>
{
	private static final ResourceLocation jayTexture = new ResourceLocation(Main.MODID + ":textures/entity/homer.png");

	public RenderHomer(RenderManager rendermanager)
	{
        super(rendermanager, new ModelPlayer(0.5F, false), 0.5F);
	}

    @Override
    protected ResourceLocation getEntityTexture(EntityHomer entity)
    {
    	return jayTexture;
    }
}