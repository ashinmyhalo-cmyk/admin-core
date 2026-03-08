package me.rbus.admincore;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ownercommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission("gothcraft.owner")) {
            sender.sendMessage("§cYou don't have permission to use this command!");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage("§eOwner Commands: /owner broadcast <message>, /owner op <player>");
            return true;
        }

        Player target;
        switch (args[0].toLowerCase()) {
            case "broadcast":
                if (args.length < 2) {
                    sender.sendMessage("§cUsage: /owner broadcast <message>");
                    return true;
                }
                StringBuilder msg = new StringBuilder();
                for (int i = 1; i < args.length; i++) msg.append(args[i]).append(" ");
                Bukkit.broadcastMessage("§4[OWNER BROADCAST] §f" + msg);
                break;

            case "op":
                if (args.length < 2) {
                    sender.sendMessage("§cUsage: /owner op <player>");
                    return true;
                }
                target = Bukkit.getPlayer(args[1]);
                if (target != null) {
                    target.setOp(true);
                    sender.sendMessage("§aPlayer " + target.getName() + " is now OP!");
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