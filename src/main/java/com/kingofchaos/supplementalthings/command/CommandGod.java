package com.kingofchaos.supplementalthings.command;

import com.google.common.collect.Lists;
import com.kingofchaos.supplementalthings.SupplementalThings;
import com.kingofchaos.supplementalthings.commandhelper.InvincibleHelper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nonnull;
import java.util.List;

public class CommandGod extends CommandBase {

    public CommandGod(){
        aliases = Lists.newArrayList(SupplementalThings.modid, "God", "god");
    }

    private final List<String> aliases;

    @Override
    @Nonnull
    public String getCommandName() {
        return "god";
    }

    @Override
    @Nonnull
    public String getCommandUsage(@Nonnull ICommandSender sender) {
        return "/god - Makes you invincible";
    }

    @Override
    @Nonnull
    public List<String> getCommandAliases() {
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        if (sender instanceof EntityPlayer) {

            if (InvincibleHelper.isInvincible((EntityPlayer) sender,true))
            {
                sender.addChatMessage(new TextComponentString("Your invincibility has been turned off"));
                InvincibleHelper.setInvincible((EntityPlayer) sender, false);
            }

            else
                {
                    sender.addChatMessage(new TextComponentString("Your invincibility has been turned on"));
                    InvincibleHelper.setInvincible((EntityPlayer) sender, true);
                }
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    public int getRequiredPermissionLevel()
    {
        return 2;
    }

}
