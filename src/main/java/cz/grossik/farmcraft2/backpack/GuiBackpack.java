package cz.grossik.farmcraft2.backpack;

import cz.grossik.farmcraft2.Main;
import cz.grossik.farmcraft2.event.FC2VersionEvent.Color;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class GuiBackpack extends GuiContainer
{
    private static final ResourceLocation CHEST_GUI_TEXTURE = new ResourceLocation("farmcraft2:textures/gui/container/backpack.png");

    protected InventoryPlayer player;

    final boolean isPrivate;

    public GuiBackpack(InventoryPlayer playerInventory, int id, EntityPlayer player, World world, BlockPos pos)
    {
        super(new ContainerBackpack(playerInventory, id, player, world, pos));

        isPrivate = (id & 1) != 0;

        this.player = playerInventory;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1, 1, 1, 1);
        this.mc.getTextureManager().bindTexture(CHEST_GUI_TEXTURE);

        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, 3 * 18 + 17);
        this.drawTexturedModalRect(guiLeft, guiTop + 3 * 18 + 17, 0, 126, xSize, 96);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        this.fontRendererObj.drawString(I18n.translateToLocal(Color.GOLD + "Backpack"), 8, 6, 4210752);
        this.fontRendererObj.drawString(Color.GOLD + this.player.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }
}