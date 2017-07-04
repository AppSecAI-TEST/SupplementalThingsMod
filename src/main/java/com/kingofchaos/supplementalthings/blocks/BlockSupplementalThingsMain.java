package com.kingofchaos.supplementalthings.blocks;

import com.kingofchaos.supplementalthings.SupplementalThings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;

public class BlockSupplementalThingsMain extends Block
{
    protected String name;

    public BlockSupplementalThingsMain(Material material, String name) {
        super(Material.ROCK);
        this.setCreativeTab(SupplementalThings.creativeTab);
        this.setHardness(1.5F);
        this.name = name;
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
    }

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public void registerItemModel(ItemBlock itemBlock) {
        SupplementalThings.proxy.registerItemRenderer(itemBlock, 0, this.name);
    }
}
