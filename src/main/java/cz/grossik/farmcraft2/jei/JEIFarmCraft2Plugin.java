package cz.grossik.farmcraft2.jei;

import javax.annotation.Nonnull;

import cz.grossik.farmcraft2.boiling.ContainerBoiling;
import cz.grossik.farmcraft2.bottling.ContainerBottling;
import cz.grossik.farmcraft2.crushing.ContainerCrushing;
import cz.grossik.farmcraft2.fermentingbarrel.ContainerFermentingBarrel;
import cz.grossik.farmcraft2.handler.BlockHandler;
import cz.grossik.farmcraft2.handler.ItemHandler;
import cz.grossik.farmcraft2.jei.boiling.BoilingRecipeCategory;
import cz.grossik.farmcraft2.jei.boiling.BoilingRecipeHandler;
import cz.grossik.farmcraft2.jei.boiling.BoilingRecipeMaker;
import cz.grossik.farmcraft2.jei.boiling.BoilingSmeltingCategory;
import cz.grossik.farmcraft2.jei.crushing.CrushingRecipeCategory;
import cz.grossik.farmcraft2.jei.crushing.CrushingRecipeHandler;
import cz.grossik.farmcraft2.jei.crushing.CrushingRecipeMaker;
import cz.grossik.farmcraft2.jei.crushing.CrushingSmeltingCategory;
import cz.grossik.farmcraft2.jei.fermentingbarrel.FermentingBarrelRecipeCategory;
import cz.grossik.farmcraft2.jei.fermentingbarrel.FermentingBarrelRecipeHandler;
import cz.grossik.farmcraft2.jei.fermentingbarrel.FermentingBarrelRecipeMaker;
import cz.grossik.farmcraft2.jei.fermentingbarrel.FermentingBarrelSmeltingCategory;
import cz.grossik.farmcraft2.jei.juicer.JuicerRecipeCategory;
import cz.grossik.farmcraft2.jei.juicer.JuicerRecipeHandler;
import cz.grossik.farmcraft2.jei.juicer.JuicerRecipeMaker;
import cz.grossik.farmcraft2.jei.juicer.JuicerSmeltingCategory;
import cz.grossik.farmcraft2.jei.mashtun.MashTunRecipeCategory;
import cz.grossik.farmcraft2.jei.mashtun.MashTunRecipeHandler;
import cz.grossik.farmcraft2.jei.mashtun.MashTunRecipeMaker;
import cz.grossik.farmcraft2.jei.mashtun.MashTunSmeltingCategory;
import cz.grossik.farmcraft2.juicer.ContainerJuicer;
import cz.grossik.farmcraft2.mashtun.ContainerMashTun;
import cz.grossik.farmcraft2.spigot.ContainerSpigot;
import cz.grossik.farmcraft2.treetap.ContainerTreetap;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IJeiRuntime;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class JEIFarmCraft2Plugin implements IModPlugin
{
  private static IJeiRuntime jeiRuntime = null;

  @Override
  public void register(IModRegistry registry)
  {
    IJeiHelpers helpers = registry.getJeiHelpers();
	IGuiHelper guiHelper = helpers.getGuiHelper();
    registry.addRecipeCategories(
        new BottlingJEI.Category(helpers),
        new SpigotJEI.Category(helpers),
        new JuicerSmeltingCategory(guiHelper),
        new BoilingSmeltingCategory(guiHelper),
        new CrushingSmeltingCategory(guiHelper),
        new MashTunSmeltingCategory(guiHelper),
        new FermentingBarrelSmeltingCategory(helpers),
        new TreetapJEI.Category(helpers),
        new PanJEI.Category(helpers)
    );

    registry.addRecipeHandlers(
        new BottlingJEI.Handler(),
        new SpigotJEI.Handler(),
        new JuicerRecipeHandler(),
        new BoilingRecipeHandler(),
        new CrushingRecipeHandler(),
        new MashTunRecipeHandler(),
        new FermentingBarrelRecipeHandler(),
        new TreetapJEI.Handler(),
        new PanJEI.Handler()
    );
    IRecipeTransferRegistry transfer_registry = registry.getRecipeTransferRegistry();

    transfer_registry.addRecipeTransferHandler(ContainerBottling.class, "Bottling",
        ContainerBottling.SLOTS_TE,
        ContainerBottling.SLOTS_TE_SIZE, 
        ContainerBottling.SLOTS_INVENTORY, 36);
    transfer_registry.addRecipeTransferHandler(ContainerSpigot.class, "Spigot",
        ContainerSpigot.SLOTS_TE,
        ContainerSpigot.SLOTS_TE_SIZE, 
        ContainerSpigot.SLOTS_INVENTORY, 36);
    transfer_registry.addRecipeTransferHandler(ContainerJuicer.class, "Juicer", 0, 1, 3, 36);
    transfer_registry.addRecipeTransferHandler(ContainerBoiling.class, "Boiling", 0, 1, 3, 36);
    transfer_registry.addRecipeTransferHandler(ContainerCrushing.class, "Crushing", 0, 1, 3, 36);
    transfer_registry.addRecipeTransferHandler(ContainerMashTun.class, "Mash Tun", 0, 1, 3, 36);
    transfer_registry.addRecipeTransferHandler(ContainerFermentingBarrel.class, "Fermenting Barrel", 0, 1, 3, 36);
    transfer_registry.addRecipeTransferHandler(ContainerTreetap.class, "Treetap", 0, 1, 3, 36);

    registry.addRecipeCategoryCraftingItem(new ItemStack(BlockHandler.juicerOff), "juiceroff");
    registry.addRecipeCategoryCraftingItem(new ItemStack(BlockHandler.spigot), "spigot");
    registry.addRecipeCategoryCraftingItem(new ItemStack(BlockHandler.BottlingOff), "bottlingoff");
    registry.addRecipeCategoryCraftingItem(new ItemStack(BlockHandler.BoilingOff), "boilingoff");
    registry.addRecipeCategoryCraftingItem(new ItemStack(BlockHandler.CrushingOff), "crushingoff");
    registry.addRecipeCategoryCraftingItem(new ItemStack(BlockHandler.MashTunOff), "mashtunoff");
    registry.addRecipeCategoryCraftingItem(new ItemStack(BlockHandler.FermentingBarrelOff), "fermentingbarreloff");
    registry.addRecipeCategoryCraftingItem(new ItemStack(ItemHandler.ITreetap), "treetap");
    registry.addRecipeCategoryCraftingItem(new ItemStack(BlockHandler.Pan), "pan");

    registry.addRecipes(BottlingJEI.getRecipes(helpers));
    registry.addRecipes(SpigotJEI.getRecipes());
    registry.addRecipes(TreetapJEI.getRecipes(helpers));
    registry.addRecipes(PanJEI.getRecipes(helpers));
    registry.addRecipes(JuicerRecipeMaker.getFurnaceRecipes(helpers));
    registry.addRecipes(BoilingRecipeMaker.getFurnaceRecipes(helpers));
    registry.addRecipes(CrushingRecipeMaker.getFurnaceRecipes(helpers));
    registry.addRecipes(MashTunRecipeMaker.getFurnaceRecipes(helpers));
    registry.addRecipes(FermentingBarrelRecipeMaker.getFurnaceRecipes(helpers));
    
    CrushingRecipeCategory.register(registry, guiHelper);
    BottlingJEI.Category.register(registry, guiHelper);
    SpigotJEI.Category.register(registry, guiHelper);
    TreetapJEI.Category.register(registry, guiHelper);
    BoilingRecipeCategory.register(registry, guiHelper);
    FermentingBarrelRecipeCategory.register(registry, guiHelper);
    JuicerRecipeCategory.register(registry, guiHelper);
    MashTunRecipeCategory.register(registry, guiHelper);
  }

  @Override
  public void onRuntimeAvailable(@Nonnull IJeiRuntime jeiRuntime) {
    JEIFarmCraft2Plugin.jeiRuntime = jeiRuntime;
    JeiAccessor.jeiRuntimeAvailable = true;
  }

  public static void setFilterText(@Nonnull String filterText) {
    jeiRuntime.getItemListOverlay().setFilterText(filterText);
  }

  public static @Nonnull String getFilterText() {
    return jeiRuntime.getItemListOverlay().getFilterText();
  }
}