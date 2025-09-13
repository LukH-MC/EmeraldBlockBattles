package de.lukh.emeraldBlockBattles.cmds;

import de.lukh.emeraldBlockBattles.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class getPlayers implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
            if (Main.game.getPlayers() == null) {
                sender.sendMessage(Main.sendWarning("There are no players registered for a battle. Add 2 via /addPlayer [name]"));
                return false;
            }
            sender.sendMessage(Main.sendInfo(Main.game.getPlayers()));
        return true;
    }
}
