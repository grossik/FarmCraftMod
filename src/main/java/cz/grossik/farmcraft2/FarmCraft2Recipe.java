package cz.grossik.farmcraft2;

import cz.grossik.farmcraft2.bottling.BottlingRecipeManager;
import cz.grossik.farmcraft2.bottling.ItemStackMatcher;
import cz.grossik.farmcraft2.handler.BlockHandler;
import cz.grossik.farmcraft2.handler.ItemHandler;
import cz.grossik.farmcraft2.spigot.SpigotRecipeManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.IFluidContainerItem;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.items.wrapper.PlayerMainInvWrapper;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class FarmCraft2Recipe{

	  public static void init()
	  {
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
	        GameRegistry.addRecipe(new ItemStack(BlockHandler.BottlingOff, 1), new Object[]{"PPP", "P#P", "PXP", 'P', Items.iron_ingot, '#', Blocks.lever, 'X', Blocks.glass});
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
	    GameRegistry.addRecipe(new ItemStack(ItemHandler.KegOfBeer, 1), new Object[]{"XXX", "X X", "XXX" , 'X', new ItemStack(Items.iron_ingot)});
	        
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
	          
	    ItemStack output = new ItemStack(ItemHandler.KegOfBeer, 1);
	    IFluidContainerItem fluidContainer = (IFluidContainerItem) output.getItem();
	    FluidStack liquid = new FluidStack(Main.liquid_beer, 1000);
	    fluidContainer.fill(output, liquid, true);
	    BottlingRecipeManager.instance.addRecipe(output, new ItemStackMatcher(new ItemStack(ItemHandler.KegOfBeer)), new ItemStackMatcher(ItemHandler.BeerBucket));
	    
	    BottlingRecipeManager.instance.addRecipe(new ItemStack(ItemHandler.BottleSW), new ItemStackMatcher(ItemHandler.BottleFW), new ItemStackMatcher(ItemHandler.FermentedWine));

        SpigotRecipeManager.instance.addRecipe(new ItemStackMatcher(ItemHandler.BeerBottle), new FluidStack(Main.liquid_beer, 10), new ItemStack(ItemHandler.Bottle), null);
	}
}
