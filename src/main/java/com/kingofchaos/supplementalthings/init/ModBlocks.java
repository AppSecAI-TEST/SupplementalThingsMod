package com.kingofchaos.supplementalthings.init;

import com.kingofchaos.supplementalthings.blocks.*;
import com.kingofchaos.supplementalthings.items.ItemBlockRoad;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks
{
    public static BlockSupplementalThingsMain testblock;
    public static BlockSupplementalThingsMain xblock;
    public static BlockExit exit;
    public static BlockCone cone;
    public static BlockBaseBlocks model;
    public static BlockBaseBlocks totalblack;
    public static BlockRoad road;
    public static BlockExtinguisher extinguisher;
    public static BlockCement cement;
    public static ItemBlockRoad itemBlockRoad;

    public ModBlocks() {
    }

    public static void init() {
        testblock = register(new BlockBaseBlocks("testblock"));
        xblock = register(new BlockBaseBlocks("xblock"));
        exit = register(new BlockExit("exit"));
        cone = register(new BlockCone("cone"));
        model = register(new BlockBaseBlocks("model"));
        totalblack = register(new BlockBaseBlocks("totalblack"));
        extinguisher = register(new BlockExtinguisher("extinguisher"));
        cement = register(new BlockCement("cement"));
    }

    private static <T extends Block> T register(T block, ItemBlock itemBlock) {
        GameRegistry.register(block);
        GameRegistry.register(itemBlock);
        if(block instanceof BlockBaseBlocks) {
            ((BlockBaseBlocks)block).registerItemModel(itemBlock);
        }

        if(block instanceof BlockExit) {
            ((BlockExit)block).registerItemModel(itemBlock);
        }

        if(block instanceof BlockCone) {
            ((BlockCone)block).registerItemModel(itemBlock);
        }

        if(block instanceof BlockExtinguisher) {
            ((BlockExtinguisher)block).registerItemModel(itemBlock);
        }

        return block;
    }

    private static <T extends Block> T register(T block) {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return register(block, itemBlock);
    }
}
