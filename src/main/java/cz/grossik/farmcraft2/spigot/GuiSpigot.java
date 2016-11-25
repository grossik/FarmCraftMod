package cz.grossik.farmcraft2.spigot;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import cz.grossik.farmcraft2.util.GuiFC;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiSpigot extends GuiFC
{
  private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("farmcraft2:textures/gui/container/spigot.png");

  public static final int TANK_HEIGHT = 47;
  private static final int TANK_X = 39;
  private static final int TANK_Y = 21;
  
  private static final int PROGRESS_X = 60;
  private static final int PROGRESS_Y = 51;
  private static final int PROGRESS_WIDTH = 22;
  private static final int PROGRESS_HEIGHT = 15;
  
  private static final int TANK_OVERLAY_X = 176;
  private static final int TANK_OVERLAY_Y = 0;

  private static final int PROGRESS_OVERLAY_X = 176;
  private static final int PROGRESS_OVERLAY_Y = 53;
  
  private TileEntitySpigot te_spigot;

  public GuiSpigot(TileEntitySpigot te, EntityPlayer player)
  {
    super(new ContainerSpigot(te, player));
    allowUserInput = false;
    ySize = 166;
    te_spigot = te;
  }

  @Override
  protected void drawGuiContainerForegroundLayer(int mouse_x, int mouse_y)
  {
    super.drawGuiContainerForegroundLayer(mouse_x, mouse_y);

    fontRendererObj.drawString("Spigot", this.xSize / 2 - this.fontRendererObj.getStringWidth("Spigot") / 2, 6, 4210752);
    fontRendererObj.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
  }

  @Override
  protected void drawGuiContainerBackgroundLayer(float f, int x, int y)
  {
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    mc.renderEngine.bindTexture(GUI_TEXTURE);
    int window_x = (width - xSize) / 2;
    int window_y = (height - ySize) / 2;
    drawTexturedModalRect(window_x, window_y, 0, 0, xSize, ySize);

    //Draw progress bar.
    int progress = te_spigot.getProgress() * PROGRESS_WIDTH / TileEntitySpigot.CAST_TIME;
    if(progress > 0)
    {
      drawTexturedModalRect(window_x + PROGRESS_X, window_y + PROGRESS_Y, PROGRESS_OVERLAY_X, PROGRESS_OVERLAY_Y, progress, PROGRESS_HEIGHT);
    }

    displayTank(window_x, window_y, TANK_X, TANK_Y, TANK_HEIGHT, TANK_OVERLAY_X, TANK_OVERLAY_Y, te_spigot.getTank(0));
  }

  @Override
  public void drawScreen(int mousex, int mousey, float par3)
  {
    super.drawScreen(mousex, mousey, par3);

    if(isPointInRegion(TANK_X,TANK_Y,16,TANK_HEIGHT,mousex,mousey))
    {
      List<String> currenttip = new ArrayList<String>();
      addTankTooltip(currenttip, mousex, mousey, te_spigot.getTank(0));
      drawHoveringText(currenttip, mousex, mousey, fontRendererObj);
    }
  }
  
  @Override
  protected ResourceLocation getGUITexture()
  {
    return GUI_TEXTURE;
  }

  @Override 
  public void initGui()
  {
    super.initGui();
    int window_x = (width - xSize) / 2;
    int window_y = (height - ySize) / 2;
  }
}