package com.kingofchaos.supplementalthings.blocks.blocksubtypes;

import net.minecraft.util.IStringSerializable;

public enum BlockRoadSubtypes implements IStringSerializable
{
    ROAD(0, "road"),
    DOUBLEYELLOWLINE(1, "doubleyellowline"),
    DASHEDYELLOWLINE(2, "dashedyellowline"),
    DASHEDWHITELINE(3, "dashedwhiteline"),
    SOLIDYELLOWLINE(4, "solidyellowline"),
    SOLIDWHITELINE(5, "solidwhiteline"),
    WHITETURNINGLINE(6, "whiteturningline"),
    YELLOWTURNINGLINE(7, "yellowturningline"),
    STANDARDCROSSWALKPART(8, "standardcrosswalk"),
    CONTINENTALCROSSWALK(9, "continentalcrosswalk");


    public int getMetadata()
    {
        return this.meta;
    }

    @Override
    public String toString()
    {
        return this.name;
    }

    public static BlockRoadSubtypes byMetadata(int meta)
    {
        if (meta < 0 || meta >= META_LOOKUP.length)
        {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    public String getName()
    {
        return this.name;
    }

    private final int meta;
    private final String name;
    private static final BlockRoadSubtypes[] META_LOOKUP = new BlockRoadSubtypes[values().length];

    BlockRoadSubtypes(int meta, String name)
    {
        this.meta = meta;
        this.name = name;
    }

    static
    {
        for (BlockRoadSubtypes variants : values()) {
            META_LOOKUP[variants.getMetadata()] = variants;
        }
    }
}
