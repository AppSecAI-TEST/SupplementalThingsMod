package com.kingofchaos.supplementalthings.commandhelper;

import net.minecraft.entity.player.EntityPlayer;

public class CommandHelper {

    public static void setInvincible(EntityPlayer player, boolean invincible) {
        player.capabilities.disableDamage = invincible;
        player.sendPlayerAbilities();
    }

    public static boolean isInvincible(EntityPlayer player, boolean invincible) {
        return player.capabilities.disableDamage;
    }

    public static void setFly(EntityPlayer player, boolean flymode) {
        player.capabilities.allowFlying = flymode;
        player.sendPlayerAbilities();
    }

    public static boolean isFlyEnabled(EntityPlayer player, boolean flymode) {
        return player.capabilities.allowFlying;
    }

}
