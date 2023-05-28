package me.goodi.wd1.Commands;

import me.goodi.wd1.WD1;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

import static me.goodi.wd1.WD1.plugin;

public class Time implements CommandExecutor, TabCompleter {

    FileConfiguration configuration = plugin.getConfig();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player player)
            if(player.isOp()){
                switch (args[0].toLowerCase()) {
                    case "setdaytick" -> {
                        configuration.set("Day-Tick", Integer.parseInt(args[1]));
                        plugin.saveConfig();
                    }
                    case "setnighttick" -> {
                        configuration.set("Night-Tick", Integer.parseInt(args[1]));
                        plugin.saveConfig();
                    }
                    case "setresetcycle" -> {
                        configuration.set("ResetCycle", Integer.parseInt(args[1]));
                        plugin.saveConfig();
                    }
                    case "settime" -> {
                        configuration.set("Time", Integer.parseInt(args[1]));
                        plugin.saveConfig();
                    }
                }
            }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            if (sender.isOp()) {
                List<String> cmd = new ArrayList<>();
                cmd.add("SetDayTick");
                cmd.add("SetNightTick");
                cmd.add("SetResetCycle");
                cmd.add("SetTime");

                final List<String> completions = new ArrayList<>();

                StringUtil.copyPartialMatches(args[0], cmd, completions);


                return completions;
            }
        }
        return null;
    }
}
