package com.kingofchaos.supplementalthings.blocks;

import com.kingofchaos.supplementalthings.SupplementalThings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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

    public void registerItemModel(ItemBlock itemBlock) {
        SupplementalThings.proxy.registerItemRenderer(itemBlock, 0, this.name);
    }
}
