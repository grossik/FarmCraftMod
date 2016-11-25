package cz.grossik.farmcraft2;

import com.google.common.eventbus.Subscribe;

import cz.grossik.farmcraft2.combine.EntityCombine;
import cz.grossik.farmcraft2.combine.RenderCombine;
import cz.grossik.farmcraft2.easteregg.EntityHomer;
import cz.grossik.farmcraft2.easteregg.RenderHomer;
import cz.grossik.farmcraft2.event.FC2VersionEvent;
import cz.grossik.farmcraft2.event.FarmCraft2Event;
import cz.grossik.farmcraft2.fluid.FC2Fluid;
import cz.grossik.farmcraft2.goat.EntityGoat;
import cz.grossik.farmcraft2.goat.RenderGoat;
import cz.grossik.farmcraft2.handler.BlockHandler;
import cz.grossik.farmcraft2.handler.ConfigHandler;
import cz.grossik.farmcraft2.handler.FC2_GuiHandler;
import cz.grossik.farmcraft2.handler.ItemHandler;
import cz.grossik.farmcraft2.tractor.EntityTractor;
import cz.grossik.farmcraft2.tractor.RenderTractor;
import cz.grossik.farmcraft2.util.MessageTileEntitySync;
import cz.grossik.farmcraft2.wordgen.BiomeGenFC2Tree;
import cz.grossik.farmcraft2.wordgen.WordGen;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = Main.MODID, version = Main.VERSION, name = "FarmCraft 2")
public class Main
{
    public static final String MODID = "farmcraft2";
    public static final String VERSION = "1.1.1";
    
    @Instance(MODID)
    public static Main instance;
    @SidedProxy(clientSide = "cz.grossik.farmcraft2.ProxyClient", serverSide = "cz.grossik.farmcraft2.ProxyCommon")
    public static ProxyCommon proxy;
    
    public static SimpleNetworkWrapper network_channel;
    
    public static CreativeTabs FarmCraft2Tab = new FarmCraft2Tab("FarmCraft 2");
    
    public static Biome FC2TreeBiome = new BiomeGenFC2Tree(false, (new Biome.BiomeProperties("Fruit Biome")).setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(0.8F).setRainfall(0.4F));
           
    public FC2Sounds sounds;
    
    public Main()
    {    	
    	FC2Fluid.instance.registerFluids();
    	
    	//Register Block
    	GameRegistry.registerBlock(BlockHandler.Corn, "cornblock");
    	GameRegistry.registerBlock(BlockHandler.TomatoBlock, "tomatoblock");
    	GameRegistry.registerBlock(BlockHandler.Scarecrow, "scarecrow");
    	GameRegistry.registerBlock(BlockHandler.ScarecrowTop, "scarecrow_top");
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
        GameRegistry.registerBlock(BlockHandler.CrushingOff, "crushingoff");
        GameRegistry.registerBlock(BlockHandler.CrushingOn, "crushingon");
        GameRegistry.registerBlock(BlockHandler.FermentingBarrelOff, "fermentingbarreloff");
        GameRegistry.registerBlock(BlockHandler.FermentingBarrelOn, "fermentingbarrelon");
        GameRegistry.registerBlock(BlockHandler.spigot, "spigot");
        GameRegistry.registerBlock(BlockHandler.HomerStatue, "statue_homer");
        GameRegistry.registerBlock(BlockHandler.HomerStatueTop, "statue_homer_top");
        GameRegistry.registerBlock(BlockHandler.leavesBananaNormal, "leavesbn");
        GameRegistry.registerBlock(BlockHandler.leavesBananaSB, "leavesbananaplne");
        GameRegistry.registerBlock(BlockHandler.SaplingBanana, "saplingBanana");    
        GameRegistry.registerBlock(BlockHandler.Pan, "pan");    
    	GameRegistry.registerBlock(BlockHandler.Treetap, "treetap");   
        GameRegistry.registerBlock(BlockHandler.MapleLeaves, "maple_leaves");
        GameRegistry.registerBlock(BlockHandler.SaplingMaple, "saplingMaple");
        GameRegistry.registerBlock(BlockHandler.MapleWood, "maple_wood");
        GameRegistry.registerBlock(BlockHandler.MarijuanaBlock, "marijuanablock");

        //Register ItemBlock
        register(BlockHandler.Rose, ItemHandler.ItemBlockRose, "fc_rose");
        register(BlockHandler.Lily, ItemHandler.ItemBlockLily, "lily");

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
        GameRegistry.registerItem(ItemHandler.backpack, "backpack");
        GameRegistry.registerItem(ItemHandler.GlassFW, "glassfw");
        GameRegistry.registerItem(ItemHandler.GlassSW, "glasssw");
        GameRegistry.registerItem(ItemHandler.WineBucket, "winebucket");
        GameRegistry.registerItem(ItemHandler.FermentedWine, "fermentedwine");
        GameRegistry.registerItem(ItemHandler.BottleFW, "bottlefw");
        GameRegistry.registerItem(ItemHandler.BottleSW, "bottlesw");
        GameRegistry.registerItem(ItemHandler.KegOfBeer, "kegofbeer");
        GameRegistry.registerItem(ItemHandler.Cornflakes_with_milk, "cornlakes_with_milk");
        GameRegistry.registerItem(ItemHandler.StrawberryJam, "strawberryjam");
        GameRegistry.registerItem(ItemHandler.ToastWSJ, "toastwithstrawberryjam");
        GameRegistry.registerItem(ItemHandler.Salad, "salad");
        GameRegistry.registerItem(ItemHandler.Chocolate, "chocolate");
        GameRegistry.registerItem(ItemHandler.HotChocolateBucket, "hotchocolatebucket");
        GameRegistry.registerItem(ItemHandler.MaP, "mortar_and_pestle");
        GameRegistry.registerItem(ItemHandler.Flour, "flour");
        GameRegistry.registerItem(ItemHandler.DfD, "dough_for_donuts");
        GameRegistry.registerItem(ItemHandler.Donuts, "donuts");
        GameRegistry.registerItem(ItemHandler.Banana, "banana");
        GameRegistry.registerItem(ItemHandler.FillingDonuts, "filling_donuts");
        GameRegistry.registerItem(ItemHandler.PizzaDough, "pizza_dough");
        GameRegistry.registerItem(ItemHandler.PizzaDoughTomato, "pizza_dough_tomato");
        GameRegistry.registerItem(ItemHandler.Pizza, "pizza");
        GameRegistry.registerItem(ItemHandler.CookedPizza, "cooked_pizza");
        GameRegistry.registerItem(ItemHandler.Ham, "ham");
        GameRegistry.registerItem(ItemHandler.PearYoghurt, "pearyoghurt");
        GameRegistry.registerItem(ItemHandler.MagicHoe, "magic_hoe");
        GameRegistry.registerItem(ItemHandler.DfPancakes, "dough_for_pancakes");
        GameRegistry.registerItem(ItemHandler.Pancakes, "pancakes");
    	GameRegistry.registerItem(ItemHandler.ITreetap, "itreetap");   
    	GameRegistry.registerItem(ItemHandler.SapBucket, "sap_bucket");   
    	GameRegistry.registerItem(ItemHandler.MapleSyrup, "maple_syrup");   
    	GameRegistry.registerItem(ItemHandler.PancakesWithSyrup, "pancakes_with_syrup");   
    	GameRegistry.registerItem(ItemHandler.PancakesWithJam, "pancakes_with_jam");   
    	GameRegistry.registerItem(ItemHandler.Marijuana, "marijuana");   
    	GameRegistry.registerItem(ItemHandler.MarijuanaSeeds, "marijuanaseeds");  
    	GameRegistry.registerItem(ItemHandler.Joint, "joint");  
    	GameRegistry.registerItem(ItemHandler.ItemCombine, "item_combine");  
    	GameRegistry.registerItem(ItemHandler.Wheels, "wheels");  
    	GameRegistry.registerItem(ItemHandler.Headers, "headers");  
    	GameRegistry.registerItem(ItemHandler.Cab, "cab");  
    	GameRegistry.registerItem(ItemHandler.GoatMilkBucket, "goat_milk_bucket");
    	GameRegistry.registerItem(ItemHandler.ItemTractor, "item_tractor");

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
        MinecraftForge.addGrassSeed(new ItemStack(ItemHandler.MarijuanaSeeds), 7);    
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    { 
    	FarmCraft2Recipe.init();  	
    }

    @EventHandler
    public static void PreLoad(FMLPreInitializationEvent PreEvent) {
        proxy.registerTileEntities();
        proxy.preInit();        
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {       
        network_channel = NetworkRegistry.INSTANCE.newSimpleChannel("GROSSIK.FARMCRAFT");
        network_channel.registerMessage(MessageTileEntitySync.Handler.class, MessageTileEntitySync.class, 0, Side.SERVER);
        network_channel.registerMessage(MessageTileEntitySync.Handler.class, MessageTileEntitySync.class, 0, Side.CLIENT);
             
        sounds = new FC2Sounds();
        
        proxy.registerRenderer();
		proxy.preInitRenders();
		proxy.registerEntities();
				
		GameRegistry.register(FC2TreeBiome.setRegistryName(new ResourceLocation(MODID, "FC2TreeBiome")));
		BiomeDictionary.registerBiomeType(FC2TreeBiome, Type.PLAINS, Type.SPOOKY);
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(FC2TreeBiome, 100));
		BiomeManager.addSpawnBiome(FC2TreeBiome);
    	
    	OreDictionary.registerOre("oreCopper", BlockHandler.OreCopper);
    	OreDictionary.registerOre("blockCopper", BlockHandler.BlockCopper);
    	OreDictionary.registerOre("ingotCopper", ItemHandler.ingotCopper);
    	    	
    	GameRegistry.registerWorldGenerator(new WordGen(), 0);

        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new FC2_GuiHandler());
        
        MinecraftForge.EVENT_BUS.register(new FarmCraft2Event());
        
        FMLCommonHandler.instance().bus().register(new FC2VersionEvent());
        
        ConfigHandler.init(event.getSuggestedConfigurationFile());
    }
    
	private static void register(Block block, ItemBlock ib, String name, String unlocal)
	{
		block.setUnlocalizedName(unlocal).setRegistryName(Main.MODID, name);
		ib.setUnlocalizedName(unlocal).setRegistryName(Main.MODID, name);
		GameRegistry.register(block);
		GameRegistry.register(ib);
	}	
	
	private static void register(Block block, ItemBlock ib, String name)
	{
		register(block, ib, name, name);		
	}
	
	private static SoundEvent registerSoundEvent(String name){
		ResourceLocation res = new ResourceLocation(MODID, name);
		SoundEvent evt = new SoundEvent(res).setRegistryName(res);
		GameRegistry.register(evt);
		return evt;
	}
}