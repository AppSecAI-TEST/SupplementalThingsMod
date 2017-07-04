package com.kingofchaos.supplementalthings.blocks;

import com.kingofchaos.supplementalthings.SupplementalThings;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockExit extends BlockSupplementalThingsMain
{
    private static double a;
    private static double NSX1WZ1;
    private static double SY1;
    private static double NZ1WX1;
    private static double NSX2WZ2;
    private static double SY2;
    private static double NZ2WX2;
    private static double SZ1;
    private static double SZ2;
    private static double EX1;
    private static double EZ1;
    private static double EX2;
    private static double EZ2;
    //private static final AxisAlignedBB NORTH_BOX;
    //private static final AxisAlignedBB SOUTH_BOX;
    //private static final AxisAlignedBB WEST_BOX;
    //private static final AxisAlignedBB EAST_BOX;

    public BlockExit(String name) {
        super(Material.ROCK, name);
    }
/*

    public void registerItemModel(ItemBlock itemBlock) {
        SupplementalThings.proxy.registerItemRenderer(itemBlock, 0, this.name);
    }

    public void func_180633_a(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {
        EnumFacing entityFacing = entity.func_174811_aO();
        if(!world.field_72995_K) {
            if(entityFacing == EnumFacing.NORTH) {
                entityFacing = EnumFacing.NORTH;
            } else if(entityFacing == EnumFacing.SOUTH) {
                entityFacing = EnumFacing.SOUTH;
            } else if(entityFacing == EnumFacing.EAST) {
                entityFacing = EnumFacing.EAST;
            } else if(entityFacing == EnumFacing.WEST) {
                entityFacing = EnumFacing.WEST;
            }

            world.func_180501_a(pos, state.func_177226_a(FACING, entityFacing), 2);
        }

    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        switch ((EnumFacing)state.getValue(FACING))
        {
            case EAST:
                return TORCH_EAST_AABB;
            case WEST:
                return TORCH_WEST_AABB;
            case SOUTH:
                return TORCH_SOUTH_AABB;
            case NORTH:
                return TORCH_NORTH_AABB;
            default:
                return STANDING_AABB;
        }
    }
    */

}
