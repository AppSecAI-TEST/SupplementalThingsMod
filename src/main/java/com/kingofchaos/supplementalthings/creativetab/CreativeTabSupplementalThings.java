package com.kingofchaos.supplementalthings.creativetab;

import com.kingofchaos.supplementalthings.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabSupplementalThings extends CreativeTabs
{
    public CreativeTabSupplementalThings() {
        super("miscblocks2");
    }

    @Override
    public Item getTabIconItem() {
        return ModItems.test;
    }
}
