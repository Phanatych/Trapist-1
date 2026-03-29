package com.trapistsone.mod.commands;

import com.trapistsone.mod.world.dimension.ModDimensions;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class CommandTeleportDimension extends CommandBase {

    @Override
    public String getName() {
        return "tpdimension";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/tpdimension <id>";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (sender instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP) sender;
            if (args.length == 1) {
                try {
                    int dimensionId = Integer.parseInt(args[0]);
                    
                    if (player.dimension != dimensionId) {
                        server.getPlayerList().transferPlayerToDimension(player, dimensionId, new TeleporterDimension(server.getWorld(dimensionId)));
                    } else {
                        // Return to overworld if already there
                        server.getPlayerList().transferPlayerToDimension(player, 0, new TeleporterDimension(server.getWorld(0)));
                    }
                } catch (NumberFormatException e) {
                    throw new CommandException("Invalid dimension ID");
                }
            }
        }
    }

    // A simple teleporter that places the player at a safe height
    private static class TeleporterDimension extends Teleporter {
        public TeleporterDimension(WorldServer worldIn) {
            super(worldIn);
        }

        @Override
        public void placeInPortal(net.minecraft.entity.Entity entityIn, float rotationYaw) {
            this.world.getBlockState(new net.minecraft.util.math.BlockPos((int)entityIn.posX, 100, (int)entityIn.posZ));
            entityIn.setPositionAndUpdate(entityIn.posX, 100, entityIn.posZ);
        }

        @Override
        public boolean placeInExistingPortal(net.minecraft.entity.Entity entityIn, float rotationYaw) {
            return false;
        }

        @Override
        public boolean makePortal(net.minecraft.entity.Entity entityIn) {
            return true;
        }
    }
}
