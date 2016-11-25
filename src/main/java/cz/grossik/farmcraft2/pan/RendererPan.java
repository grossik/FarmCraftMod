package cz.grossik.farmcraft2.pan;

import cz.grossik.farmcraft2.Main;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RendererPan extends TileEntitySpecialRenderer<TileEntityPan>
{
	private static final ModelPan model = new ModelPan();
    private static final ResourceLocation tAno = new ResourceLocation(Main.MODID + ":textures/models/neudelana.png");
    private static final ResourceLocation tNe = new ResourceLocation(Main.MODID + ":textures/models/udelana.png");
    private static final ResourceLocation tNic = new ResourceLocation(Main.MODID + ":textures/models/nic.png");

    @Override
    public void renderTileEntityAt(TileEntityPan te, double x, double y, double z, float partialTicks, int destroyStage)
    {	    	  
    	GlStateManager.pushMatrix();
    	GlStateManager.translate(x, y + 0.84375f, z + 0.5f);

        ResourceLocation texture;
            
        if(te.Check() == true)
        {
        	texture = tNe;
        } else if(te.isBurning()){
            texture = tAno;
        } else {
            texture = tNic;
        }
            
        bindTexture(texture);

        model.render();

        GlStateManager.popMatrix();        
    }
}