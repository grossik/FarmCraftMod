package cz.grossik.farmcraft.handler;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemReed;
import net.minecraftforge.common.config.Configuration;
import cz.grossik.farmcraft.FarmCraft;
import cz.grossik.farmcraft.item.FC_Item;
import cz.grossik.farmcraft.item.Item_Bucket;
import cz.grossik.farmcraft.item.Item_Cheese;
import cz.grossik.farmcraft.item.Item_Scarecrow;
import cz.grossik.farmcraft.item.Item_Seeds;

public class ItemHandler {

    public static String itemids = "Item IDs";

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
    //Juice
    public static Item StrawberryJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("strawberryjuice").setCreativeTab(FarmCraft.FarmCraftTab).setContainerItem(ItemHandler.Glass).setTextureName("farmcraft:juice_strawberry");
    public static Item CarrotJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("carrotjuice").setCreativeTab(FarmCraft.FarmCraftTab).setContainerItem(ItemHandler.Glass).setTextureName("farmcraft:juice_carrot");
    public static Item PearJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("pearjuice").setCreativeTab(FarmCraft.FarmCraftTab).setContainerItem(ItemHandler.Glass).setTextureName("farmcraft:juice_pear");
    public static Item AppleJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("applejuice").setCreativeTab(FarmCraft.FarmCraftTab).setContainerItem(ItemHandler.Glass).setTextureName("farmcraft:juice_apple");
    public static Item CherryJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("cherryjuice").setCreativeTab(FarmCraft.FarmCraftTab).setContainerItem(ItemHandler.Glass).setTextureName("farmcraft:juice_cherry");
    public static Item PlumJuice = (new ItemFood(5, 0.4F, false)).setUnlocalizedName("plumjuice").setCreativeTab(FarmCraft.FarmCraftTab).setContainerItem(ItemHandler.Glass).setTextureName("farmcraft:juice_plum");
    public static Item ingotCopper = (new FC_Item()).setUnlocalizedName("ingotcopper").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:ingot_copper");
    public static Item HotWaterBucket = (new Item_Bucket()).setUnlocalizedName("hotwater").setContainerItem(Items.bucket).setTextureName("farmcraft:bucket_hotwater");
    public static Item AppleCake = (new ItemReed(BlockHandler.AppleCakeBlock)).setMaxStackSize(1).setUnlocalizedName("applecake").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:apple_cake");


    //Beer
    public static Item BucketCurd = new Item_Bucket().setUnlocalizedName("curd").setContainerItem(Items.bucket).setTextureName("farmcraft:bucket_curd");
    public static Item Malt = new FC_Item().setUnlocalizedName("malt").setTextureName("farmcraft:malt");
    public static Item SoakedBarley = (new FC_Item()).setUnlocalizedName("soakedbarley").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:soaked_barley");
    public static Item Mash = (new FC_Item().setUnlocalizedName("mash").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:mash"));
    public static Item Worts = (new FC_Item().setUnlocalizedName("worts").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:worts"));
    public static Item ColdWorts = (new FC_Item().setUnlocalizedName("coldworts").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:cold_worts"));
    public static Item Bottle = (new FC_Item()).setUnlocalizedName("bottle").setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:bottle_nobeer");
    public static Item BeerBottle = (new ItemFood(4, 0.3F, false)).setUnlocalizedName("beerbottle").setContainerItem(ItemHandler.Bottle).setCreativeTab(FarmCraft.FarmCraftTab).setTextureName("farmcraft:bottle_beer");


    public static void configureItemIDs(Configuration config) {


    }
}
