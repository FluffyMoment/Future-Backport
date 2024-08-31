package com.fluffymoment.futurebackport.objects.blocks.blast_furnace.slots;

import com.fluffymoment.futurebackport.objects.blocks.blast_furnace.TileEntityBlastFurnace;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotBlastFurnaceFuel extends Slot
{
    public SlotBlastFurnaceFuel(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition)
    {
        super(inventoryIn, slotIndex, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack)
    {
        return TileEntityBlastFurnace.isItemFuel(stack) || isBucket(stack);
    }

    @Override
    public int getItemStackLimit(ItemStack stack)
    {
        return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
    }

    public static boolean isBucket(ItemStack stack)
    {
        return stack.getItem() == Items.BUCKET;
    }
}

