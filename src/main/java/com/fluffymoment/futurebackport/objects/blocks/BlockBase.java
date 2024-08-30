package com.fluffymoment.futurebackport.objects.blocks;

import com.fluffymoment.futurebackport.Main;
import com.fluffymoment.futurebackport.init.BlockInit;
import com.fluffymoment.futurebackport.init.ItemInit;
import com.fluffymoment.futurebackport.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel
{
    public BlockBase(String name, Material material)
    {
        super(material);
        setUnlocalizedName(name);
        setCreativeTab(Main.FUTUREBACKPORTTAB);
        setRegistryName(name);

        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        BlockInit.BLOCKS.add(this);
    }

    @Override
    public void registerModels()
    {
        Main.clientProxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
