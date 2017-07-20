package com.kingofchaos.supplementalthings.blocks;

import net.minecraft.util.IStringSerializable;

public enum BlockRoadSubtypes implements IStringSerializable
{
    ROAD(0, "road"),
    SOLIDYELLOWLINE(1, "solidyellowline"),
    DASHEDYELLOWLINE(2, "dashedyellowline");

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

    private BlockRoadSubtypes(int i_meta, String i_name)
    {
        this.meta = i_meta;
        this.name = i_name;
    }

    static
    {
        for (BlockRoadSubtypes colour : values()) {
            META_LOOKUP[colour.getMetadata()] = colour;
        }
    }
}
