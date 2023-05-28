package me.goodi.wd1.Runnables;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.scheduler.BukkitRunnable;

public class ZombieTarget extends BukkitRunnable {
    @Override
    public void run() {
        for (LivingEntity entity : Bukkit.getWorld("world").getLivingEntities()) {

            if (entity instanceof Zombie) {

                for (Entity player : entity.getNearbyEntities(100, 30, 100)) {
                    for (Entity entity1 : entity.getNearbyEntities(100, 30, 100)) {
                        if (player instanceof Player) {

                            if (((Player) player).getGameMode().equals(GameMode.SURVIVAL)) {
                                ((Zombie) entity).setTarget((LivingEntity) player);
                                ((Zombie) entity1).setTarget((LivingEntity) player);
                            }
                        }
                    }
                }
            }
        }
    }
}
