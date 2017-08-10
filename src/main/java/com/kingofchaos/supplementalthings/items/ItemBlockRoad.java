package com.kingofchaos.supplementalthings.items;

import com.kingofchaos.supplementalthings.SupplementalThings;
import com.kingofchaos.supplementalthings.blocks.blocksubtypes.BlockRoadSubtypes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import static com.kingofchaos.supplementalthings.init.ModBlocks.road;

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
        BlockRoadSubtypes variant = BlockRoadSubtypes.byMetadata(stack.getMetadata());
        return super.getUnlocalizedName() + "." + variant.toString();
    }

    public void registerItemModel(ItemBlock itemBlock) {
        SupplementalThings.proxy.registerItemRenderer(Item.getItemFromBlock(road), 0, "road");
    }
}
