package ch.mertzeni.ReleaseToBeta;

import ch.mertzeni.ReleaseToBeta.listeners.DisableHunger;
import ch.mertzeni.ReleaseToBeta.listeners.DisablePotions;
import ch.mertzeni.ReleaseToBeta.listeners.DisableShieldSlot;
import ch.mertzeni.ReleaseToBeta.listeners.PlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

@Plugin(name="ReleaseToBeta" , version="0.1")
@Description(value = "Taking modern minecraft back to simpler times.")
@Author(value = "Adam Mertzenich")

public class ReleaseToBeta extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DisableShieldSlot(), this);
        getServer().getPluginManager().registerEvents(new DisableHunger(), this);
        getServer().getPluginManager().registerEvents(new DisablePotions(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getLogger().info("Release to Beta has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Release to Beta has been disabled.");
    }
}
