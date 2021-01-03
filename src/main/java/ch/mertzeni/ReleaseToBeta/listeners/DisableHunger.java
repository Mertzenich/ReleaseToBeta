package ch.mertzeni.ReleaseToBeta.listeners;

import ch.mertzeni.ReleaseToBeta.ReleaseToBeta;
import ch.mertzeni.ReleaseToBeta.tasks.HungerFix;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class DisableHunger implements Listener {

    public ReleaseToBeta plugin;
    public DisableHunger(ReleaseToBeta plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent e) {
        Player player = Bukkit.getPlayer(e.getEntity().getUniqueId());
        e.setFoodLevel(6);
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();
        BukkitTask task = new HungerFix(plugin, player).runTask(plugin);
    }
}
