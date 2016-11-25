package cz.grossik.farmcraft2.treetap;

import cz.grossik.farmcraft2.util.GuiFC;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiTreetap extends GuiContainer {

    private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("farmcraft2:textures/gui/container/treetap.png");
    private final InventoryPlayer playerInventory;
    private IInventory tileFurnace;
    private TileEntityTreetap treetap;

    public GuiTreetap(InventoryPlayer playerInv, TileEntityTreetap furnaceInv)
    {
        super(new ContainerTreetap(playerInv, furnaceInv));
        this.playerInventory = playerInv;
        this.tileFurnace = furnaceInv;
        this.treetap = furnaceInv;
    }

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = this.tileFurnace.getDisplayName().getUnformattedText();
        String k = pocetSirupu();

        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);        
   
        this.fontRendererObj.drawString(k, 124, this.ySize - 96 + 2, 4210752);
    }
    
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
    }
    
    private String pocetSirupu() {
    	int k = this.tileFurnace.getField(0);
    	
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(k + " mB");
        
        return sb.toString();
    }
}
