package me.goodi.wd1.Listeners;

import me.goodi.wd1.PathFinding.CustomZombie;
import net.minecraft.server.level.ServerLevel;
import org.bukkit.craftbukkit.v1_19_R2.CraftWorld;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;


public class ZombieDamage implements Listener {

    @EventHandler
    public void setDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Zombie) {
            e.setDamage(10);
        }
        e.getEntity().sendMessage(String.valueOf(e.getDamage()));
    }

    @EventHandler
    public void spawn(CreatureSpawnEvent e) {
        if (e.getEntity().getType().equals(EntityType.ZOMBIE)) {
            Zombie z = (Zombie) e.getEntity();
            CustomZombie zombie = new CustomZombie(z.getLocation());
            ServerLevel world = ((CraftWorld) z.getWorld()).getHandle();
            if(e.getSpawnReason() != CreatureSpawnEvent.SpawnReason.DEFAULT) {
                z.remove();
                world.addFreshEntity(zombie, CreatureSpawnEvent.SpawnReason.DEFAULT);
            }
        }
    }
}