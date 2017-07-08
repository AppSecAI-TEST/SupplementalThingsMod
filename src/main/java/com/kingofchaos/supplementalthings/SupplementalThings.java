
package com.kingofchaos.supplementalthings;

import com.kingofchaos.supplementalthings.command.CommandGod;
import com.kingofchaos.supplementalthings.creativetab.CreativeTabSupplementalThings;
import com.kingofchaos.supplementalthings.init.ModBlocks;
import com.kingofchaos.supplementalthings.init.ModItems;
import com.kingofchaos.supplementalthings.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = SupplementalThings.modid, name = SupplementalThings.name, version = SupplementalThings.version)
public class SupplementalThings {

    public static final String modid = "supplementalthings";
    public static final String name = "supplementalthings";
    public static final String version = "DEV-1.0";

    @SidedProxy(serverSide = "com.kingofchaos.supplementalthings.proxy.ServerProxy", clientSide = "com.kingofchaos.supplementalthings.proxy.ClientProxy")
    public static CommonProxy proxy;

    public static final CreativeTabSupplementalThings creativeTab = new CreativeTabSupplementalThings();


    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        System.out.println("Supplemental Things is in the preinit phase!");
        ModItems.init();
        ModBlocks.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("Supplemental Things is in the init phase!");
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        System.out.println("Supplemental Things is in the postinit phase!");
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandGod());
    }

}
