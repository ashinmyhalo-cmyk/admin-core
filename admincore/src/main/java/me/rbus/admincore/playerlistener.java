package me.rbus.admincore;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.entity.Player;

public class playerlistener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("§6Welcome §e" + player.getName() + " §6to GothCraft!");
        event.setJoinMessage("§a" + player.getName() + " has joined the server!");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage("§c" + event.getPlayer().getName() + " has left the server!");
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        // Example: owners get [OWNER] tag, admins get [ADMIN]
        if (player.hasPermission("gothcraft.owner")) {
            event.setFormat("§4[OWNER] §f" + player.getName() + " §7» §f" + event.getMessage());
        } else if (player.hasPermission("gothcraft.admin")) {
            event.setFormat("§c[ADMIN] §f" + player.getName() + " §7» §f" + event.getMessage());
        } else {
            event.setFormat("§7[PLAYER] §f" + player.getName() + " §7» §f" + event.getMessage());
        }
    }
}