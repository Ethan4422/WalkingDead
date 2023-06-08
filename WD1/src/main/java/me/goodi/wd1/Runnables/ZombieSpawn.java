package me.goodi.wd1.Runnables;

import me.goodi.wd1.PathFinding.CustomZombie;
import net.minecraft.server.level.ServerLevel;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_19_R2.CraftWorld;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;
import java.util.Random;

import static me.goodi.wd1.WD1.plugin;

public class ZombieSpawn extends BukkitRunnable {
    FileConfiguration configuration = plugin.getConfig();

    private Location getRandomLocation(Chunk chunk) {
        Random rand = new Random();
        int x = rand.nextInt(16);
        int z = rand.nextInt(16);
        int y = chunk.getWorld().getHighestBlockYAt(x, z);
        Location randLoc = chunk.getBlock(x, y, z).getLocation();
        if (randLoc.getBlock().isLiquid() == false && randLoc.add(0,1,0).getBlock().getType() == Material.AIR && randLoc.getBlock().getLocation().add(0,-1,0).getBlock().getType() != Material.AIR) {
            return randLoc;
        }
        return null;
    }

    @Override
    public void run() {
        if (configuration.getBoolean("MobSpawn")) {
            for (Chunk chunk : Objects.requireNonNull(Bukkit.getWorld("world")).getLoadedChunks()) {
                Location loc = getRandomLocation(chunk);
                if (loc != null) {
                    if (chunk.getWorld().getNearbyEntities(loc, 16, 256, 16).size() < 10) {
                        for (int i = 0; i < 3; i++) {
                            CustomZombie zombie = new CustomZombie(loc);
                            ServerLevel world = ((CraftWorld) loc.getWorld()).getHandle();

                            world.addFreshEntity(zombie, CreatureSpawnEvent.SpawnReason.DEFAULT);
                        }
                    }
                }
            }
        }
    }
}
