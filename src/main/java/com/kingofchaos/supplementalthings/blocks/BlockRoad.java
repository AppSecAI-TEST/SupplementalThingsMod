package com.kingofchaos.supplementalthings.blocks;

import com.kingofchaos.supplementalthings.SupplementalThings;
import com.kingofchaos.supplementalthings.blocks.blocksubtypes.BlockRoadSubtypes;
import com.kingofchaos.supplementalthings.items.ItemBlockRoad;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import static com.kingofchaos.supplementalthings.init.ModBlocks.itemBlockRoad;
import static com.kingofchaos.supplementalthings.init.ModBlocks.road;
import static net.minecraftforge.fml.common.registry.GameRegistry.register;

//TODO Different Variants, Cleanup, Adapt to existing code, Finish textures and inventory models
public class BlockRoad extends Block {

    public static final PropertyDirection PROPERTYFACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static final PropertyEnum PROPERTYVARIANT = PropertyEnum.create("variant", BlockRoadSubtypes.class);

    public static void init(){

        road = register(new BlockRoad());

        itemBlockRoad = new ItemBlockRoad(road);
        itemBlockRoad.setRegistryName("roaditem");
        register(itemBlockRoad);}

    public BlockRoad() {
        super(Material.ROCK);
        setCreativeTab(SupplementalThings.creativeTab);
        setUnlocalizedName("road");
        setRegistryName("road");
        setDefaultState(this.blockState.getBaseState().withProperty(PROPERTYVARIANT, BlockRoadSubtypes.ROAD));
    }

    @Override
    public int damageDropped(IBlockState state) {
        BlockRoadSubtypes BlockRoadSubtypes = (BlockRoadSubtypes) state.getValue(PROPERTYVARIANT);
        return BlockRoadSubtypes.getMetadata();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
        for (BlockRoadSubtypes blockroadsubtypes : BlockRoadSubtypes.values())
        {
            list.add(new ItemStack(itemIn, 1, blockroadsubtypes.getMetadata()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing facing = EnumFacing.getHorizontal(meta);
        return this.getDefaultState().withProperty(PROPERTYVARIANT, BlockRoadSubtypes.byMetadata(meta)).withProperty(PROPERTYFACING, facing);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((BlockRoadSubtypes)state.getValue(PROPERTYVARIANT)).getMetadata();
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, PROPERTYFACING, PROPERTYVARIANT);
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        BlockRoadSubtypes variant = BlockRoadSubtypes.byMetadata(meta);
        EnumFacing enumfacing = (placer == null) ? EnumFacing.NORTH : EnumFacing.fromAngle(placer.rotationYaw);

        return this.getDefaultState().withProperty(PROPERTYFACING, enumfacing).withProperty(PROPERTYVARIANT, variant);
    }


}
