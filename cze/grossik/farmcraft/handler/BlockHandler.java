package cze.grossik.farmcraft.handler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.config.Configuration;
import cze.grossik.farmcraft.FarmCraft;
import cze.grossik.farmcraft.block.Block_AppleCake;
import cze.grossik.farmcraft.block.Block_Cheese;
import cze.grossik.farmcraft.block.Block_Copper;
import cze.grossik.farmcraft.block.Block_Ore;
import cze.grossik.farmcraft.block.Block_Scarecrow;
import cze.grossik.farmcraft.block.crop.Block_Barley;
import cze.grossik.farmcraft.block.crop.Block_Blueberry;
import cze.grossik.farmcraft.block.crop.Block_Broccoli;
import cze.grossik.farmcraft.block.crop.Block_Cabbage;
import cze.grossik.farmcraft.block.crop.Block_Capsicum;
import cze.grossik.farmcraft.block.crop.Block_Cucumber;
import cze.grossik.farmcraft.block.crop.Block_Hops;
import cze.grossik.farmcraft.block.crop.Block_Pineapple;
import cze.grossik.farmcraft.block.crop.Block_Radish;
import cze.grossik.farmcraft.block.crop.Block_Rice;
import cze.grossik.farmcraft.block.crop.Block_Strawberry;
import cze.grossik.farmcraft.block.crop.Block_Tomato;
import cze.grossik.farmcraft.block.tree.Block_LeavesCherry;
import cze.grossik.farmcraft.block.tree.Block_LeavesCherryST;
import cze.grossik.farmcraft.block.tree.Block_LeavesPear;
import cze.grossik.farmcraft.block.tree.Block_LeavesPearSH;
import cze.grossik.farmcraft.block.tree.Block_LeavesPlum;
import cze.grossik.farmcraft.block.tree.Block_LeavesPlumSS;
import cze.grossik.farmcraft.block.tree.Block_SaplingCherry;
import cze.grossik.farmcraft.block.tree.Block_SaplingPear;
import cze.grossik.farmcraft.block.tree.Block_SaplingPlum;
import cze.grossik.farmcraft.boiling.Block_Boiling;
import cze.grossik.farmcraft.bottling.Block_Bottling;
import cze.grossik.farmcraft.juicer.Block_Juicer;
import cze.grossik.farmcraft.mashtun.Block_MashTun;

public class BlockHandler {

    public static String blockids = "Block IDs";

    //Crop
    public static Block TomatoBlock = new Block_Tomato().setBlockName("tomatoblock").setBlockTextureName("farmcraft:tomato");
    public static Block RadishBlock = new Block_Radish().setBlockName("radishblock").setBlockTextureName("farmcraft:radish");
    public static Block BroccoliBlock = new Block_Broccoli().setBlockName("broccoliblock").setBlockTextureName("farmcraft:broccoli");
    public static Block CucumberBlock = new Block_Cucumber().setBlockName("cucumberblock").setBlockTextureName("farmcraft:cucumber");
    public static Block RiceBlock = new Block_Rice().setBlockName("riceblock").setBlockTextureName("farmcraft:rice");
    public static Block CapsicumBlock = new Block_Capsicum().setBlockName("capsicumblock").setBlockTextureName("farmcraft:capsicum");
    public static Block CabbageBlock = new Block_Cabbage().setBlockName("cabbageblock").setBlockTextureName("farmcraft:cabbage");
    public static Block StrawberryBlock = new Block_Strawberry().setHardness(0.2F).setBlockName("strawberryblock").setBlockTextureName("farmcraft:strawberry");
    public static Block HopsBlock = new Block_Hops().setHardness(0.2F).setBlockName("hopsblock").setBlockTextureName("farmcraft:hops");
    public static Block BarleyBlock = new Block_Barley().setBlockName("barleyblock").setBlockTextureName("farmcraft:barley");
    public static Block BlueberryBlock = new Block_Blueberry().setHardness(0.2F).setBlockName("blueberryblock").setBlockTextureName("farmcraft:blueberry");
    public static Block PineappleBlock = new Block_Pineapple().setBlockName("pineappleblock").setBlockTextureName("farmcraft:pineapple");

    //Zbytek
    public static Block Scarecrow = new Block_Scarecrow(Material.wood).setHardness(3.0F).setBlockName("scarecrow").setBlockTextureName("farmcraft:scarecrow");
    public static Block CheeseBlock = new Block_Cheese().setHardness(0.5F).setBlockName("cheeseblock").setBlockTextureName("farmcraft:cheese");
    public static Block OreCopper = new Block_Ore().setHardness(3.0F).setResistance(5.0F).setCreativeTab(FarmCraft.FarmCraftTab).setStepSound(Block.soundTypeStone).setBlockName("oreCopper").setBlockTextureName("farmcraft:copper_ore");
    public static Block BlockCopper = new Block_Copper().setHardness(5.0F).setResistance(10.0F).setCreativeTab(FarmCraft.FarmCraftTab).setStepSound(Block.soundTypeMetal).setBlockName("blockCopper").setBlockTextureName("farmcraft:copper_block");
    public static Block AppleCakeBlock = (new Block_AppleCake()).setHardness(0.5F).setStepSound(Block.soundTypeCloth).setBlockName("applecakeB").setBlockTextureName("farmcraft:cake_apple");


    //Strom
    public static Block leavesPearNormal = new Block_LeavesPear().setHardness(0.2F).setLightOpacity(1).setCreativeTab(FarmCraft.FarmCraftTab).setStepSound(Block.soundTypeGrass).setBlockName("leavesPN").setBlockTextureName("farmcraft:leaves");
    public static Block leavesPearSH = (new Block_LeavesPearSH()).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundTypeGrass).setBlockName("leavespearplne").setBlockTextureName("farmcraft:leaves");
    public static Block SaplingPear = (new Block_SaplingPear()).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("saplingPear").setBlockTextureName("farmcraft:sapling");
    public static Block leavesCherryNormal = new Block_LeavesCherry().setHardness(0.2F).setLightOpacity(1).setCreativeTab(FarmCraft.FarmCraftTab).setStepSound(Block.soundTypeGrass).setBlockName("leavesCH").setBlockTextureName("farmcraft:leaves");
    public static Block leavesCherryST = (new Block_LeavesCherryST().setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundTypeGrass).setBlockName("leavescherryplne").setBlockTextureName("farmcraft:leaves"));
    public static Block SaplingCherry = (new Block_SaplingCherry().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("saplingCherry").setBlockTextureName("farmcraft:sapling"));
    public static Block leavesPlumNormal = new Block_LeavesPlum().setHardness(0.2F).setLightOpacity(1).setCreativeTab(FarmCraft.FarmCraftTab).setStepSound(Block.soundTypeGrass).setBlockName("farmcraft:leavesPL").setBlockTextureName("farmcraft:leaves");
    public static Block leavesPlumSS = (new Block_LeavesPlumSS().setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundTypeGrass).setBlockName("leavesplumplne").setBlockTextureName("farmcraft:leaves"));
    public static Block SaplingPlum = (new Block_SaplingPlum().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("saplingPlum").setBlockTextureName("farmcraft:sapling"));

    //Juicer
    public static Block juicerOn = new Block_Juicer(true).setHardness(5.5F).setResistance(15.0F).setStepSound(Block.soundTypeMetal).setBlockName("juiceron");
    public static Block juicerOff = new Block_Juicer(false).setHardness(5.5F).setResistance(15.0F).setStepSound(Block.soundTypeMetal).setBlockName("juiceroff").setCreativeTab(FarmCraft.FarmCraftTab);

    //MashTun
    public static Block MashTunOn = new Block_MashTun(true).setHardness(5.5F).setResistance(15.0F).setStepSound(Block.soundTypeMetal).setBlockName("mashtunon");
    public static Block MashTunOff = new Block_MashTun(false).setHardness(5.5F).setResistance(15.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(FarmCraft.FarmCraftTab).setBlockName("mashtunoff");

    //Boiling
    public static Block BoilingOn = new Block_Boiling(true).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("boilingon");
    public static Block BoilingOff = new Block_Boiling(false).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setCreativeTab(FarmCraft.FarmCraftTab).setBlockName("boilingoff");

    //Bottling
    public static Block BottlingOn = new Block_Bottling(true).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("bottlingon");
    public static Block BottlingOff = new Block_Bottling(false).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setCreativeTab(FarmCraft.FarmCraftTab).setBlockName("bottlingoff");

    public static void configureBlockIDs(Configuration config) {
        // TODO Auto-generated method stub

        FarmCraft.addToVillages = config.get("Worldgen Disabler", "Add Village Generation", true).getBoolean(true);

    }


}
