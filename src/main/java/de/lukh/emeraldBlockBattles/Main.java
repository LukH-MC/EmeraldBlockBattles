package de.lukh.emeraldBlockBattles;

import de.lukh.emeraldBlockBattles.cmds.addPlayer;
import de.lukh.emeraldBlockBattles.cmds.getPlayers;
import de.lukh.emeraldBlockBattles.cmds.removePlayer;
import de.lukh.emeraldBlockBattles.game.Game;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {
    public static Game game;
    public static Main plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        newCommand("addPlayer", new addPlayer());
        newCommand("getPlayers", new getPlayers());
        newCommand("removePlayer", new removePlayer());


        //end of Startup
        Bukkit.getConsoleSender().sendMessage("§aCreating Gameobject for BlockBattles");
        game = new Game();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }







    //

    public static Component sendError(String s) {
        return Component.text("[", NamedTextColor.DARK_AQUA)
                .append(Component.text("EBB", NamedTextColor.DARK_GREEN))
                .append(Component.text("]", NamedTextColor.DARK_AQUA))
                .append(Component.text(" " + s, NamedTextColor.RED));
    }
    public static Component sendWarning(String s) {
        return Component.text("[", NamedTextColor.DARK_AQUA)
                .append(Component.text("EBB", NamedTextColor.DARK_GREEN))
                .append(Component.text("]", NamedTextColor.DARK_AQUA))
                .append(Component.text(" " + s, NamedTextColor.GOLD));
    }
    public static Component sendInfo(String s) {
        return Component.text("[", NamedTextColor.DARK_AQUA)
                .append(Component.text("EBB", NamedTextColor.DARK_GREEN))
                .append(Component.text("]", NamedTextColor.DARK_AQUA))
                .append(Component.text(" " + s, NamedTextColor.AQUA));
    }











    //Eventregisitrierung
    private void newEvent(Listener eventfile) {
        Bukkit.getPluginManager().registerEvents(eventfile, this);
    }

    //Einfache Befehls Erstellung
    private void newCommand(String command, CommandExecutor cmdFile) {
        PluginCommand pluginCommand = getCommand(command);

        if (pluginCommand != null) pluginCommand.setExecutor(cmdFile);
        else Bukkit.getLogger().warning("Befehl '" + command + "' konnte nicht registriert werden - Prüfe die yml und Code");
    }
}
