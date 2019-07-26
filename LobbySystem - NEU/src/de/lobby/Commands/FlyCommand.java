package de.lobby.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lobby.main.Lobby;

public class FlyCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String st, String[] args) {
		Player p = (Player)s;
		if(p.isOp() || p.hasPermission("pvpsucht.admin")) {
			if(args.length == 0) {
				if(p.getGameMode() == GameMode.SURVIVAL || p.getGameMode() == GameMode.ADVENTURE) {
				if(!Lobby.fly.contains(p)) {
						p.setAllowFlight(true);
						p.setFlying(true);
						Lobby.fly.add(p);
						p.sendMessage(Lobby.prefix + "Du kannst nun §afliegen§8!");
				}else {
					p.setAllowFlight(false);
					p.setFlying(false);
					Lobby.fly.remove(p);
					p.sendMessage(Lobby.prefix + "Du kannst nun §cnicht §7mehr fliegen §8!");
				}
				}else {
					p.sendMessage(Lobby.prefix + "Du bist bereits im Gamemode §a§lCreative §7oder §a§lSpectator§8!");
				}
			}else {
				p.sendMessage(Lobby.prefix + "Benutze /§a§lfly");
			}
		}else {
			p.sendMessage(Lobby.NoPerm);
		}
		return false;
	}
	
	

}
