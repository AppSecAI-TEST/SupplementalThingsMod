package com.kingofchaos.supplementalthings.blocks;

import com.kingofchaos.supplementalthings.SupplementalThings;
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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import static com.kingofchaos.supplementalthings.blocks.BlockCustomModelBase.PixelSize;

public class BlockExit extends BlockCustomModelBase {

    private static double NSX1WZ1 = 13.0D;
    private static double Y1 = 0.0D;
    private static double NZ1WX1 = 0.0D;
    private static double NSX2WZ2 = 3.0D;
    private static double Y2 = 7.0D;
    private static double NZ2WX2 = 2.0D;
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

    public BlockExit(String name) {
        super(Material.ROCK, name);
        setLightLevel(5.0F);
    }

    public void registerItemModel(ItemBlock itemBlock) {
        SupplementalThings.proxy.registerItemRenderer(itemBlock, 0, this.name);
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
}
