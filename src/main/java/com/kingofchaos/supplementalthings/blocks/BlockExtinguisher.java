package com.kingofchaos.supplementalthings.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockExtinguisher extends BlockDirection
{
    private static double NSX1WZ1 = 13.0D;
    private static double Y1 = 0.0D;
    private static double NZ1WX1 = 11.0D;
    private static double NSX2WZ2 = 4.0D;
    private static double Y2 = 7.0D;
    private static double NZ2WX2 = .0D;
    private static double SZ1 = 16.0D - NZ2WX2;
    private static double SZ2 = 16.0D - NZ1WX1;
    private static double EX1 = 16.0D - NZ2WX2;
    private static double EZ1 = 16.0D - NSX2WZ2;
    private static double EX2 = 16.0D - NZ1WX1;
    private static double EZ2 = 16.0D - NSX1WZ1;

    private static final AxisAlignedBB NORTH_BOX = new AxisAlignedBB(PixelSize * NSX1WZ1, PixelSize * Y1, PixelSize * NZ1WX1, PixelSize * NSX2WZ2, PixelSize * Y2, PixelSize * NZ2WX2);
    private static final AxisAlignedBB SOUTH_BOX = new AxisAlignedBB(PixelSize * NSX1WZ1, PixelSize * Y1, PixelSize * SZ1, PixelSize * NSX2WZ2, PixelSize * Y2, PixelSize * SZ2);
    private static final AxisAlignedBB WEST_BOX = new AxisAlignedBB(PixelSize * NZ1WX1, PixelSize * Y1, PixelSize * NSX1WZ1, PixelSize * NZ2WX2, PixelSize * Y2, PixelSize * NSX2WZ2);
    private static final AxisAlignedBB EAST_BOX = new AxisAlignedBB(PixelSize * EX1, PixelSize * Y1, PixelSize * EZ1, PixelSize * EX2, PixelSize * Y2, PixelSize * EZ2);

    public BlockExtinguisher(String name) {
        super(Material.ROCK, name);
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch (state.getValue(FACING))
        {
            case EAST:
                return EAST_BOX;
            case WEST:
                return WEST_BOX;
            case SOUTH:
                return SOUTH_BOX;
            case NORTH:
                return NORTH_BOX;
            default:
                return NORTH_BOX;
        }
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
}
