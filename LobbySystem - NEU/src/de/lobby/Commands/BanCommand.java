package de.lobby.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lobby.main.Lobby;

public class BanCommand implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String st, String[] args) {
		Player p = (Player)s;
		if(p.hasPermission("pvpsucht.admin") || p.isOp() || p.hasPermission("pvpsucht.mod")) {
			if(args.length == 0) {
				p.sendMessage(Lobby.prefix + "Bitte gebe einen Spieler an§8!");
			}else if(args.length == 1) {
				p.sendMessage(Lobby.prefix + "Bitte gebe einen Grund an§8!");
			}else if(args.length == 2) {
					Player t = Bukkit.getPlayer(args[0]);
					String grund = args[1];
					if(t.hasPermission("pvpsucht.admin") || t.hasPermission("pvpsucht.mod") || t.isOp()) {
						p.sendMessage(Lobby.prefix + "Du kannst die Ränge §aModerator§7, oder höher nicht §cBannen§8!");
					}else {
						if(grund.equalsIgnoreCase("Hacking")) {
							p.sendMessage(Lobby.prefix + "Du hast den Spieler §a" + t.getName() + "§7 erfolgreich gebannt");
							if(t != null) {
								t.kickPlayer("§7» §a§lPvPSucht.de §7« \n \nDu wurdest gebannt! \n \n§cGrund: §4Hacking \n \n §eDu kannst einen Entbannungsantrag im Discord stellen\n §7https://discord.gg/vRMPg8B \n ");
								t.setBanned(true);
								Lobby.isBanned.add(t);
							}
						}else if(grund.equalsIgnoreCase("Spamming")) {
							p.sendMessage(Lobby.prefix + "Du hast den Spieler §a" + t.getName() + "§7 erfolgreich gebannt");
							if(t != null) {
								t.kickPlayer("§7» §a§lPvPSucht.de §7« \n \nDu wurdest gebannt! \n \n§cGrund: §4Spamming \n \n §eDu kannst einen Entbannungsantrag im Discord stellen\n §7https://discord.gg/vRMPg8B \n ");
								t.setBanned(true);
								Lobby.isBanned.add(t);
							}
						}else if(grund.equalsIgnoreCase("Werbung")) {
							p.sendMessage(Lobby.prefix + "Du hast den Spieler §a" + t.getName() + "§7 erfolgreich gebannt");
							if(t != null) {
								t.kickPlayer("§7» §a§lPvPSucht.de §7« \n \nDu wurdest gebannt! \n \n§cGrund: §4Werbung \n \n §eDu kannst einen Entbannungsantrag im Discord stellen\n §7https://discord.gg/vRMPg8B \n ");
								t.setBanned(true);
								Lobby.isBanned.add(t);
							}
						}else if(grund.equalsIgnoreCase("BugUsing")) {
							p.sendMessage(Lobby.prefix + "Du hast den Spieler §a" + t.getName() + "§7 erfolgreich gebannt");
							if(t != null) {
								t.kickPlayer("§7» §a§lPvPSucht.de §7« \n \nDu wurdest gebannt! \n \n§cGrund: §4BugUsing \n \n §eDu kannst einen Entbannungsantrag im Discord stellen\n §7https://discord.gg/vRMPg8B \n ");
								t.setBanned(true);
								Lobby.isBanned.add(t);
							}
						}else if(grund.equalsIgnoreCase("Beleidigung")) {
							p.sendMessage(Lobby.prefix + "Du hast den Spieler §a" + t.getName() + "§7 erfolgreich gebannt");
							if(t != null) {
								t.kickPlayer("§7» §a§lPvPSucht.de §7« \n \nDu wurdest gebannt! \n \n§cGrund: §4Beleidigung \n \n §eDu kannst einen Entbannungsantrag im Discord stellen\n §7https://discord.gg/vRMPg8B \n ");
								t.setBanned(true);
								Lobby.isBanned.add(t);
							}
						}
					}
			
			}else {
				p.sendMessage(Lobby.prefix + "/§a§lban §7<§a§lSpieler§7> <§a§lGrund§7>");
			}
		}else {
			p.sendMessage(Lobby.NoPerm);
		}
		return false;
	}
	
	

}
