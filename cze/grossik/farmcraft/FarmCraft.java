package cze.grossik.farmcraft;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cze.grossik.farmcraft.handler.BlockHandler;
import cze.grossik.farmcraft.handler.ItemHandler;
import cze.grossik.farmcraft.item.FC_Item;
import cze.grossik.farmcraft.item.Item_Bucket;
import cze.grossik.farmcraft.item.Item_Cheese;
import cze.grossik.farmcraft.item.Item_Scarecrow;
import cze.grossik.farmcraft.item.Item_Seeds;
import cze.grossik.farmcraft.wordgen.VillageBarakHandler;
import cze.grossik.farmcraft.wordgen.VillagePoleHandler;
import cze.grossik.farmcraft.wordgen.Village_Barak;
import cze.grossik.farmcraft.wordgen.Village_Pole;
import cze.grossik.farmcraft.wordgen.WordGen;
import cze.grossik.farmcraft.wordgen.WorldGenTree;

@Mod(name = "FarmCraft mod", version = FarmCraft.VERSION, useMetadata = false, modid = FarmCraft.MODID)

public class FarmCraft {

    public static final String VERSION = "3.0";
    public static final String MODID = "FarmCraft";

    @Instance(MODID)
    public static FarmCraft instance;
    @SidedProxy(clientSide = "cz.grossik.farmcraft.FCProxyClient", serverSide = "cz.grossik.farmcraft.FCProxyCommon")
    public static cze.grossik.farmcraft.FCProxyCommon proxy;

    public static CreativeTabs FarmCraftTab = new FarmCraftTab("FarmCraft");

    public static boolean addToVillages;

    //Seeds
    public static Item TomatoSeeds = new Item_Seeds(BlockHandler.TomatoBlock, Blocks.farmland).setUnlocalizedName("tomatoseeds").setTextureName("farmcraft:seeds_tomato");
    public static Item RadishSeeds = new Item_Seeds(BlockHandler.RadishBlock, Blocks.farmland).setUnlocalizedName("radishseeds").setTextureName("farmcraft:seeds_radish");
    public static Item BroccoliSeeds = new Item_Seeds(BlockHandler.BroccoliBlock, Blocks.farmland).setUnlocalizedName("broccoliseeds").setTextureName("farmcraft:seeds_broccoli");
    public static Item CucumberSeeds = new Item_Seeds(BlockHandler.CucumberBlock, Blocks.farmland).setUnlocalizedName("cucumberseeds").setTextureName("farmcraft:seeds_cucumber");
    public static Item RiceSeeds = new Item_Seeds(BlockHandler.RiceBlock, Blocks.farmland).setUnlocalizedName("riceseeds").setTextureName("farmcraft:seeds_rice");
    public static Item CapsicumSeeds = new Item_Seeds(BlockHandler.CapsicumBlock, Blocks.farmland).setUnlocalizedName("capsicumseeds").setTextureName("farmcraft:seeds_capsicum");
    public static Item CabbageSeeds = new Item_Seeds(BlockHandler.CabbageBlock, Blocks.farmland).setUnlocalizedName("cabbageseeds").setTextureName("farmcraft:seeds_cabbage");
    public static Item StrawberrySeeds = new Item_Seeds(BlockHandler.StrawberryBlock, Blocks.farmland).setUnlocalizedName("strawberryseeds").setTextureName("farmcraft:seeds_strawberry");
    public static Item HopsSeeds = new Item_Seeds(BlockHandler.HopsBlock, Blocks.farmland).setUnlocalizedName("hopsseeds").setTextureName("farmcraft:seeds_hops");
    public static Item BarleySeeds = new Item_Seeds(BlockHandler.BarleyBlock, Blocks.farmland).setUnlocalizedName("barleyseeds").setTextureName("farmcraft:seeds_barley");
    public static Item BlueberrySeeds = new Item_Seeds(BlockHandler.BlueberryBlock, Blocks.farmland).setUnlocalizedName("blueberryseeds").setTextureName("farmcraft:seeds_blueberry");
    public static Item PineappleSeeds = new Item_Seeds(BlockHandler.PineappleBlock, Blocks.farmland).setUnlocalizedName("pineappleseeds").setTextureName("farmcraft:seeds_pineapple");
   
    //Food
    public static Item Tomato = new ItemFood(3, 3, false).setUnlocalizedName("tomato").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:tomato");
    public static Item Radish = new ItemFood(3, 3, false).setUnlocalizedName("radish").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:radish");
    public static Item Broccoli = new ItemFood(3, 3, false).setUnlocalizedName("broccoli").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:broccoli");
    public static Item Cucumber = new ItemFood(3, 3, false).setUnlocalizedName("cucumber").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:cucumber");
    public static Item Rice = new ItemFood(3, 3, false).setUnlocalizedName("rice").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:rice");
    public static Item Capsicum = new ItemFood(3, 3, false).setUnlocalizedName("capsicum").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:capsicum");
    public static Item Cabbage = new ItemFood(3, 3, false).setUnlocalizedName("cabbage").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:cabbage");
    public static Item Strawberry = new ItemFood(3, 3, false).setUnlocalizedName("strawberry").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:strawberry");
    public static Item Pear = new ItemFood(3, 3, false).setUnlocalizedName("pear").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:pear");
    public static Item Hops = new ItemFood(3, 3, false).setUnlocalizedName("hops").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:hops");
    public static Item Barley = new ItemFood(3, 3, false).setUnlocalizedName("barley").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:barley");
    public static Item Blueberry = new ItemFood(3, 3, false).setUnlocalizedName("blueberry").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:blueberry");
    public static Item Pineapple = new ItemFood(3, 3, false).setUnlocalizedName("pineapple").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:pineapple");
    public static Item Cherry = new ItemFood(3, 3, false).setUnlocalizedName("cherry").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:cherry");
    public static Item slicedCheese = (new ItemFood(2, 0.1F, false)).setUnlocalizedName("slicedCheese").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:slicedCheese");
    public static Item Toast = (new ItemFood(1, 0.3F, false)).setUnlocalizedName("toast").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:toast");
    public static Item BakedToast = (new ItemFood(3, 0.3F, false)).setUnlocalizedName("bakedtoast").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:baked_toast");
    public static Item JellyP = (new ItemFood(1, 0.3F, false)).setUnlocalizedName("jellyp").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:jelly_powder");
    public static Item PearJam = (new ItemFood(3, 0.6F, false)).setUnlocalizedName("pearjam").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:jam_pear");
    public static Item AppleJam = (new ItemFood(3, 0.6F, false)).setUnlocalizedName("applejam").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:jam_apple");
    public static Item AppleSlice = (new ItemFood(1, 0.1F, false)).setUnlocalizedName("appleslice").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:apple_slice");
    public static Item AppleYoghurt = (new ItemFood(4, 0.4F, false)).setUnlocalizedName("appleyoghurt").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:yoghurt_apple");
    public static Item ToastWAJ = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("toastwithapplejam").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:toast_with_apple_jam");
    public static Item PearSlice = (new ItemFood(1, 0.1F, false)).setUnlocalizedName("pearslice").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:pear_slice");
    public static Item Plum = (new ItemFood(4, 0.3F, false)).setUnlocalizedName("plum").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:plum");
    public static Item PlumJam = (new ItemFood(3, 0.6F, false)).setUnlocalizedName("plumjam").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:jam_plum");
    public static Item CherryJam = (new ItemFood(3, 0.6F, false)).setUnlocalizedName("cherryjam").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:jam_cherry");
    public static Item ToastWPearJ = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("toastwithpearjam").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:toast_with_pear_jam");
    public static Item ToastWCherryJ = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("toastwithcherryjam").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:toast_with_cherry_jam");
    public static Item ToastWPlumJ = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("toastwithplumjam").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:toast_with_plum_jam");
    public static Item PlumSlice = (new ItemFood(1, 0.1F, false)).setUnlocalizedName("plumslice").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:plum_slice");
    
    //Zbytek
    public static Item ScarecrowItem = new Item_Scarecrow(Material.wood).setUnlocalizedName("scarecrow_item").setTextureName("farmcraft:scarecrow");
    public static Item Salt = new FC_Item().setUnlocalizedName("salt").setTextureName("farmcraft:salt");
    public static Item CheeseItem = new Item_Cheese(BlockHandler.CheeseBlock).setCreativeTab(FarmCraft.FarmCraftTab).setUnlocalizedName("cheese").setTextureName("farmcraft:cheese");
    public static Item Knife = new FC_Item().setUnlocalizedName("knife").setTextureName("farmcraft:knife");
    public static Item Glass = new FC_Item().setUnlocalizedName("glass").setTextureName("farmcraft:glass");
    public static Item ingotCopper = (new FC_Item()).setUnlocalizedName("ingotcopper").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:ingot_copper");
    public static Item HotWaterBucket = (new Item_Bucket()).setUnlocalizedName("hotwater").setContainerItem(Items.bucket).setTextureName("farmcraft:bucket_hotwater");
    public static Item AppleCake = (new ItemReed(BlockHandler.AppleCakeBlock)).setMaxStackSize(1).setUnlocalizedName("applecake").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:apple_cake");

    //Juice
    public static Item StrawberryJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("strawberryjuice").setCreativeTab(FarmCraft.FarmCraftTab).setContainerItem(FarmCraft.Glass).setTextureName("farmcraft:juice_strawberry");
    public static Item CarrotJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("carrotjuice").setCreativeTab(FarmCraft.FarmCraftTab).setContainerItem(FarmCraft.Glass).setTextureName("farmcraft:juice_carrot");
    public static Item PearJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("pearjuice").setCreativeTab(FarmCraft.FarmCraftTab).setContainerItem(FarmCraft.Glass).setTextureName("farmcraft:juice_pear");
    public static Item AppleJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("applejuice").setCreativeTab(FarmCraft.FarmCraftTab).setContainerItem(FarmCraft.Glass).setTextureName("farmcraft:juice_apple");
    public static Item CherryJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("cherryjuice").setCreativeTab(FarmCraft.FarmCraftTab).setContainerItem(FarmCraft.Glass).setTextureName("farmcraft:juice_cherry");
    public static Item PlumJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("plumjuice").setCreativeTab(FarmCraft.FarmCraftTab).setContainerItem(FarmCraft.Glass).setTextureName("farmcraft:juice_plum");

    //Beer
    public static Item BucketCurd = new Item_Bucket().setUnlocalizedName("curd").setContainerItem(Items.bucket).setTextureName("farmcraft:bucket_curd");
    public static Item Malt = new FC_Item().setUnlocalizedName("malt").setTextureName("farmcraft:malt");
    public static Item SoakedBarley = (new FC_Item()).setUnlocalizedName("soakedbarley").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:soaked_barley");
    public static Item Mash = (new FC_Item().setUnlocalizedName("mash").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:mash"));
    public static Item Worts = (new FC_Item().setUnlocalizedName("worts").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:worts"));
    public static Item ColdWorts = (new FC_Item().setUnlocalizedName("coldworts").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:cold_worts"));
    public static Item Bottle = (new FC_Item()).setUnlocalizedName("bottle").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:bottle_nobeer");
    public static Item BeerBottle = (new ItemFood(4, 0.3F, false)).setUnlocalizedName("beerbottle").setContainerItem(FarmCraft.Bottle).setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:bottle_beer");
    public static Item BeerBucket = (new Item_Bucket()).setUnlocalizedName("hotbeer").setTextureName("farmcraft:bucket_beer");  

    public FarmCraft() {

        GameRegistry.registerItem(FarmCraft.TomatoSeeds, "tomatoSeeds");
        GameRegistry.registerItem(FarmCraft.Tomato, "tomato");
        GameRegistry.registerItem(FarmCraft.RadishSeeds, "radihSeeds");
        GameRegistry.registerItem(FarmCraft.Radish, "radish");
        GameRegistry.registerItem(FarmCraft.Broccoli, "broccoli");
        GameRegistry.registerItem(FarmCraft.BroccoliSeeds, "broccoliseeds");
        GameRegistry.registerItem(FarmCraft.BucketCurd, "bucketMilk");
        GameRegistry.registerItem(FarmCraft.CheeseItem, "cheese");
        GameRegistry.registerItem(FarmCraft.ScarecrowItem, "scarecrowI");
        GameRegistry.registerItem(FarmCraft.Pear, "pear");
        GameRegistry.registerItem(FarmCraft.CucumberSeeds, "CucumberSeeds");
        GameRegistry.registerItem(FarmCraft.Cucumber, "Cucumber");
        GameRegistry.registerItem(FarmCraft.RiceSeeds, "RiceSeeds");
        GameRegistry.registerItem(FarmCraft.Rice, "Rice");
        GameRegistry.registerItem(FarmCraft.CapsicumSeeds, "capsicumseeds");
        GameRegistry.registerItem(FarmCraft.Capsicum, "capsicum");
        GameRegistry.registerItem(FarmCraft.Knife, "knife");
        GameRegistry.registerItem(FarmCraft.Glass, "glasses");
        GameRegistry.registerItem(FarmCraft.CabbageSeeds, "CabbageSeeds");
        GameRegistry.registerItem(FarmCraft.Cabbage, "Cabbage");
        GameRegistry.registerItem(FarmCraft.AppleJuice, "applejuice");
        GameRegistry.registerItem(FarmCraft.PearJuice, "pearjuice");
        GameRegistry.registerItem(FarmCraft.CarrotJuice, "carrotjuice");
        GameRegistry.registerItem(FarmCraft.Malt, "malt");
        GameRegistry.registerItem(FarmCraft.StrawberrySeeds, "strawberrySeeds");
        GameRegistry.registerItem(FarmCraft.Strawberry, "strawberry");
        GameRegistry.registerItem(FarmCraft.StrawberryJuice, "strawberryjuice");
        GameRegistry.registerItem(FarmCraft.Cherry, "cherry");
        GameRegistry.registerItem(FarmCraft.CherryJuice, "cherryjuice");
        GameRegistry.registerItem(FarmCraft.slicedCheese, "slicedCheese");
        GameRegistry.registerItem(FarmCraft.ingotCopper, "ingotcopper");
        GameRegistry.registerItem(FarmCraft.HopsSeeds, "hopsseeds");
        GameRegistry.registerItem(FarmCraft.Hops, "hops");
        GameRegistry.registerItem(FarmCraft.BarleySeeds, "barleyseeds");
        GameRegistry.registerItem(FarmCraft.Barley, "barley");
        GameRegistry.registerItem(FarmCraft.SoakedBarley, "soakedbarley");
        GameRegistry.registerItem(FarmCraft.HotWaterBucket, "hotwater");
        GameRegistry.registerItem(FarmCraft.Mash, "mash");
        GameRegistry.registerItem(FarmCraft.Worts, "worts");
        GameRegistry.registerItem(FarmCraft.ColdWorts, "coldworts");
        GameRegistry.registerItem(FarmCraft.Bottle, "bottle");
        GameRegistry.registerItem(FarmCraft.BeerBottle, "bottlebeer");
        GameRegistry.registerItem(FarmCraft.BlueberrySeeds, "blueberrySeeds");
        GameRegistry.registerItem(FarmCraft.Blueberry, "blueberry");
        GameRegistry.registerItem(FarmCraft.Toast, "toast");
        GameRegistry.registerItem(FarmCraft.BakedToast, "bakedtoast");
        GameRegistry.registerItem(FarmCraft.JellyP, "jellyp");
        GameRegistry.registerItem(FarmCraft.PearJam, "pearjam");
        GameRegistry.registerItem(FarmCraft.AppleJam, "applejam");
        GameRegistry.registerItem(FarmCraft.AppleCake, "applecake");
        GameRegistry.registerItem(FarmCraft.AppleSlice, "appleslice");
        GameRegistry.registerItem(FarmCraft.AppleYoghurt, "appleyoghurt");
        GameRegistry.registerItem(FarmCraft.ToastWAJ, "toastwithapplejam");
        GameRegistry.registerItem(FarmCraft.PearSlice, "pearslice");
        GameRegistry.registerItem(FarmCraft.Plum, "plum");
        GameRegistry.registerItem(FarmCraft.PlumJuice, "plumJuice");
        GameRegistry.registerItem(FarmCraft.PlumJam, "plumjam");
        GameRegistry.registerItem(FarmCraft.CherryJam, "cherryjam");
        GameRegistry.registerItem(FarmCraft.ToastWPearJ, "toastwithpearjam");
        GameRegistry.registerItem(FarmCraft.ToastWCherryJ, "toastwithcherryjam");
        GameRegistry.registerItem(FarmCraft.ToastWPlumJ, "toastwithplumjam");
        GameRegistry.registerItem(FarmCraft.PlumSlice, "plumslice");
        GameRegistry.registerItem(FarmCraft.PineappleSeeds, "pineappleSeeds");
        GameRegistry.registerItem(FarmCraft.Pineapple, "pineapple");
        GameRegistry.registerItem(FarmCraft.Salt, "salt");
        GameRegistry.registerItem(FarmCraft.BeerBucket, "hotbeer");


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


        LanguageRegistry.addName(FarmCraft.TomatoSeeds, "Tomato seed");
    	LanguageRegistry.addName(FarmCraft.Tomato, "Tomato");
    	LanguageRegistry.addName(FarmCraft.RadishSeeds, "Radish seed");
    	LanguageRegistry.addName(FarmCraft.Radish, "Radish");
    	LanguageRegistry.addName(FarmCraft.Broccoli, "Broccoli");
    	LanguageRegistry.addName(FarmCraft.BroccoliSeeds, "Broccoli seed");
    	LanguageRegistry.addName(FarmCraft.BucketCurd, "Curd Bucket");
    	LanguageRegistry.addName(FarmCraft.Salt, "Salt");
    	LanguageRegistry.addName(FarmCraft.CheeseItem, "Cheese");
    	LanguageRegistry.addName(FarmCraft.ScarecrowItem, "Scarecrow");
        LanguageRegistry.addName(FarmCraft.CabbageSeeds, "Cabbage seed");
        LanguageRegistry.addName(FarmCraft.Cabbage, "Cabbage");
        LanguageRegistry.addName(FarmCraft.Mash, "Malt");
        LanguageRegistry.addName(FarmCraft.CucumberSeeds, "Cucumber seed");
    	LanguageRegistry.addName(FarmCraft.Cucumber, "Cucumber");
    	LanguageRegistry.addName(FarmCraft.RiceSeeds, "Rice seed");
    	LanguageRegistry.addName(FarmCraft.Rice, "Rice");
    	LanguageRegistry.addName(FarmCraft.Pear, "Pear");
    	LanguageRegistry.addName(FarmCraft.CapsicumSeeds, "Capsicum seed");
    	LanguageRegistry.addName(FarmCraft.Capsicum, "Capsicum");
    	LanguageRegistry.addName(FarmCraft.Knife, "Knife");
    	LanguageRegistry.addName(FarmCraft.AppleJuice, "Apple Juice");
        LanguageRegistry.addName(FarmCraft.Glass, "Glass");
        LanguageRegistry.addName(FarmCraft.PearJuice, "Pear Juice");
        LanguageRegistry.addName(FarmCraft.CarrotJuice, "Carrot Juice");
        LanguageRegistry.addName(FarmCraft.StrawberrySeeds, "Strawberry seed");
        LanguageRegistry.addName(FarmCraft.Strawberry, "Strawberry");
    	LanguageRegistry.addName(FarmCraft.StrawberryJuice, "Strawberry Juice");
    	LanguageRegistry.addName(FarmCraft.Cherry, "Cherry");
    	LanguageRegistry.addName(FarmCraft.CherryJuice, "Cherry Juice");
    	LanguageRegistry.addName(FarmCraft.slicedCheese, "Sliced Cheese");
    	LanguageRegistry.addName(FarmCraft.ingotCopper, "Copper Ingot");
    	LanguageRegistry.addName(FarmCraft.HopsSeeds, "Hops seed");
    	LanguageRegistry.addName(FarmCraft.Hops, "Hops");
    	LanguageRegistry.addName(FarmCraft.BarleySeeds, "Barley seed");
    	LanguageRegistry.addName(FarmCraft.Barley, "Barley");
    	LanguageRegistry.addName(FarmCraft.SoakedBarley, "Soaked Barley");
    	LanguageRegistry.addName(FarmCraft.HotWaterBucket, "Hot Water Bucket");
        LanguageRegistry.addName(FarmCraft.Mash, "Mash");
        LanguageRegistry.addName(FarmCraft.Worts, "Hot Worts");
        LanguageRegistry.addName(FarmCraft.ColdWorts, "Cold Worts");
        LanguageRegistry.addName(FarmCraft.BeerBucket, "Beer Bucket");
        LanguageRegistry.addName(FarmCraft.Bottle, "Beer Bottle");
        LanguageRegistry.addName(FarmCraft.BeerBottle, "Bottle of Beer");
        LanguageRegistry.addName(FarmCraft.BlueberrySeeds, "Blueberry seed");
        LanguageRegistry.addName(FarmCraft.Blueberry, "Blueberry");
        LanguageRegistry.addName(FarmCraft.Toast, "Toast");
        LanguageRegistry.addName(FarmCraft.BakedToast, "Baked Toast");
        LanguageRegistry.addName(FarmCraft.JellyP, "Jelly Powder");
        LanguageRegistry.addName(FarmCraft.PearJam, "Pear Jam");
        LanguageRegistry.addName(FarmCraft.AppleJam, "Apple Jam");
        LanguageRegistry.addName(FarmCraft.AppleCake, "Apple Cake");
        LanguageRegistry.addName(FarmCraft.AppleSlice, "Apple Slice");
        LanguageRegistry.addName(FarmCraft.AppleYoghurt, "Apple Yoghurt");
        LanguageRegistry.addName(FarmCraft.ToastWAJ, "Toast With Apple Jam");
        LanguageRegistry.addName(FarmCraft.PearSlice, "Pear Slice");
        LanguageRegistry.addName(FarmCraft.Plum, "Plum");
        LanguageRegistry.addName(FarmCraft.PlumJuice, "Plum Juice");
        LanguageRegistry.addName(FarmCraft.PlumJam, "Plum Jam");
        LanguageRegistry.addName(FarmCraft.CherryJam, "Cherry Jam");
        LanguageRegistry.addName(FarmCraft.ToastWPearJ, "Toast With Pear Jam");
        LanguageRegistry.addName(FarmCraft.ToastWCherryJ, "Toast With Cherry Jam");
        LanguageRegistry.addName(FarmCraft.ToastWPlumJ, "Toast With Plum Jam");
        LanguageRegistry.addName(FarmCraft.PlumSlice, "Plum Slice");
        LanguageRegistry.addName(FarmCraft.PineappleSeeds, "Pineapple seed");
        LanguageRegistry.addName(FarmCraft.Pineapple, "Pineapple");

    	//Language Block
    	LanguageRegistry.addName(BlockHandler.SaplingPear, "Pear Sapling");
    	LanguageRegistry.addName(BlockHandler.juicerOff, "Juicer");
    	LanguageRegistry.addName(BlockHandler.juicerOn, "Juicer");
        LanguageRegistry.addName(BlockHandler.leavesPearNormal, "Pear Leaves");
        LanguageRegistry.addName(BlockHandler.leavesPearSH, "Pear Leaves");
        LanguageRegistry.addName(BlockHandler.leavesCherryNormal, "Cherry Leaves");
        LanguageRegistry.addName(BlockHandler.leavesCherryST, "Cherry Leaves");
        LanguageRegistry.addName(BlockHandler.SaplingCherry, "Cherry Sapling");
        LanguageRegistry.addName(BlockHandler.OreCopper, "Copper Ore");
        LanguageRegistry.addName(BlockHandler.BlockCopper, "Copper Block");
    	LanguageRegistry.addName(BlockHandler.MashTunOff, "Mash Tun");
    	LanguageRegistry.addName(BlockHandler.BoilingOff, "Boiling");
    	LanguageRegistry.addName(BlockHandler.BottlingOff, "Bottling");
        LanguageRegistry.addName(BlockHandler.leavesPlumNormal, "Plum Leaves");
        LanguageRegistry.addName(BlockHandler.leavesPlumSS, "Plum Leaves");
        LanguageRegistry.addName(BlockHandler.SaplingPlum, "Plum Sapling");
        
        GameRegistry.addRecipe(new ItemStack(FarmCraft.CheeseItem, 1), new Object[]{"BA", "AA", 'A', FarmCraft.BucketCurd, 'B', FarmCraft.Salt});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.ScarecrowItem, 1), new Object[]{" U ", "AXA", " A ", 'A', Items.stick, 'X', Items.wheat, 'U', Blocks.pumpkin});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.TomatoSeeds, 1), new Object[]{"X", 'X', FarmCraft.Tomato});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.RadishSeeds, 1), new Object[]{"X", 'X', FarmCraft.Radish});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.BroccoliSeeds, 1), new Object[]{"X", 'X', FarmCraft.Broccoli});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.CucumberSeeds, 1), new Object[]{"X", 'X', FarmCraft.Cucumber});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.RiceSeeds, 1), new Object[]{"X", 'X', FarmCraft.Rice});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.CapsicumSeeds, 1), new Object[]{"X", 'X', FarmCraft.Capsicum});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.Knife, 1), new Object[]{"AAX", 'A', Items.iron_ingot, 'X', Items.stick});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.Glass, 1), new Object[]{"X X", "XXX", 'X', Blocks.glass_pane});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.juicerOff, 1), new Object[]{"XXX", "XAX", "XYX", 'A', Items.flint, 'X', Blocks.cobblestone, 'Y', Items.redstone});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.StrawberrySeeds, 1), new Object[]{"X", 'X', FarmCraft.Strawberry});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.SaplingPear, 1), new Object[]{"HS", 'H', FarmCraft.Pear, 'S', new ItemStack(Blocks.sapling, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.SaplingCherry, 1), new Object[]{"TS", 'T', FarmCraft.Cherry, 'S', new ItemStack(Blocks.sapling, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.slicedCheese, 6), new Object[]{"XA", 'X', FarmCraft.CheeseItem, 'A', FarmCraft.Knife});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.BlockCopper, 1), new Object[]{"XXX", "XXX", "XXX", 'X', FarmCraft.ingotCopper});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.SoakedBarley, 8), new Object[]{"XXX", "XYX", "XXX", 'X', FarmCraft.Barley, 'Y', Items.water_bucket});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.MashTunOff, 1), new Object[]{"XXX", "XYX", "XXX", 'X', Items.iron_ingot, 'Y', FarmCraft.Malt});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.BoilingOff, 1), new Object[]{"XXX", "XYX", "XXX", 'X', FarmCraft.ingotCopper, 'Y', FarmCraft.Hops});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.Bottle, 8), new Object[]{"X X", "XYX", "XXX", 'X', Blocks.glass, 'Y', FarmCraft.Hops});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.BlueberrySeeds, 1), new Object[]{"X", 'X', FarmCraft.Blueberry});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.BottlingOff, 1), new Object[]{"PPP", "P#P", "PXP", 'P', Items.iron_ingot, '#', Blocks.lever, 'X', FarmCraft.Bottle});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.ColdWorts, 1), new Object[]{"X", 'X', FarmCraft.Worts});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.Toast, 8), new Object[]{"YX", 'Y', FarmCraft.Knife, 'X', Items.bread});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.JellyP, 1), new Object[]{"X", 'X', Items.sugar});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.PearJam, 1), new Object[]{"YX", 'Y', FarmCraft.JellyP, 'X', FarmCraft.Pear});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.AppleJam, 1), new Object[]{"YX", 'Y', FarmCraft.JellyP, 'X', Items.apple});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.AppleCake, 1), new Object[]{" E ", "BAB", "CCC", 'A', Items.milk_bucket, 'B', Items.sugar, 'C', Items.wheat, 'E', FarmCraft.AppleJam});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.AppleSlice, 8), new Object[]{"YX", 'Y', FarmCraft.Knife, 'X', Items.apple});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.PearSlice, 8), new Object[]{"YX", 'Y', FarmCraft.Knife, 'X', FarmCraft.Pear});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.AppleYoghurt, 1), new Object[]{"E", "E", "C", 'C', Items.milk_bucket, 'E', FarmCraft.AppleSlice});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.ToastWAJ, 1), new Object[]{"E", "C", 'C', FarmCraft.BakedToast, 'E', FarmCraft.AppleJam});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.PlumJam, 1), new Object[]{"YX", 'Y', FarmCraft.JellyP, 'X', FarmCraft.Plum});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.CherryJam, 1), new Object[]{"YX", 'Y', FarmCraft.JellyP, 'X', FarmCraft.Cherry});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.ToastWPearJ, 1), new Object[]{"E", "C", 'C', FarmCraft.BakedToast, 'E', FarmCraft.PearJam});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.ToastWCherryJ, 1), new Object[]{"E", "C", 'C', FarmCraft.BakedToast, 'E', FarmCraft.CherryJam});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.ToastWPlumJ, 1), new Object[]{"E", "C", 'C', FarmCraft.BakedToast, 'E', FarmCraft.PlumJam});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.PlumSlice, 8), new Object[]{"YX", 'Y', FarmCraft.Knife, 'X', FarmCraft.Plum});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.PineappleSeeds, 1), new Object[]{"X", 'X', FarmCraft.Pineapple});
        GameRegistry.addRecipe(new ItemStack(BlockHandler.SaplingPlum, 1), new Object[]{"TS", 'T', FarmCraft.Plum, 'S', new ItemStack(Blocks.sapling, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(FarmCraft.HopsSeeds, 1), new Object[]{"X", 'X', FarmCraft.Hops});


        MinecraftForge.addGrassSeed(new ItemStack(FarmCraft.TomatoSeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(FarmCraft.RadishSeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(FarmCraft.BroccoliSeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(FarmCraft.CucumberSeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(FarmCraft.RiceSeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(FarmCraft.CapsicumSeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(FarmCraft.CabbageSeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(FarmCraft.StrawberrySeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(FarmCraft.HopsSeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(FarmCraft.BarleySeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(FarmCraft.BlueberrySeeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(FarmCraft.PineappleSeeds), 10);
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
