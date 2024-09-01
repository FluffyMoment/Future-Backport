package com.fluffymoment.futurebackport.util.handlers;

import com.fluffymoment.futurebackport.events.OverrideRecipes;
import net.minecraftforge.common.MinecraftForge;

public class EventHandler
{
    public static void registerEvents()
    {
        OverrideRecipes recipeEvent = new OverrideRecipes();

        MinecraftForge.EVENT_BUS.register(recipeEvent);
    }
}
