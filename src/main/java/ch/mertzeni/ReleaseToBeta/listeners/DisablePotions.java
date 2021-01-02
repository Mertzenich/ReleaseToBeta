package ch.mertzeni.ReleaseToBeta.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;

public class DisablePotions implements Listener {
    @EventHandler
    public void onPotionEffect(EntityPotionEffectEvent e) {
        e.setCancelled(true);
    }
}
