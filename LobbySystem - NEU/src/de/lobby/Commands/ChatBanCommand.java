package de.lobby.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lobby.main.Lobby;

public class ChatBanCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String st, String[] args) {
		Player p = (Player)s;
		if(p.hasPermission("pvpsucht.ban")) {
			if(args.length == 0) {
				p.sendMessage("§7Mögliche Chatban-Möglichkeiten§8:");
				p.sendMessage("§7-1 §8-> §aBeleidigung");
				p.sendMessage("§7-2 §8-> §aSpamming");
				p.sendMessage("§7-3 §8-> §aWerbung");
				p.sendMessage(Lobby.prefix + "§7Benutze /§a§lChatban §7<§a§lSpieler§7> <§a§lMutegrund§7>");
			}else if(args.length == 1) {
				p.sendMessage(Lobby.prefix + "§7Benutze /§a§lChatban §7<§a§lSpieler§7> <§a§lMutegrund§7>");

			}else if(args.length == 2) {
				String reason = args[1];
				Player t = Bukkit.getPlayer(args[0]);
				if(t != null) {
					if(!(t == p)) {
						if(reason.equalsIgnoreCase("1")) {
					
						if(!Lobby.Chatban.contains(t)) {
							p.sendMessage(Lobby.prefix + "Du hast den Spieler §a" + t.getName()
							+ "§7 erfolgreich aus dem Chat gebannt§8!"); 
							Lobby.Chatban.add(t);
							t.sendMessage("§4Du wurdest gemutet! \n §7Grund§8: §cBeleidigung \n§7Von§8: §c" + p.getName());
						}else {
							p.sendMessage("§cDieser Spieler ist bereits aus dem Chat gebannt!");
						}
					}else if(reason.equalsIgnoreCase("2")) {
						if(!Lobby.Chatban.contains(t)) {
							p.sendMessage(Lobby.prefix + "Du hast den Spieler §a" + t.getName()
							+ "§7 erfolgreich aus dem Chat gebannt§8!"); 
							Lobby.Chatban.add(t);
							t.sendMessage("§4Du wurdest gemutet! \n §7Grund§8: §cSpamming \n§7Von§8: §c" + p.getName());
						}else {
							p.sendMessage("§cDieser Spieler ist bereits aus dem Chat gebannt!");
						}
					}else if(reason.equalsIgnoreCase("3")) {
						if(!Lobby.Chatban.contains(t)) {
							p.sendMessage(Lobby.prefix + "Du hast den Spieler §a" + t.getName()
							+ "§7 erfolgreich aus dem Chat gebannt§8!"); 
							Lobby.Chatban.add(t);
							t.sendMessage("§4Du wurdest gemutet! \n §7Grund§8: §cWerbung \n§7Von§8: §c" + p.getName());
						}else {
							p.sendMessage("§cDieser Spieler ist bereits aus dem Chat gebannt!");
						}
					}else {
						p.sendMessage(Lobby.prefix +"§cBitte gebe einen Grund an§8!");
					}
					}else {
						p.sendMessage(Lobby.prefix +"§cDu kannst dich nicht selber muten§8!");
					}
				}else {
					p.sendMessage(Lobby.prefix + "§cDieser Spieler ist nicht Online§8!");
				}
			
			}
		}else {
			p.sendMessage(Lobby.NoPerm);
		}
		return false;
	}
	
	

}
