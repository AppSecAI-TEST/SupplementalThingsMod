package com.kingofchaos.supplementalthings.init;

import com.kingofchaos.supplementalthings.items.ItemSupplementalThings;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems
{
    public static ItemSupplementalThings test;

    public ModItems() {
    }

    public static void init() {
        test = register(new ItemSupplementalThings("test"));
    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);
        if(item instanceof ItemSupplementalThings) {
            ((ItemSupplementalThings)item).registerItemModel();
        }

        return item;
    }
}
