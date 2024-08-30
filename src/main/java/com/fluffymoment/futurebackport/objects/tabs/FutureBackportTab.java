package com.fluffymoment.futurebackport.objects.tabs;

import com.fluffymoment.futurebackport.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class FutureBackportTab extends CreativeTabs
{
    public FutureBackportTab(String label)
    {
        super("futurebackporttab");
        setBackgroundImageName("futurebackport.png");
    }

    @Override
    public ItemStack getTabIconItem()
     {
         return new ItemStack(ItemInit.TEST_ITEM);
     }
}
