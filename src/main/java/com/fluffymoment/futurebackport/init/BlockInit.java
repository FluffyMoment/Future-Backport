package com.fluffymoment.futurebackport.init;

import com.fluffymoment.futurebackport.Main;
import com.fluffymoment.futurebackport.objects.blocks.*;
import com.fluffymoment.futurebackport.objects.blocks.blast_furnace.BlastFurnace;
import com.fluffymoment.futurebackport.objects.blocks.smoker.Smoker;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit
{
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    //Blocks
    //public static final Block BLUE_ICE = new BlockBlueIce("blue_ice", Material.PACKED_ICE);
    public static final Block SMOKER_OFF = new Smoker("smoker_off",  false).setCreativeTab(Main.FUTUREBACKPORTTAB);
    public static final Block SMOKER_ON = new Smoker("smoker_on", true);
    public static final Block BLAST_FURNACE_OFF = new BlastFurnace("blast_furnace_off",  false).setCreativeTab(Main.FUTUREBACKPORTTAB);
    public static final Block BLAST_FURNACE_ON = new BlastFurnace("blast_furnace_on", true);

    //Pressure Plates
    public static final Block SPRUCE_PRESSURE_PLATE = new BlockWoodPressurePlate("spruce_pressure_plate", Material.WOOD, BlockPressurePlate.Sensitivity.EVERYTHING);
    public static final Block JUNGLE_PRESSURE_PLATE = new BlockWoodPressurePlate("jungle_pressure_plate", Material.WOOD, BlockPressurePlate.Sensitivity.EVERYTHING);
    public static final Block ACACIA_PRESSURE_PLATE = new BlockWoodPressurePlate("acacia_pressure_plate", Material.WOOD, BlockPressurePlate.Sensitivity.EVERYTHING);
    public static final Block DARK_OAK_PRESSURE_PLATE = new BlockWoodPressurePlate("dark_oak_pressure_plate", Material.WOOD, BlockPressurePlate.Sensitivity.EVERYTHING);
    public static final Block BIRCH_PRESSURE_PLATE = new BlockWoodPressurePlate("birch_pressure_plate", Material.WOOD, BlockPressurePlate.Sensitivity.EVERYTHING);

    //Buttons
    public static final Block SPRUCE_BUTTON = new BlockWoodButton("spruce_button");
    public static final Block BIRCH_BUTTON = new BlockWoodButton("birch_button");
    public static final Block DARK_OAK_BUTTON = new BlockWoodButton("dark_oak_button");
    public static final Block ACACIA_BUTTON = new BlockWoodButton("acacia_button");
    public static final Block JUNGLE_BUTTON = new BlockWoodButton("jungle_button");

    //Trapdoors
    public static final Block SPRUCE_TRAPDOOR = new BlockWoodTrapdoor("spruce_trapdoor");
    public static final Block BIRCH_TRAPDOOR = new BlockWoodTrapdoor("birch_trapdoor");
    public static final Block DARK_OAK_TRAPDOOR = new BlockWoodTrapdoor("dark_oak_trapdoor");
    public static final Block ACACIA_TRAPDOOR = new BlockWoodTrapdoor("acacia_trapdoor");
    public static final Block JUNGLE_TRAPDOOR = new BlockWoodTrapdoor("jungle_trapdoor");
}
