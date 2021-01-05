package ch.mertzeni.ReleaseToBeta.listeners;

import ch.mertzeni.ReleaseToBeta.ReleaseToBeta;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class FoodHandler implements Listener {

    public ReleaseToBeta plugin;
    public FoodHandler(ReleaseToBeta plugin) {
        this.plugin = plugin;
    }


    // Disallow placing items in off-hand slot
    @EventHandler
    public void onConsume(PlayerItemConsumeEvent e) {
        e.setCancelled(true);
    }

}
