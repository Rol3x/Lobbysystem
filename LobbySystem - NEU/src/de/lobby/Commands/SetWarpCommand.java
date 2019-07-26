package de.lobby.Commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.lobby.main.Lobby;

public class SetWarpCommand implements CommandExecutor{
	
	static File file = new File("plugins//LobbySystem//spawns.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String st, String[] args) {
		Player p = (Player)s;
		if(p.isOp() || p.hasPermission("pvpsucht.admin") || p.hasPermission("pvpsucht.mod")) {
			if(args.length == 0) {
				p.sendMessage(Lobby.prefix + "Benutze /§a§lSetwarp §7<§a§l1-4§7>§8!");
			}else if(args.length == 1) {
				String warp = args[0];
				if(warp.equalsIgnoreCase("1")) {
					Lobby.cfg.set("OneDayVaro.X", p.getLocation().getBlockX());
					Lobby.cfg.set("OneDayVaro.Y", p.getLocation().getBlockY());
					Lobby.cfg.set("OneDayVaro.Z", p.getLocation().getBlockZ());
					Lobby.cfg.set("OneDayVaro.World", p.getWorld());
					Lobby.cfg.set("OneDayVaro.Pitch", p.getLocation().getPitch());
					Lobby.cfg.set("OneDayVaro.Yaw", p.getLocation().getYaw());
					try {
						Lobby.cfg.save(file);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}else if(warp.equalsIgnoreCase("2")) {
					Lobby.cfg.set("UHCMeetup.X", p.getLocation().getBlockX());
					Lobby.cfg.set("UHCMeetup.Y", p.getLocation().getBlockY());
					Lobby.cfg.set("UHCMeetup.Z", p.getLocation().getBlockZ());
					Lobby.cfg.set("UHCMeetup.World", p.getWorld());
					Lobby.cfg.set("UHCMeetup.Pitch", p.getLocation().getPitch());
					Lobby.cfg.set("UHCMeetup.Yaw", p.getLocation().getYaw());
					try {
						Lobby.cfg.save(file);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}else if(warp.equalsIgnoreCase("3")) {
					Lobby.cfg.set("SpeedUHC.X", p.getLocation().getBlockX());
					Lobby.cfg.set("SpeedUHC.Y", p.getLocation().getBlockY());
					Lobby.cfg.set("SpeedUHC.Z", p.getLocation().getBlockZ());
					Lobby.cfg.set("SpeedUHC.World", p.getWorld());
					Lobby.cfg.set("SpeedUHC.Pitch", p.getLocation().getPitch());
					Lobby.cfg.set("SpeedUHC.Yaw", p.getLocation().getYaw());
					try {
						Lobby.cfg.save(file);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}else if(warp.equalsIgnoreCase("4")) {
					Lobby.cfg.set("Spawn.X", p.getLocation().getBlockX());
					Lobby.cfg.set("Spawn.Y", p.getLocation().getBlockY());
					Lobby.cfg.set("Spawn.Z", p.getLocation().getBlockZ());
					Lobby.cfg.set("Spawn.World", p.getWorld());
					Lobby.cfg.set("Spawn.Pitch", p.getLocation().getPitch());
					Lobby.cfg.set("Spawn.Yaw", p.getLocation().getYaw());
					try {
						Lobby.cfg.save(file);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}else {
					p.sendMessage(Lobby.prefix + "Bitte gebe eine Zahl von <§a§l1§7-§a§l4§7> an§8!");
				}
			}else {
				p.sendMessage(Lobby.prefix + "Benutze /§a§lSetwarp §7<§a§l1-4§7>§8!");
			}
		}else {
			p.sendMessage(Lobby.NoPerm);
		}
		return false;
	}
	

}
