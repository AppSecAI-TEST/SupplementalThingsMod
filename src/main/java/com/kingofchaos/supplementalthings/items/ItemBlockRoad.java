package com.kingofchaos.supplementalthings.items;

import com.kingofchaos.supplementalthings.blocks.BlockRoad;
import com.kingofchaos.supplementalthings.blocks.BlockRoadSubtypes;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockRoad extends ItemBlock
{

    public ItemBlockRoad(Block block)
    {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int metadata)
    {
        return metadata;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        BlockRoadSubtypes colour = BlockRoadSubtypes.byMetadata(stack.getMetadata());
        return super.getUnlocalizedName() + "." + colour.toString();
    }
}
