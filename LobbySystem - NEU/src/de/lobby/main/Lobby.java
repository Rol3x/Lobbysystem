package de.lobby.main;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import de.lobby.Commands.BanCommand;
import de.lobby.Commands.ChatBanCommand;
import de.lobby.Commands.FlyCommand;
import de.lobby.Commands.GamemodeCommand;
import de.lobby.Commands.GlobalmuteCommand;
import de.lobby.Commands.HelpCommand;
import de.lobby.Commands.InfoCommand;
import de.lobby.Commands.IpCommand;
import de.lobby.Commands.PingCommand;
import de.lobby.Commands.RankaddCommand;
import de.lobby.Commands.RankremoveCommand;
import de.lobby.Commands.ReportCommand;
import de.lobby.Commands.SetWarpCommand;
import de.lobby.Commands.UnbanCommand;
import de.lobby.Commands.WartungenCommand;
import de.lobby.manage.Listeners;
import de.lobby.manage.AllListeners.ChatListener;

public class Lobby extends JavaPlugin implements Listener{

	public static Lobby plugin;
	
	public static String prefix = "§7[§aSystem§7] ";
	public static ArrayList<Player> Chatban = new ArrayList<>();
	public static ArrayList<Player> fly = new ArrayList<>();
	public static ArrayList<Player> isBanned = new ArrayList<>();
	public static ArrayList<Player> hasGadgetBoots = new ArrayList<>();
	
	public static String NoPerm = prefix + "§8x §cDazu hast du keine Berechtigungen!";
	
	static File file = new File("plugins//LobbySystem//config.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	@Override
	public void onEnable() {
	
		plugin = this;
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Listeners(), this);
		pm.registerEvents(new ChatListener(), this);
		pm.registerEvents(new ReportCommand(), this);
		getCommand("rankadd").setExecutor(new RankaddCommand());
		getCommand("ping").setExecutor(new PingCommand());
		getCommand("gamemode").setExecutor(new GamemodeCommand());
		getCommand("gm").setExecutor(new GamemodeCommand());
		getCommand("chatban").setExecutor(new ChatBanCommand());
		getCommand("wartungen").setExecutor(new WartungenCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("rankremove").setExecutor(new RankremoveCommand());
		getCommand("help").setExecutor(new HelpCommand());
		getCommand("report").setExecutor(new ReportCommand());
		getCommand("ban").setExecutor(new BanCommand());
		getCommand("unban").setExecutor(new UnbanCommand());
		getCommand("globalmute").setExecutor(new GlobalmuteCommand());
		getCommand("info").setExecutor(new InfoCommand());
		getCommand("ip").setExecutor(new IpCommand());
		getCommand("setwarp").setExecutor(new SetWarpCommand());
	}
	
	@Override
	public void onDisable() {
		
		
		
	}

	public static void createFiles() {
		
		File ordner = new File("plugins//LobbySystem");
		if(!ordner.exists()) {
			ordner.mkdir();
		}
		
		if(!file.exists()) {
			try {
				cfg.set("Wartungen", false);
				cfg.set("Globalmute", false);
				cfg.save(file);
			} catch (Exception e) {
				
			}
		}
		
	}
	
	public static Lobby getPlugin() {
		return plugin;
	}
	
}
