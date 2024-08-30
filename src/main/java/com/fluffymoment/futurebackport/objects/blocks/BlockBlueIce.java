package com.fluffymoment.futurebackport.objects.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

import java.util.List;

public class BlockBlueIce extends BlockBase
{
    public BlockBlueIce(String name, Material material)
    {
        super(name, material);
        setSoundType(SoundType.GLASS);
        setHardness(2.8F);
        setResistance(0.5F);
        setLightLevel(0.0F);
        setHarvestLevel("pickaxe", 0);
        setDefaultSlipperiness(0.98F);
    }

    @Override
    public List<ItemStack> getDrops(net.minecraft.world.IBlockAccess world, net.minecraft.util.math.BlockPos pos, net.minecraft.block.state.IBlockState state, int fortune) {
        return new java.util.ArrayList<>();
    }
}
