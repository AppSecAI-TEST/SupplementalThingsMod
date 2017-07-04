package com.kingofchaos.supplementalthings.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockExtinguisher extends BlockSupplementalThingsMain
{
    private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.6875D, 0.0D, 0.6875D, 0.25D, 0.9375D, 0.3125D);

    public BlockExtinguisher(String name) {
        super(Material.ROCK, name);
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDING_BOX;
    }
}
