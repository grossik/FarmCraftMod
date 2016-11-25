package cz.grossik.farmcraft2;

import cz.grossik.farmcraft2.bottling.RendererBottling;
import cz.grossik.farmcraft2.bottling.TileEntityBottling;
import cz.grossik.farmcraft2.combine.EntityCombine;
import cz.grossik.farmcraft2.combine.RenderCombine;
import cz.grossik.farmcraft2.crushing.RendererCrushing;
import cz.grossik.farmcraft2.crushing.TileEntityCrushing;
import cz.grossik.farmcraft2.easteregg.EntityHomer;
import cz.grossik.farmcraft2.easteregg.RenderHomer;
import cz.grossik.farmcraft2.fermentingbarrel.RendererFermentingBarrel;
import cz.grossik.farmcraft2.fermentingbarrel.TileEntityFermentingBarrel;
import cz.grossik.farmcraft2.flowers.BlockRose;
import cz.grossik.farmcraft2.fluid.FC2Fluid;
import cz.grossik.farmcraft2.goat.EntityGoat;
import cz.grossik.farmcraft2.goat.RenderGoat;
import cz.grossik.farmcraft2.handler.BlockHandler;
import cz.grossik.farmcraft2.handler.ItemHandler;
import cz.grossik.farmcraft2.pan.RendererPan;
import cz.grossik.farmcraft2.pan.TileEntityPan;
import cz.grossik.farmcraft2.spigot.RendererSpigot;
import cz.grossik.farmcraft2.spigot.TileEntitySpigot;
import cz.grossik.farmcraft2.tractor.EntityTractor;
import cz.grossik.farmcraft2.tractor.RenderTractor;
import cz.grossik.farmcraft2.village.ComponentVillageField;
import cz.grossik.farmcraft2.village.ComponentVillagePub;
import cz.grossik.farmcraft2.village.VillageFieldHandler;
import cz.grossik.farmcraft2.village.VillagePubHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class ProxyClient extends ProxyCommon {
	
	public static int nextID = 0;

	static private class SimpleItemMeshDefinition implements ItemMeshDefinition
	  {
	    public final ModelResourceLocation location;
	    
	    public SimpleItemMeshDefinition(ModelResourceLocation location)
	    {
	      this.location = location;
	    }

	    @Override
	    public ModelResourceLocation getModelLocation(ItemStack stack)
	    {
	      return location;
	    }    
	  }
	 
	   public static int nextInternalID()
	    {
	    	nextID++;
	    	return nextID - 1;
	    }
	
    @Override
    public void registerRenderer() {
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFermentingBarrel.class, new RendererFermentingBarrel());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBottling.class, new RendererBottling());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySpigot.class, new RendererSpigot());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrushing.class, new RendererCrushing());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPan.class, new RendererPan());
    	
      	RenderingRegistry.registerEntityRenderingHandler(EntityHomer.class, manager -> new RenderHomer(manager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityCombine.class, manager -> new RenderCombine(manager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGoat.class, manager -> new RenderGoat(manager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityTractor.class, manager -> new RenderTractor(manager));
    }
    
    private void registerFluidModel(Fluid fluid,String name)
    {
      Block block = fluid.getBlock();
      Item item = Item.getItemFromBlock(block);
      ModelBakery.registerItemVariants(item);
      ModelLoader.setCustomMeshDefinition( item, new SimpleItemMeshDefinition(new ModelResourceLocation("farmcraft2:" + name)));
      ModelLoader.setCustomStateMapper(block, (new StateMap.Builder().ignore(BlockFluidBase.LEVEL).build()));
    }
    
    @Override
	public void preInit() {
    	ModelLoader.setCustomStateMapper(BlockHandler.leavesPearNormal, new StateMap.Builder().ignore(new IProperty[] {BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE}).build());
    	ModelLoader.setCustomStateMapper(BlockHandler.leavesPearSH, new StateMap.Builder().ignore(new IProperty[] {BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE}).build());
    	ModelLoader.setCustomStateMapper(BlockHandler.SaplingPear, new StateMap.Builder().ignore(new IProperty[] {BlockSapling.TYPE}).build());
    	ModelLoader.setCustomStateMapper(BlockHandler.leavesCherryNormal, new StateMap.Builder().ignore(new IProperty[] {BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE}).build());
    	ModelLoader.setCustomStateMapper(BlockHandler.leavesCherryST, new StateMap.Builder().ignore(new IProperty[] {BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE}).build());
    	ModelLoader.setCustomStateMapper(BlockHandler.SaplingCherry, new StateMap.Builder().ignore(new IProperty[] {BlockSapling.TYPE}).build());    
    	ModelLoader.setCustomStateMapper(BlockHandler.leavesPlumNormal, new StateMap.Builder().ignore(new IProperty[] {BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE}).build());
    	ModelLoader.setCustomStateMapper(BlockHandler.leavesPlumSS, new StateMap.Builder().ignore(new IProperty[] {BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE}).build());
    	ModelLoader.setCustomStateMapper(BlockHandler.SaplingPlum, new StateMap.Builder().ignore(new IProperty[] {BlockSapling.TYPE}).build());         
    	ModelLoader.setCustomStateMapper(BlockHandler.leavesBananaNormal, new StateMap.Builder().ignore(new IProperty[] {BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE}).build());
    	ModelLoader.setCustomStateMapper(BlockHandler.leavesBananaSB, new StateMap.Builder().ignore(new IProperty[] {BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE}).build());
    	ModelLoader.setCustomStateMapper(BlockHandler.SaplingBanana, new StateMap.Builder().ignore(new IProperty[] {BlockSapling.TYPE}).build());         
    	ModelLoader.setCustomStateMapper(BlockHandler.Rose, (new StateMap.Builder()).withName(BlockRose.VARIANT).ignore(new IProperty[] {BlockRose.FACING}).build());
    	ModelLoader.setCustomStateMapper(BlockHandler.Lily, (new StateMap.Builder()).withName(BlockHandler.Lily.getTypeProperty()).build());
    	ModelLoader.setCustomStateMapper(BlockHandler.SaplingMaple, new StateMap.Builder().ignore(new IProperty[] {BlockSapling.TYPE}).build());         
		ModelLoader.setCustomStateMapper(BlockHandler.MapleLeaves, new StateMap.Builder().ignore(new IProperty[] {BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE}).build());

        VillagerRegistry.instance().registerVillageCreationHandler(new VillageFieldHandler());
        MapGenStructureIO.registerStructureComponent(ComponentVillageField.class, "FieldFC2");
        
        VillagerRegistry.instance().registerVillageCreationHandler(new VillagePubHandler());
        MapGenStructureIO.registerStructureComponent(ComponentVillagePub.class, "PubFC2");        

        registerFluidModel(FC2Fluid.liquid_beer,"liquidBeer");
        
		EntityRegistry.registerModEntity(EntityHomer.class, "homer", nextInternalID(), Main.instance, 48, 3, true, 0xfffc00, 0xffffff);
		EntityRegistry.registerModEntity(EntityCombine.class, "combine", nextInternalID(), Main.instance, 48, 3, false);
		EntityRegistry.registerModEntity(EntityTractor.class, "tractor", nextInternalID(), Main.instance, 48, 3, false);
		EntityRegistry.registerModEntity(EntityGoat.class, "goat", nextInternalID(), Main.instance, 48, 3, true, 0xFFFFFF, 0xC6C6C6);
		
		EntityRegistry.addSpawn(EntityGoat.class, 10, 1, 5, EnumCreatureType.CREATURE, Biomes.PLAINS, Biomes.FOREST, Biomes.EXTREME_HILLS, Biomes.TAIGA, Biomes.SAVANNA);
    }
    
	@Override
	public void preInitRenders()
	{		
		registerRender(Item.getItemFromBlock(BlockHandler.CheeseBlock), "cheeseblock");
        registerRender(Item.getItemFromBlock(BlockHandler.Scarecrow), "scarecrow");
        registerRender(Item.getItemFromBlock(BlockHandler.ScarecrowTop), "scarecrow_top");
        registerRender(Item.getItemFromBlock(BlockHandler.BlockCopper), "blockcopper");
        registerRender(Item.getItemFromBlock(BlockHandler.OreCopper), "orecopper");
        registerRender(Item.getItemFromBlock(BlockHandler.AppleCakeBlock), "applecakeblock");
        registerRender(Item.getItemFromBlock(BlockHandler.juicerOff), "juiceroff");
        registerRender(Item.getItemFromBlock(BlockHandler.juicerOn), "juiceron");
        registerRender(Item.getItemFromBlock(BlockHandler.BottlingOff), "bottlingoff");
        registerRender(Item.getItemFromBlock(BlockHandler.leavesPearNormal), "leavespn");
        registerRender(Item.getItemFromBlock(BlockHandler.SaplingPear), "saplingPear");
        registerRender(Item.getItemFromBlock(BlockHandler.leavesPearSH), "leavespearplne");
        registerRender(Item.getItemFromBlock(BlockHandler.leavesCherryNormal), "leavesCH");
        registerRender(Item.getItemFromBlock(BlockHandler.SaplingCherry), "saplingCherry");
        registerRender(Item.getItemFromBlock(BlockHandler.leavesCherryST), "leavescherryplne");
        registerRender(Item.getItemFromBlock(BlockHandler.leavesPlumNormal), "leavesPL");
        registerRender(Item.getItemFromBlock(BlockHandler.SaplingPlum), "saplingPlum");
        registerRender(Item.getItemFromBlock(BlockHandler.leavesPlumSS), "leavesplumplne");
        registerRender(Item.getItemFromBlock(BlockHandler.spigot), "spigot");
        registerRender(Item.getItemFromBlock(BlockHandler.MashTunOff), "mashtunoff");
        registerRender(Item.getItemFromBlock(BlockHandler.MashTunOn), "mashtunon");
        registerRender(Item.getItemFromBlock(BlockHandler.BoilingOff), "boilingoff");
        registerRender(Item.getItemFromBlock(BlockHandler.BoilingOn), "boilingon");
        registerRender(Item.getItemFromBlock(BlockHandler.FermentingBarrelOff), "fermentingbarreloff");
        registerRender(Item.getItemFromBlock(BlockHandler.CrushingOff), "crushingoff");
        registerRender(Item.getItemFromBlock(BlockHandler.CrushingOn), "crushingon");
        registerRender(Item.getItemFromBlock(BlockHandler.HomerStatue), "statue_homer");
        registerRender(Item.getItemFromBlock(BlockHandler.HomerStatueTop), "statue_homer_top");
        registerRender(Item.getItemFromBlock(BlockHandler.leavesBananaNormal), "leavesbn");
        registerRender(Item.getItemFromBlock(BlockHandler.SaplingBanana), "saplingBanana");
        registerRender(Item.getItemFromBlock(BlockHandler.leavesBananaSB), "leavesbananaplne");     
        registerRender(Item.getItemFromBlock(BlockHandler.Rose), "double_white_rose", 0);
        registerRender(Item.getItemFromBlock(BlockHandler.Rose), "double_pink_rose", 1);
        registerRender(Item.getItemFromBlock(BlockHandler.Rose), "double_blue_rose", 2);
        registerRender(Item.getItemFromBlock(BlockHandler.Rose), "double_black_rose", 3);
        registerRender(Item.getItemFromBlock(BlockHandler.Rose), "double_yellow_rose", 4);
        registerRender(Item.getItemFromBlock(BlockHandler.Rose), "double_purple_rose", 5);
        registerRender(Item.getItemFromBlock(BlockHandler.Pan), "pan");
        registerRender(Item.getItemFromBlock(BlockHandler.MapleLeaves), "maple_leaves");
        registerRender(Item.getItemFromBlock(BlockHandler.SaplingMaple), "saplingMaple");     
        registerRender(Item.getItemFromBlock(BlockHandler.MapleWood), "maple_wood");     
        registerRender(Item.getItemFromBlock(BlockHandler.Treetap), "treetap");     
        registerRender(Item.getItemFromBlock(BlockHandler.Lily), "white_lily", 0);
        registerRender(Item.getItemFromBlock(BlockHandler.Lily), "orange_lily", 1);
        registerRender(Item.getItemFromBlock(BlockHandler.Lily), "blue_lily", 2);

    	//Item\\
        registerRender(ItemHandler.Corn_flakes, "Corn_flakes");
        registerRender(ItemHandler.Corn_Item, "Corn_Item");
        registerRender(ItemHandler.AppleJam, "applejam");
        registerRender(ItemHandler.AppleSlice, "appleslice");
        registerRender(ItemHandler.AppleYoghurt, "appleyoghurt");
        registerRender(ItemHandler.BakedToast, "bakedtoast");
        registerRender(ItemHandler.Barley, "barley");
        registerRender(ItemHandler.Blueberry, "blueberry");
        registerRender(ItemHandler.Broccoli, "broccoli");
        registerRender(ItemHandler.Cabbage, "cabbage");
        registerRender(ItemHandler.Capsicum, "capsicum");
        registerRender(ItemHandler.Cherry, "cherry");
        registerRender(ItemHandler.CherryJam, "cherryjam");
        registerRender(ItemHandler.Cucumber, "cucumber");
        registerRender(ItemHandler.Hops, "hops");
        registerRender(ItemHandler.JellyP, "jellyp");
        registerRender(ItemHandler.Pear, "pear");
        registerRender(ItemHandler.PearJam, "pearjam");
        registerRender(ItemHandler.PearSlice, "pearslice");
        registerRender(ItemHandler.Pineapple, "pineapple");
        registerRender(ItemHandler.Plum, "plum");
        registerRender(ItemHandler.PlumJam, "plumjam");
        registerRender(ItemHandler.PlumSlice, "plumslice");
        registerRender(ItemHandler.Radish, "radish");
        registerRender(ItemHandler.Rice, "rice");
        registerRender(ItemHandler.slicedCheese, "slicedcheese");
        registerRender(ItemHandler.Strawberry, "strawberry");
        registerRender(ItemHandler.Toast, "toast");
        registerRender(ItemHandler.ToastWAJ, "toastwithapplejam");
        registerRender(ItemHandler.ToastWCherryJ, "toastwithcherryjam");
        registerRender(ItemHandler.ToastWPearJ, "toastwithpearjam");
        registerRender(ItemHandler.ToastWPlumJ, "toastwithplumjam");
        registerRender(ItemHandler.Tomato, "tomato");
        registerRender(ItemHandler.Wine, "grape");
        registerRender(ItemHandler.backpack, "backpack");
        registerRender(ItemHandler.Cornflakes_with_milk, "cornlakes_with_milk");
        registerRender(ItemHandler.WineBucket, "winebucket");
        registerRender(ItemHandler.FermentedWine, "fermentedwine");
        registerRender(ItemHandler.StrawberryJam, "strawberryjam");
        registerRender(ItemHandler.ToastWSJ, "toastwithstrawberryjam");
        registerRender(ItemHandler.Salad, "salad");
        registerRender(ItemHandler.Chocolate, "chocolate");
        registerRender(ItemHandler.HotChocolateBucket, "hotchocolatebucket");
        registerRender(ItemHandler.Salt, "salt");
        registerRender(ItemHandler.GlassFJ, "glass");
        registerRender(ItemHandler.ingotCopper, "ingotcopper");
        registerRender(ItemHandler.Knife, "knife");
        registerRender(ItemHandler.CheeseItem, "cheese");
        registerRender(ItemHandler.AppleCake, "applecake");
        registerRender(ItemHandler.HotWaterBucket, "hotwater");
        registerRender(ItemHandler.MaP, "mortar_and_pestle");
        registerRender(ItemHandler.Flour, "flour");
        registerRender(ItemHandler.DfD, "dough_for_donuts");
        registerRender(ItemHandler.Donuts, "donuts");
        registerRender(ItemHandler.Banana, "banana");
        registerRender(ItemHandler.FillingDonuts, "chocolate_donuts", 0);
        registerRender(ItemHandler.FillingDonuts, "strawberry_donuts", 1);
        registerRender(ItemHandler.FillingDonuts, "banana_donuts", 2);
        registerRender(ItemHandler.PizzaDough, "pizza_dough");
        registerRender(ItemHandler.PizzaDoughTomato, "pizza_basic");
        registerRender(ItemHandler.Ham, "ham");        
        registerRender(ItemHandler.Pizza, "pizza_mushroom", 0);
        registerRender(ItemHandler.Pizza, "pizza_cheese", 1);
        registerRender(ItemHandler.Pizza, "pizza_hawai", 2);
        registerRender(ItemHandler.Pizza, "pizza_ham", 3);
        registerRender(ItemHandler.CookedPizza, "cooked_pizza_mushroom", 0);
        registerRender(ItemHandler.CookedPizza, "cooked_pizza_cheese", 1);
        registerRender(ItemHandler.CookedPizza, "cooked_pizza_hawai", 2);
        registerRender(ItemHandler.CookedPizza, "cooked_pizza_ham", 3);
        registerRender(ItemHandler.PearYoghurt, "pearyoghurt");
        registerRender(ItemHandler.MagicHoe, "hoe_magic");
        registerRender(ItemHandler.DfPancakes, "dough_for_pancakes");
        registerRender(ItemHandler.Pancakes, "pancakes");
        registerRender(ItemHandler.ITreetap, "item_treetap");
        registerRender(ItemHandler.SapBucket, "sap_bucket");
        registerRender(ItemHandler.MapleSyrup, "maple_syrup");   
        registerRender(ItemHandler.PancakesWithSyrup, "pancakes_with_syrup");
        registerRender(ItemHandler.PancakesWithJam, "pancakes_with_pear_jam", 0);
        registerRender(ItemHandler.PancakesWithJam, "pancakes_with_strawberry_jam", 1);
        registerRender(ItemHandler.PancakesWithJam, "pancakes_with_apple_jam", 2);
        registerRender(ItemHandler.PancakesWithJam, "pancakes_with_plum_jam", 3);
        registerRender(ItemHandler.PancakesWithJam, "pancakes_with_cherry_jam", 4);
        registerRender(ItemHandler.Marijuana, "marijuana");
        registerRender(ItemHandler.Joint, "joint");
        registerRender(ItemHandler.GoatMilkBucket, "goat_milk_bucket");

        //Seeds
        registerRender(ItemHandler.Corn_Seed, "Corn_Seed");
        registerRender(ItemHandler.BarleySeeds, "barleyseeds");
        registerRender(ItemHandler.BlueberrySeeds, "blueberryseeds");
        registerRender(ItemHandler.BroccoliSeeds, "broccoliseeds");
        registerRender(ItemHandler.CabbageSeeds, "cabbageseeds");
        registerRender(ItemHandler.CapsicumSeeds, "capsicumseeds");
        registerRender(ItemHandler.CucumberSeeds, "cucumberseeds");
        registerRender(ItemHandler.HopsSeeds, "hopsseeds");
        registerRender(ItemHandler.PineappleSeeds, "pineappleseeds");
        registerRender(ItemHandler.RadishSeeds, "radishseeds");
        registerRender(ItemHandler.RiceSeeds, "riceseeds");
        registerRender(ItemHandler.StrawberrySeeds, "strawberryseeds");
        registerRender(ItemHandler.TomatoSeeds, "tomatoseeds");
        registerRender(ItemHandler.WineSeeds, "grapeseeds");	
        registerRender(ItemHandler.MarijuanaSeeds, "marijuanaseeds");	

        //Juice
        registerRender(ItemHandler.AppleJuice, "applejuice");
        registerRender(ItemHandler.CarrotJuice, "carrotjuice");
        registerRender(ItemHandler.CherryJuice, "cherryjuice");
        registerRender(ItemHandler.PearJuice, "pearjuice");
        registerRender(ItemHandler.PineappleJuice, "pineapplejuice");
        registerRender(ItemHandler.PlumJuice, "plumjuice");
        registerRender(ItemHandler.StrawberryJuice, "strawberryjuice");

        //Beer
        registerRender(ItemHandler.Bottle, "bottle");
        registerRender(ItemHandler.BeerBottle, "beerbottle");
        registerRender(ItemHandler.Malt, "malt");
        registerRender(ItemHandler.SoakedBarley, "soakedbarley");
        registerRender(ItemHandler.Mash, "mash");
        registerRender(ItemHandler.Worts, "worts");
        registerRender(ItemHandler.ColdWorts, "coldworts");
        registerRender(ItemHandler.BucketCurd, "curd");
        registerRender(ItemHandler.BeerBucket, "hotbeer");
        registerRender(ItemHandler.KegOfBeer, "kegofbeer");
        
        //Wine
        registerRender(ItemHandler.GlassFW, "glassfw");
        registerRender(ItemHandler.GlassSW, "glasssw");
        registerRender(ItemHandler.BottleFW, "bottlefw");
        registerRender(ItemHandler.BottleSW, "bottlesw");
        
        //Vehicle
        registerRender(ItemHandler.Cab, "cab");
        registerRender(ItemHandler.Wheels, "wheels");
        registerRender(ItemHandler.Headers, "headers");
        registerRender(ItemHandler.ItemTractor, "tractor");
        registerRender(ItemHandler.ItemCombine, "combine");

	}
    
	/**@Override
	public void registerEntities()
	{
		super.registerEntities();
		registerTextured(EntityHomer.class);	
		registerTextureds(EntityCombine.class);	
		registerTexturedGoat(EntityGoat.class);
		registerTexturedTractor(EntityTractor.class);		
	}
	
	public static void registerTextured(Class<? extends EntityHomer> homer)
	{
		RenderingRegistry.registerEntityRenderingHandler(homer, new IRenderFactory<EntityHomer>() 
		{
			@Override
			public Render<? super EntityHomer> createRenderFor(RenderManager manager) 
			{
				return new RenderHomer(manager);
			}
		});
	}
	
	public static void registerTextureds(Class<? extends EntityCombine> golem)
	{		
		RenderingRegistry.registerEntityRenderingHandler(golem, new IRenderFactory<EntityCombine>() 
		{
			@Override
			public Render<? super EntityCombine> createRenderFor(RenderManager manager) 
			{
				return new RenderCombine(manager);
			}
		});
	}
	
	public static void registerTexturedTractor(Class<? extends EntityTractor> homer)
	{
		RenderingRegistry.registerEntityRenderingHandler(homer, new IRenderFactory<EntityTractor>() 
		{
			@Override
			public Render<? super EntityTractor> createRenderFor(RenderManager manager) 
			{
				return new RenderTractor(manager);
			}
		});
	}

	public static void registerTexturedGoat(Class<? extends EntityGoat> homer)
	{
		RenderingRegistry.registerEntityRenderingHandler(homer, new IRenderFactory<EntityGoat>() 
		{
			@Override
			public Render<? super EntityGoat> createRenderFor(RenderManager manager) 
			{
				return new RenderGoat(manager);
			}
		});
	}	**/
	
	private void registerRender(Item i, String name, int... meta)
	{
		if(meta.length < 1) meta = new int[] {0};
		for(int m : meta)
		{
			ModelLoader.setCustomModelResourceLocation(i, m, new ModelResourceLocation(Main.MODID + ":" + name, "inventory"));
		}
	}
}