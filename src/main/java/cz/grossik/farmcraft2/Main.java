package cz.grossik.farmcraft2;

import cz.grossik.farmcraft2.bottling.BottlingRecipeManager;
import cz.grossik.farmcraft2.bottling.ItemStackMatcher;
import cz.grossik.farmcraft2.handler.BlockHandler;
import cz.grossik.farmcraft2.handler.FC2_GuiHandler;
import cz.grossik.farmcraft2.handler.ItemHandler;
import cz.grossik.farmcraft2.wordgen.WordGen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

@Mod(modid = Main.MODID, version = Main.VERSION, name = "FarmCraft 2")
public class Main
{
    public static final String MODID = "farmcraft2";
    public static final String VERSION = "1.0";
    
    @Instance(MODID)
    public static Main instance;
    @SidedProxy(clientSide = "cz.grossik.farmcraft2.ProxyClient", serverSide = "cz.grossik.farmcraft2.ProxyCommon")
    public static cz.grossik.farmcraft2.ProxyCommon proxy;
    
    public static CreativeTabs FarmCraft2Tab = new FarmCraft2Tab("FarmCraft 2");
    
    public static BiomeGenBase FC2TreeBiome = new BiomeGenFC2Tree(false, (new BiomeGenBase.BiomeProperties("Fruit Biome")).setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(0.8F).setRainfall(0.4F));
    
    public Main()
    {
    	//Register Block
    	GameRegistry.registerBlock(BlockHandler.Corn, "cornblock");
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
        GameRegistry.registerBlock(BlockHandler.OreCopper, "orecopper");
        GameRegistry.registerBlock(BlockHandler.BlockCopper, "blockcopper");
        GameRegistry.registerBlock(BlockHandler.leavesPearNormal, "leavespn");
        GameRegistry.registerBlock(BlockHandler.leavesPearSH, "leavespearplne");
        GameRegistry.registerBlock(BlockHandler.SaplingPear, "saplingPear");
        GameRegistry.registerBlock(BlockHandler.leavesCherryNormal, "leavesCH");
        GameRegistry.registerBlock(BlockHandler.leavesCherryST, "leavescherryplne");
        GameRegistry.registerBlock(BlockHandler.SaplingCherry, "saplingCherry");
        GameRegistry.registerBlock(BlockHandler.AppleCakeBlock, "applecakeblock");
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
        GameRegistry.registerBlock(BlockHandler.WineBlock, "grapeblock");
        GameRegistry.registerBlock(BlockHandler.CrushingOff, "crushingOff");
        GameRegistry.registerBlock(BlockHandler.CrushingOn, "crushingOn");
        GameRegistry.registerBlock(BlockHandler.FermentingBarrelOff, "fermentingbarelloff");
        GameRegistry.registerBlock(BlockHandler.FermentingBarrelOn, "fermentingbarellon");
        
    	//Register Item
    	GameRegistry.registerItem(ItemHandler.Corn_flakes, "Corn_flakes");
       	GameRegistry.registerItem(ItemHandler.Corn_Seed, "Corn_Seed");
    	GameRegistry.registerItem(ItemHandler.Corn_Item, "Corn_Item"); 	
        GameRegistry.registerItem(ItemHandler.TomatoSeeds, "tomatoseeds");
        GameRegistry.registerItem(ItemHandler.Tomato, "tomato");
        GameRegistry.registerItem(ItemHandler.RadishSeeds, "radishseeds");
        GameRegistry.registerItem(ItemHandler.Radish, "radish");
        GameRegistry.registerItem(ItemHandler.Broccoli, "broccoli");
        GameRegistry.registerItem(ItemHandler.BroccoliSeeds, "broccoliseeds");
        GameRegistry.registerItem(ItemHandler.BucketCurd, "curd");
        GameRegistry.registerItem(ItemHandler.CheeseItem, "cheese");
        GameRegistry.registerItem(ItemHandler.ScarecrowItem, "scarecrow_item");
        GameRegistry.registerItem(ItemHandler.Pear, "pear");
        GameRegistry.registerItem(ItemHandler.CucumberSeeds, "cucumberseeds");
        GameRegistry.registerItem(ItemHandler.Cucumber, "cucumber");
        GameRegistry.registerItem(ItemHandler.RiceSeeds, "riceseeds");
        GameRegistry.registerItem(ItemHandler.Rice, "rice");
        GameRegistry.registerItem(ItemHandler.CapsicumSeeds, "capsicumseeds");
        GameRegistry.registerItem(ItemHandler.Capsicum, "capsicum");
        GameRegistry.registerItem(ItemHandler.Knife, "knife");
        GameRegistry.registerItem(ItemHandler.GlassFJ, "glass");
        GameRegistry.registerItem(ItemHandler.CabbageSeeds, "cabbageseeds");
        GameRegistry.registerItem(ItemHandler.Cabbage, "cabbage");
        GameRegistry.registerItem(ItemHandler.AppleJuice, "applejuice");
        GameRegistry.registerItem(ItemHandler.PearJuice, "pearjuice");
        GameRegistry.registerItem(ItemHandler.CarrotJuice, "carrotjuice");
        GameRegistry.registerItem(ItemHandler.Malt, "malt");
        GameRegistry.registerItem(ItemHandler.StrawberrySeeds, "strawberryseeds");
        GameRegistry.registerItem(ItemHandler.Strawberry, "strawberry");
        GameRegistry.registerItem(ItemHandler.StrawberryJuice, "strawberryjuice");
        GameRegistry.registerItem(ItemHandler.Cherry, "cherry");
        GameRegistry.registerItem(ItemHandler.CherryJuice, "cherryjuice");
        GameRegistry.registerItem(ItemHandler.slicedCheese, "slicedcheese");
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
        GameRegistry.registerItem(ItemHandler.BeerBottle, "beerbottle");
        GameRegistry.registerItem(ItemHandler.BlueberrySeeds, "blueberryseeds");
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
        GameRegistry.registerItem(ItemHandler.PlumJuice, "plumjuice");
        GameRegistry.registerItem(ItemHandler.PlumJam, "plumjam");
        GameRegistry.registerItem(ItemHandler.CherryJam, "cherryjam");
        GameRegistry.registerItem(ItemHandler.ToastWPearJ, "toastwithpearjam");
        GameRegistry.registerItem(ItemHandler.ToastWCherryJ, "toastwithcherryjam");
        GameRegistry.registerItem(ItemHandler.ToastWPlumJ, "toastwithplumjam");
        GameRegistry.registerItem(ItemHandler.PlumSlice, "plumslice");
        GameRegistry.registerItem(ItemHandler.PineappleSeeds, "pineappleseeds");
        GameRegistry.registerItem(ItemHandler.Pineapple, "pineapple");
        GameRegistry.registerItem(ItemHandler.Salt, "salt");
        GameRegistry.registerItem(ItemHandler.BeerBucket, "hotbeer");
        GameRegistry.registerItem(ItemHandler.PineappleJuice, "pineapplejuice");
        GameRegistry.registerItem(ItemHandler.Wine, "grape");
        GameRegistry.registerItem(ItemHandler.WineSeeds, "grapeseeds");
        //GameRegistry.registerItem(ItemHandler.backpack, "backpack");
        GameRegistry.registerItem(ItemHandler.GlassFW, "glassfw");
        GameRegistry.registerItem(ItemHandler.GlassSW, "glasssw");
        GameRegistry.registerItem(ItemHandler.WineBucket, "winebucket");
        GameRegistry.registerItem(ItemHandler.FermentedWine, "fermentedwine");
        GameRegistry.registerItem(ItemHandler.BottleFW, "bottlefw");
        GameRegistry.registerItem(ItemHandler.BottleSW, "bottlesw");
        GameRegistry.registerItem(ItemHandler.KegForBeer, "kegforbeer");
        GameRegistry.registerItem(ItemHandler.KegOfBeer, "kegofbeer");

        //Smelting
    	GameRegistry.addSmelting(Items.milk_bucket, new ItemStack(ItemHandler.BucketCurd, 1), 2);
    	GameRegistry.addSmelting(BlockHandler.OreCopper, new ItemStack(ItemHandler.ingotCopper, 1), 7);
    	GameRegistry.addSmelting(ItemHandler.SoakedBarley, new ItemStack(ItemHandler.Malt, 1), 4);
    	GameRegistry.addSmelting(Items.water_bucket, new ItemStack(ItemHandler.HotWaterBucket, 1), 2);
    	GameRegistry.addSmelting(ItemHandler.Toast, new ItemStack(ItemHandler.BakedToast, 1), 2);
    	GameRegistry.addSmelting(ItemHandler.HotWaterBucket, new ItemStack(ItemHandler.Salt, 3), 1);

        //Recepty
        GameRegistry.addRecipe(new ItemStack(ItemHandler.ScarecrowItem, 1), new Object[]{" U ", "AXA", " A ", 'A', Items.stick, 'X', Items.wheat, 'U', Blocks.pumpkin});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.TomatoSeeds, 1), new Object[]{"X", 'X', ItemHandler.Tomato});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.RadishSeeds, 1), new Object[]{"X", 'X', ItemHandler.Radish});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.BroccoliSeeds, 1), new Object[]{"X", 'X', ItemHandler.Broccoli});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.CucumberSeeds, 1), new Object[]{"X", 'X', ItemHandler.Cucumber});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.RiceSeeds, 1), new Object[]{"X", 'X', ItemHandler.Rice});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.CapsicumSeeds, 1), new Object[]{"X", 'X', ItemHandler.Capsicum});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.Knife, 1), new Object[]{"AAX", 'A', Items.iron_ingot, 'X', Items.stick});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.GlassFJ, 1), new Object[]{"X X", "XXX", 'X', Blocks.glass_pane});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.juicerOff, 1), new Object[]{"XXX", "XAX", "XYX", 'A', Items.flint, 'X', Blocks.cobblestone, 'Y', Items.redstone});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.StrawberrySeeds, 1), new Object[]{"X", 'X', ItemHandler.Strawberry});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.SaplingPear, 1), new Object[]{"HS", 'H', ItemHandler.Pear, 'S', new ItemStack(Blocks.sapling, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.SaplingCherry, 1), new Object[]{"TS", 'T', ItemHandler.Cherry, 'S', new ItemStack(Blocks.sapling, 1, 0)});
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockHandler.BlockCopper, 1), new Object[]{"XXX", "XXX", "XXX", 'X', "ingotCopper"}));
        GameRegistry.addRecipe(new ItemStack(ItemHandler.SoakedBarley, 8), new Object[]{"XXX", "XYX", "XXX", 'X', ItemHandler.Barley, 'Y', Items.water_bucket});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.MashTunOff, 1), new Object[]{"XXX", "XYX", "XXX", 'X', Items.iron_ingot, 'Y', ItemHandler.Malt});
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockHandler.BoilingOff, 1), new Object[]{"XXX", "XYX", "XXX", 'X', "ingotCopper", 'Y', ItemHandler.Hops}));
        GameRegistry.addRecipe(new ItemStack(ItemHandler.Bottle, 8), new Object[]{"X X", "XYX", "XXX", 'X', Blocks.glass, 'Y', ItemHandler.Hops});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.BlueberrySeeds, 1), new Object[]{"X", 'X', ItemHandler.Blueberry});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.BottlingOff, 1), new Object[]{"PPP", "P#P", "PXP", 'P', Items.iron_ingot, '#', Blocks.lever, 'X', ItemHandler.Bottle});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.ColdWorts, 1), new Object[]{"X", 'X', ItemHandler.Worts});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.JellyP, 1), new Object[]{"X", 'X', Items.sugar});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.PearJam, 1), new Object[]{"YX", 'Y', ItemHandler.JellyP, 'X', ItemHandler.Pear});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.AppleJam, 1), new Object[]{"YX", 'Y', ItemHandler.JellyP, 'X', Items.apple});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.AppleCake, 1), new Object[]{" E ", "BAB", "CCC", 'A', Items.milk_bucket, 'B', Items.sugar, 'C', Items.wheat, 'E', ItemHandler.AppleJam});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.AppleYoghurt, 1), new Object[]{" E ", " E ", " C ", 'C', Items.milk_bucket, 'E', ItemHandler.AppleSlice});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.PlumJam, 1), new Object[]{"YX", 'Y', ItemHandler.JellyP, 'X', ItemHandler.Plum});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.CherryJam, 1), new Object[]{"YX", 'Y', ItemHandler.JellyP, 'X', ItemHandler.Cherry});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.PineappleSeeds, 1), new Object[]{"X", 'X', ItemHandler.Pineapple});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.SaplingPlum, 1), new Object[]{"TS", 'T', ItemHandler.Plum, 'S', new ItemStack(Blocks.sapling, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.HopsSeeds, 1), new Object[]{"X", 'X', ItemHandler.Hops});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.CabbageSeeds, 1), new Object[]{"X", 'X', ItemHandler.Cabbage});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.BarleySeeds, 1), new Object[]{"X", 'X', ItemHandler.Barley});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.ingotCopper, 9), new Object[]{"X", 'X', BlockHandler.BlockCopper});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.backpack, 1), new Object[]{"TTT", "TST", "TTT", 'T', Items.leather, 'S', Blocks.chest});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.WineSeeds, 1), new Object[]{"X", 'X', ItemHandler.Wine});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.GlassFW, 1), new Object[]{"X X", " X " , 'X', Blocks.glass_pane});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.GlassSW, 1), new Object[]{"Y", "X" , 'X', ItemHandler.GlassFW, 'Y', new ItemStack(ItemHandler.BottleSW, 1, OreDictionary.WILDCARD_VALUE)});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.BottleFW, 1), new Object[]{" X ", "X X", "XXX" , 'X', new ItemStack(Blocks.stained_glass, 1, 13)});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.FermentingBarrelOff, 1), new Object[]{"XXX", "YXY", "XXX", 'Y', Items.iron_ingot, 'X', Blocks.planks});
        GameRegistry.addRecipe(new ItemStack(ItemHandler.KegForBeer, 1), new Object[]{"XXX", "X X", "XXX" , 'X', new ItemStack(Items.iron_ingot)});

        
        GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.ToastWPearJ, 1), new ItemStack(ItemHandler.BakedToast), new ItemStack(ItemHandler.PearJam));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.ToastWCherryJ, 1), new ItemStack(ItemHandler.BakedToast), new ItemStack(ItemHandler.CherryJam));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.ToastWPlumJ, 1), new ItemStack(ItemHandler.BakedToast), new ItemStack(ItemHandler.PlumJam));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.ToastWAJ, 1), new ItemStack(ItemHandler.BakedToast), new ItemStack(ItemHandler.AppleJam));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.CheeseItem, 1), new ItemStack(ItemHandler.Salt), new ItemStack(ItemHandler.BucketCurd), new ItemStack(ItemHandler.BucketCurd), new ItemStack(ItemHandler.BucketCurd));
        
        //Knife
        GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.PlumSlice, 8), new ItemStack(ItemHandler.Knife, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ItemHandler.Plum));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.PearSlice, 8), new ItemStack(ItemHandler.Knife, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ItemHandler.Pear));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.AppleSlice, 8), new ItemStack(ItemHandler.Knife, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.apple));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.Toast, 8), new ItemStack(ItemHandler.Knife, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.bread));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.slicedCheese, 6), new ItemStack(ItemHandler.Knife, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ItemHandler.CheeseItem));
        
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.TomatoSeeds), 7);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.RadishSeeds), 7);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.BroccoliSeeds), 7);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.CucumberSeeds), 7);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.RiceSeeds), 7);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.CapsicumSeeds), 7);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.CabbageSeeds), 7);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.StrawberrySeeds), 7);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.HopsSeeds), 7);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.BarleySeeds), 7);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.BlueberrySeeds), 7);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.PineappleSeeds), 7);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.WineSeeds), 7);
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.Corn_Seed), 7);
        
        BottlingRecipeManager.instance.addRecipe(new ItemStack(ItemHandler.KegOfBeer), new ItemStackMatcher(ItemHandler.KegForBeer), new ItemStackMatcher(ItemHandler.BeerBucket));
        BottlingRecipeManager.instance.addRecipe(new ItemStack(ItemHandler.BottleSW), new ItemStackMatcher(ItemHandler.BottleFW), new ItemStackMatcher(ItemHandler.FermentedWine));
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    { 
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

        //Block\\
        
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.CheeseBlock), 0, new ModelResourceLocation(MODID + ":" + "cheeseblock", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.Scarecrow), 0, new ModelResourceLocation(MODID + "scarecrow", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.BlockCopper), 0, new ModelResourceLocation(MODID + ":" + "blockcopper", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.OreCopper), 0, new ModelResourceLocation(MODID + ":" + "orecopper", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.AppleCakeBlock), 0, new ModelResourceLocation(MODID + ":" + "applecakeblock", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.juicerOff), 0, new ModelResourceLocation(MODID + ":" + "juiceroff", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.juicerOn), 0, new ModelResourceLocation(MODID + ":" + "juiceron", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.BottlingOff), 0, new ModelResourceLocation(MODID + ":" + "bottlingoff", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.leavesPearNormal), 0, new ModelResourceLocation(MODID + ":" + "leavespn", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.SaplingPear), 0, new ModelResourceLocation(MODID + ":" + "saplingPear", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.leavesPearSH), 0, new ModelResourceLocation(MODID + ":" + "leavespearplne", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.leavesCherryNormal), 0, new ModelResourceLocation(MODID + ":" + "leavesCH", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.SaplingCherry), 0, new ModelResourceLocation(MODID + ":" + "saplingCherry", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.leavesCherryST), 0, new ModelResourceLocation(MODID + ":" + "leavescherryplne", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.leavesPlumNormal), 0, new ModelResourceLocation(MODID + ":" + "leavesPL", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.SaplingPlum), 0, new ModelResourceLocation(MODID + ":" + "saplingPlum", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.leavesPlumSS), 0, new ModelResourceLocation(MODID + ":" + "leavesplumplne", "inventory"));
        
        //Crop        
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.Corn), 0, new ModelResourceLocation(MODID + ":" + "cornblock", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.TomatoBlock), 0, new ModelResourceLocation(MODID + ":" + "tomatoblock", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.RadishBlock), 0, new ModelResourceLocation(MODID + ":" + "radishblock", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.BroccoliBlock), 0, new ModelResourceLocation(MODID + ":" + "broccoliblock", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.CucumberBlock), 0, new ModelResourceLocation(MODID + ":" + "cucumberblock", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.RiceBlock), 0, new ModelResourceLocation(MODID + ":" + "riceblock", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.CapsicumBlock), 0, new ModelResourceLocation(MODID + ":" + "capsicumblock", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.CabbageBlock), 0, new ModelResourceLocation(MODID + ":" + "cabbageblock", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.StrawberryBlock), 0, new ModelResourceLocation(MODID + ":" + "strawberryblock", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.HopsBlock), 0, new ModelResourceLocation(MODID + ":" + "hopsblock", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.BarleyBlock), 0, new ModelResourceLocation(MODID + ":" + "barleyblock", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.BlueberryBlock), 0, new ModelResourceLocation(MODID + ":" + "blueberryblock", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.PineappleBlock), 0, new ModelResourceLocation(MODID + ":" + "pineappleblock", "inventory"));
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockHandler.WineBlock), 0, new ModelResourceLocation(MODID + ":" + "grapeblock", "inventory"));

        
    	//Item\\
        
        //Food
        renderItem.getItemModelMesher().register(ItemHandler.Corn_flakes, 0, new ModelResourceLocation(MODID + ":" + "Corn_flakes", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Corn_Item, 0, new ModelResourceLocation(MODID + ":" + "Corn_Item", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.AppleJam, 0, new ModelResourceLocation(MODID + ":" + "applejam", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.AppleSlice, 0, new ModelResourceLocation(MODID + ":" + "appleslice", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.AppleYoghurt, 0, new ModelResourceLocation(MODID + ":" + "appleyoghurt", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.BakedToast, 0, new ModelResourceLocation(MODID + ":" + "bakedtoast", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Barley, 0, new ModelResourceLocation(MODID + ":" + "barley", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Blueberry, 0, new ModelResourceLocation(MODID + ":" + "blueberry", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Broccoli, 0, new ModelResourceLocation(MODID + ":" + "broccoli", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Cabbage, 0, new ModelResourceLocation(MODID + ":" + "cabbage", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Capsicum, 0, new ModelResourceLocation(MODID + ":" + "capsicum", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Cherry, 0, new ModelResourceLocation(MODID + ":" + "cherry", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.CherryJam, 0, new ModelResourceLocation(MODID + ":" + "cherryjam", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Cucumber, 0, new ModelResourceLocation(MODID + ":" + "cucumber", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Hops, 0, new ModelResourceLocation(MODID + ":" + "hops", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.JellyP, 0, new ModelResourceLocation(MODID + ":" + "jellyp", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Pear, 0, new ModelResourceLocation(MODID + ":" + "pear", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.PearJam, 0, new ModelResourceLocation(MODID + ":" + "pearjam", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.PearSlice, 0, new ModelResourceLocation(MODID + ":" + "pearslice", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Pineapple, 0, new ModelResourceLocation(MODID + ":" + "pineapple", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Plum, 0, new ModelResourceLocation(MODID + ":" + "plum", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.PlumJam, 0, new ModelResourceLocation(MODID + ":" + "plumjam", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.PlumSlice, 0, new ModelResourceLocation(MODID + ":" + "plumslice", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Radish, 0, new ModelResourceLocation(MODID + ":" + "radish", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Rice, 0, new ModelResourceLocation(MODID + ":" + "rice", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.slicedCheese, 0, new ModelResourceLocation(MODID + ":" + "slicedcheese", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Strawberry, 0, new ModelResourceLocation(MODID + ":" + "strawberry", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Toast, 0, new ModelResourceLocation(MODID + ":" + "toast", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.ToastWAJ, 0, new ModelResourceLocation(MODID + ":" + "toastwithapplejam", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.ToastWCherryJ, 0, new ModelResourceLocation(MODID + ":" + "toastwithcherryjam", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.ToastWPearJ, 0, new ModelResourceLocation(MODID + ":" + "toastwithpearjam", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.ToastWPlumJ, 0, new ModelResourceLocation(MODID + ":" + "toastwithplumjam", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Tomato, 0, new ModelResourceLocation(MODID + ":" + "tomato", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Wine, 0, new ModelResourceLocation(MODID + ":" + "grape", "inventory"));
        
        //Seeds
        renderItem.getItemModelMesher().register(ItemHandler.Corn_Seed, 0, new ModelResourceLocation(MODID + ":" + "Corn_Seed", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.BarleySeeds, 0, new ModelResourceLocation(MODID + ":" + "barleyseeds", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.BlueberrySeeds, 0, new ModelResourceLocation(MODID + ":" + "blueberryseeds", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.BroccoliSeeds, 0, new ModelResourceLocation(MODID + ":" + "broccoliseeds", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.CabbageSeeds, 0, new ModelResourceLocation(MODID + ":" + "cabbageseeds", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.CapsicumSeeds, 0, new ModelResourceLocation(MODID + ":" + "capsicumseeds", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.CucumberSeeds, 0, new ModelResourceLocation(MODID + ":" + "cucumberseeds", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.HopsSeeds, 0, new ModelResourceLocation(MODID + ":" + "hopsseeds", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.PineappleSeeds, 0, new ModelResourceLocation(MODID + ":" + "pineappleseeds", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.RadishSeeds, 0, new ModelResourceLocation(MODID + ":" + "radishseeds", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.RiceSeeds, 0, new ModelResourceLocation(MODID + ":" + "riceseeds", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.StrawberrySeeds, 0, new ModelResourceLocation(MODID + ":" + "strawberryseeds", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.TomatoSeeds, 0, new ModelResourceLocation(MODID + ":" + "tomatoseeds", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.WineSeeds, 0, new ModelResourceLocation(MODID + ":" + "grapeseeds", "inventory"));	
  
        //Zbytek
        renderItem.getItemModelMesher().register(ItemHandler.Salt, 0, new ModelResourceLocation(MODID + ":" + "salt", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.GlassFJ, 0, new ModelResourceLocation(MODID + ":" + "glass", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.ingotCopper, 0, new ModelResourceLocation(MODID + ":" + "ingotcopper", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Knife, 0, new ModelResourceLocation(MODID + ":" + "knife", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.ScarecrowItem, 0, new ModelResourceLocation(MODID + ":" + "scarecrow_item", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.CheeseItem, 0, new ModelResourceLocation(MODID + ":" + "cheese", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.AppleCake, 0, new ModelResourceLocation(MODID + ":" + "applecake", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.HotWaterBucket, 0, new ModelResourceLocation(MODID + ":" + "hotwater", "inventory"));

        //Juice
        renderItem.getItemModelMesher().register(ItemHandler.AppleJuice, 0, new ModelResourceLocation(MODID + ":" + "applejuice", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.CarrotJuice, 0, new ModelResourceLocation(MODID + ":" + "carrotjuice", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.CherryJuice, 0, new ModelResourceLocation(MODID + ":" + "cherryjuice", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.PearJuice, 0, new ModelResourceLocation(MODID + ":" + "pearjuice", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.PineappleJuice, 0, new ModelResourceLocation(MODID + ":" + "pineapplejuice", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.PlumJuice, 0, new ModelResourceLocation(MODID + ":" + "plumjuice", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.StrawberryJuice, 0, new ModelResourceLocation(MODID + ":" + "strawberryjuice", "inventory"));

        //Beer
        renderItem.getItemModelMesher().register(ItemHandler.Bottle, 0, new ModelResourceLocation(MODID + ":" + "bottle", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.BeerBottle, 0, new ModelResourceLocation(MODID + ":" + "beerbottle", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Malt, 0, new ModelResourceLocation(MODID + ":" + "malt", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.SoakedBarley, 0, new ModelResourceLocation(MODID + ":" + "soakedbarley", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Mash, 0, new ModelResourceLocation(MODID + ":" + "mash", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.Worts, 0, new ModelResourceLocation(MODID + ":" + "worts", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.ColdWorts, 0, new ModelResourceLocation(MODID + ":" + "coldworts", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.BucketCurd, 0, new ModelResourceLocation(MODID + ":" + "curd", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.BeerBucket, 0, new ModelResourceLocation(MODID + ":" + "hotbeer", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.KegForBeer, 0, new ModelResourceLocation(MODID + ":" + "kegforbeer", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.KegOfBeer, 0, new ModelResourceLocation(MODID + ":" + "kegofbeer", "inventory"));

        //Wine
        renderItem.getItemModelMesher().register(ItemHandler.GlassFW, 0, new ModelResourceLocation(MODID + ":" + "glassfw", "inventory"));
        renderItem.getItemModelMesher().register(ItemHandler.GlassSW, 0, new ModelResourceLocation(MODID + ":" + "glasssw", "inventory"));
    }
    
    @EventHandler
    public static void PreLoad(FMLPreInitializationEvent PreEvent) {
        proxy.registerTileEntities();
        proxy.preInit();
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {         	
        proxy.registerRenderer();

		registerBiomeWithTypes(FC2TreeBiome, "FC2TreeBiome", 100, BiomeType.WARM, Type.PLAINS, Type.SPOOKY);
		BiomeManager.addSpawnBiome(FC2TreeBiome);
    	
    	OreDictionary.registerOre("oreCopper", BlockHandler.OreCopper);
    	OreDictionary.registerOre("blockCopper", BlockHandler.BlockCopper);
    	OreDictionary.registerOre("ingotCopper", ItemHandler.ingotCopper);
    	    	
    	GameRegistry.registerWorldGenerator(new WordGen(), 0);

        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new FC2_GuiHandler());
    }
    
    private static void registerBiomeWithTypes(BiomeGenBase biome, String name, int weight, BiomeType btype, Type...types){
		GameRegistry.register(biome.setRegistryName(new ResourceLocation(MODID, name)));
		BiomeDictionary.registerBiomeType(biome, types);
		BiomeManager.addBiome(btype, new BiomeEntry(biome, weight));
	}
}
