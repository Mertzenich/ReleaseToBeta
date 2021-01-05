package ch.mertzeni.ReleaseToBeta;

import ch.mertzeni.ReleaseToBeta.listeners.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.command.Command;
import org.bukkit.plugin.java.annotation.command.Commands;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

@Plugin(name="ReleaseToBeta" , version="0.1")
@Description(value = "Taking modern minecraft back to simpler times.")
@Author(value = "Adam Mertzenich")
@Commands(@Command(name = "r2b", desc = "ReleaseToBeta Command"))

public class ReleaseToBeta extends JavaPlugin {
    @Override
    public void onEnable() {
        // Configurationn
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Register Events
        if (getConfig().getBoolean("enabled")) {
            getServer().getPluginManager().registerEvents(new DisableShieldSlot(this), this);
            getServer().getPluginManager().registerEvents(new DisableHunger(this), this);
            getServer().getPluginManager().registerEvents(new FoodHandler(this), this);
            getServer().getPluginManager().registerEvents(new DisablePotions(), this);
            getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        }

        getLogger().info("Release to Beta has been enabled.");
    }

    @Override
    public void onDisable() {
    }
}
