package com.kingofchaos.supplementalthings.blocks;

import com.kingofchaos.supplementalthings.SupplementalThings;
import com.kingofchaos.supplementalthings.creativetab.CreativeTabSupplementalThings;
import com.kingofchaos.supplementalthings.items.ItemBlockRoad;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import static com.kingofchaos.supplementalthings.init.ModBlocks.itemBlockRoad;
import static com.kingofchaos.supplementalthings.init.ModBlocks.road;
import static net.minecraftforge.fml.common.registry.GameRegistry.register;

//TODO Different Variants
public class BlockRoad extends Block {

    public static void init(){

        road = register(new BlockRoad());

        itemBlockRoad = new ItemBlockRoad(road);
        itemBlockRoad.setRegistryName("roaditem");
        register(itemBlockRoad);}

    public BlockRoad() {
        super(Material.ROCK);
        this.setCreativeTab(SupplementalThings.creativeTab);
        setUnlocalizedName("road");
        setRegistryName("road");
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState iBlockState) {
        return EnumBlockRenderType.MODEL;
    }

    public static final PropertyDirection PROPERTYFACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static final PropertyEnum PROPERTYCOLOUR = PropertyEnum.create("colour", BlockRoadSubtypes.class);

    @Override
    public int damageDropped(IBlockState state) {
        BlockRoadSubtypes BlockRoadSubtypes = (BlockRoadSubtypes) state.getValue(PROPERTYCOLOUR);
        return BlockRoadSubtypes.getMetadata();
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
        BlockRoadSubtypes[] allColours = BlockRoadSubtypes.values();
        for (BlockRoadSubtypes colour : allColours) {
            list.add(new ItemStack(itemIn, 1, colour.getMetadata()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing facing = EnumFacing.getHorizontal(meta);
        int colourbits = (meta & 0x0c) >> 2;
        BlockRoadSubtypes colour = BlockRoadSubtypes.byMetadata(colourbits);
        return this.getDefaultState().withProperty(PROPERTYCOLOUR, colour).withProperty(PROPERTYFACING, facing);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        EnumFacing facing = (EnumFacing) state.getValue(PROPERTYFACING);
        BlockRoadSubtypes colour = (BlockRoadSubtypes) state.getValue(PROPERTYCOLOUR);

        int facingbits = facing.getHorizontalIndex();
        int colourbits = colour.getMetadata() << 2;
        return facingbits | colourbits;
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, PROPERTYFACING, PROPERTYCOLOUR);
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        BlockRoadSubtypes colour = BlockRoadSubtypes.byMetadata(meta);
        EnumFacing enumfacing = (placer == null) ? EnumFacing.NORTH : EnumFacing.fromAngle(placer.rotationYaw);

        return this.getDefaultState().withProperty(PROPERTYFACING, enumfacing).withProperty(PROPERTYCOLOUR, colour);
    }
}
