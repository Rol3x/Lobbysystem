package de.lobby.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lobby.main.Lobby;

public class InfoCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String st, String[] args) {
		Player p = (Player)s;
		if(args.length == 0) {
			p.sendMessage("§7x §aPvPSucht §7x");
			p.sendMessage("");
			p.sendMessage("§7Plugin by§8:");
			p.sendMessage("§aCedric :)");
			p.sendMessage("");
			p.sendMessage("§7Dein Rang§8:");
			if(p.isOp()) {
				p.sendMessage("§4Owner");
			}else if(p.hasPermission("pvpsucht.admin")) {
				p.sendMessage("§cAdmin");
			}else if(p.hasPermission("pvpsucht.dev")) {
				p.sendMessage("§3Dev");
			}else if(p.hasPermission("pvpsucht.devlehrling")) {
				p.sendMessage("§3Dev. Lehrling");
			}else if(p.hasPermission("pvpsucht.mod")) {
				p.sendMessage("§aModerator");
			}else if(p.hasPermission("pvpsucht.sup")) {
				p.sendMessage("§bSupporter");
			}else if(p.hasPermission("pvpsucht.builder")) {
				p.sendMessage("§eBuilder");
			}else if(p.hasPermission("pvpsucht.youtuber")) {
				p.sendMessage("§5You§fTuber");
			}else if(p.hasPermission("pvpsucht.supremium")) {
				p.sendMessage("§bSupremium");
			}else if(p.hasPermission("pvpsucht.premium")) {
				p.sendMessage("§6Premium");
			}else {
				p.sendMessage("§7Spieler");
			}
			p.sendMessage("");
			p.sendMessage("§7x §aPvPSucht §7x");
		}else {
			p.sendMessage(Lobby.prefix + "Benutze /§a§linfo§8!");
		}
		return false;
	}
	
	

}
