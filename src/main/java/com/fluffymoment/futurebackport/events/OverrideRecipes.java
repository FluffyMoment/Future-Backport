package com.fluffymoment.futurebackport.events;

import com.fluffymoment.futurebackport.recipes.VanillaRecipe;
import com.fluffymoment.futurebackport.util.Reference;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class OverrideRecipes
{
    @SubscribeEvent
    public void registerRecipes(RegistryEvent.Register<IRecipe> event)
    {
        IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable)event.getRegistry();
        removeRecipe(modRegistry, new ResourceLocation("minecraft:wooden_button"), Reference.MOD_ID);
    }

    public static void removeRecipe(IForgeRegistryModifiable modRegistry, ResourceLocation recipe, String modID)
    {
        IRecipe p = (IRecipe)modRegistry.getValue(recipe);
        modRegistry.remove(recipe);
        modRegistry.register(VanillaRecipe.from(p));
    }
}

