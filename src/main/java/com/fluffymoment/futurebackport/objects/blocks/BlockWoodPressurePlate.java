package com.fluffymoment.futurebackport.objects.blocks;


import com.fluffymoment.futurebackport.Main;
import com.fluffymoment.futurebackport.init.BlockInit;
import com.fluffymoment.futurebackport.init.ItemInit;
import com.fluffymoment.futurebackport.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockWoodPressurePlate extends BlockPressurePlate implements IHasModel
{
    public BlockWoodPressurePlate(String name, Material materialIn, Sensitivity sensitivityIn)
    {
        super(Material.WOOD, Sensitivity.EVERYTHING);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.FUTUREBACKPORTTAB);
        setHardness(0.5F);
        setResistance(0.5F);
        setSoundType(SoundType.WOOD);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels()
    {
        Main.clientProxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
