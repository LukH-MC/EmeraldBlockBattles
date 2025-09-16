package de.lukh.emeraldBlockBattles.cmds;

import de.lukh.emeraldBlockBattles.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class getArena implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        Location[] locs = Main.game.getArena();

        if (locs[0] == null ||  locs[1] == null) {
            sender.sendMessage(Main.sendError("You have not setup an arena yet! Try using /setArena"));
            return false;
        }

        sender.sendMessage(Main.sendInfo("Point 1: " + locs[0].getBlockX() + " " + locs[0].getBlockY() + " " + locs[0].getBlockZ() + "\nPoint 2: " + locs[1].getBlockX() + " " + locs[1].getBlockY() + " " + locs[1].getBlockZ()));

        return true;
    }
}
