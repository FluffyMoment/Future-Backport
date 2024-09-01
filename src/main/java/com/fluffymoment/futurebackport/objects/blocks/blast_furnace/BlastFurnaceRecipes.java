package com.fluffymoment.futurebackport.objects.blocks.blast_furnace;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;

import java.util.Map;

public class BlastFurnaceRecipes
{
    private static final BlastFurnaceRecipes COOKING_BASE = new BlastFurnaceRecipes();
    private final Map<ItemStack, ItemStack> cookingList = Maps.<ItemStack, ItemStack>newHashMap();
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    public static BlastFurnaceRecipes instance()
    {
        return COOKING_BASE;
    }

    private BlastFurnaceRecipes()
    {
        //this.addCookingRecipeForBlock(BlockInit.BLUE_ICE, new ItemStack(ItemInit.TEST_ITEM), 0.25f);
        this.addCookingRecipeForBlock(Blocks.COAL_ORE, new ItemStack(Items.COAL), 0.7f);
        this.addCookingRecipeForBlock(Blocks.IRON_ORE, new ItemStack(Items.IRON_INGOT), 0.7f);
        this.addCookingRecipeForBlock(Blocks.REDSTONE_ORE, new ItemStack(Items.REDSTONE), 0.7f);
        this.addCookingRecipeForBlock(Blocks.GOLD_ORE, new ItemStack(Items.GOLD_INGOT), 0.9f);
        this.addCookingRecipeForBlock(Blocks.DIAMOND_ORE, new ItemStack(Items.DIAMOND), 1.0f);
        this.addCookingRecipeForBlock(Blocks.EMERALD_ORE, new ItemStack(Items.EMERALD), 1.0f);
        this.addCookingRecipeForCustomBlock(Blocks.MITHRIL_ORE, new ItemStack(OreIngredient.MITHRIL_INGOT), 1.0f);
    }
    public void addCookingRecipeForCustomBlock(Block input, OreDictionary oredict, float experience)
    {
        this.addCookingCustom(Item.getItemFromBlock(input), oredict, experience);
    }

    private void addCookingRecipeForItem(Item input, ItemStack stack, float experience)
    {
        this.addCooking(Item.getItemById(Item.getIdFromItem(input)), stack, experience);
    }

    public void addCookingRecipeForBlock(Block input, ItemStack stack, float experience)
    {
        this.addCooking(Item.getItemFromBlock(input), stack, experience);
    }

    public void addCookingCustom(Item input, OreDictionary oredict, float experience)
    {
        this.addCookingRecipe(new ItemStack(input, 1, 32767), null, experience);
    }

    public void addCooking(Item input, ItemStack stack, float experience)
    {
        this.addCookingRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }

    public void addCookingRecipe(ItemStack input, ItemStack stack, float experience)
    {
        if (getCookingResult(input) != ItemStack.EMPTY)
        {
            FMLLog.log.info("Ignored cooking recipe with conflicting input: {} = {}", input, stack); return;
        }
        this.cookingList.put(input, stack);
        this.experienceList.put(stack, Float.valueOf(experience));
    }

    public ItemStack getCookingResult(ItemStack stack)
    {
        for (Map.Entry<ItemStack, ItemStack> entry : this.cookingList.entrySet())
        {
            if (this.compareItemStacks(stack, entry.getKey()))
            {
                return entry.getValue();
            }
        }

        return ItemStack.EMPTY;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<ItemStack, ItemStack> getCookingList()
    {
        return this.cookingList;
    }

    public float getCookingExperience(ItemStack stack)
    {
        float ret = stack.getItem().getSmeltingExperience(stack);
        if (ret != -1) return ret;
        for (Map.Entry<ItemStack, Float> entry : this.experienceList.entrySet())
        {
            if (this.compareItemStacks(stack, entry.getKey()))
            {
                return ((Float)entry.getValue()).floatValue();
            }
        }
        return 0.0F;
    }
}
