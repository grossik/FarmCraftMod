package cz.grossik.farmcraft2;

import cz.grossik.farmcraft2.bottling.BottlingRecipeManager;
import cz.grossik.farmcraft2.bottling.ItemStackMatcher;
import cz.grossik.farmcraft2.fluid.FC2Fluid;
import cz.grossik.farmcraft2.handler.BlockHandler;
import cz.grossik.farmcraft2.handler.ItemHandler;
import cz.grossik.farmcraft2.item.ItemPizza;
import cz.grossik.farmcraft2.spigot.SpigotRecipeManager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class FarmCraft2Recipe{
	
	  public static void init()
	  {
	    //Smelting
	    GameRegistry.addSmelting(Items.MILK_BUCKET, new ItemStack(ItemHandler.BucketCurd, 1), 2);
	    GameRegistry.addSmelting(BlockHandler.OreCopper, new ItemStack(ItemHandler.ingotCopper, 1), 2);
	    GameRegistry.addSmelting(ItemHandler.SoakedBarley, new ItemStack(ItemHandler.Malt, 1), 1);
	    GameRegistry.addSmelting(Items.WATER_BUCKET, new ItemStack(ItemHandler.HotWaterBucket, 1), 2);
	    GameRegistry.addSmelting(ItemHandler.Toast, new ItemStack(ItemHandler.BakedToast, 1), 2);
	    GameRegistry.addSmelting(ItemHandler.HotWaterBucket, new ItemStack(ItemHandler.Salt, 3), 1);
	    GameRegistry.addSmelting(ItemHandler.Chocolate, new ItemStack(ItemHandler.HotChocolateBucket, 1), 2);
	    GameRegistry.addSmelting(ItemHandler.DfD, new ItemStack(ItemHandler.Donuts, 1), 2);
	    GameRegistry.addSmelting(ItemHandler.SapBucket, new ItemStack(ItemHandler.MapleSyrup, 1), 1);
	    GameRegistry.addSmelting(BlockHandler.MapleWood, new ItemStack(Items.COAL, 1, 1), 1);

	    GameRegistry.addSmelting(new ItemStack(ItemHandler.Pizza, 1, 0), new ItemStack(ItemHandler.CookedPizza, 1, 0), 2);
	    GameRegistry.addSmelting(new ItemStack(ItemHandler.Pizza, 1, 1), new ItemStack(ItemHandler.CookedPizza, 1, 1), 2);
	    GameRegistry.addSmelting(new ItemStack(ItemHandler.Pizza, 1, 2), new ItemStack(ItemHandler.CookedPizza, 1, 2), 2);
	    GameRegistry.addSmelting(new ItemStack(ItemHandler.Pizza, 1, 3), new ItemStack(ItemHandler.CookedPizza, 1, 3), 2);

	    //Recepty
	    GameRegistry.addRecipe(new ItemStack(BlockHandler.Scarecrow, 1), new Object[]{" U ", "AXA", " A ", 'A', Items.STICK, 'X', Items.WHEAT, 'U', Blocks.PUMPKIN});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.TomatoSeeds, 1), new Object[]{"X", 'X', ItemHandler.Tomato});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.RadishSeeds, 1), new Object[]{"X", 'X', ItemHandler.Radish});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.BroccoliSeeds, 1), new Object[]{"X", 'X', ItemHandler.Broccoli});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.CucumberSeeds, 1), new Object[]{"X", 'X', ItemHandler.Cucumber});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.RiceSeeds, 1), new Object[]{"X", 'X', ItemHandler.Rice});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.CapsicumSeeds, 1), new Object[]{"X", 'X', ItemHandler.Capsicum});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.Knife, 1), new Object[]{"AAX", 'A', Items.IRON_INGOT, 'X', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.GlassFJ, 1), new Object[]{"X X", "XXX", 'X', Blocks.GLASS_PANE});
	    GameRegistry.addRecipe(new ItemStack(BlockHandler.juicerOff, 1), new Object[]{"XXX", "XAX", "XYX", 'A', Items.FLINT, 'X', Blocks.COBBLESTONE, 'Y', Items.REDSTONE});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.StrawberrySeeds, 1), new Object[]{"X", 'X', ItemHandler.Strawberry});
	    GameRegistry.addRecipe(new ItemStack(BlockHandler.SaplingPear, 1), new Object[]{"HS", 'H', ItemHandler.Pear, 'S', new ItemStack(Blocks.SAPLING, 1, 0)});
	    GameRegistry.addRecipe(new ItemStack(BlockHandler.SaplingCherry, 1), new Object[]{"TS", 'T', ItemHandler.Cherry, 'S', new ItemStack(Blocks.SAPLING, 1, 0)});
	    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockHandler.BlockCopper, 1), new Object[]{"XXX", "XXX", "XXX", 'X', "ingotCopper"}));
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.SoakedBarley, 8), new Object[]{"XXX", "XYX", "XXX", 'X', ItemHandler.Barley, 'Y', Items.WATER_BUCKET});
	    GameRegistry.addRecipe(new ItemStack(BlockHandler.MashTunOff, 1), new Object[]{"XXX", "XYX", "XXX", 'X', Items.IRON_INGOT, 'Y', ItemHandler.Malt});
	    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockHandler.BoilingOff, 1), new Object[]{"XXX", "XYX", "XXX", 'X', "ingotCopper", 'Y', ItemHandler.Hops}));
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.Bottle, 8), new Object[]{"X X", "XYX", "XXX", 'X', Blocks.GLASS, 'Y', ItemHandler.Hops});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.BlueberrySeeds, 1), new Object[]{"X", 'X', ItemHandler.Blueberry});
	    GameRegistry.addRecipe(new ItemStack(BlockHandler.BottlingOff, 1), new Object[]{"PPP", "P#P", "PXP", 'P', Items.IRON_INGOT, '#', Blocks.LEVER, 'X', Blocks.GLASS});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.ColdWorts, 1), new Object[]{"X", 'X', ItemHandler.Worts});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.JellyP, 1), new Object[]{"X", 'X', Items.SUGAR});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.PearJam, 1), new Object[]{"YX", 'Y', ItemHandler.JellyP, 'X', ItemHandler.Pear});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.AppleJam, 1), new Object[]{"YX", 'Y', ItemHandler.JellyP, 'X', Items.APPLE});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.AppleCake, 1), new Object[]{" E ", "BAB", "CCC", 'A', Items.MILK_BUCKET, 'B', Items.SUGAR, 'C', Items.WHEAT, 'E', ItemHandler.AppleJam});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.AppleYoghurt, 1), new Object[]{" E ", " E ", " C ", 'C', Items.MILK_BUCKET, 'E', ItemHandler.AppleSlice});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.PlumJam, 1), new Object[]{"YX", 'Y', ItemHandler.JellyP, 'X', ItemHandler.Plum});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.StrawberryJam, 1), new Object[]{"YX", 'Y', ItemHandler.JellyP, 'X', ItemHandler.Strawberry});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.CherryJam, 1), new Object[]{"YX", 'Y', ItemHandler.JellyP, 'X', ItemHandler.Cherry});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.PineappleSeeds, 1), new Object[]{"X", 'X', ItemHandler.Pineapple});
	    GameRegistry.addRecipe(new ItemStack(BlockHandler.SaplingPlum, 1), new Object[]{"TS", 'T', ItemHandler.Plum, 'S', new ItemStack(Blocks.SAPLING, 1, 0)});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.HopsSeeds, 1), new Object[]{"X", 'X', ItemHandler.Hops});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.MarijuanaSeeds, 1), new Object[]{"X", 'X', ItemHandler.Marijuana});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.CabbageSeeds, 1), new Object[]{"X", 'X', ItemHandler.Cabbage});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.BarleySeeds, 1), new Object[]{"X", 'X', ItemHandler.Barley});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.ingotCopper, 9), new Object[]{"X", 'X', BlockHandler.BlockCopper});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.backpack, 1), new Object[]{"TTT", "TST", "TYT", 'T', Items.LEATHER, 'S', Blocks.CHEST, 'Y', Items.ENDER_EYE});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.WineSeeds, 1), new Object[]{"X", 'X', ItemHandler.Wine});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.GlassFW, 1), new Object[]{"X X", " X " , 'X', Blocks.GLASS_PANE});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.GlassSW, 1), new Object[]{"Y", "X" , 'X', ItemHandler.GlassFW, 'Y', new ItemStack(ItemHandler.BottleSW, 1, OreDictionary.WILDCARD_VALUE)});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.BottleFW, 1), new Object[]{" X ", "X X", "XXX" , 'X', new ItemStack(Blocks.STAINED_GLASS, 1, 13)});
	    GameRegistry.addRecipe(new ItemStack(BlockHandler.FermentingBarrelOff, 1), new Object[]{"XXX", "YXY", "XXX", 'Y', Items.IRON_INGOT, 'X', Blocks.PLANKS});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.KegOfBeer, 1), new Object[]{"XXX", "X X", "XXX" , 'X', new ItemStack(Items.IRON_INGOT)});
	    GameRegistry.addRecipe(new ItemStack(BlockHandler.CrushingOff, 1), new Object[]{"XXX", "XYX", "X X" , 'X', new ItemStack(Items.IRON_INGOT), 'Y', new ItemStack(Blocks.PISTON)});
	    GameRegistry.addRecipe(new ItemStack(BlockHandler.spigot, 1), new Object[]{"YXX", " XX", "ZXX" , 'X', new ItemStack(Items.IRON_INGOT), 'Y', new ItemStack(Items.STICK), 'Z', new ItemStack(Blocks.COBBLESTONE)});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.Cornflakes_with_milk, 1), new Object[]{"Y", "X", "Z" , 'X', new ItemStack(Items.MILK_BUCKET), 'Y', new ItemStack(ItemHandler.Corn_flakes), 'Z', new ItemStack(Items.BOWL)});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.Corn_Seed, 1), new Object[]{"X", 'X', ItemHandler.Corn_Item});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.Corn_flakes, 2), new Object[]{"XX", "XX", 'X', ItemHandler.Corn_Item});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.MaP, 1), new Object[]{"XYX", " X " , 'X', new ItemStack(Blocks.COBBLESTONE), 'Y', new ItemStack(Items.STICK)});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.DfD, 1), new Object[]{"XXX", "ZYZ" , 'X', new ItemStack(Items.SUGAR), 'Y', new ItemStack(ItemHandler.Flour), 'Z', new ItemStack(Items.EGG)});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.FillingDonuts, 1, 0), new Object[]{"TST", 'T', ItemHandler.HotChocolateBucket, 'S', ItemHandler.Donuts});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.FillingDonuts, 1, 1), new Object[]{"TST", 'T', ItemHandler.Strawberry, 'S', ItemHandler.Donuts});
	    GameRegistry.addRecipe(new ItemStack(BlockHandler.SaplingBanana, 1), new Object[]{"HS", 'H', ItemHandler.Banana, 'S', new ItemStack(Blocks.SAPLING, 1, 3)});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.FillingDonuts, 1, 2), new Object[]{"TST", 'T', ItemHandler.Banana, 'S', ItemHandler.Donuts});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.PearYoghurt, 1), new Object[]{" E ", " E ", " C ", 'C', Items.MILK_BUCKET, 'E', ItemHandler.PearSlice});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.MagicHoe, 1), new Object[]{"EEE", " C ", 'C', Items.DIAMOND_HOE, 'E', Items.REDSTONE});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.DfPancakes, 1), new Object[]{"XYZ", "CV", 'X', new ItemStack(Items.SUGAR), 'Y', new ItemStack(ItemHandler.Flour), 'Z', new ItemStack(Items.EGG), 'C', new ItemStack(Items.MILK_BUCKET), 'V', new ItemStack(Items.BOWL)});
	    GameRegistry.addRecipe(new ItemStack(BlockHandler.Pan, 1), new Object[]{"XXX", "XXX", "ZYS" , 'X', new ItemStack(Items.IRON_INGOT), 'Y', new ItemStack(Items.STICK), 'Z', new ItemStack(Items.FLINT_AND_STEEL), 'S', new ItemStack(Blocks.STONE, 1, 0)});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.ITreetap, 1), new Object[]{"XXX", "  X", "YYY" , 'X', new ItemStack(Items.IRON_INGOT), 'Y', new ItemStack(Blocks.PLANKS)});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.Joint, 1), new Object[]{"XXX", "YYY", "XXX" , 'X', new ItemStack(Items.PAPER), 'Y', new ItemStack(ItemHandler.Marijuana)});
	    
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.Headers, 1), new Object[]{"X  ", "XYY", "X  " , 'X', new ItemStack(Items.DIAMOND), 'Y', new ItemStack(Items.IRON_INGOT)});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.Wheels, 1), new Object[]{" X ", "XYX", " X " , 'X', new ItemStack(Items.COAL), 'Y', new ItemStack(Items.IRON_INGOT)});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.Cab, 1), new Object[]{"XXX", "X Y", "XYY" , 'X', new ItemStack(Blocks.IRON_BLOCK), 'Y', new ItemStack(Blocks.WOOL)});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.ItemCombine, 1), new Object[]{" XV", " VB", "CYY" , 'X', new ItemStack(ItemHandler.Cab), 'Y', new ItemStack(ItemHandler.Wheels), 'C', new ItemStack(ItemHandler.Headers), 'V', new ItemStack(Blocks.IRON_BLOCK), 'B', new ItemStack(Blocks.COAL_BLOCK)});
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.ItemTractor, 1), new Object[]{" XV", "VVB", "VYY" , 'X', new ItemStack(ItemHandler.Cab), 'Y', new ItemStack(ItemHandler.Wheels), 'V', new ItemStack(Blocks.IRON_BLOCK), 'B', new ItemStack(Blocks.COAL_BLOCK)});

	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.Flour, 1), new ItemStack(ItemHandler.MaP, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.WHEAT));

	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.ToastWPearJ, 1), new ItemStack(ItemHandler.BakedToast), new ItemStack(ItemHandler.PearJam));
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.ToastWCherryJ, 1), new ItemStack(ItemHandler.BakedToast), new ItemStack(ItemHandler.CherryJam));
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.ToastWPlumJ, 1), new ItemStack(ItemHandler.BakedToast), new ItemStack(ItemHandler.PlumJam));
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.ToastWAJ, 1), new ItemStack(ItemHandler.BakedToast), new ItemStack(ItemHandler.AppleJam));
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.CheeseItem, 1), new ItemStack(ItemHandler.Salt), new ItemStack(ItemHandler.BucketCurd), new ItemStack(ItemHandler.BucketCurd), new ItemStack(ItemHandler.BucketCurd));
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.ToastWSJ, 1), new ItemStack(ItemHandler.BakedToast), new ItemStack(ItemHandler.StrawberryJam));
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.Salad, 1), new ItemStack(ItemHandler.Cucumber), new ItemStack(ItemHandler.Capsicum), new ItemStack(ItemHandler.Tomato), new ItemStack(ItemHandler.slicedCheese), new ItemStack(Items.BOWL));
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.Chocolate, 1), new ItemStack(Items.DYE, 1, 3), new ItemStack(Items.MILK_BUCKET), new ItemStack(Items.SUGAR));
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.PizzaDough, 1), new ItemStack(ItemHandler.Flour), new ItemStack(ItemHandler.Salt), new ItemStack(Items.WATER_BUCKET));
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.PizzaDoughTomato, 1), new ItemStack(ItemHandler.PizzaDough), new ItemStack(ItemHandler.Tomato));	    
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.PancakesWithSyrup, 1), new ItemStack(ItemHandler.Pancakes), new ItemStack(ItemHandler.MapleSyrup, 1, OreDictionary.WILDCARD_VALUE));

	    GameRegistry.addShapelessRecipe(new ItemStack(Items.DYE, 1, EnumDyeColor.SILVER.getDyeDamage()), new ItemStack(BlockHandler.Lily, 1, 0));
	    GameRegistry.addShapelessRecipe(new ItemStack(Items.DYE, 1, EnumDyeColor.ORANGE.getDyeDamage()), new ItemStack(BlockHandler.Lily, 1, 1));
	    GameRegistry.addShapelessRecipe(new ItemStack(Items.DYE, 2, EnumDyeColor.SILVER.getDyeDamage()), new ItemStack(BlockHandler.Rose, 1, 0));
	    GameRegistry.addShapelessRecipe(new ItemStack(Items.DYE, 2, EnumDyeColor.PINK.getDyeDamage()), new ItemStack(BlockHandler.Rose, 1, 1));
	    GameRegistry.addShapelessRecipe(new ItemStack(Items.DYE, 2, EnumDyeColor.LIGHT_BLUE.getDyeDamage()), new ItemStack(BlockHandler.Rose, 1, 2));
	    GameRegistry.addShapelessRecipe(new ItemStack(Items.DYE, 2, EnumDyeColor.BLACK.getDyeDamage()), new ItemStack(BlockHandler.Rose, 1, 3));
	    GameRegistry.addShapelessRecipe(new ItemStack(Items.DYE, 2, EnumDyeColor.YELLOW.getDyeDamage()), new ItemStack(BlockHandler.Rose, 1, 4));
	    GameRegistry.addShapelessRecipe(new ItemStack(Items.DYE, 2, EnumDyeColor.PURPLE.getDyeDamage()), new ItemStack(BlockHandler.Rose, 1, 5));
	    GameRegistry.addShapelessRecipe(new ItemStack(Items.DYE, 1, EnumDyeColor.LIGHT_BLUE.getDyeDamage()), new ItemStack(BlockHandler.Lily, 1, 2));

	    //Knife
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.PlumSlice, 8), new ItemStack(ItemHandler.Knife, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ItemHandler.Plum));
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.PearSlice, 8), new ItemStack(ItemHandler.Knife, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ItemHandler.Pear));
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.AppleSlice, 8), new ItemStack(ItemHandler.Knife, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.APPLE));
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.Toast, 8), new ItemStack(ItemHandler.Knife, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.BREAD));
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.slicedCheese, 6), new ItemStack(ItemHandler.Knife, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ItemHandler.CheeseItem));
	          
	    //Pizzy
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.Pizza, 1, 0), new ItemStack(ItemHandler.PizzaDoughTomato), ItemHandler.slicedCheese, ItemHandler.Ham, Blocks.BROWN_MUSHROOM);
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.Pizza, 1, 1), new ItemStack(ItemHandler.PizzaDoughTomato), ItemHandler.slicedCheese, ItemHandler.slicedCheese, ItemHandler.Corn_Item);
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.Pizza, 1, 2), new ItemStack(ItemHandler.PizzaDoughTomato), ItemHandler.slicedCheese, ItemHandler.Pineapple, ItemHandler.Ham);
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.Pizza, 1, 3), new ItemStack(ItemHandler.PizzaDoughTomato), ItemHandler.slicedCheese, ItemHandler.Ham);

	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.PancakesWithJam, 1, 0), new ItemStack(ItemHandler.Pancakes), ItemHandler.PearJam);
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.PancakesWithJam, 1, 1), new ItemStack(ItemHandler.Pancakes), ItemHandler.StrawberryJam);
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.PancakesWithJam, 1, 2), new ItemStack(ItemHandler.Pancakes), ItemHandler.AppleJam);
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.PancakesWithJam, 1, 3), new ItemStack(ItemHandler.Pancakes), ItemHandler.PlumJam);
	    GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.PancakesWithJam, 1, 4), new ItemStack(ItemHandler.Pancakes), ItemHandler.CherryJam);

	    ItemStack output = new ItemStack(ItemHandler.KegOfBeer, 1);
	    IFluidContainerItem fluidContainer = (IFluidContainerItem) output.getItem();
	    FluidStack liquid = new FluidStack(FC2Fluid.liquid_beer, 1000);
	    fluidContainer.fill(output, liquid, true);
	    BottlingRecipeManager.instance.addRecipe(output, new ItemStackMatcher(new ItemStack(ItemHandler.KegOfBeer)), new ItemStackMatcher(ItemHandler.BeerBucket));
	    
	    BottlingRecipeManager.instance.addRecipe(new ItemStack(ItemHandler.BottleSW), new ItemStackMatcher(ItemHandler.BottleFW), new ItemStackMatcher(ItemHandler.FermentedWine));

        SpigotRecipeManager.instance.addRecipe(new ItemStackMatcher(ItemHandler.BeerBottle), new FluidStack(FC2Fluid.liquid_beer, 10), new ItemStack(ItemHandler.Bottle), null);
        
        ItemStack egg = new ItemStack(Items.SPAWN_EGG, 1);
        NBTTagCompound nbttagcompound = egg.hasTagCompound() ? egg.getTagCompound() : new NBTTagCompound();
        NBTTagCompound nbttagcompound1 = new NBTTagCompound();
        nbttagcompound1.setString("id", "farmcraft2.homer");
        nbttagcompound.setTag("EntityTag", nbttagcompound1);
        egg.setTagCompound(nbttagcompound);
	    GameRegistry.addRecipe(egg, new Object[]{"XXX", "XZX", "XXX" , 'X', new ItemStack(ItemHandler.FillingDonuts, 1, OreDictionary.WILDCARD_VALUE), 'Z', new ItemStack(ItemHandler.BeerBottle)});
	  
	  }
}