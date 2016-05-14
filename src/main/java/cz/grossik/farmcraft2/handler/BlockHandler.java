package cz.grossik.farmcraft2.handler;

import cz.grossik.farmcraft2.Main;
import cz.grossik.farmcraft2.block.Block_AppleCake;
import cz.grossik.farmcraft2.block.Block_Cheese;
import cz.grossik.farmcraft2.block.Block_Copper;
import cz.grossik.farmcraft2.block.Block_Scarecrow;
import cz.grossik.farmcraft2.block.boiling.Block_Boiling;
import cz.grossik.farmcraft2.block.crop.Block_Barley;
import cz.grossik.farmcraft2.block.crop.Block_Blueberry;
import cz.grossik.farmcraft2.block.crop.Block_Broccoli;
import cz.grossik.farmcraft2.block.crop.Block_Cabbage;
import cz.grossik.farmcraft2.block.crop.Block_Capsicum;
import cz.grossik.farmcraft2.block.crop.Block_Corn;
import cz.grossik.farmcraft2.block.crop.Block_Cucumber;
import cz.grossik.farmcraft2.block.crop.Block_Grape;
import cz.grossik.farmcraft2.block.crop.Block_Hops;
import cz.grossik.farmcraft2.block.crop.Block_Pineapple;
import cz.grossik.farmcraft2.block.crop.Block_Radish;
import cz.grossik.farmcraft2.block.crop.Block_Rice;
import cz.grossik.farmcraft2.block.crop.Block_Strawberry;
import cz.grossik.farmcraft2.block.crop.Block_Tomato;
import cz.grossik.farmcraft2.block.leaves.Block_LeavesCherry;
import cz.grossik.farmcraft2.block.leaves.Block_LeavesCherryST;
import cz.grossik.farmcraft2.block.leaves.Block_LeavesPear;
import cz.grossik.farmcraft2.block.leaves.Block_LeavesPearSH;
import cz.grossik.farmcraft2.block.leaves.Block_LeavesPlum;
import cz.grossik.farmcraft2.block.leaves.Block_LeavesPlumSS;
import cz.grossik.farmcraft2.block.mashtun.Block_MashTun;
import cz.grossik.farmcraft2.block.sapling.Block_SaplingCherry;
import cz.grossik.farmcraft2.block.sapling.Block_SaplingPear;
import cz.grossik.farmcraft2.block.sapling.Block_SaplingPlum;
import cz.grossik.farmcraft2.bottling.Block_Bottling;
import cz.grossik.farmcraft2.crushing.Block_Crushing;
import cz.grossik.farmcraft2.fermentingbarrel.Block_FermentingBarrel;
import cz.grossik.farmcraft2.juicer.Block_Juicer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;

public class BlockHandler {

	//Crop
    public static Block Corn = new Block_Corn().setUnlocalizedName("cornblock");
    public static Block TomatoBlock = new Block_Tomato().setUnlocalizedName("tomatoblock");
    public static Block RadishBlock = new Block_Radish().setUnlocalizedName("radishblock");
    public static Block BroccoliBlock = new Block_Broccoli().setUnlocalizedName("broccoliblock");
    public static Block CucumberBlock = new Block_Cucumber().setUnlocalizedName("cucumberblock");
    public static Block RiceBlock = new Block_Rice().setUnlocalizedName("riceblock");
    public static Block CapsicumBlock = new Block_Capsicum().setUnlocalizedName("capsicumblock");
    public static Block CabbageBlock = new Block_Cabbage().setUnlocalizedName("cabbageblock");
    public static Block StrawberryBlock = new Block_Strawberry().setHardness(0.2F).setUnlocalizedName("strawberryblock");
    public static Block HopsBlock = new Block_Hops().setHardness(0.2F).setUnlocalizedName("hopsblock");
    public static Block BarleyBlock = new Block_Barley().setUnlocalizedName("barleyblock");
    public static Block BlueberryBlock = new Block_Blueberry().setHardness(0.2F).setUnlocalizedName("blueberryblock");
    public static Block PineappleBlock = new Block_Pineapple().setHardness(0.2F).setUnlocalizedName("pineappleblock");
    public static Block WineBlock = new Block_Grape().setUnlocalizedName("grapeblock");
    
    //Zbytek
    public static Block Scarecrow = new Block_Scarecrow(Material.wood).setHardness(3.0F).setUnlocalizedName("scarecrow");
    public static Block CheeseBlock = new Block_Cheese().setHardness(0.5F).setUnlocalizedName("cheeseblock");
    public static Block OreCopper = new BlockOre().setHardness(3.0F).setResistance(5.0F).setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("orecopper");
    public static Block BlockCopper = (new Block_Copper().setHardness(5.0F).setResistance(10.0F).setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("blockcopper"));
    public static Block AppleCakeBlock = (new Block_AppleCake()).setHardness(0.5F).setUnlocalizedName("applecakeblock");

    //Strom
    public static Block leavesPearNormal = new Block_LeavesPear().setHardness(0.2F).setLightOpacity(1).setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("leavespn");
    public static Block leavesPearSH = (new Block_LeavesPearSH()).setHardness(0.2F).setLightOpacity(1).setUnlocalizedName("leavespearplne");
    public static Block SaplingPear = (new Block_SaplingPear()).setHardness(0.0F).setUnlocalizedName("saplingPear");
    public static Block leavesCherryNormal = new Block_LeavesCherry().setHardness(0.2F).setLightOpacity(1).setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("leavesCH");
    public static Block leavesCherryST = (new Block_LeavesCherryST().setHardness(0.2F).setLightOpacity(1).setUnlocalizedName("leavescherryplne"));
    public static Block SaplingCherry = (new Block_SaplingCherry().setHardness(0.0F).setUnlocalizedName("saplingCherry"));
    public static Block leavesPlumNormal = new Block_LeavesPlum().setHardness(0.2F).setLightOpacity(1).setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("leavesPL");
    public static Block leavesPlumSS = (new Block_LeavesPlumSS().setHardness(0.2F).setLightOpacity(1).setUnlocalizedName("leavesplumplne"));
    public static Block SaplingPlum = (new Block_SaplingPlum().setHardness(0.0F).setUnlocalizedName("saplingPlum"));

    //Juicer
    public static Block juicerOn = new Block_Juicer(true).setHardness(5.5F).setResistance(15.0F).setUnlocalizedName("juiceron");
    public static Block juicerOff = new Block_Juicer(false).setHardness(5.5F).setResistance(15.0F).setUnlocalizedName("juiceroff").setCreativeTab(Main.FarmCraft2Tab);

    //MashTun
    public static Block MashTunOn = new Block_MashTun(true).setHardness(5.5F).setResistance(15.0F).setUnlocalizedName("mashtunon");
    public static Block MashTunOff = new Block_MashTun(false).setHardness(5.5F).setResistance(15.0F).setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("mashtunoff");

    //Boiling
    public static Block BoilingOn = new Block_Boiling(true).setHardness(5.0F).setResistance(10.0F).setUnlocalizedName("boilingon");
    public static Block BoilingOff = new Block_Boiling(false).setHardness(5.0F).setResistance(10.0F).setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("boilingoff");

    //Bottling
    //public static Block BottlingOn = new Block_Bottling().setHardness(5.0F).setResistance(10.0F).setUnlocalizedName("bottlingon");
    public static Block BottlingOff = new Block_Bottling().setHardness(5.0F).setResistance(10.0F).setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("bottlingoff");
    
    //Crushing
    public static Block CrushingOn = new Block_Crushing(true).setHardness(5.0F).setResistance(10.0F).setUnlocalizedName("crushingon");
    public static Block CrushingOff = new Block_Crushing(false).setHardness(5.0F).setResistance(10.0F).setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("crushingoff");

    //Fermenting Barrel
    public static Block FermentingBarrelOn = new Block_FermentingBarrel(true).setHardness(5.0F).setResistance(10.0F).setUnlocalizedName("fermentingbarrelon");
    public static Block FermentingBarrelOff = new Block_FermentingBarrel(false).setHardness(5.0F).setResistance(10.0F).setCreativeTab(Main.FarmCraft2Tab).setUnlocalizedName("fermentingbarreloff");
}
