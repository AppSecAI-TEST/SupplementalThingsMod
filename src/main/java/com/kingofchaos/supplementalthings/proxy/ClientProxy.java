package com.kingofchaos.supplementalthings.proxy;

import com.kingofchaos.supplementalthings.SupplementalThings;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {

    public ClientProxy()
    {

    }

    @SideOnly(Side.CLIENT)
    public void registerItemRenderer(Item item, int meta, String id)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(SupplementalThings.modid + ":" + id, "inventory"));
    }
    
}