package ch.mertzeni.ReleaseToBeta.listeners;


import ch.mertzeni.ReleaseToBeta.ReleaseToBeta;
import ch.mertzeni.ReleaseToBeta.tasks.ShieldSlotFix;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;

public class DisableShieldSlot implements Listener {

    public ReleaseToBeta plugin;
    public DisableShieldSlot(ReleaseToBeta plugin) {
        this.plugin = plugin;
    }


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
        Player player = Bukkit.getPlayer(e.getWhoClicked().getUniqueId());
        BukkitTask task = new ShieldSlotFix(plugin, player).runTask(plugin);
    }

    // Disallow using key to swap items into off-hand slot
    @EventHandler
    public void onHandSwap(PlayerSwapHandItemsEvent e) {
        e.setCancelled(true);
    }
}
