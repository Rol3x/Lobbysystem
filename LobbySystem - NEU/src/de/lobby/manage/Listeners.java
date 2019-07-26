package de.lobby.manage;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.help.HelpTopic;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.lobby.main.Lobby;
import de.lobby.manage.ScoreboardManager.PvPSuchtScoreboard;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;

public class Listeners implements Listener{
	
	
	
	
	private final String GUI = "§6§lTeleporter";
	private final String GUI_HIDE = "§6§lSpieler verstecken";
	
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void inQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		if(!Lobby.cfg.getBoolean("Wartungen") == false) {
			e.setQuitMessage(null);
			for(Player all : Bukkit.getOnlinePlayers()) {
			 	sendTablistHeaderAndFooter(all, "§7» §a§lPvPSucht.de §7« §r\n", " \n §7Discord§8: §a/vRMPg8B \n §7Twitter§8: §b@PvPSucht \n\n");
			 	new PvPSuchtScoreboard(all).editScore(all, "§7» §c", String.valueOf(Bukkit.getOnlinePlayers().size()));
			 	
			}
			new PvPSuchtScoreboard(p).SetScoreSB();
		}else {
			e.setQuitMessage(null);
			for(Player all : Bukkit.getOnlinePlayers()) {
			 	sendTablistHeaderAndFooter(all, "§7» §a§lPvPSucht.de §7« §r\n", " \n §7Discord§8: §a/vRMPg8B \n §7Twitter§8: §b@PvPSucht \n\n");
			 	
			 	new PvPSuchtScoreboard(all).editScore(all, "§7» §c", String.valueOf(Bukkit.getOnlinePlayers().size()));
			}
			new PvPSuchtScoreboard(p).SetScoreSB();
		}
	}
	
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p  = e.getPlayer();
		if(!Lobby.isBanned.contains(p)) {
		if(Lobby.cfg.getBoolean("Wartungen") == false) {
		 p.setGameMode(GameMode.ADVENTURE);
		 for(Player all : Bukkit.getOnlinePlayers()) {
		 	sendTablistHeaderAndFooter(all, "§7» §a§lPvPSucht.de §7« §r\n", " \n §7Discord§8: §a/vRMPg8B \n §7Twitter§8: §b@PvPSucht \n\n");
		 	new PvPSuchtScoreboard(p).updateScore(all, "");
		 }
        
		 p.setHealth(20);
		 p.setFoodLevel(20);
		 Location loc = new Location(p.getWorld(), 113.5, 70, -144.5);
		 loc.setYaw(p.getLocation().getYaw());
		 loc.setPitch(p.getLocation().getPitch());
		 p.teleport(loc);
		 
		 p.getInventory().clear();
		 e.setJoinMessage(null);
		 p.sendMessage("§aWillkommen auf PvPSucht.de!");
		 ItemStack co = new ItemStack(Material.COMPASS);
		 ItemMeta cometa = co.getItemMeta();
		 cometa.setDisplayName("§5§lTeleporter");
		 co.setItemMeta(cometa);
		 ItemStack hide = new ItemStack(Material.BLAZE_ROD);
		 ItemMeta hidemeta = hide.getItemMeta();
		 hidemeta.setDisplayName("§5§lSpieler verstecken");
		 hide.setItemMeta(hidemeta);
		 p.getInventory().setItem(0, co);
		 p.getInventory().setItem(8, hide);
		 new PvPSuchtScoreboard(p).SetScoreSB();
		
			for(Player all : Bukkit.getOnlinePlayers()) {
				new PvPSuchtScoreboard(all).editScore(all, "§7» §c", String.valueOf(Bukkit.getOnlinePlayers().size()));
				
			}
			
		}else {
			if(p.hasPermission("pvpsucht.admin") || p.isOp() || p.hasPermission("pvpsucht.admin") 
			|| p.hasPermission("pvpsucht.dev") || p.hasPermission("pvpsucht.mod") || p.hasPermission("pvpsucht.sup")
			|| p.hasPermission("pvpsucht.builder")) {
				p.setGameMode(GameMode.ADVENTURE);
				for(Player all : Bukkit.getOnlinePlayers()) {
				 	sendTablistHeaderAndFooter(all, "§7» §a§lPvPSucht.de §7« §r\n", " \n §7Discord§8: §a/vRMPg8B \n §7Twitter§8: §b@PvPSucht \n\n");
				 	new PvPSuchtScoreboard(p).updateScore(all, "");
				}
				 p.setHealth(20);
				 p.setFoodLevel(20);
				 Location loc = new Location(p.getWorld(), 113.5, 70, -144.5);
				 loc.setYaw(p.getLocation().getYaw());
				 loc.setPitch(p.getLocation().getPitch());
				 p.teleport(loc);
				 p.getInventory().clear();
				 e.setJoinMessage(null);
				 p.sendMessage("§aWillkommen auf PvPSucht.de!");
				 ItemStack co = new ItemStack(Material.COMPASS);
				 ItemMeta cometa = co.getItemMeta();
				 cometa.setDisplayName("§5§lTeleporter");
				 co.setItemMeta(cometa);
				 ItemStack hide = new ItemStack(Material.BLAZE_ROD);
				 ItemMeta hidemeta = hide.getItemMeta();
				 hidemeta.setDisplayName("§5§lSpieler verstecken");
				 hide.setItemMeta(hidemeta);
				 ItemStack gd = new ItemStack(Material.DOUBLE_PLANT);
				 ItemMeta gdmeta = gd.getItemMeta();
				 gdmeta.setDisplayName("§5§lGadgets");
				 gd.setItemMeta(gdmeta);
				 p.getInventory().setItem(0, co);
				 p.getInventory().setItem(4, gd);
				 p.getInventory().setItem(8, hide);
				 new PvPSuchtScoreboard(p).SetScoreSB();
				 for(Player all : Bukkit.getOnlinePlayers()) {
						new PvPSuchtScoreboard(all).editScore(all, "§7» §c", String.valueOf(Bukkit.getOnlinePlayers().size()));
						
					}
				}else {
					e.setJoinMessage(null);
					p.kickPlayer("§cWARTUNGEN AKTIVIERT!");
				}
		}
		}else {
			p.kickPlayer("§7» §a§lPvPSucht.de §7« \n \n §4Du bist gebannt!");
		}
	}
		public void openGUI(Player player) {
		
		ItemStack mc = new ItemStack(Material.MAGMA_CREAM);
		ItemMeta mcmeta = mc.getItemMeta();
		mcmeta.setDisplayName("§7•§8● §7| §aSpawn");
		mc.setItemMeta(mcmeta);
		
		ItemStack is = new ItemStack(Material.IRON_SWORD);
		ItemMeta ismeta = is.getItemMeta();
		ismeta.setDisplayName("§7•§8● §7| §aOneDayVaro");
		is.setItemMeta(ismeta);
		
		ItemStack ga = new ItemStack(Material.GOLDEN_APPLE);
		ItemMeta gameta = ga.getItemMeta();
		gameta.setDisplayName("§7•§8● §7| §eUHC-Meetup");
		ga.setItemMeta(gameta);
		
		ItemStack gr = new ItemStack(Material.GOLD_PICKAXE);
		ItemMeta grmeta = gr.getItemMeta();
		grmeta.setDisplayName("§7•§8● §7| §eSpeed-UHC");
		gr.setItemMeta(grmeta);
		
		Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST, GUI);
		inv.setItem(4, is);
		inv.setItem(11, ga);
		inv.setItem(22, mc);
		inv.setItem(15, gr);
		
		player.openInventory(inv);
	}
		public void openGUIHide(Player player) {
			
			ItemStack zu = new ItemStack(Material.BARRIER);
			ItemMeta zumeta = zu.getItemMeta();
			zumeta.setDisplayName("§7•§8● §7| §cSpieler verstecken");
			zu.setItemMeta(zumeta);
			
			ItemStack auf = new ItemStack(Material.SLIME_BALL);
			ItemMeta aufmeta = auf.getItemMeta();
			aufmeta.setDisplayName("§7•§8● §7| §aSpieler anzeigen");
			auf.setItemMeta(aufmeta);
			
			Inventory inv = Bukkit.createInventory(null, 9*1, GUI_HIDE);
			inv.setItem(2, auf);
			inv.setItem(6, zu);
			
			player.openInventory(inv);
		}
	
		@EventHandler
		public void NavigatorOpener(PlayerInteractEvent e) {
			if(e.getItem().getType() != Material.COMPASS) return;
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK);
				openGUI(e.getPlayer());
		}
		
		@EventHandler
		public void NavigatorOpenerHIDE(PlayerInteractEvent e) {
			if(e.getItem().getType() != Material.BLAZE_ROD) return;
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK);
				openGUIHide(e.getPlayer());
		}
		
		@EventHandler
		public void GUIClick(InventoryClickEvent e) {
			if(!(e.getWhoClicked() instanceof Player)) return;
			Player p = (Player)e.getWhoClicked();
			if(e.getClickedInventory().getTitle().equals(GUI)) {
				switch(e.getCurrentItem().getType()) {
				case MAGMA_CREAM:
					Location loc0 = new Location(p.getWorld(), 113.5, 70, -143.5);
					p.teleport(loc0);
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 2);
					p.closeInventory();
					break;
				case IRON_SWORD:
					Location loc = new Location(p.getWorld(), 113.5, 70, -190.5);
					p.teleport(loc);
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 2);
					p.closeInventory();
					break;
				case GOLDEN_APPLE:
					Location loc1 = new Location(p.getWorld(), 154.5, 71, -143.5);
					p.teleport(loc1);
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 2);
					p.closeInventory();
					break;
				case GOLD_PICKAXE:
					Location loc2 = new Location(p.getWorld(), 114.5, 71, -83.5);
					p.teleport(loc2);
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 2);
					p.closeInventory();
					break;
				default:
					p.closeInventory();
					break;
				
				}
			}
		}
		
		@EventHandler
		public void GUIClickHIDE(InventoryClickEvent e) {
			if(!(e.getWhoClicked() instanceof Player)) return;
			Player p = (Player)e.getWhoClicked();
			if(e.getClickedInventory().getTitle().equals(GUI_HIDE)) {
				switch(e.getCurrentItem().getType()) {
				case SLIME_BALL:
					for(Player all : Bukkit.getOnlinePlayers()) {
						p.showPlayer(all);
					}
					p.closeInventory();
					p.sendMessage(Lobby.prefix + "Du siehst nun wieder §aalle §7Spieler§8!");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
					break;
				case BARRIER:
					for(Player all : Bukkit.getOnlinePlayers()) {
						p.hidePlayer(all);
					}
					p.closeInventory();
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
					p.sendMessage(Lobby.prefix + "Du siehst nun §ckeine §7Spieler mehr§8!");

					break;
				default:
					p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 1, 1);
					break;
				
				}
			}
		}

	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		e.setDeathMessage(null);
		Location loc0 = new Location(e.getEntity().getWorld(), 113.5, 70, -143.5);
		e.getEntity().teleport(loc0);
		
	}
	
	@EventHandler
	public void onFood(FoodLevelChangeEvent e) {
			e.setCancelled(true);
	}

	@EventHandler
	public void onDespawn(ItemDespawnEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		e.setCancelled(true);
	}
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage(null);
		for(Player all : Bukkit.getOnlinePlayers()) {
			new PvPSuchtScoreboard(all).editScore(all, "§7» §c", String.valueOf(Bukkit.getOnlinePlayers().size() -1));
			
		}
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void Unknown(PlayerCommandPreprocessEvent e) {
		if(!(e.isCancelled())) {
			Player p = e.getPlayer();
			String msg = e.getMessage().split(" ")[0];
			HelpTopic t = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
			if(t == null) {
				p.sendMessage(Lobby.prefix + "Der Befehl [§a§l"+t+"§7] existert nicht!");
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void Reload(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		String command = e.getMessage();
		if(command.equalsIgnoreCase("rl") || command.equalsIgnoreCase("reload")) {
			if(p.isOp() || p.hasPermission("legendbw.admin")) {
				e.setCancelled(true);
				Bukkit.broadcastMessage(Lobby.prefix + "§cRELOAD!");
				Bukkit.reload();
				Bukkit.broadcastMessage(Lobby.prefix + "§a§lRELOAD ABGESCHLOSSEN!");
			}
		}
	}
	

	public void sendTablistHeaderAndFooter(Player p, String header, String footer) {

		if(header == null) header = "";

		if(footer == null) footer = "";

		

		IChatBaseComponent tabHeader = ChatSerializer.a("{\"text\":\"" + header + "\"}");

		IChatBaseComponent tabFooter = ChatSerializer.a("{\"text\":\"" + footer + "\"}");

	

		PacketPlayOutPlayerListHeaderFooter headerPacket = new PacketPlayOutPlayerListHeaderFooter(tabHeader);

		try {

			Field field = headerPacket.getClass().getDeclaredField("b");

			field.setAccessible(true);

			field.set(headerPacket, tabFooter);

		} catch(Exception e) {

			e.printStackTrace();

		} finally {

			((CraftPlayer)p).getHandle().playerConnection.sendPacket(headerPacket);

		}

	}
	
	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e) {
		e.setCancelled(true);
	}
	
}
