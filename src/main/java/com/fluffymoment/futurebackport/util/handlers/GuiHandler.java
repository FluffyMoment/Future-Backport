package com.fluffymoment.futurebackport.util.handlers;

import com.fluffymoment.futurebackport.objects.blocks.smoker.ContainerSmoker;
import com.fluffymoment.futurebackport.objects.blocks.smoker.GuiSmoker;
import com.fluffymoment.futurebackport.objects.blocks.smoker.TileEntitySmoker;
import com.fluffymoment.futurebackport.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == ConfigHandler.GUI_SMOKER)
        {
            return new ContainerSmoker(player.inventory, (TileEntitySmoker)world.getTileEntity(new BlockPos(x, y, z)));
        }

        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == ConfigHandler.GUI_SMOKER)
        {
            return new GuiSmoker(player.inventory, (TileEntitySmoker)world.getTileEntity(new BlockPos(x, y, z)));
        }

        return null;
    }
}