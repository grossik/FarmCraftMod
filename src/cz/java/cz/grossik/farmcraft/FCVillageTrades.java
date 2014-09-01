package cz.grossik.farmcraft;

import cz.grossik.farmcraft.handler.BlockHandler;
import cz.grossik.farmcraft.handler.ItemHandler;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FCVillageTrades implements IVillageTradeHandler {

    private final List<ItemStack> allowedIngredients = new ArrayList<ItemStack>();
    private final int max = 64;
    private final int min = 32;

    public FCVillageTrades() {
        super();

        // vanilla blocks
        allowedIngredients.add(new ItemStack(Items.wheat_seeds, 3));

        allowedIngredients.add(new ItemStack(Items.emerald, 2));

    }

    @Override
    public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
        if (villager.getProfession() == 69699) {
            ItemStack ingredient;
            ItemStack ingredient2;
            ItemStack result;

            for (int sc = 8; sc < 12; sc++) {
                int num = getNextInt(random, min, max);

                ingredient = getIngredient(random, num);
                if (ingredient.stackSize < 13) {
                    ingredient2 = getIngredient(random, ingredient);
                } else {
                    ingredient2 = null;
                }
                result = new ItemStack(BlockHandler.SaplingCherry, calcStackSize(ingredient, ingredient2), sc);
                recipeList.addToListWithCheck(new MerchantRecipe(ingredient, ingredient2, result));

                if (sc == 8) {
                    // adds alumine orebush to the recipe list
                    result = new ItemStack(BlockHandler.SaplingPear, calcStackSize(ingredient, ingredient2), sc);
                    recipeList.addToListWithCheck(new MerchantRecipe(ingredient, ingredient2, result));
                }
                if (sc == 8) {
                    // adds alumine orebush to the recipe list
                    result = new ItemStack(ItemHandler.BroccoliSeeds, calcStackSize(ingredient, ingredient2), sc);
                    recipeList.addToListWithCheck(new MerchantRecipe(ingredient, ingredient2, result));
                }
                if (sc == 8) {
                    // adds alumine orebush to the recipe list
                    result = new ItemStack(ItemHandler.CabbageSeeds, calcStackSize(ingredient, ingredient2), sc);
                    recipeList.addToListWithCheck(new MerchantRecipe(ingredient, ingredient2, result));
                }
                if (sc == 8) {
                    // adds alumine orebush to the recipe list
                    result = new ItemStack(ItemHandler.CapsicumSeeds, calcStackSize(ingredient, ingredient2), sc);
                    recipeList.addToListWithCheck(new MerchantRecipe(ingredient, ingredient2, result));
                }
                if (sc == 8) {
                    // adds alumine orebush to the recipe list
                    result = new ItemStack(ItemHandler.CucumberSeeds, calcStackSize(ingredient, ingredient2), sc);
                    recipeList.addToListWithCheck(new MerchantRecipe(ingredient, ingredient2, result));
                }
                if (sc == 8) {
                    // adds alumine orebush to the recipe list
                    result = new ItemStack(ItemHandler.RadishSeeds, calcStackSize(ingredient, ingredient2), sc);
                    recipeList.addToListWithCheck(new MerchantRecipe(ingredient, ingredient2, result));
                }
                if (sc == 8) {
                    // adds alumine orebush to the recipe list
                    result = new ItemStack(ItemHandler.RiceSeeds, calcStackSize(ingredient, ingredient2), sc);
                    recipeList.addToListWithCheck(new MerchantRecipe(ingredient, ingredient2, result));
                }
                if (sc == 8) {
                    // adds alumine orebush to the recipe list
                    result = new ItemStack(ItemHandler.TomatoSeeds, calcStackSize(ingredient, ingredient2), sc);
                    recipeList.addToListWithCheck(new MerchantRecipe(ingredient, ingredient2, result));
                }
            }
        }
    }

    private int calcStackSize(ItemStack ingredient, ItemStack ingredient2) {
        if (ingredient == null)
            return 1;
        int num = ingredient.stackSize;
        if (ingredient2 != null)
            num += ingredient2.stackSize;

        return Math.max(1, Math.round((num - 5) / 4));
    }

    private ItemStack getIngredient(Random random, ItemStack ingredient) {
        int sc;
        ItemStack is;
        int tries = 0;
        while (true) {
            sc = getNextInt(random, 0, allowedIngredients.size() - 1);
            is = allowedIngredients.get(sc);

            if (is != ingredient || is.getItemDamage() != ingredient.getItemDamage())
                break;

            tries++;
            if (tries == 5)
                return null;
        }
        int num = getNextInt(random, 0, Math.min(is.stackSize, max - ingredient.stackSize));
        return is.copy().splitStack(num);
    }

    private ItemStack getIngredient(Random random, int num) {
        int sc = getNextInt(random, 0, allowedIngredients.size() - 1);
        ItemStack item = allowedIngredients.get(sc);
        return item.copy().splitStack(Math.min(num, item.stackSize));
    }

    private int getNextInt(Random random, int min, int max) {
        return random.nextInt(Math.max(1, (max - min) + 1)) + min;
    }
}