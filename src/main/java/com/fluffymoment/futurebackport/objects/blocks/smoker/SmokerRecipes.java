package com.fluffymoment.futurebackport.objects.blocks.smoker;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


import java.util.Map;

public class SmokerRecipes
{
    private static final SmokerRecipes COOKING_BASE = new SmokerRecipes();
    private final Map<ItemStack, ItemStack> cookingList = Maps.<ItemStack, ItemStack>newHashMap();
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    public static SmokerRecipes instance()
    {
        return COOKING_BASE;
    }

    private SmokerRecipes()
    {
        //this.addCookingRecipeForBlock(BlockInit.BLUE_ICE, new ItemStack(ItemInit.TEST_ITEM), 0.25f);
        this.addCookingRecipeForItem(Items.FISH, new ItemStack(Items.COOKED_FISH), 0.25f);
        this.addCookingRecipeForItem(Items.RABBIT, new ItemStack(Items.COOKED_RABBIT), 0.25f);
        this.addCookingRecipeForItem(Items.BEEF, new ItemStack(Items.COOKED_BEEF), 0.25f);
        this.addCookingRecipeForItem(Items.CHICKEN, new ItemStack(Items.COOKED_CHICKEN), 0.25f);
        this.addCookingRecipeForItem(Items.PORKCHOP, new ItemStack(Items.COOKED_PORKCHOP), 0.25f);
        this.addCookingRecipeForItem(Items.MUTTON, new ItemStack(Items.COOKED_MUTTON), 0.25f);
        this.addCookingRecipeForItem(Items.POTATO, new ItemStack(Items.BAKED_POTATO), 0.25f);
    }

    private void addCookingRecipeForItem(Item input, ItemStack stack, float experience)
    {
        this.addCooking(Item.getItemById(Item.getIdFromItem(input)), stack, experience);
    }

    public void addCookingRecipeForBlock(Block input, ItemStack stack, float experience)
    {
        this.addCooking(Item.getItemFromBlock(input), stack, experience);
    }

    public void addCooking(Item input, ItemStack stack, float experience)
    {
        this.addCookingRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }

    public void addCookingRecipe(ItemStack input, ItemStack stack, float experience)
    {
        if (getCookingResult(input) != ItemStack.EMPTY)
        {
            net.minecraftforge.fml.common.FMLLog.log.info("Ignored cooking recipe with conflicting input: {} = {}", input, stack); return;
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
