package com.kingofchaos.supplementalthings.items;

import com.kingofchaos.supplementalthings.SupplementalThings;
import net.minecraft.item.Item;

public class ItemSupplementalThings extends Item
{
    protected String name;

    public ItemSupplementalThings(String name) {
        this.name = name;
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(SupplementalThings.creativeTab);
    }

    public void registerItemModel() {
        SupplementalThings.proxy.registerItemRenderer(this, 0, this.name);
    }
}
