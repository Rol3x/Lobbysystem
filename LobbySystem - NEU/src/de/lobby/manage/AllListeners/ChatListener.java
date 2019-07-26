package de.lobby.manage.AllListeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.lobby.main.Lobby;

public class ChatListener implements Listener{
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();
		if(Lobby.cfg.getBoolean("Globalmute") == false) {
			if(!Lobby.Chatban.contains(p)) {
				if(p.hasPermission("pvpsucht.owner") || p.hasPermission("pvpsucht.admin") || p.hasPermission("pvpsucht.dev") 
						|| p.hasPermission("pvpsucht.mod") || p.hasPermission("pvpsucht.sup") || p.hasPermission("pvpsucht.builder")
						|| p.hasPermission("pvpsucht.youtuber") || p.hasPermission("pvpsucht.supremium") || p.hasPermission("pvpsucht.premium")) {
					if(p.hasPermission("pvpsucht.owner")) {
						e.setFormat("§4O §8| §4" + p.getName() + " §7-> §f" + msg);
					}else if(p.hasPermission("pvpsucht.admin")) {
						e.setFormat("§cA §8| §c" + p.getName() + " §7-> §f" + msg);
					}else if(p.hasPermission("pvpsucht.dev")) {
						e.setFormat("§3Dev §8| §3" + p.getName() + " §7-> §f" + msg);
					}else if(p.hasPermission("pvpsucht.mod")) {
						e.setFormat("§aMod §8| §a" + p.getName() + " §7-> §f" + msg);
					}else if(p.hasPermission("pvpsucht.sup")) {
						e.setFormat("§bSup §8| §b" + p.getName() + " §7-> §f" + msg);
					}else if(p.hasPermission("pvpsucht.builder")) {
						e.setFormat("§eB §8| §e" + p.getName() + " §7-> §f" + msg);
					}else if(p.hasPermission("pvpsucht.supremium")) {
						e.setFormat("§b" + p.getName() + " §7-> §f" + msg);
					}else if(p.hasPermission("pvpsucht.premium")) {
						e.setFormat("§6" + p.getName() + " §7-> §f" + msg);
					}else {
						e.setCancelled(true);
						p.sendMessage(Lobby.prefix + "Du musst ein §6Premium §7Spieler sein, um in den Chat zu schreiben!");
						}
				}else {
					e.setCancelled(true);				}
		}else {
			e.setCancelled(true);
		}
		}else {
			if(!p.hasPermission("pvpsucht.admin") || p.isOp() ||
					p.hasPermission("pvpsucht.dev") || p.hasPermission("pvpsucht.devlehrling") || 
					p.hasPermission("pvpsucht.mod") || p.hasPermission("pvpsucht.sup") || p.hasPermission("pvpsucht.builder")
					|| p.hasPermission("pvpsucht.youtuber") || p.hasPermission("pvpsucht.supremium") || p.hasPermission("pvpsucht.premium")) {
				e.setCancelled(true);
			}else {
				if(p.hasPermission("pvpsucht.owner")) {
					e.setFormat("§4O §8| §4" + p.getName() + " §7-> §f" + msg);
				}else if(p.hasPermission("pvpsucht.admin")) {
					e.setFormat("§cA §8| §c" + p.getName() + " §7-> §f" + msg);
				}else if(p.hasPermission("pvpsucht.dev")) {
					e.setFormat("§3Dev §8| §3" + p.getName() + " §7-> §f" + msg);
				}else if(p.hasPermission("pvpsucht.devlehrling")) {
					e.setFormat("§3Dev. L. §8| §3" + p.getName() + " §7-> §f" + msg);
				}else if(p.hasPermission("pvpsucht.mod")) {
					e.setFormat("§aMod §8| §a" + p.getName() + " §7-> §f" + msg);
				}else if(p.hasPermission("pvpsucht.sup")) {
					e.setFormat("§bSup §8| §b" + p.getName() + " §7-> §f" + msg);
				}else if(p.hasPermission("pvpsucht.builder")) {
					e.setFormat("§eB §8| §e" + p.getName() + " §7-> §f" + msg);
				}else if(p.hasPermission("pvpsucht.supremium")) {
					e.setFormat("§b" + p.getName() + " §7-> §f" + msg);
				}else if(p.hasPermission("pvpsucht.premium")) {
					e.setFormat("§6" + p.getName() + " §7-> §f" + msg);
				}
			}
				
				
				
		}
	}

}
