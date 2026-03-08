package me.rbus.admincore;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class admincommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission("gothcraft.admin")) {
            sender.sendMessage("§cYou don't have permission to use this command!");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage("§eAdmin Commands: /admin kick <player>, /admin fly <player>");
            return true;
        }

        Player target;
        switch (args[0].toLowerCase()) {
            case "kick":
                if (args.length < 2) {
                    sender.sendMessage("§cUsage: /admin kick <player>");
                    return true;
                }
                target = Bukkit.getPlayer(args[1]);
                if (target != null) {
                    target.kickPlayer("§cYou have been kicked by an admin!");
                    sender.sendMessage("§aPlayer kicked successfully!");
                } else {
                    sender.sendMessage("§cPlayer not found!");
                }
                break;

            case "fly":
                if (args.length < 2) {
                    sender.sendMessage("§cUsage: /admin fly <player>");
                    return true;
                }
                target = Bukkit.getPlayer(args[1]);
                if (target != null) {
                    target.setAllowFlight(!target.getAllowFlight());
                    sender.sendMessage("§aToggled flight for " + target.getName());
                } else {
                    sender.sendMessage("§cPlayer not found!");
                }
                break;

            default:
                sender.sendMessage("§cUnknown subcommand!");
                break;
        }
        return true;
    }
}