package de.lukh.emeraldBlockBattles.cmds;

import de.lukh.emeraldBlockBattles.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class addPlayer implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
            if (args.length < 1) {
                sender.sendMessage(Main.sendError("Too many arguments! You can only add one player at a time."));
                return false;
            }
            if (Bukkit.getPlayer(args[0]) == null) {
                sender.sendMessage(Main.sendError("No player found!"));
                return false;
            }
            if (!Objects.requireNonNull(Bukkit.getPlayer(args[0])).isConnected()) {
                sender.sendMessage(Main.sendWarning("Player is not online!"));
                return false;
            }
            int retval = Main.game.setPlayer(args[0]);

            switch (retval) {
                case 0:
                    sender.sendMessage(Main.sendInfo("Player has been set as Player 1."));
                    return true;
                case 1:
                    sender.sendMessage(Main.sendInfo("Player has been set as Player 2."));
                    return true;
                case -1:
                    sender.sendMessage(Main.sendError("Player limit exceeded! Please remove a player via /removePlayer [name]"));
                    return false;
            }

        return false;
    }
}
