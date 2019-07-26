package de.lobby.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lobby.main.Lobby;

public class UnbanCommand implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String st, String[] args) {
		Player p = (Player)s;
		if(p.isOp() || p.hasPermission("pvpsucht.admin") || p.hasPermission("pvpsucht.mod")) {
			if(args.length == 0) {
				p.sendMessage(Lobby.prefix + "/�a�lunban �7<�a�lSpieler�7>");
			}else if(args.length == 1) {
				Player t = Bukkit.getPlayer(args[0]);
					
					if(!Lobby.isBanned.contains(t)) {
						p.sendMessage(Lobby.prefix + "Dieser Spieler ist nicht gebannt�8!");
					}else {
						p.sendMessage(Lobby.prefix + "Du hast den Spieler �a�l" + t.getName() + "�7 erfolgreich entbannt�8!");
						t.setBanned(false);
						Lobby.isBanned.remove(t);
					}
				
			}
		}else {
			p.sendMessage(Lobby.NoPerm);
		}
		return false;
	}

}
