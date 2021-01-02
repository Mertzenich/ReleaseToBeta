package ch.mertzeni.ReleaseToBeta.listeners;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class DisableShieldSlot implements Listener {

    // Disallow placing items in off-hand slot
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getSlot() == 40) {
            e.setCancelled(true);
        }
    }

    // Disallow dragging items into off-hand slot
    @EventHandler
    public void onInventoryDrag(InventoryDragEvent e) {
        if (e.getInventorySlots().contains(40)) {
            e.setCancelled(true);
        }
    }

    // Disallow using key to swap items into off-hand slot
    @EventHandler
    public void onHandSwap(PlayerSwapHandItemsEvent e) {
        e.setCancelled(true);
    }
}
