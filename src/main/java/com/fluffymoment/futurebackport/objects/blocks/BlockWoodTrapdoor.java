package com.fluffymoment.futurebackport.objects.blocks;


import com.fluffymoment.futurebackport.Main;
import com.fluffymoment.futurebackport.init.BlockInit;
import com.fluffymoment.futurebackport.init.ItemInit;
import com.fluffymoment.futurebackport.util.IHasModel;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockWoodTrapdoor extends BlockTrapDoor implements IHasModel
{
    public BlockWoodTrapdoor(String name)
    {
        super(Material.WOOD);
        this.setSoundType(SoundType.WOOD);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setHardness(0.5F);
        this.setResistance(0.5F);
        this.setCreativeTab(Main.FUTUREBACKPORTTAB);
        this.setHarvestLevel("axe", 0);
        this.disableStats();

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity)
    {
        if (state.getValue(OPEN))
        {
            IBlockState down = world.getBlockState(pos.down());
            if (down.getBlock() instanceof BlockLadder)
                return down.getValue(BlockLadder.FACING) == state.getValue(FACING);
        }
        return false;
    }

    @Override
    public void registerModels()
    {
        Main.clientProxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
