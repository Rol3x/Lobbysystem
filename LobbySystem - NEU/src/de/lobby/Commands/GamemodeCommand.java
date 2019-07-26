package de.lobby.Commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lobby.main.Lobby;

public class GamemodeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String st, String[] args) {
		Player p = (Player)s;
		if(p.hasPermission("pvpsucht.gamemode")) {
			if(args.length == 0) {
				p.sendMessage(Lobby.prefix + "Benutze /§a§lgamemode §7<§a§lSpieler§7> <§a§lModus§7>");
			}else if(args.length == 1) {
				String msg = args[0];
				if(msg.equalsIgnoreCase("0")) {
					p.sendMessage(Lobby.prefix + "Du bist nun im Gamemode §a§lSURVIVAL");
					p.setGameMode(GameMode.SURVIVAL);
					
				}else
				if(msg.equalsIgnoreCase("1")) {
					p.sendMessage(Lobby.prefix + "Du bist nun im Gamemode §a§lCREATIVE");
					p.setGameMode(GameMode.CREATIVE);

				}else
				if(msg.equalsIgnoreCase("2")) {
					p.sendMessage(Lobby.prefix + "Du bist nun im Gamemode §a§lADVENTURE");
					p.setGameMode(GameMode.ADVENTURE);

				}else
				if(msg.equalsIgnoreCase("3")) {
					p.sendMessage(Lobby.prefix + "Du bist nun im Gamemode §a§lSPECTATOR");
					p.setGameMode(GameMode.SPECTATOR);

					
				}else {
					p.sendMessage("§7Bitte definiere einen §a§lGamemode§8!");
				}
			}else if(args.length == 2) {
				String msg = args[1];
				Player t = Bukkit.getPlayer(args[0]);
				if(t != null) {
					if(msg.equalsIgnoreCase("0")) {
						t.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(Lobby.prefix + "Der Spieler §a§l" + t.getName() 
						+ "§7 ist nun im Gamemode §a§lSURVIVAL");
						t.sendMessage(Lobby.prefix + "§7Dein Gamemode wurde §a§lverändert§8!");
					}else
					if(msg.equalsIgnoreCase("1")) {
						t.setGameMode(GameMode.CREATIVE);
						p.sendMessage(Lobby.prefix + "Der Spieler §a§l" + t.getName() 
						+ "§7 ist nun im Gamemode §a§lCREATIVE");
						t.sendMessage(Lobby.prefix + "§7Dein Gamemode wurde §a§lverändert§8!");
					}else
					if(msg.equalsIgnoreCase("2")) {
						t.setGameMode(GameMode.ADVENTURE);
						p.sendMessage(Lobby.prefix + "Der Spieler §a§l" + t.getName() 
						+ "§7 ist nun im Gamemode §a§lADVENTURE");
						t.sendMessage(Lobby.prefix + "§7Dein Gamemode wurde §a§lverändert§8!");
					}else
					if(msg.equalsIgnoreCase("3")) {
						t.setGameMode(GameMode.SPECTATOR);
						p.sendMessage(Lobby.prefix + "Der Spieler §a§l" + t.getName() 
						+ "§7 ist nun im Gamemode §a§lSPECTATOR");
						t.sendMessage(Lobby.prefix + "§7Dein Gamemode wurde §a§lverändert§8!");
					}else {
						p.sendMessage(Lobby.prefix + "§cBitte definiere einen Gamemode§8!");
					}
							
					
				}else {
					p.sendMessage(Lobby.prefix + "§cDieser Spieler ist nicht Online");
				}
			}
		}else {
			p.sendMessage(Lobby.NoPerm);
		}
		return false;
	}

}
