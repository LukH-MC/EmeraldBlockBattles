package de.lukh.emeraldBlockBattles.cmds;

import de.lukh.emeraldBlockBattles.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class removePlayer implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (args.length < 1) {
            sender.sendMessage(Main.sendError("Too many arguments! You can only add one player at a time."));
            return false;
        }
        if (Bukkit.getPlayer(args[0]) == null) {
            sender.sendMessage(Main.sendError("No player found!"));
            return false;
        }
        Player[] registered = Main.game.getPlayerObj();

        if (registered[0].getName().equals(args[0])) {
            Main.game.forceRemovePlayer(0);
            return true;
        }
        if (registered[1].getName().equals(args[0])) {
            Main.game.forceRemovePlayer(1);
            return true;
        }
        return false;
    }
}
