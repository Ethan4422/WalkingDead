package me.goodi.wd1.Listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static me.goodi.wd1.WD1.plugin;

public class Join implements Listener {
        FileConfiguration configuration = plugin.getConfig();

        @EventHandler
        public void join (PlayerJoinEvent e){
            e.getPlayer().setPlayerTime(configuration.getInt("Time"), false);

    }
}
