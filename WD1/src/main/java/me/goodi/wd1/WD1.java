package me.goodi.wd1;

import me.goodi.wd1.Commands.Time;
import me.goodi.wd1.Listeners.Join;
import me.goodi.wd1.Listeners.ZombieDamage;
import me.goodi.wd1.Runnables.timeRun;
import org.bukkit.GameRule;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;


public final class WD1 extends JavaPlugin {
    public static WD1 plugin;


    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        plugin = this;

        config.options().copyDefaults(true);
        saveConfig();

        getServer().getWorld("world").setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        getServer().getWorld("world").setTime(20000);

        getServer().getPluginManager().registerEvents(new Join(), this);
        getServer().getPluginManager().registerEvents(new ZombieDamage(), this);

        getCommand("TimeCycle").setExecutor(new Time());

        BukkitTask time = new timeRun().runTaskTimer(this, 0, config.getInt("Update-Tick"));
        BukkitTask targetRun = new timeRun().runTaskTimer(this, 0, 20);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
