package ch.mertzeni.ReleaseToBeta.listeners;

import ch.mertzeni.ReleaseToBeta.ReleaseToBeta;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Cake;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

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

    // Food Handling
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack itemStack = e.getItem();

        double playerHealth = player.getHealth();
        // Standard Food
        if (e.getItem() != null && e.getItem().getType() != null) {
            if (e.getItem().getType() == Material.COOKED_PORKCHOP) {
                player.setHealth(healAmount(playerHealth, 8));
                itemStack.setAmount(itemStack.getAmount() - 1);
            } else if (e.getItem().getType() == Material.MUSHROOM_STEW) {
                player.setHealth(healAmount(playerHealth, 10));
                itemStack.setAmount(itemStack.getAmount() - 1);
            } else if (e.getItem().getType() == Material.GOLDEN_APPLE) {
                player.setHealth(healAmount(playerHealth, 20));
                itemStack.setAmount(itemStack.getAmount() - 1);
            } else if (e.getItem().getType() == Material.APPLE) {
                player.setHealth(healAmount(playerHealth, 4));
                itemStack.setAmount(itemStack.getAmount() - 1);
            } else if (e.getItem().getType() == Material.BREAD) {
                player.setHealth(healAmount(playerHealth, 5));
                itemStack.setAmount(itemStack.getAmount() - 1);
            } else if (e.getItem().getType() == Material.PORKCHOP) {
                player.setHealth(healAmount(playerHealth, 3));
                itemStack.setAmount(itemStack.getAmount() - 1);
            } else if (e.getItem().getType() == Material.SALMON) {
                player.setHealth(healAmount(playerHealth, 2));
                itemStack.setAmount(itemStack.getAmount() - 1);
            } else if (e.getItem().getType() == Material.COOKED_SALMON) {
                player.setHealth(healAmount(playerHealth, 5));
                itemStack.setAmount(itemStack.getAmount() - 1);
            } else if (e.getItem().getType() == Material.COOKIE) {
                player.setHealth(healAmount(playerHealth, 1));
                itemStack.setAmount(itemStack.getAmount() - 1);
            }
        }

        // Cake Eating
        Block clicked = e.getClickedBlock();
        if (clicked != null &&
        clicked.getType() == Material.CAKE &&
        e.getAction() == Action.RIGHT_CLICK_BLOCK) {

            Cake cakeData = (Cake) e.getClickedBlock().getBlockData();
            player.sendMessage("" + cakeData.getBites());
            if (cakeData.getBites() == 4) {
                cakeData.setBites(6);
                e.getClickedBlock().setBlockData(cakeData);

                e.setCancelled(true);
            }
            player.setHealth(healAmount(playerHealth, 3));
        }

    }


    // Disallow consuming food (probably won't ever fire when everything else is done)
    @EventHandler
    public void onConsume(PlayerItemConsumeEvent e) {
        e.setCancelled(true);
    }

}
