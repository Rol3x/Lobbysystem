package de.lobby.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lobby.main.Lobby;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class RankaddCommand implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String st, String[] args) {
		Player p = (Player)s;
		if(p.isOp() || p.hasPermission("*")) {
			if(args.length == 0) {
				p.sendMessage(Lobby.prefix + "Benutze /§a§lrankadd §7<§a§lSpieler§7>");
			}else if(args.length == 1) {
				p.sendMessage(Lobby.prefix + "Benutze /§a§lrankadd §7<§a§lSpieler§7> <§a§lRang§7>");
			}else if(args.length == 2) {
				Player t = Bukkit.getPlayer(args[0]);
				String msg = args[1];
				if(msg.equalsIgnoreCase("admin")) {
					PermissionsEx.getUser(t).addPermission("pvpsucht.admin");
					t.kickPlayer("§7Du wurdest zum \n §cAdmin \n §7befördert!");
				}else if(msg.equalsIgnoreCase("dev")) {
					PermissionsEx.getUser(t).addPermission("pvpsucht.dev");
					t.kickPlayer("§7Du wurdest zum \n §3Developer \n §7befördert!");
				}else if(msg.equalsIgnoreCase("devlehrling")) {
					PermissionsEx.getUser(t).addPermission("pvpsucht.devlehrling");
					t.kickPlayer("§7Du wurdest zum \n §3Dev - Lehrling \n §7befördert!");
				}else if(msg.equalsIgnoreCase("mod")) {
					PermissionsEx.getUser(t).addPermission("pvpsucht.mod");
					t.kickPlayer("§7Du wurdest zum \n §aModerator \n §7befördert!");
				}else if(msg.equalsIgnoreCase("sup")) {
					PermissionsEx.getUser(t).addPermission("pvpsucht.sup");
					t.kickPlayer("§7Du wurdest zum \n §bSupporter \n §7befördert!");
				}else if(msg.equalsIgnoreCase("builder")) {
					PermissionsEx.getUser(t).addPermission("pvpsucht.builder");
					t.kickPlayer("§7Du wurdest zum \n\n §eBuilder \n\n §7befördert!");
				}else if(msg.equalsIgnoreCase("youtuber")) {
					PermissionsEx.getUser(t).addPermission("pvpsucht.youtuber");
					t.kickPlayer("§7Du wurdest zum \n §5You§fTuber \n §7befördert!");
				}else if(msg.equalsIgnoreCase("supremium")) {
					PermissionsEx.getUser(t).addPermission("pvpsucht.supremium");
					t.kickPlayer("§7Du wurdest zum \n §bSupremium \n §7befördert!");
				}else if(msg.equalsIgnoreCase("premium")) {
					PermissionsEx.getUser(t).addPermission("pvpsucht.premium");
					t.kickPlayer("§7Du wurdest zum \n §6Premium \n §7befördert!");
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
