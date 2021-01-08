package ch.mertzeni.ReleaseToBeta.listeners;

import ch.mertzeni.ReleaseToBeta.ReleaseToBeta;
import ch.mertzeni.ReleaseToBeta.tasks.HungerFix;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitTask;

public class HungerHandler implements Listener {
    public ReleaseToBeta plugin;
    public HungerHandler(ReleaseToBeta plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        String uuid = e.getPlayer().getUniqueId().toString();
    }

    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent e) {
        String uuid = e.getEntity().getUniqueId().toString();
        e.setFoodLevel(6);
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();
        player.sendMessage("Name: " + player.getName() + " Display name: " + player.getDisplayName() + " Player list name: " + player.getPlayerListName() + " UID " + player.getUniqueId());
        BukkitTask task = new HungerFix(plugin, player).runTask(plugin);
    }

}
