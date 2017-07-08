package com.kingofchaos.supplementalthings.command;

import com.google.common.collect.Lists;
import com.kingofchaos.supplementalthings.SupplementalThings;
import com.kingofchaos.supplementalthings.commandhelper.CommandHelper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nonnull;
import java.util.List;

public class CommandFly extends CommandBase {

    public CommandFly(){
        aliases = Lists.newArrayList(SupplementalThings.modid, "Fly", "fly");
    }

    private final List<String> aliases;

    @Override
    @Nonnull
    public String getCommandName() {
        return "fly";
    }

    @Override
    @Nonnull
    public String getCommandUsage(@Nonnull ICommandSender sender) {
        return "/fly  - Gives you flight";
    }

    @Override
    @Nonnull
    public List<String> getCommandAliases() {
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        if (sender instanceof EntityPlayer) {

            if (CommandHelper.isFlyEnabled((EntityPlayer) sender,true))
            {
                sender.addChatMessage(new TextComponentString("Your fly has been turned off"));
                CommandHelper.setFly((EntityPlayer) sender, false);
            }

            else
            {
                sender.addChatMessage(new TextComponentString("Your fly has been turned on"));
                CommandHelper.setFly((EntityPlayer) sender, true);
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
