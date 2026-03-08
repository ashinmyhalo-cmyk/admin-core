package me.rbus.admincore;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class playcommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("§cOnly players can use this command!");
            return true;
        }

        if (args.length == 0) {
            player.sendMessage("§ePlayer Commands: /player spawn, /player heal");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "spawn":
                player.teleport(player.getWorld().getSpawnLocation());
                player.sendMessage("§aTeleported to spawn!");
                break;

            case "heal":
                player.setHealth(player.getMaxHealth());
                player.setFoodLevel(20);
                player.sendMessage("§aYou have been healed!");
                break;

            default:
                player.sendMessage("§cUnknown subcommand!");
                break;
        }

        return true;
    }
}