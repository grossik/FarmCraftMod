package cz.grossik.farmcraft2.handler;

import cz.grossik.farmcraft2.Main;
import cz.grossik.farmcraft2.backpack.Item_Backpack;
import cz.grossik.farmcraft2.item.ItemBeer;
import cz.grossik.farmcraft2.item.ItemGlassSW;
import cz.grossik.farmcraft2.item.ItemKegBeer;
import cz.grossik.farmcraft2.item.Item_BottleSW;
import cz.grossik.farmcraft2.item.Item_Bucket;
import cz.grossik.farmcraft2.item.Item_Knife;
import cz.grossik.farmcraft2.item.Item_Scarecrow;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlockSpecial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.fluids.FluidContainerRegistry;

public class ItemHandler {

    //Seeds
    public static Item Corn_Seed = new ItemSeeds(BlockHandler.Corn, Blocks.farmland).setUnlocalizedName("Corn_Seed").setCreativeTab(Main.FarmCraft2Tab); 
    public static Item TomatoSeeds = new ItemSeeds(BlockHandler.TomatoBlock, Blocks.farmland).setUnlocalizedName("tomatoseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item RadishSeeds = new ItemSeeds(BlockHandler.RadishBlock, Blocks.farmland).setUnlocalizedName("radishseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item BroccoliSeeds = new ItemSeeds(BlockHandler.BroccoliBlock, Blocks.farmland).setUnlocalizedName("broccoliseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item CucumberSeeds = new ItemSeeds(BlockHandler.CucumberBlock, Blocks.farmland).setUnlocalizedName("cucumberseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item RiceSeeds = new ItemSeeds(BlockHandler.RiceBlock, Blocks.farmland).setUnlocalizedName("riceseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item CapsicumSeeds = new ItemSeeds(BlockHandler.CapsicumBlock, Blocks.farmland).setUnlocalizedName("capsicumseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item CabbageSeeds = new ItemSeeds(BlockHandler.CabbageBlock, Blocks.farmland).setUnlocalizedName("cabbageseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item StrawberrySeeds = new ItemSeeds(BlockHandler.StrawberryBlock, Blocks.farmland).setUnlocalizedName("strawberryseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item HopsSeeds = new ItemSeeds(BlockHandler.HopsBlock, Blocks.farmland).setUnlocalizedName("hopsseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item BarleySeeds = new ItemSeeds(BlockHandler.BarleyBlock, Blocks.farmland).setUnlocalizedName("barleyseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item BlueberrySeeds = new ItemSeeds(BlockHandler.BlueberryBlock, Blocks.farmland).setUnlocalizedName("blueberryseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item PineappleSeeds = new ItemSeeds(BlockHandler.PineappleBlock, Blocks.farmland).setUnlocalizedName("pineappleseeds").setCreativeTab(Main.FarmCraft2Tab);
    public static Item WineSeeds = new ItemSeeds(BlockHandler.WineBlock, Blocks.farmland).setUnlocalizedName("grapeseeds").setCreativeTab(Main.FarmCraft2Tab);
    
    //Food
    public static Item Corn_Item = new ItemFood(2, 0.1F, false).setUnlocalizedName("Corn_Item").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Corn_flakes = new Item().setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("Corn_flakes");
    public static Item Tomato = new ItemFood(3, 3, false).setUnlocalizedName("tomato").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Radish = new ItemFood(2, 3, false).setUnlocalizedName("radish").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Broccoli = new ItemFood(1, 3, false).setUnlocalizedName("broccoli").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Cucumber = new ItemFood(2, 3, false).setUnlocalizedName("cucumber").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Rice = new ItemFood(1, 3, false).setUnlocalizedName("rice").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Capsicum = new ItemFood(2, 3, false).setUnlocalizedName("capsicum").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Cabbage = new ItemFood(1, 3, false).setUnlocalizedName("cabbage").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Strawberry = new ItemFood(2, 3, false).setUnlocalizedName("strawberry").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Pear = new ItemFood(4, 3, false).setUnlocalizedName("pear").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Hops = new ItemFood(1, 3, false).setUnlocalizedName("hops").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Barley = new ItemFood(1, 3, false).setUnlocalizedName("barley").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Blueberry = new ItemFood(2, 3, false).setUnlocalizedName("blueberry").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Pineapple = new ItemFood(4, 3, false).setUnlocalizedName("pineapple").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Cherry = new ItemFood(2, 3, false).setUnlocalizedName("cherry").setCreativeTab(Main.FarmCraft2Tab);
    public static Item slicedCheese = (new ItemFood(1, 0.1F, false)).setUnlocalizedName("slicedcheese").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Toast = (new ItemFood(2, 0.3F, false)).setUnlocalizedName("toast").setCreativeTab(Main.FarmCraft2Tab);
    public static Item BakedToast = (new ItemFood(3, 0.3F, false)).setUnlocalizedName("bakedtoast").setCreativeTab(Main.FarmCraft2Tab);
    public static Item JellyP = (new ItemFood(1, 0.3F, false)).setUnlocalizedName("jellyp").setCreativeTab(Main.FarmCraft2Tab);
    public static Item PearJam = (new ItemFood(2, 0.6F, false)).setUnlocalizedName("pearjam").setCreativeTab(Main.FarmCraft2Tab);
    public static Item AppleJam = (new ItemFood(2, 0.6F, false)).setUnlocalizedName("applejam").setCreativeTab(Main.FarmCraft2Tab);
    public static Item AppleSlice = (new ItemFood(1, 0.1F, false)).setUnlocalizedName("appleslice").setCreativeTab(Main.FarmCraft2Tab);
    public static Item AppleYoghurt = (new ItemFood(4, 0.4F, false)).setUnlocalizedName("appleyoghurt").setCreativeTab(Main.FarmCraft2Tab);
    public static Item ToastWAJ = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("toastwithapplejam").setCreativeTab(Main.FarmCraft2Tab);
    public static Item PearSlice = (new ItemFood(1, 0.1F, false)).setUnlocalizedName("pearslice").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Plum = (new ItemFood(4, 0.3F, false)).setUnlocalizedName("plum").setCreativeTab(Main.FarmCraft2Tab);
    public static Item PlumJam = (new ItemFood(2, 0.6F, false)).setUnlocalizedName("plumjam").setCreativeTab(Main.FarmCraft2Tab);
    public static Item CherryJam = (new ItemFood(2, 0.6F, false)).setUnlocalizedName("cherryjam").setCreativeTab(Main.FarmCraft2Tab);
    public static Item ToastWPearJ = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("toastwithpearjam").setCreativeTab(Main.FarmCraft2Tab);
    public static Item ToastWCherryJ = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("toastwithcherryjam").setCreativeTab(Main.FarmCraft2Tab);
    public static Item ToastWPlumJ = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("toastwithplumjam").setCreativeTab(Main.FarmCraft2Tab);
    public static Item PlumSlice = (new ItemFood(1, 0.1F, false)).setUnlocalizedName("plumslice").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Wine =(new ItemFood(2, 0.3F, false)).setUnlocalizedName("grape").setCreativeTab(Main.FarmCraft2Tab);

    //Zbytek
    public static Item ScarecrowItem = new Item_Scarecrow(BlockHandler.Scarecrow).setUnlocalizedName("scarecrow_item");
    public static Item Salt = new Item().setUnlocalizedName("salt").setCreativeTab(Main.FarmCraft2Tab);
    public static Item CheeseItem = new ItemBlockSpecial(BlockHandler.CheeseBlock).setMaxStackSize(1).setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("cheese");
    public static Item Knife = new Item_Knife().setUnlocalizedName("knife");
    public static Item GlassFJ = new Item().setUnlocalizedName("glass").setCreativeTab(Main.FarmCraft2Tab);
    public static Item ingotCopper = (new Item()).setUnlocalizedName("ingotcopper").setCreativeTab(Main.FarmCraft2Tab);
    public static Item HotWaterBucket = (new Item_Bucket()).setUnlocalizedName("hotwater").setContainerItem(Items.bucket).setCreativeTab(Main.FarmCraft2Tab);
    public static Item AppleCake = (new ItemBlockSpecial(BlockHandler.AppleCakeBlock)).setMaxStackSize(1).setUnlocalizedName("applecake").setCreativeTab(Main.FarmCraft2Tab); 
    
    //Juice
    public static Item StrawberryJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("strawberryjuice").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(ItemHandler.GlassFJ);
    public static Item CarrotJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("carrotjuice").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(ItemHandler.GlassFJ);
    public static Item PearJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("pearjuice").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(ItemHandler.GlassFJ);
    public static Item AppleJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("applejuice").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(ItemHandler.GlassFJ);
    public static Item CherryJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("cherryjuice").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(ItemHandler.GlassFJ);
    public static Item PlumJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("plumjuice").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(ItemHandler.GlassFJ);
    public static Item PineappleJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("pineapplejuice").setCreativeTab(Main.FarmCraft2Tab).setContainerItem(ItemHandler.GlassFJ);
    
    //Beer
    public static Item BucketCurd = new Item_Bucket().setUnlocalizedName("curd").setContainerItem(Items.bucket).setCreativeTab(Main.FarmCraft2Tab);
    public static Item Malt = new Item().setUnlocalizedName("malt").setCreativeTab(Main.FarmCraft2Tab);
    public static Item SoakedBarley = (new Item()).setUnlocalizedName("soakedbarley").setCreativeTab(Main.FarmCraft2Tab);
    public static Item Mash = (new Item().setUnlocalizedName("mash").setCreativeTab(Main.FarmCraft2Tab));
    public static Item Worts = (new Item().setUnlocalizedName("worts").setCreativeTab(Main.FarmCraft2Tab));
    public static Item ColdWorts = (new Item().setUnlocalizedName("coldworts").setCreativeTab(Main.FarmCraft2Tab));
    public static Item Bottle = (new Item()).setUnlocalizedName("bottle").setCreativeTab(Main.FarmCraft2Tab);
    public static Item BeerBottle = (new ItemBeer(4, false)).setUnlocalizedName("beerbottle").setContainerItem(ItemHandler.Bottle).setCreativeTab(Main.FarmCraft2Tab);
    public static Item BeerBucket = (new Item_Bucket()).setUnlocalizedName("hotbeer").setCreativeTab(Main.FarmCraft2Tab);  
    public static Item KegForBeer = new Item().setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("kegforbeer");
    public static Item KegOfBeer = new ItemKegBeer(1000).setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("kegofbeer");

    //Wine
    public static Item FermentedWine = (new Item_Bucket()).setUnlocalizedName("fermentedwine").setCreativeTab(Main.FarmCraft2Tab);
    public static Item GlassFW = (new Item()).setUnlocalizedName("glassfw").setCreativeTab(Main.FarmCraft2Tab);
    public static Item GlassSW = (new ItemGlassSW(2, false)).setUnlocalizedName("glasssw").setCreativeTab(Main.FarmCraft2Tab);  
    public static Item WineBucket = new Item_Bucket().setUnlocalizedName("winebucket").setContainerItem(Items.bucket).setCreativeTab(Main.FarmCraft2Tab);
    public static Item BottleFW = new Item().setUnlocalizedName("bottlefw").setCreativeTab(Main.FarmCraft2Tab); 
    public static Item BottleSW = new Item_BottleSW(2, false).setUnlocalizedName("bottlesw").setCreativeTab(Main.FarmCraft2Tab);
    
    //Backpack
    public static Item backpack = new Item_Backpack().setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("backpack");
}
