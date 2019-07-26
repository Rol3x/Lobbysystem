package de.lobby.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lobby.main.Lobby;

public class HelpCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String st, String[] args) {
		Player p = (Player)s;
		if(args.length == 0) {
			p.sendMessage("§7/§ayoutube §8- §7Zeige die Vorraussetzungen für den §5You§ftuber §7Rang");
			p.sendMessage("§7/§adiscord §8- §7Zeige den Discord-Link");
			p.sendMessage("§7/§abewerben §8- §7Zeige Informationen zur Bewerbung");
			p.sendMessage("§7/§areport §8- §7Reporte einen Spieler");
		}else {
			p.sendMessage(Lobby.prefix + "Benutze /§a§lhelp§8!");
		}
		return false;
	}
	
	

}
