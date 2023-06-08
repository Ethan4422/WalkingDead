package me.goodi.wd1.Runnables;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.monster.Zombie;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.craftbukkit.v1_19_R2.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_19_R2.entity.CraftZombie;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ZombieTarget extends BukkitRunnable {
    @Override
    public void run() {
        for (Entity entity : Bukkit.getWorld("world").getEntities()) {
            if (entity.getType() == EntityType.ZOMBIE) {
                for (Entity p : entity.getNearbyEntities(100, 100, 100)) {
                    if (p.getType() == EntityType.PLAYER) {
                        if(((Player)p).getGameMode() == GameMode.SURVIVAL) {
                            ServerPlayer player = (((CraftPlayer) p).getHandle());
                            Zombie zombie = (((CraftZombie) entity).getHandle());

                            zombie.setTarget(player);
                        }
                    }
                }
            }
        }
    }
}
