package cz.grossik.farmcraft2.fermentingbarrel;

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
	public class RendererFermentingBarrel extends TileEntitySpecialRenderer<TileEntityFermentingBarrel>
	{
	    private static final ResourceLocation SIGN_TEXTURE = new ResourceLocation("farmcraft2:textures/entity/fermentingbarrel.png");
	    /** The ModelSign instance for use in this renderer */
	    private final ModelFermentingBarrel model = new ModelFermentingBarrel();

	    public void renderTileEntityAt(TileEntityFermentingBarrel te, double x, double y, double z, float partialTicks, int destroyStage)
	    {
	        Block block = te.getBlockType();
	        GlStateManager.pushMatrix();
	        float f = 0.6666667F;

	        int i = 0;

	        if (te.hasWorldObj())
	        {
	            i = te.getBlockMetadata();
	        }
	        
	        if (block == BlockHandler.FermentingBarrelOff)
	        {
	            GlStateManager.translate((float)x + 0.5F, (float)y + 1.5F * f, (float)z + 0.5F);
	            this.model.Shape1.showModel = true;
	            this.model.Shape2.showModel = true;
	            this.model.Shape3.showModel = true;
	            this.model.Shape4.showModel = true;
	            this.model.Shape5.showModel = true;
	            this.model.Shape6.showModel = true;
	            this.model.Shape7.showModel = true;
	            this.model.Shape8.showModel = true;
	            this.model.Shape9.showModel = true;
	            this.model.Shape10.showModel = true;
	            this.model.Shape11.showModel = true;
	            this.model.Shape12.showModel = true;
	            this.model.Shape13.showModel = true;
	            this.model.Shape14.showModel = true;
	            this.model.Shape15.showModel = true;
	            this.model.Shape16.showModel = true;
	            this.model.Shape17.showModel = true;
	            this.model.Shape18.showModel = true;
	            this.model.Shape19.showModel = true;
	            this.model.Shape20.showModel = true;
	            this.model.Shape21.showModel = true;
	            this.model.Shape22.showModel = true;
	            this.model.Shape23.showModel = true;
	            this.model.Shape24.showModel = true;
	            this.model.Shape25.showModel = true;
	            this.model.Shape26.showModel = true;
	            this.model.Shape27.showModel = true;
	            this.model.Shape28.showModel = true;
	            this.model.Shape29.showModel = true;
	            this.model.Shape30.showModel = true;
	            this.model.Shape31.showModel = true;
	            this.model.Shape32.showModel = true;
	            this.model.Shape33.showModel = true;
	            this.model.Shape34.showModel = true;
	            this.model.Shape35.showModel = true;
	            this.model.Shape36.showModel = true;
	            this.model.Shape37.showModel = true;
	            this.model.Shape38.showModel = true;
	            this.model.Shape39.showModel = true;
	            this.model.Shape40.showModel = true;
	            this.model.Shape41.showModel = true;
	            this.model.Shape42.showModel = true;
	            this.model.Shape43.showModel = true;
	            this.model.Shape44.showModel = true;
	            this.model.Shape45.showModel = true;
	            this.model.Shape46.showModel = true;
	            this.model.Shape47.showModel = true;
	        }

	        if (destroyStage >= 0)
	        {
	            this.bindTexture(DESTROY_STAGES[destroyStage]);
	            GlStateManager.matrixMode(5890);
	            GlStateManager.pushMatrix();
	            GlStateManager.scale(4.0F, 2.0F, 1.0F);
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
	        GlStateManager.scale(f, -f, -f);
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