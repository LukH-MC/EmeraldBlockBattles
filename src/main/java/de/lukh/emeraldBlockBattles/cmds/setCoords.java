package de.lukh.emeraldBlockBattles.cmds;

import de.lukh.emeraldBlockBattles.Main;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class setCoords implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        if (args.length != 4) {
            sender.sendMessage(Main.sendError("Wrong amount of arguments! \nUsage: /setCoords [1/2] [x] [y] [z]"));
            return false;
        }

        if (args[0] != "1" && args[0] != "2") {
            sender.sendMessage(Main.sendError("Wrong usage! \nUsage: /setCoords [1/2] [x] [y] [z]"));
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (StringUtils.isNumeric(args[i])) {
                sender.sendMessage(Main.sendError("Wrong usage! \nUsage: /setCoords [1/2] [x] [y] [z]"));
                return false;
            }
        }



        Location coords = null;
        coords.add(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));


        return false;
    }
}
