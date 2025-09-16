package de.lukh.emeraldBlockBattles.cmds;

import de.lukh.emeraldBlockBattles.Main;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class setArena implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        if (args.length != 4) {
            sender.sendMessage(Main.sendError("Wrong amount of arguments! \nUsage: /setCoords [1/2] [x] [y] [z]"));
            return false;
        }

        if (!args[0].equals("1") && !args[0].equals("2")) {
            sender.sendMessage(Main.sendError("Wrong usage! \nUsage: /setCoords [1/2] [x] [y] [z]"));
            return false;
        }


        String intRegex = "^-?\\d+$";

        for (int i = 1; i < 4; i++) {
            if (!args[i].matches(intRegex)) {
                sender.sendMessage(Main.sendError("Invalid coordinate at position " + i +
                        "! Usage: /setCoords [1/2] [x] [y] [z]"));
                return false;
            }
        }


        World world = Bukkit.getWorld("world");
        Location coords = new Location(world, Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));
        try {
            Main.game.setCoord(coords, args[0]);
            sender.sendMessage(Main.sendInfo("Success!"));
        } catch (Exception e) {
            sender.sendMessage(Main.sendError("Something went wrong..."));
        }

        return false;
    }
}
