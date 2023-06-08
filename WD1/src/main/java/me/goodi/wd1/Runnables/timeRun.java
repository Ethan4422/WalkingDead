package me.goodi.wd1.Runnables;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static me.goodi.wd1.WD1.plugin;

public class timeRun extends BukkitRunnable {
    FileConfiguration configuration = plugin.getConfig();
    @Override
    public void run() {

        if(configuration.getInt("Time") <= 12000){
            configuration.set("Time", configuration.getInt("Time") + configuration.getInt("Day-Tick"));

        } else if (configuration.getInt("Time") >= 12000 && configuration.getInt("Time") < configuration.getInt("ResetCycle")) {
            configuration.set("Time", configuration.getInt("Time") + configuration.getInt("Night-Tick"));
        } else if (configuration.getInt("Time") >= configuration.getInt("ResetCycle")) {
            configuration.set("Time", 0);
        }

        plugin.saveConfig();
        for(Player player : Bukkit.getOnlinePlayers()){
            player.setPlayerTime(configuration.getInt("Time"), false);
        }
    }
}
