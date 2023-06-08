package me.goodi.wd1.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static me.goodi.wd1.WD1.plugin;

public class spawn implements CommandExecutor {

    FileConfiguration configuration = plugin.getConfig();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p){
            configuration.set("MobSpawn", !(configuration.getBoolean("MobSpawn")));
            p.sendMessage(String.valueOf(configuration.getBoolean("MobSpawn")));
        }
        return false;
    }
}
