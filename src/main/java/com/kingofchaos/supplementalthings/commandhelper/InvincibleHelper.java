package com.kingofchaos.supplementalthings.commandhelper;

import net.minecraft.entity.player.EntityPlayer;

public class InvincibleHelper {


    public static void setInvincible(EntityPlayer player, boolean invincible) {
        player.capabilities.disableDamage = invincible;
        player.sendPlayerAbilities();
    }

    public static boolean isInvincible(EntityPlayer player, boolean b) {
        return player.capabilities.disableDamage;
    }

}
