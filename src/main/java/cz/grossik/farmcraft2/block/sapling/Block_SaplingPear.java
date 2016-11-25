package cz.grossik.farmcraft2.block.sapling;

import java.util.List;
import java.util.Random;

import cz.grossik.farmcraft2.Main;
import cz.grossik.farmcraft2.wordgen.tree.WorldGenPearTree;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class Block_SaplingPear extends BlockSapling {

	public Block_SaplingPear() {
		setCreativeTab(Main.FarmCraft2Tab);
	}

	public void growTree(World world, BlockPos pos, IBlockState state, Random random)
	{
		if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, random, pos)) return;

		world.setBlockState(pos, Blocks.AIR.getDefaultState(), 1);
		Object obj = new WorldGenPearTree(true);
		if(!((WorldGenerator) obj).generate(world, random, pos))
			world.setBlockState(pos, getDefaultState(), 4);
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {

		if (state.getValue(STAGE).intValue() == 0)
			worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
		else
			growTree(worldIn, pos, state, rand);
	}

	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
	{
		list.add(new ItemStack(itemIn, 1, 0));
	}
}