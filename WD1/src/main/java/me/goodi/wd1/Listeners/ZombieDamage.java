package me.goodi.wd1.Listeners;

import net.minecraft.world.level.pathfinder.PathFinder;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.craftbukkit.v1_19_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_19_R2.entity.CraftZombie;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.lang.reflect.Field;

public class ZombieDamage implements Listener {

    @EventHandler
    public void setDamage(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Zombie) {
            if (e.getEntity() instanceof Player) {
                e.setDamage(10);
            }
        }
    }

    @EventHandler
    public void spawn(EntitySpawnEvent e){
        if(e.getEntity() instanceof Zombie z){
            z.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(100);
        }
    }

}