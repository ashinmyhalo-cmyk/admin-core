package me.rbus.admincore;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        // Register listeners
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);

        // Register commands
        this.getCommand("admin").setExecutor(new AdminCommand());
        this.getCommand("owner").setExecutor(new OwnerCommand());
        this.getCommand("player").setExecutor(new PlayerCommand());

        getLogger().info("GothCraft Admin Plugin Enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("GothCraft Admin Plugin Disabled!");
    }

    public static Main getInstance() {
        return instance;
    }

    private record AdminCommand() implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
            return false;
        }
    }

    private class OwnerCommand implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
            return false;
        }
    }

    private record PlayerCommand() implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
            return false;
        }
    }

    private record PlayerListener<p>() implements Listener {
    }
}