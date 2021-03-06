package ch.mertzeni.ReleaseToBeta.tasks;

import ch.mertzeni.ReleaseToBeta.ReleaseToBeta;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;

public class ShieldSlotFix extends BukkitRunnable {

    public ReleaseToBeta plugin;
    public Player player;
    public ShieldSlotFix(ReleaseToBeta plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
    }


    @Override
    public void run() {
        PlayerInventory inv = player.getInventory();
        ItemStack shieldSlot = inv.getItem(40);


        if (shieldSlot != null) {
            //player.getInventory().addItem(shieldSlot);
            inv.addItem(shieldSlot);
            player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1, 1);
            shieldSlot.setAmount(0);
        }
    }
}
