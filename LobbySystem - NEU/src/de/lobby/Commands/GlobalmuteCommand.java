package de.lobby.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lobby.main.Lobby;

public class GlobalmuteCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String st, String[] args) {
		Player p = (Player)s;
		if(p.isOp() || p.hasPermission("pvpsucht.admin") || p.hasPermission("pvpsucht.dev") || p.hasPermission("pvpsucht.mod")) {
			if(args.length == 0) {
				p.sendMessage(Lobby.prefix + "Benutze /§a§lglobalmute §7<§a§lan§7>§8/§7<§a§laus§7>");
			}else if(args.length == 1) {
				if(Lobby.cfg.getBoolean("Globalmute") == false) {
					Lobby.cfg.set("Globalmute", true);
					p.sendMessage(Lobby.prefix + "Du hast den §a§lGlobalmute §7erfolgreich §aaktiviert!");
				}else {
					Lobby.cfg.set("Globalmute", false);
					p.sendMessage(Lobby.prefix + "Du hast den §a§lGlobalmute §7erfolgreich §cdeaktiviert!");

				}
			}else {
				p.sendMessage(Lobby.prefix + "Benutze /§a§lglobalmute §7<§a§lan§7>§8/§7<§a§laus§7>");

			}
		}else {
			p.sendMessage(Lobby.NoPerm);
		}
		return false;
	}
	
	

}
