package de.lobby.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lobby.main.Lobby;

public class WartungenCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String st, String[] args) {
		Player p = (Player)s;
		if(p.hasPermission("pvpsucht.wartungen")) {
			if(args.length == 0) {
				p.sendMessage(Lobby.prefix + "Benutze /§a§lwartungen §7<§a§lan§7> <§a§laus§7>");
				if(Lobby.cfg.getBoolean("Wartungen") == true) {
					p.sendMessage("§7Der Wartungsmodus ist derzeit §a§laktiviert§8!");
				}else {
					p.sendMessage("§7Der Wartungsmodus ist derzeit §a§ldeaktiviert§8!");
				}
			}else if(args.length == 1) {
				String msg = args[0];
				if(msg.equalsIgnoreCase("an")) {
				if(!Lobby.cfg.getBoolean("Wartungen") == true){	
					p.sendMessage(Lobby.prefix + "Du hast den Wartungsmodus erfolgreich §a§laktiviert§8!");
						Lobby.cfg.set("Wartungen", true);
					}else {
						p.sendMessage(Lobby.prefix + "§cBenutze §7/§a§lwartungen §7<§a§laus§7>");
					}
				}else if(msg.equalsIgnoreCase("aus")) {
					if(Lobby.cfg.getBoolean("Wartungen") == true){	
						p.sendMessage(Lobby.prefix + "Du hast den Wartungsmodus erfolgreich §a§ldeaktiviert§8!");
						Lobby.cfg.set("Wartungen", false);
						}else {
							p.sendMessage(Lobby.prefix + "§cBenutze §7/§a§lwartungen §7<§a§lan§7>");
						}
				}else {
					p.sendMessage(Lobby.prefix + "Bitte gebe einen richtigen Parameter an§8!");
				}
			}
		}else {
			p.sendMessage(Lobby.prefix + "§cDu hast keine Permissions für diesen Command");
		}
		return false;
	}
	
	

}
