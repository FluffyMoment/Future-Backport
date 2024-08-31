package com.fluffymoment.futurebackport;

import com.fluffymoment.futurebackport.objects.tabs.FutureBackportTab;
import com.fluffymoment.futurebackport.proxy.ClientProxy;
import com.fluffymoment.futurebackport.proxy.CommonProxy;
import com.fluffymoment.futurebackport.util.Reference;
import com.fluffymoment.futurebackport.util.handlers.GuiHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import java.io.File;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main
{
    @Mod.Instance
    public static Main instance;

    public static CommonProxy serverProxy = new CommonProxy();

    public static ClientProxy clientProxy = new ClientProxy();

    public static final CreativeTabs FUTUREBACKPORTTAB = new FutureBackportTab("futurebackport");

    public static File config;

    @Mod.EventHandler
    public void preInit(net.minecraftforge.fml.common.event.FMLPreInitializationEvent event)
    {

    }
    @Mod.EventHandler
    public void init(net.minecraftforge.fml.common.event.FMLInitializationEvent event)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
    }
    @Mod.EventHandler
    public void postInit(net.minecraftforge.fml.common.event.FMLPostInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void serverInit(net.minecraftforge.fml.common.event.FMLServerStartingEvent event)
    {

    }
}
