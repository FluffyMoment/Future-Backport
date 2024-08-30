package com.fluffymoment.futurebackport.init;

import com.fluffymoment.futurebackport.Main;
import com.fluffymoment.futurebackport.objects.blocks.BlockBase;
import com.fluffymoment.futurebackport.objects.blocks.BlockBlueIce;
import com.fluffymoment.futurebackport.objects.blocks.smoker.Smoker;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit
{
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block BLUE_ICE = new BlockBlueIce("blue_ice", Material.PACKED_ICE);
    public static final Block SMOKER_OFF = new Smoker("smoker_off",  false).setCreativeTab(Main.FUTUREBACKPORTTAB);
    public static final Block SMOKER_ON = new Smoker("smoker_on", true);
}
