package de.lobby.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lobby.main.Lobby;

public class IpCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String st, String[] args) {
		Player p = (Player)s;
		if(p.isOp() || p.hasPermission("pvpsucht.admin")) {
			if(args.length == 0) {
				p.sendMessage(Lobby.prefix + "§Benutze /§a§lip §7<§a§lSpieler§7");
			}else if(args.length == 1) {
				Player t = Bukkit.getPlayer(args[0]);
				if(t != null) {
					p.sendMessage(Lobby.prefix + "Die Ip von §a§l" + t.getName() + "§7 lautet§8: §a§l" + t.getAddress());
				}else {
					p.sendMessage(Lobby.prefix + "§cDieser Spieler ist nicht Online!");
				}
			}
		}else {
			p.sendMessage(Lobby.NoPerm);
		}
		return false;
	}
	
	

}
