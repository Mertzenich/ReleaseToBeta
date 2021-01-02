package ch.mertzeni.adam.ReleaseToBeta.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().setFoodLevel(6);
        e.getPlayer().getActivePotionEffects().clear();
    }
}
