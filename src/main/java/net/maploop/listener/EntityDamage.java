package net.maploop.listener;

import net.maploop.GrapplingHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import static org.bukkit.event.entity.EntityDamageEvent.DamageCause.FALL;

public class EntityDamage implements Listener {
    @EventHandler
    public static void onDamage(EntityDamageEvent event) {
        if(event.getEntity() instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL) {
            Player player = (Player) event.getEntity();
            if(GrapplingHook.FLYING_TIMEOUT.containsKey(player.getUniqueId())) {
                if(GrapplingHook.FLYING_TIMEOUT.get(player.getUniqueId()) < System.currentTimeMillis()) return;
                event.setCancelled(true);
            }
        }
    }
}
