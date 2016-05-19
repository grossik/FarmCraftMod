package cz.grossik.farmcraft2.spigot;

import cz.grossik.farmcraft2.handler.BlockHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

	@SideOnly(Side.CLIENT)
	public class RendererSpigot extends TileEntitySpecialRenderer<TileEntitySpigot>
	{
	    private static final ResourceLocation SIGN_TEXTURE = new ResourceLocation("farmcraft2:textures/entity/spigot.png");
	    private final ModelSpigot model = new ModelSpigot();

	    public void renderTileEntityAt(TileEntitySpigot te, double x, double y, double z, float partialTicks, int destroyStage)
	    {
	        Block block = te.getBlockType();
	        GlStateManager.pushMatrix();
	        float f = 0.6666667F;

	        int i = 0;

	        if (te.hasWorldObj())
	        {
	            i = te.getBlockMetadata();
	        }
	        
	        if (block == BlockHandler.spigot)
	        {
	            GlStateManager.translate((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
	            this.model.pipa.showModel = true;
	            this.model.pipa1.showModel = true;
	            this.model.pipa2.showModel = true;
	            this.model.pipa3.showModel = true;
	            this.model.pipa4.showModel = true;
	            this.model.pipa5.showModel = true;
	            this.model.pipa6.showModel = true;
	            this.model.pipa7.showModel = true;
	            this.model.pipa8.showModel = true;
	            this.model.pipa9.showModel = true;
	            this.model.pipa10.showModel = true;
	        }

	        if (destroyStage >= 0)
	        {
	            this.bindTexture(DESTROY_STAGES[destroyStage]);
	            GlStateManager.matrixMode(5890);
	            GlStateManager.pushMatrix();
	            GlStateManager.scale(1.0F, 1.0F, 1.0F);
	            GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
	            GlStateManager.matrixMode(5888);
	        }
	        else
	        {
	            this.bindTexture(SIGN_TEXTURE);
	        }
	        
	        int j = 0;

	        if (i == 2)
	        {
	            j = 180;
	        }

	        if (i == 3)
	        {
	            j = 0;
	        }

	        if (i == 4)
	        {
	            j = 90;
	        }

	        if (i == 5)
	        {
	            j = -90;
	        }

	        GlStateManager.rotate((float)j, 0.0F, 1.0F, 0.0F);
            
	        GlStateManager.enableRescaleNormal();
	        GlStateManager.pushMatrix();
	        GlStateManager.scale(1.0F, -1.0F, -1.0F);
	        this.model.render();
	        GlStateManager.popMatrix();
	        FontRenderer fontrenderer = this.getFontRenderer();
	        float f3 = 0.015625F * f;
	        GlStateManager.translate(0.0F, 0.5F * f, 0.07F * f);
	        GlStateManager.scale(f3, -f3, f3);
	        GlStateManager.glNormal3f(0.0F, 0.0F, -1.0F * f3);
	        GlStateManager.depthMask(false);
	        GlStateManager.depthMask(true);
	        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	        GlStateManager.popMatrix();

	        if (destroyStage >= 0)
	        {
	            GlStateManager.matrixMode(5890);
	            GlStateManager.popMatrix();
	            GlStateManager.matrixMode(5888);
	        }
	    }
	}