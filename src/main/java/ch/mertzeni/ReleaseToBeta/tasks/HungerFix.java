package ch.mertzeni.ReleaseToBeta.tasks;

import ch.mertzeni.ReleaseToBeta.ReleaseToBeta;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;

public class HungerFix extends BukkitRunnable {
    public ReleaseToBeta plugin;
    public Player player;
    public HungerFix(ReleaseToBeta plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
    }


    @Override
    public void run() {
        player.setFoodLevel(6);
    }
}
