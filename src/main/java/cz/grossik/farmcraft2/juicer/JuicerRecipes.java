package cz.grossik.farmcraft2.juicer;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import cz.grossik.farmcraft2.handler.ItemHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class JuicerRecipes
{
    private static final JuicerRecipes smeltingBase = new JuicerRecipes();
    private Map<ItemStack, ItemStack> smeltingList = Maps.<ItemStack, ItemStack>newHashMap();
    private Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    public static JuicerRecipes instance()
    {
        return smeltingBase;
    }

    public JuicerRecipes()
    {
        this.addSmelting(Items.APPLE, new ItemStack(ItemHandler.AppleJuice), 0.0F);
        this.addSmelting(Items.CARROT, new ItemStack(ItemHandler.CarrotJuice), 0.0F);
        this.addSmelting(ItemHandler.Pear, new ItemStack(ItemHandler.PearJuice), 0.0F);
        this.addSmelting(ItemHandler.Strawberry, new ItemStack(ItemHandler.StrawberryJuice), 0.0F);
        this.addSmelting(ItemHandler.Cherry, new ItemStack(ItemHandler.CherryJuice), 0.0F);
        this.addSmelting(ItemHandler.Plum, new ItemStack(ItemHandler.PlumJuice), 0.0F);
        this.addSmelting(ItemHandler.Pineapple, new ItemStack(ItemHandler.PineappleJuice), 0.0F);
    }

    public void addSmeltingRecipeForBlock(Block input, ItemStack stack, float experience)
    {
        this.addSmelting(Item.getItemFromBlock(input), stack, experience);
    }

    public void addSmelting(Item input, ItemStack stack, float experience)
    {
        this.addSmeltingRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }

    /**
     * Adds a smelting recipe using an ItemStack as the input for the recipe.
     */
    public void addSmeltingRecipe(ItemStack input, ItemStack stack, float experience)
    {
        if (getSmeltingResult(input) != null) { net.minecraftforge.fml.common.FMLLog.info("Ignored smelting recipe with conflicting input: " + input + " = " + stack); return; }
        this.smeltingList.put(input, stack);
        this.experienceList.put(stack, Float.valueOf(experience));
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getSmeltingResult(ItemStack stack)
    {
        for (Entry<ItemStack, ItemStack> entry : this.smeltingList.entrySet())
        {
            if (this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return (ItemStack)entry.getValue();
            }
        }

        return null;
    }

    /**
     * Compares two itemstacks to ensure that they are the same. This checks both the item and the metadata of the item.
     */
    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<ItemStack, ItemStack> getSmeltingList()
    {
        return this.smeltingList;
    }

    public float getSmeltingExperience(ItemStack stack)
    {
        float ret = stack.getItem().getSmeltingExperience(stack);
        if (ret != -1) return ret;

        for (Entry<ItemStack, Float> entry : this.experienceList.entrySet())
        {
            if (this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return ((Float)entry.getValue()).floatValue();
            }
        }

        return 0.0F;
    }
}