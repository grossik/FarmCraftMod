package cz.grossik.farmcraft;

import cz.grossik.farmcraft.handler.BlockHandler;
import cz.grossik.farmcraft.handler.ItemHandler;
import cz.grossik.farmcraft.wordgen.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

@Mod(name = "FarmCraft mod", version = FarmCraft.VERSION, useMetadata = false, modid = FarmCraft.MODID)

public class FarmCraft {

    public static final String VERSION = "3.0a";
    public static final String MODID = "cz.grossik.farmcraft";

    @Instance(MODID)
    public static FarmCraft instance;
    @SidedProxy(clientSide = "cz.grossik.farmcraft.FCProxyClient", serverSide = "cz.grossik.farmcraft.FCProxyCommon")
    public static cz.grossik.farmcraft.FCProxyCommon proxy;

    public static CreativeTabs FarmCraftTab = new FarmCraftTab("FarmCraft");

    public static boolean addToVillages;


    public FarmCraft() {

        GameRegistry.registerItem(ItemHandler.TomatoSeeds, "tomatoSeeds");
        GameRegistry.registerItem(ItemHandler.Tomato, "tomato");
        GameRegistry.registerItem(ItemHandler.RadishSeeds, "radihSeeds");
        GameRegistry.registerItem(ItemHandler.Radish, "radish");
        GameRegistry.registerItem(ItemHandler.Broccoli, "broccoli");
        GameRegistry.registerItem(ItemHandler.BroccoliSeeds, "broccoliseeds");
        GameRegistry.registerItem(ItemHandler.BucketCurd, "bucketMilk");
        GameRegistry.registerItem(ItemHandler.CheeseItem, "cheese");
        GameRegistry.registerItem(ItemHandler.ScarecrowItem, "scarecrowI");
        GameRegistry.registerItem(ItemHandler.Pear, "pear");
        GameRegistry.registerItem(ItemHandler.CucumberSeeds, "CucumberSeeds");
        GameRegistry.registerItem(ItemHandler.Cucumber, "Cucumber");
        GameRegistry.registerItem(ItemHandler.RiceSeeds, "RiceSeeds");
        GameRegistry.registerItem(ItemHandler.Rice, "Rice");
        GameRegistry.registerItem(ItemHandler.CapsicumSeeds, "capsicumseeds");
        GameRegistry.registerItem(ItemHandler.Capsicum, "capsicum");
        GameRegistry.registerItem(ItemHandler.Knife, "knife");
        GameRegistry.registerItem(ItemHandler.Glass, "glasses");
        GameRegistry.registerItem(ItemHandler.CabbageSeeds, "CabbageSeeds");
        GameRegistry.registerItem(ItemHandler.Cabbage, "Cabbage");
        GameRegistry.registerItem(ItemHandler.AppleJuice, "applejuice");
        GameRegistry.registerItem(ItemHandler.PearJuice, "pearjuice");
        GameRegistry.registerItem(ItemHandler.CarrotJuice, "carrotjuice");
        GameRegistry.registerItem(ItemHandler.Malt, "malt");
        GameRegistry.registerItem(ItemHandler.StrawberrySeeds, "strawberrySeeds");
        GameRegistry.registerItem(ItemHandler.Strawberry, "strawberry");
        GameRegistry.registerItem(ItemHandler.StrawberryJuice, "strawberryjuice");
        GameRegistry.registerItem(ItemHandler.Cherry, "cherry");
        GameRegistry.registerItem(ItemHandler.CherryJuice, "cherryjuice");
        GameRegistry.registerItem(ItemHandler.slicedCheese, "slicedCheese");
        GameRegistry.registerItem(ItemHandler.ingotCopper, "ingotcopper");
        GameRegistry.registerItem(ItemHandler.HopsSeeds, "hopsseeds");
        GameRegistry.registerItem(ItemHandler.Hops, "hops");
        GameRegistry.registerItem(ItemHandler.BarleySeeds, "barleyseeds");
        GameRegistry.registerItem(ItemHandler.Barley, "barley");
        GameRegistry.registerItem(ItemHandler.SoakedBarley, "soakedbarley");
        GameRegistry.registerItem(ItemHandler.HotWaterBucket, "hotwater");
        GameRegistry.registerItem(ItemHandler.Mash, "mash");
        GameRegistry.registerItem(ItemHandler.Worts, "worts");
        GameRegistry.registerItem(ItemHandler.ColdWorts, "coldworts");
        GameRegistry.registerItem(ItemHandler.Bottle, "bottle");
        GameRegistry.registerItem(ItemHandler.BeerBottle, "bottlebeer");
        GameRegistry.registerItem(ItemHandler.BlueberrySeeds, "blueberrySeeds");
        GameRegistry.registerItem(ItemHandler.Blueberry, "blueberry");
        GameRegistry.registerItem(ItemHandler.Toast, "toast");
        GameRegistry.registerItem(ItemHandler.BakedToast, "bakedtoast");
        GameRegistry.registerItem(ItemHandler.JellyP, "jellyp");
        GameRegistry.registerItem(ItemHandler.PearJam, "pearjam");
        GameRegistry.registerItem(ItemHandler.AppleJam, "applejam");
        GameRegistry.registerItem(ItemHandler.AppleCake, "applecake");
        GameRegistry.registerItem(ItemHandler.AppleSlice, "appleslice");
        GameRegistry.registerItem(ItemHandler.AppleYoghurt, "appleyoghurt");
        GameRegistry.registerItem(ItemHandler.ToastWAJ, "toastwithapplejam");
        GameRegistry.registerItem(ItemHandler.PearSlice, "pearslice");
        GameRegistry.registerItem(ItemHandler.Plum, "plum");
        GameRegistry.registerItem(ItemHandler.PlumJuice, "plumJuice");
        GameRegistry.registerItem(ItemHandler.PlumJam, "plumjam");
        GameRegistry.registerItem(ItemHandler.CherryJam, "cherryjam");
        GameRegistry.registerItem(ItemHandler.ToastWPearJ, "toastwithpearjam");
        GameRegistry.registerItem(ItemHandler.ToastWCherryJ, "toastwithcherryjam");
        GameRegistry.registerItem(ItemHandler.ToastWPlumJ, "toastwithplumjam");
        GameRegistry.registerItem(ItemHandler.PlumSlice, "plumslice");
        GameRegistry.registerItem(ItemHandler.PineappleSeeds, "pineappleSeeds");
        GameRegistry.registerItem(ItemHandler.Pineapple, "pineapple");
        GameRegistry.registerItem(ItemHandler.Salt, "salt");


        GameRegistry.registerBlock(BlockHandler.TomatoBlock, "tomatoblock");
        GameRegistry.registerBlock(BlockHandler.Scarecrow, "scarecrow");
        GameRegistry.registerBlock(BlockHandler.CheeseBlock, "cheeseblock");
        GameRegistry.registerBlock(BlockHandler.RadishBlock, "radishblock");
        GameRegistry.registerBlock(BlockHandler.BroccoliBlock, "broccoliblock");
        GameRegistry.registerBlock(BlockHandler.CucumberBlock, "cucumberblock");
        GameRegistry.registerBlock(BlockHandler.RiceBlock, "riceblock");
        GameRegistry.registerBlock(BlockHandler.CapsicumBlock, "capsicumblock");
        GameRegistry.registerBlock(BlockHandler.CabbageBlock, "cabbageblock");
        GameRegistry.registerBlock(BlockHandler.StrawberryBlock, "strawberryblock");
        GameRegistry.registerBlock(BlockHandler.HopsBlock, "hopsblock");
        GameRegistry.registerBlock(BlockHandler.BarleyBlock, "barleyblock");
        GameRegistry.registerBlock(BlockHandler.BlueberryBlock, "blueberryblock");
        GameRegistry.registerBlock(BlockHandler.PineappleBlock, "pineappleblock");
        GameRegistry.registerBlock(BlockHandler.OreCopper, "oreCopper");
        GameRegistry.registerBlock(BlockHandler.BlockCopper, "blockCopper");
        GameRegistry.registerBlock(BlockHandler.leavesPearNormal, "leavesPN");
        GameRegistry.registerBlock(BlockHandler.leavesPearSH, "leavespearplne");
        GameRegistry.registerBlock(BlockHandler.SaplingPear, "saplingPear");
        GameRegistry.registerBlock(BlockHandler.leavesCherryNormal, "leavesCH");
        GameRegistry.registerBlock(BlockHandler.leavesCherryST, "leavescherryplne");
        GameRegistry.registerBlock(BlockHandler.SaplingCherry, "saplingCherry");
        GameRegistry.registerBlock(BlockHandler.AppleCakeBlock, "applecakeB");
        GameRegistry.registerBlock(BlockHandler.leavesPlumNormal, "leavesPL");
        GameRegistry.registerBlock(BlockHandler.leavesPlumSS, "leavesplumplne");
        GameRegistry.registerBlock(BlockHandler.SaplingPlum, "saplingPlum");
        GameRegistry.registerBlock(BlockHandler.juicerOff, "juiceroff");
        GameRegistry.registerBlock(BlockHandler.juicerOn, "juiceron");
        GameRegistry.registerBlock(BlockHandler.MashTunOff, "mashtunoff");
        GameRegistry.registerBlock(BlockHandler.MashTunOn, "mashtunon");
        GameRegistry.registerBlock(BlockHandler.BoilingOff, "boilingoff");
        GameRegistry.registerBlock(BlockHandler.BoilingOn, "boilingon");
        GameRegistry.registerBlock(BlockHandler.BottlingOff, "bottlingoff");
        GameRegistry.registerBlock(BlockHandler.BottlingOn, "bottlingon");


        GameRegistry.addRecipe(new ItemStack(ItemHandler.CheeseItem, 1), new Object[]{"BA", "AA", 'A', ItemHandler.BucketCurd, 'B', ItemHandler.Salt});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.ScarecrowItem, 1), new Object[]{" U ", "AXA", " A ", 'A', Items.stick, 'X', Items.wheat, 'U', Blocks.pumpkin});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.TomatoSeeds, 1), new Object[]{"X", 'X', ItemHandler.Tomato});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.RadishSeeds, 1), new Object[]{"X", 'X', ItemHandler.Radish});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.BroccoliSeeds, 1), new Object[]{"X", 'X', ItemHandler.Broccoli});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.CucumberSeeds, 1), new Object[]{"X", 'X', ItemHandler.Cucumber});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.RiceSeeds, 1), new Object[]{"X", 'X', ItemHandler.Rice});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.CapsicumSeeds, 1), new Object[]{"X", 'X', ItemHandler.Capsicum});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.Knife, 1), new Object[]{"AAX", 'A', Items.iron_ingot, 'X', Items.stick});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.Glass, 1), new Object[]{"X X", "XXX", 'X', Blocks.glass_pane});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.juicerOff, 1), new Object[]{"XXX", "XAX", "XYX", 'A', Items.flint, 'X', Blocks.cobblestone, 'Y', Items.redstone});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.StrawberrySeeds, 1), new Object[]{"X", 'X', ItemHandler.Strawberry});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.SaplingPear, 1), new Object[]{"HS", 'H', ItemHandler.Pear, 'S', new ItemStack(Blocks.sapling, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.SaplingCherry, 1), new Object[]{"TS", 'T', ItemHandler.Cherry, 'S', new ItemStack(Blocks.sapling, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.slicedCheese, 6), new Object[]{"XA", 'X', ItemHandler.CheeseItem, 'A', ItemHandler.Knife});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.BlockCopper, 1), new Object[]{"XXX", "XXX", "XXX", 'X', ItemHandler.ingotCopper});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.SoakedBarley, 8), new Object[]{"XXX", "XYX", "XXX", 'X', ItemHandler.Barley, 'Y', Items.water_bucket});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.MashTunOff, 1), new Object[]{"XXX", "XYX", "XXX", 'X', Items.iron_ingot, 'Y', ItemHandler.Malt});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.BoilingOff, 1), new Object[]{"XXX", "XYX", "XXX", 'X', ItemHandler.ingotCopper, 'Y', ItemHandler.Hops});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.Bottle, 8), new Object[]{"X X", "XYX", "XXX", 'X', Blocks.glass, 'Y', ItemHandler.Hops});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.BlueberrySeeds, 1), new Object[]{"X", 'X', ItemHandler.Blueberry});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.BottlingOff, 1), new Object[]{"PPP", "P#P", "PXP", 'P', Items.iron_ingot, '#', Blocks.lever, 'X', ItemHandler.Bottle});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.ColdWorts, 1), new Object[]{"X", 'X', ItemHandler.Worts});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.Toast, 8), new Object[]{"YX", 'Y', ItemHandler.Knife, 'X', Items.bread});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.JellyP, 1), new Object[]{"X", 'X', Items.sugar});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.PearJam, 1), new Object[]{"YX", 'Y', ItemHandler.JellyP, 'X', ItemHandler.Pear});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.AppleJam, 1), new Object[]{"YX", 'Y', ItemHandler.JellyP, 'X', Items.apple});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.AppleCake, 1), new Object[]{" E ", "BAB", "CCC", 'A', Items.milk_bucket, 'B', Items.sugar, 'C', Items.wheat, 'E', ItemHandler.AppleJam});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.AppleSlice, 8), new Object[]{"YX", 'Y', ItemHandler.Knife, 'X', Items.apple});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.PearSlice, 8), new Object[]{"YX", 'Y', ItemHandler.Knife, 'X', ItemHandler.Pear});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.AppleYoghurt, 1), new Object[]{"E", "E", "C", 'C', Items.milk_bucket, 'E', ItemHandler.AppleSlice});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.ToastWAJ, 1), new Object[]{"E", "C", 'C', ItemHandler.BakedToast, 'E', ItemHandler.AppleJam});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.PlumJam, 1), new Object[]{"YX", 'Y', ItemHandler.JellyP, 'X', ItemHandler.Plum});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.CherryJam, 1), new Object[]{"YX", 'Y', ItemHandler.JellyP, 'X', ItemHandler.Cherry});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.ToastWPearJ, 1), new Object[]{"E", "C", 'C', ItemHandler.BakedToast, 'E', ItemHandler.PearJam});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.ToastWCherryJ, 1), new Object[]{"E", "C", 'C', ItemHandler.BakedToast, 'E', ItemHandler.CherryJam});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.ToastWPlumJ, 1), new Object[]{"E", "C", 'C', ItemHandler.BakedToast, 'E', ItemHandler.PlumJam});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.PlumSlice, 8), new Object[]{"YX", 'Y', ItemHandler.Knife, 'X', ItemHandler.Plum});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.PineappleSeeds, 1), new Object[]{"X", 'X', ItemHandler.Pineapple});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.SaplingPlum, 1), new Object[]{"TS", 'T', ItemHandler.Plum, 'S', new ItemStack(Blocks.sapling, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.HopsSeeds, 1), new Object[]{"X", 'X', ItemHandler.Hops});


        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.TomatoSeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.RadishSeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.BroccoliSeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.CucumberSeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.RiceSeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.CapsicumSeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.CabbageSeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.StrawberrySeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.HopsSeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.BarleySeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.BlueberrySeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.PineappleSeeds), 10);
    }

    @EventHandler
    public static void PreLoad(FMLPreInitializationEvent PreEvent) {
        proxy.registerTileEntities();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.registerRenderer();

        GameRegistry.registerWorldGenerator(new WordGen(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenTree(), 0);
        MinecraftForge.EVENT_BUS.register(new EventClass());
        NetworkRegistry.INSTANCE.registerGuiHandler(FarmCraft.instance, new FC_GuiHandler());

        Configuration config = new Configuration(event.getSuggestedConfigurationFile());

        config.load();

        BlockHandler.configureBlockIDs(config);
        ItemHandler.configureItemIDs(config);

        config.save();

        if (FarmCraft.addToVillages) {
            // adds to the villager spawner egg
            VillagerRegistry.instance().registerVillagerId(69699);
            // moved down, not needed if 'addToVillages' is false
            VillagerRegistry.instance().registerVillageTradeHandler(69699, new FCVillageTrades());

        }
        VillagerRegistry.instance().registerVillageCreationHandler(new VillagePoleHandler());
        MapGenStructureIO.func_143031_a(Village_Pole.class, "PoleStructure");

        VillagerRegistry.instance().registerVillageCreationHandler(new VillageBarakHandler());
        MapGenStructureIO.func_143031_a(Village_Barak.class, "BarakStructure");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }
}
