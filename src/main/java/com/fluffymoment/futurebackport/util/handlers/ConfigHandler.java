package com.fluffymoment.futurebackport.util.handlers;

import com.fluffymoment.futurebackport.Main;
import com.fluffymoment.futurebackport.util.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class ConfigHandler
{
    public static Configuration config;

    //GUI IDs
    public static int GUI_SMOKER = 4;

    //Entities

    //Dimensions

    //Miscellaneous

    public static void init(File file)
    {
        config = new Configuration(file);
        String category;

        category = "GUI IDs";
        config.addCustomCategoryComment(category, "Set IDs for each GUI.");
        GUI_SMOKER = config.getInt("GUI Smoker", category, 4, 0, 500, "GUI ID for the Smoker");

        category = "Entity IDs";
        config.addCustomCategoryComment(category, "Set IDs for each Entity.");

        category = "Dimension IDs";
        config.addCustomCategoryComment(category, "Set IDs for each Dimension.");

        category = "Miscellaneous";
        config.addCustomCategoryComment(category, "Set Miscellaneous Things.");

        config.save();
    }

    public static void registerConfig(FMLPreInitializationEvent event)
    {
        Main.config = new File(event.getModConfigurationDirectory() + "/" + Reference.MOD_ID);
        Main.config.mkdirs();
        init(new File(Main.config.getPath(), Reference.MOD_ID + ".cfg"));
    }
}
