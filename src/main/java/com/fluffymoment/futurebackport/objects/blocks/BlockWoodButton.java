package com.fluffymoment.futurebackport.objects.blocks;


import com.fluffymoment.futurebackport.Main;
import com.fluffymoment.futurebackport.init.BlockInit;
import com.fluffymoment.futurebackport.init.ItemInit;
import com.fluffymoment.futurebackport.util.IHasModel;
import net.minecraft.block.BlockButtonWood;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockWoodButton extends BlockButtonWood implements IHasModel
{
    public BlockWoodButton(String name)
    {
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
