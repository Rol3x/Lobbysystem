package de.lobby.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.lobby.main.Lobby;

public class ReportCommand implements CommandExecutor, Listener{
	
	public final String REPORT_GUI = "§6§lReport-System";

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String St, String[] args) {
		Player p = (Player)s;
		if(args.length == 0) {
			p.sendMessage(Lobby.prefix + "Bitte gebe einen Spieler an§8!");
		}else if(args.length == 1) {
			p.sendMessage(Lobby.prefix + "Bitte gebe einen Grund an§8!");
			p.sendMessage(Lobby.prefix + "Verfügbare Gründe§8: §cBeleidigung§7, §cWerbung§7, §cHacking§7 oder §cSpamming");
		}else if(args.length == 2) {
			String msg = args[1];
			Player t = Bukkit.getPlayer(args[0]);
			if(t != null) {
				if(msg.equalsIgnoreCase("Beleidigung")) {
					openGUI(p);
				}else if(msg.equalsIgnoreCase("Werbung")) {
					openGUI(p);
				}else if(msg.equalsIgnoreCase("Hacking")) {
					openGUI(p);
				}else if(msg.equalsIgnoreCase("Spamming")) {
					openGUI(p);
				}else {
					p.sendMessage(Lobby.prefix + "Bitte gebe einen Grund an§8!");
				}
			}else {
				p.sendMessage(Lobby.prefix + "§cDieser Spieler ist nicht Online§8!");
			}
		}
		return false;
	}
	
	public void openGUI(Player player) {
		
		ItemStack mc = new ItemStack(Material.MAGMA_CREAM);
		ItemMeta mcmeta = mc.getItemMeta();
		mcmeta.setDisplayName("§7•§8● §7| §8Report confirm");
		mc.setItemMeta(mcmeta);
		
		Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST, REPORT_GUI);
		inv.setItem(13, mc);
		
		player.openInventory(inv);
	}
	
	@EventHandler
	public void GUIClick(InventoryClickEvent e) {
		if(!(e.getWhoClicked() instanceof Player)) return;
		Player p = (Player)e.getWhoClicked();
		if(e.getClickedInventory().getTitle().equals(REPORT_GUI)) {
			switch(e.getCurrentItem().getType()) {
			case MAGMA_CREAM:
				p.closeInventory();
				p.sendMessage(Lobby.prefix+ "§7Du hast den Report erfolgreich abgeschickt!");
				for(Player all : Bukkit.getOnlinePlayers()) {
					if(all.hasPermission("pvpsucht.admin") || p.isOp() || p.hasPermission("pvpsucht.dev") 
							|| p.hasPermission("pvpsucht.mod") || p.hasPermission("pvpsucht.sup")) {
						all.sendMessage(Lobby.prefix + "Der Spieler §a§l" + p.getName()
						+ "§7 hat einen Spieler reportet!");
					}
				}
				break;
			default:
				p.closeInventory();
				break;
			
			}
		}
	}

}
