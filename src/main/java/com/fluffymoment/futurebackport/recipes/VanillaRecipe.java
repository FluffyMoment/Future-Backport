package com.fluffymoment.futurebackport.recipes;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class VanillaRecipe extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe
{
    private final ItemStack output;

    public VanillaRecipe(ItemStack output)
    {
        this.output = output;
    }

    public static IRecipe from(IRecipe other)
    {
        return new VanillaRecipe(other.getRecipeOutput()).setRegistryName(other.getRegistryName());
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn)
    {
        return false;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv)
    {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canFit(int width, int height)
    {
        return false;
    }

    @Override
    public ItemStack getRecipeOutput()
    {
        return output;
    }
}