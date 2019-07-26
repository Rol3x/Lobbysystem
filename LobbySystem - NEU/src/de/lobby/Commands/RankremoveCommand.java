package de.lobby.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lobby.main.Lobby;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class RankremoveCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String st, String[] args) {
		Player p = (Player)s;
		if(p.hasPermission("pvpsucht.admin") || p.isOp()) {
			if(args.length == 0) {
				p.sendMessage(Lobby.prefix + "Benutze /§a§lRankremove §7<§a§lSpieler§7> <§a§lRank§7>");
			}else if(args.length == 1) {
				p.sendMessage(Lobby.prefix + "Benutze /§a§lRankremove §7<§a§lSpieler§7> <§a§lRank§7>");
			}else if(args.length == 2) {

				Player t = Bukkit.getPlayer(args[0]);
				String msg = args[1];
				if(msg.equalsIgnoreCase("admin")) {
					PermissionsEx.getUser(t).removePermission("pvpsucht.admin");
					t.kickPlayer("§7Du bist nun kein §cAdmin §7mehr§8!");
				}else if(msg.equalsIgnoreCase("dev")) {
					PermissionsEx.getUser(t).removePermission("pvpsucht.dev");
					t.kickPlayer("§7Du bist nun kein §3Developer §7mehr§8!");
				}else if(msg.equalsIgnoreCase("devlehrling")) {
					PermissionsEx.getUser(t).removePermission("pvpsucht.devlehrling");
					t.kickPlayer("§7Du bist nun kein §3Dev Lehrling §7mehr§8!");
				}else if(msg.equalsIgnoreCase("mod")) {
					PermissionsEx.getUser(t).removePermission("pvpsucht.mod");
					t.kickPlayer("§7Du bist nun kein §aMod §7mehr§8!");
				}else if(msg.equalsIgnoreCase("sup")) {
					PermissionsEx.getUser(t).removePermission("pvpsucht.sup");
					t.kickPlayer("§7Du bist nun kein §bSup §7mehr§8!");
				}else if(msg.equalsIgnoreCase("builder")) {
					PermissionsEx.getUser(t).removePermission("pvpsucht.builder");
					t.kickPlayer("§7Du bist nun kein §eBuilder §7mehr§8!");
				}else if(msg.equalsIgnoreCase("youtuber")) {
					PermissionsEx.getUser(t).removePermission("pvpsucht.youtuber");
					t.kickPlayer("§7Du bist nun kein §5You§fTuber §7mehr§8!");
				}else if(msg.equalsIgnoreCase("supremium")) {
					PermissionsEx.getUser(t).removePermission("pvpsucht.supremium");
					t.kickPlayer("§7Du bist nun kein §bSupremium §7mehr§8!");
				}else if(msg.equalsIgnoreCase("premium")) {
					PermissionsEx.getUser(t).removePermission("pvpsucht.premium");
					t.kickPlayer("§7Du bist nun kein §6Premium §7mehr§8!");
				}else {
					p.sendMessage(Lobby.prefix + "§cDieser Rang existiert nicht§8!");
				}
			
			}
		}else {
			p.sendMessage(Lobby.NoPerm);
		}
		return false;
	}
	
	

}
