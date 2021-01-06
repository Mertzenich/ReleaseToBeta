package ch.mertzeni.ReleaseToBeta.listeners;

import ch.mertzeni.ReleaseToBeta.ReleaseToBeta;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

public class FoodHandler implements Listener {

    public ReleaseToBeta plugin;
    public FoodHandler(ReleaseToBeta plugin) {
        this.plugin = plugin;
    }

    public static double healAmount(double playerHealth, double healAmount) {
        if (playerHealth + healAmount < 20) {
            return playerHealth + healAmount;
        }else {
            return 20;
        }
    }




    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        e.getPlayer().sendMessage(e.getItem().toString() + " " + e.getAction().toString() + " " + e.getItem().getType().toString());
        Player player = e.getPlayer();
        double playerHealth = player.getHealth();

        if (e.getItem().getType() == Material.COOKED_PORKCHOP) {
            player.setHealth(healAmount(playerHealth, 8));
            player.sendMessage(String.valueOf(healAmount(playerHealth, 8)));
        }

    }

    // Disallow consuming food (probably won't ever fire when everything else is done)
    @EventHandler
    public void onConsume(PlayerItemConsumeEvent e) {
        e.setCancelled(true);
    }

}
