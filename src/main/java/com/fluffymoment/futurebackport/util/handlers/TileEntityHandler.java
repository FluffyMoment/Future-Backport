package com.fluffymoment.futurebackport.util.handlers;

import com.fluffymoment.futurebackport.objects.blocks.smoker.TileEntitySmoker;
import com.fluffymoment.futurebackport.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler
{
    public static void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntitySmoker.class, new ResourceLocation(Reference.MOD_ID + ":smoker"));
    }
}