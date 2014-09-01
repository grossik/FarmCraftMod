package cz.grossik.farmcraft.juicer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cz.grossik.farmcraft.handler.ItemHandler;

public class JuicerRecipes {
    private static final JuicerRecipes smeltingBase = new JuicerRecipes();
    private static final String __OBFID = "CL_00000085";
    /**
     * The list of smelting results.
     */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();

    private JuicerRecipes() {
        this.func_151396_a(Items.apple, new ItemStack(ItemHandler.AppleJuice), 0.0F);
        this.func_151396_a(Items.carrot, new ItemStack(ItemHandler.CarrotJuice), 0.0F);
        this.func_151396_a(ItemHandler.Pear, new ItemStack(ItemHandler.PearJuice), 0.0F);
        this.func_151396_a(ItemHandler.Strawberry, new ItemStack(ItemHandler.StrawberryJuice), 0.0F);
        this.func_151396_a(ItemHandler.Cherry, new ItemStack(ItemHandler.CherryJuice), 0.0F);
        this.func_151396_a(ItemHandler.Plum, new ItemStack(ItemHandler.PlumJuice), 0.0F);

    }

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static JuicerRecipes smelting() {
        return smeltingBase;
    }

    public void func_151393_a(Block p_151393_1_, ItemStack p_151393_2_, float p_151393_3_) {
        this.func_151396_a(Item.getItemFromBlock(p_151393_1_), p_151393_2_, p_151393_3_);
    }

    public void func_151396_a(Item p_151396_1_, ItemStack p_151396_2_, float p_151396_3_) {
        this.func_151394_a(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_, p_151396_3_);
    }

    public void func_151394_a(ItemStack p_151394_1_, ItemStack p_151394_2_, float p_151394_3_) {
        this.smeltingList.put(p_151394_1_, p_151394_2_);
        this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getSmeltingResult(ItemStack p_151395_1_) {
        Iterator iterator = this.smeltingList.entrySet().iterator();
        Entry entry;

        do {
            if (!iterator.hasNext()) {
                return null;
            }

            entry = (Entry) iterator.next();
        }
        while (!this.func_151397_a(p_151395_1_, (ItemStack) entry.getKey()));

        return (ItemStack) entry.getValue();
    }

    private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_) {
        return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
    }

    public Map getSmeltingList() {
        return this.smeltingList;
    }

    public float func_151398_b(ItemStack p_151398_1_) {
        float ret = p_151398_1_.getItem().getSmeltingExperience(p_151398_1_);
        if (ret != -1) return ret;

        Iterator iterator = this.experienceList.entrySet().iterator();
        Entry entry;

        do {
            if (!iterator.hasNext()) {
                return 0.0F;
            }

            entry = (Entry) iterator.next();
        }
        while (!this.func_151397_a(p_151398_1_, (ItemStack) entry.getKey()));

        return ((Float) entry.getValue()).floatValue();
    }
}