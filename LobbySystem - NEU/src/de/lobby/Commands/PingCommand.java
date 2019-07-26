package de.lobby.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import de.lobby.main.Lobby;
import net.minecraft.server.v1_8_R3.EntityPlayer;

public class PingCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String st, String[] args) {
		Player p = (Player)s;
		if(args.length >= 1) {
			p.sendMessage(Lobby.prefix + "Benutze /§a§lping§8!");
		}else if(args.length == 0) {
			p.sendMessage(Lobby.prefix + "§7Dein Ping beträgt §a§l" + getPing(p) + "ms");
		}
		return false;
	}
	
	public int getPing(Player p) {
		CraftPlayer pingc = (CraftPlayer) p;
		EntityPlayer pinge = pingc.getHandle();
		return pinge.ping;
	}
	
}
