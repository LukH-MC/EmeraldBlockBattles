package de.lukh.emeraldBlockBattles;

import de.lukh.emeraldBlockBattles.game.Game;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Game game;

    @Override
    public void onEnable() {
        // Plugin startup logic
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
}
