package cz.grossik.farmcraft2.handler;

import cz.grossik.farmcraft2.Main;
import cz.grossik.farmcraft2.backpack.Item_Backpack;
import cz.grossik.farmcraft2.flowers.ItemBlockLily;
import cz.grossik.farmcraft2.flowers.ItemBlockRose;
import cz.grossik.farmcraft2.item.ItemBeer;
import cz.grossik.farmcraft2.item.ItemCombine;
import cz.grossik.farmcraft2.item.ItemCookedPizza;
import cz.grossik.farmcraft2.item.ItemDonuts;
import cz.grossik.farmcraft2.item.ItemGlassSW;
import cz.grossik.farmcraft2.item.ItemJoint;
import cz.grossik.farmcraft2.item.ItemKegBeer;
import cz.grossik.farmcraft2.item.ItemMaP;
import cz.grossik.farmcraft2.item.ItemMagicHoe;
import cz.grossik.farmcraft2.item.ItemPancakesJam;
import cz.grossik.farmcraft2.item.ItemPizza;
import cz.grossik.farmcraft2.item.ItemSyrup;
import cz.grossik.farmcraft2.item.ItemTractor;
import cz.grossik.farmcraft2.item.Item_BottleSW;
import cz.grossik.farmcraft2.item.Item_Bucket;
import cz.grossik.farmcraft2.item.Item_Knife;
import cz.grossik.farmcraft2.treetap.ItemTreetap;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockSpecial;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;

public class ItemHandler {

    //Seeds
    public static Item Corn_Seed = new ItemSeeds(BlockHandler.Corn, Blocks.FARMLAND).setUnlocalizedName("Corn_Seed").setCreativeTab(Main.FarmCraft2Tab); 
    public static Item TomatoSeeds = new ItemSeeds(BlockHandler.TomatoBlock, Blocks.FARMLAND).setUnlocalizedName("tomatoseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item RadishSeeds = new ItemSeeds(BlockHandler.RadishBlock, Blocks.FARMLAND).setUnlocalizedName("radishseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item BroccoliSeeds = new ItemSeeds(BlockHandler.BroccoliBlock, Blocks.FARMLAND).setUnlocalizedName("broccoliseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item CucumberSeeds = new ItemSeeds(BlockHandler.CucumberBlock, Blocks.FARMLAND).setUnlocalizedName("cucumberseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item RiceSeeds = new ItemSeeds(BlockHandler.RiceBlock, Blocks.FARMLAND).setUnlocalizedName("riceseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item CapsicumSeeds = new ItemSeeds(BlockHandler.CapsicumBlock, Blocks.FARMLAND).setUnlocalizedName("capsicumseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item CabbageSeeds = new ItemSeeds(BlockHandler.CabbageBlock, Blocks.FARMLAND).setUnlocalizedName("cabbageseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item StrawberrySeeds = new ItemSeeds(BlockHandler.StrawberryBlock, Blocks.FARMLAND).setUnlocalizedName("strawberryseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item HopsSeeds = new ItemSeeds(BlockHandler.HopsBlock, Blocks.FARMLAND).setUnlocalizedName("hopsseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item BarleySeeds = new ItemSeeds(BlockHandler.BarleyBlock, Blocks.FARMLAND).setUnlocalizedName("barleyseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item BlueberrySeeds = new ItemSeeds(BlockHandler.BlueberryBlock, Blocks.FARMLAND).setUnlocalizedName("blueberryseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item PineappleSeeds = new ItemSeeds(BlockHandler.PineappleBlock, Blocks.FARMLAND).setUnlocalizedName("pineappleseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item WineSeeds = new ItemSeeds(BlockHandler.WineBlock, Blocks.FARMLAND).setUnlocalizedName("grapeseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item MarijuanaSeeds = new ItemSeeds(BlockHandler.MarijuanaBlock, Blocks.FARMLAND).setUnlocalizedName("marijuanaseeds").setCreativeTab(Main.FarmCraft2Tab);

    //Food
    public static Item Corn_Item = new ItemFood(2, 0.1F, false).setUnlocalizedName("Corn_Item").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Cornflakes_with_milk = new ItemFood(5, 0.3F, false).setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("cornlakes_with_milk").setContainerItem(Items.BOWL);
    public static Item Tomato = new ItemFood(3, 3, false).setUnlocalizedName("tomato").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Radish = new ItemFood(2, 3, false).setUnlocalizedName("radish").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Broccoli = new ItemFood(1, 3, false).setUnlocalizedName("broccoli").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Cucumber = new ItemFood(2, 3, false).setUnlocalizedName("cucumber").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Rice = new ItemFood(1, 3, false).setUnlocalizedName("rice").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Capsicum = new ItemFood(2, 3, false).setUnlocalizedName("capsicum").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Cabbage = new ItemFood(2, 3, false).setUnlocalizedName("cabbage").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Strawberry = new ItemFood(2, 3, false).setUnlocalizedName("strawberry").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Pear = new ItemFood(3, 3, false).setUnlocalizedName("pear").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Hops = new ItemFood(1, 3, false).setUnlocalizedName("hops").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Barley = new ItemFood(1, 3, false).setUnlocalizedName("barley").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Blueberry = new ItemFood(2, 3, false).setUnlocalizedName("blueberry").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Pineapple = new ItemFood(3, 3, false).setUnlocalizedName("pineapple").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Cherry = new ItemFood(2, 3, false).setUnlocalizedName("cherry").setCreativeTab(Main.FarmCraft2Tab);
    public static Item slicedCheese = (new ItemFood(1, 0.1F, false)).setUnlocalizedName("slicedcheese").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Toast = (new ItemFood(2, 0.3F, false)).setUnlocalizedName("toast").setCreativeTab(Main.FarmCraft2Tab);
    public static Item BakedToast = (new ItemFood(3, 0.3F, false)).setUnlocalizedName("bakedtoast").setCreativeTab(Main.FarmCraft2Tab);
    public static Item JellyP = (new ItemFood(1, 0.3F, false)).setUnlocalizedName("jellyp").setCreativeTab(Main.FarmCraft2Tab);
    public static Item PearJam = (new ItemFood(2, 0.6F, false)).setUnlocalizedName("pearjam").setCreativeTab(Main.FarmCraft2Tab);
    public static Item AppleJam = (new ItemFood(2, 0.6F, false)).setUnlocalizedName("applejam").setCreativeTab(Main.FarmCraft2Tab);
    public static Item AppleSlice = (new ItemFood(1, 0.1F, false)).setUnlocalizedName("appleslice").setCreativeTab(Main.FarmCraft2Tab);
    public static Item AppleYoghurt = (new ItemFood(4, 0.4F, false)).setUnlocalizedName("appleyoghurt").setCreativeTab(Main.FarmCraft2Tab);
    public static Item PearYoghurt = (new ItemFood(4, 0.4F, false)).setUnlocalizedName("pearyoghurt").setCreativeTab(Main.FarmCraft2Tab);
    public static Item ToastWAJ = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("toastwithapplejam").setCreativeTab(Main.FarmCraft2Tab);
    public static Item PearSlice = (new ItemFood(1, 0.1F, false)).setUnlocalizedName("pearslice").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Plum = (new ItemFood(3, 0.3F, false)).setUnlocalizedName("plum").setCreativeTab(Main.FarmCraft2Tab);
    public static Item PlumJam = (new ItemFood(2, 0.6F, false)).setUnlocalizedName("plumjam").setCreativeTab(Main.FarmCraft2Tab);
    public static Item CherryJam = (new ItemFood(2, 0.6F, false)).setUnlocalizedName("cherryjam").setCreativeTab(Main.FarmCraft2Tab);
    public static Item ToastWPearJ = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("toastwithpearjam").setCreativeTab(Main.FarmCraft2Tab);
    public static Item ToastWCherryJ = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("toastwithcherryjam").setCreativeTab(Main.FarmCraft2Tab);
    public static Item ToastWPlumJ = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("toastwithplumjam").setCreativeTab(Main.FarmCraft2Tab);
    public static Item PlumSlice = (new ItemFood(1, 0.1F, false)).setUnlocalizedName("plumslice").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Wine =(new ItemFood(2, 0.3F, false)).setUnlocalizedName("grape").setCreativeTab(Main.FarmCraft2Tab);
    public static Item StrawberryJam = (new ItemFood(2, 0.6F, false)).setUnlocalizedName("strawberryjam").setCreativeTab(Main.FarmCraft2Tab);
    public static Item ToastWSJ = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("toastwithstrawberryjam").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Salad = (new ItemFood(6, false)).setUnlocalizedName("salad").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(Items.BOWL);
    public static Item Chocolate = (new ItemFood(3, false)).setUnlocalizedName("chocolate").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Donuts = (new ItemFood(3, false)).setUnlocalizedName("donuts").setCreativeTab(Main.FarmCraft2Tab);
    public static Item FillingDonuts = (new ItemDonuts(6, false)).setUnlocalizedName("filling_donuts").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Banana = (new ItemFood(2, 0.3F, false)).setUnlocalizedName("banana").setCreativeTab(Main.FarmCraft2Tab);
    public static Item CookedPizza = new ItemCookedPizza(8, false).setUnlocalizedName("cooked_pizza").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Ham = new ItemFood(3, true).setUnlocalizedName("ham").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Pancakes = new ItemFood(4, false).setUnlocalizedName("pancakes").setCreativeTab(Main.FarmCraft2Tab);
    public static Item MapleSyrup = new ItemSyrup(1, false).setUnlocalizedName("maple_syrup").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(Items.BUCKET);
    public static Item PancakesWithSyrup = new ItemFood(5, false).setUnlocalizedName("pancakes_with_syrup").setCreativeTab(Main.FarmCraft2Tab);
    public static Item PancakesWithJam = new ItemPancakesJam(6, false).setUnlocalizedName("pancakes_with_jam").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Joint = new ItemJoint(0, false).setUnlocalizedName("joint").setCreativeTab(Main.FarmCraft2Tab);
    
    //Zbytek
    public static Item Salt = new Item().setUnlocalizedName("salt").setCreativeTab(Main.FarmCraft2Tab);
    public static Item CheeseItem = new ItemBlockSpecial(BlockHandler.CheeseBlock).setMaxStackSize(1).setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("cheese");
    public static Item Knife = new Item_Knife().setUnlocalizedName("knife");
    public static Item GlassFJ = new Item().setUnlocalizedName("glass").setCreativeTab(Main.FarmCraft2Tab);
    public static Item ingotCopper = (new Item()).setUnlocalizedName("ingotcopper").setCreativeTab(Main.FarmCraft2Tab);
    public static Item HotWaterBucket = (new Item_Bucket()).setUnlocalizedName("hotwater").setContainerItem(Items.BUCKET).setCreativeTab(Main.FarmCraft2Tab);
    public static Item AppleCake = (new ItemBlockSpecial(BlockHandler.AppleCakeBlock)).setMaxStackSize(1).setUnlocalizedName("applecake").setCreativeTab(Main.FarmCraft2Tab); 
    public static Item Corn_flakes = new Item().setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("Corn_flakes");
    public static Item HotChocolateBucket = (new Item_Bucket()).setUnlocalizedName("hotchocolatebucket").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(Items.BUCKET);
    public static Item MaP = new ItemMaP().setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("mortar_and_pestle");
    public static Item Flour = new Item().setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("flour");
    public static Item DfD = new Item().setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("dough_for_donuts");
    public static Item PizzaDough = new Item().setUnlocalizedName("pizza_dough").setCreativeTab(Main.FarmCraft2Tab);
    public static Item PizzaDoughTomato = new Item().setUnlocalizedName("pizza_dough_tomato").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Pizza = new ItemPizza().setUnlocalizedName("pizza").setCreativeTab(Main.FarmCraft2Tab);
    public static Item MagicHoe = new ItemMagicHoe(ToolMaterial.DIAMOND).setUnlocalizedName("magic_hoe").setCreativeTab(Main.FarmCraft2Tab);
    public static Item DfPancakes = new Item().setUnlocalizedName("dough_for_pancakes").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(Items.BOWL);
    public static Item ITreetap = new ItemTreetap().setUnlocalizedName("itreetap");
    public static Item SapBucket = new Item_Bucket().setUnlocalizedName("sap_bucket").setContainerItem(Items.BUCKET);
    public static Item Marijuana = new Item().setUnlocalizedName("marijuana").setCreativeTab(Main.FarmCraft2Tab);
    public static Item GoatMilkBucket = new ItemBucketMilk().setUnlocalizedName("goat_milk_bucket").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(Items.BUCKET);
    
    //Combine and Tractor
    public static Item ItemCombine = new ItemCombine().setUnlocalizedName("item_combine");
    public static Item Wheels = new Item().setUnlocalizedName("wheels").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Headers = new Item().setUnlocalizedName("headers").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Cab = new Item().setUnlocalizedName("cab").setCreativeTab(Main.FarmCraft2Tab);
    public static Item ItemTractor = new ItemTractor().setUnlocalizedName("item_tractor");
    
    //Juice
    public static Item StrawberryJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("strawberryjuice").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(ItemHandler.GlassFJ);
    public static Item CarrotJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("carrotjuice").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(ItemHandler.GlassFJ);
    public static Item PearJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("pearjuice").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(ItemHandler.GlassFJ);
    public static Item AppleJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("applejuice").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(ItemHandler.GlassFJ);
    public static Item CherryJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("cherryjuice").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(ItemHandler.GlassFJ);
    public static Item PlumJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("plumjuice").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(ItemHandler.GlassFJ);
    public static Item PineappleJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("pineapplejuice").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(ItemHandler.GlassFJ);
    
    //Beer
    public static Item BucketCurd = new Item_Bucket().setUnlocalizedName("curd").setContainerItem(Items.BUCKET).setCreativeTab(Main.FarmCraft2Tab);
    public static Item Malt = new Item().setUnlocalizedName("malt").setCreativeTab(Main.FarmCraft2Tab);
    public static Item SoakedBarley = (new Item()).setUnlocalizedName("soakedbarley").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Mash = (new Item().setUnlocalizedName("mash").setCreativeTab(Main.FarmCraft2Tab));
    public static Item Worts = (new Item().setUnlocalizedName("worts").setCreativeTab(Main.FarmCraft2Tab));
    public static Item ColdWorts = (new Item().setUnlocalizedName("coldworts").setCreativeTab(Main.FarmCraft2Tab));
    public static Item Bottle = (new Item()).setUnlocalizedName("bottle").setCreativeTab(Main.FarmCraft2Tab);
    public static Item BeerBottle = (new ItemBeer(3, false)).setUnlocalizedName("beerbottle").setContainerItem(ItemHandler.Bottle).setCreativeTab(Main.FarmCraft2Tab);
    public static Item BeerBucket = (new Item_Bucket()).setUnlocalizedName("hotbeer").setCreativeTab(Main.FarmCraft2Tab);  
    public static Item KegOfBeer = new ItemKegBeer(1000).setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("kegofbeer");

    //Wine
    public static Item FermentedWine = (new Item_Bucket()).setUnlocalizedName("fermentedwine").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(Items.BUCKET);
    public static Item GlassFW = (new Item()).setUnlocalizedName("glassfw").setCreativeTab(Main.FarmCraft2Tab);
    public static Item GlassSW = (new ItemGlassSW(3, false)).setUnlocalizedName("glasssw").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(GlassFW);  
    public static Item WineBucket = new Item_Bucket().setUnlocalizedName("winebucket").setMaxStackSize(1).setContainerItem(Items.BUCKET).setCreativeTab(Main.FarmCraft2Tab);
    public static Item BottleFW = new Item().setUnlocalizedName("bottlefw").setCreativeTab(Main.FarmCraft2Tab); 
    public static Item BottleSW = new Item_BottleSW(9, false).setUnlocalizedName("bottlesw").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(BottleFW);
    
    //Backpack
    public static Item backpack = new Item_Backpack().setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("backpack");
    
	public static ItemBlock ItemBlockRose = new ItemBlockRose(BlockHandler.Rose);
	public static ItemBlock ItemBlockLily = new ItemBlockLily(BlockHandler.Lily);
}