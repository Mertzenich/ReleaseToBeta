package ch.mertzeni.ReleaseToBeta.listeners;

import ch.mertzeni.ReleaseToBeta.ReleaseToBeta;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ItemHandler implements Listener {

    public ReleaseToBeta plugin;
    public ItemHandler(ReleaseToBeta plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onItemPickup(EntityPickupItemEvent e) {
        if (e.getEntity().getType() == EntityType.PLAYER) {
            Player player = (Player) e.getEntity();
            Inventory inv = player.getInventory();

            ArrayList<Material> foods = new ArrayList<Material>();
            foods.add(Material.COOKED_PORKCHOP);
            foods.add(Material.MUSHROOM_STEW);
            foods.add(Material.GOLDEN_APPLE);
            foods.add(Material.APPLE);
            foods.add(Material.BREAD);
            foods.add(Material.PORKCHOP);
            foods.add(Material.SALMON);
            foods.add(Material.COOKED_SALMON);
            foods.add(Material.COOKIE);

//            if (e.getItem().getItemStack().getType() == Material.COOKIE) {
            if (foods.contains(e.getItem().getItemStack().getType())) {
                Item item = (Item) e.getItem();
                ItemStack itemStack = (ItemStack) item.getItemStack();
                player.sendMessage("" + itemStack.getType());
                int itemAmount = itemStack.getAmount();
                itemStack.setAmount(1);

                item.remove();
                for (int i = 0; i < itemAmount; i++) {
                    inv.setItem(player.getInventory().firstEmpty(), itemStack);
                }

                e.setCancelled(true);
            }



        }
    }


}
