package de.lobby.manage.ScoreboardManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class PvPSuchtScoreboard {

	
	Player p;
	
	public PvPSuchtScoreboard(Player p) {
		this.p = p;
	}
	
	@SuppressWarnings("deprecation")
	public void SetScoreSB() {
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("aaa", "bbb");
		
		Team owner = board.registerNewTeam("0000O");
		Team dev = board.registerNewTeam("0002A");
		Team devlehrling = board.registerNewTeam("0003DL");
		Team admin = board.registerNewTeam("0001A");
		Team mod = board.registerNewTeam("0004M");
		Team sup = board.registerNewTeam("0005S");
		Team builder = board.registerNewTeam("0006B");
		Team Hoster = board.registerNewTeam("0007H");
		Team youtuber = board.registerNewTeam("0008YT");
		Team supremium = board.registerNewTeam("0009SPRE");
		Team premium = board.registerNewTeam("0011PRE");
		Team spieler = board.registerNewTeam("00012SP");
		
		owner.setPrefix("§4O §7| §4");
		admin.setPrefix("§cA §7| §c");
		dev.setPrefix("§3Dev §7| §3");
		devlehrling.setPrefix("§3Dev-L. §7| §3");
		mod.setPrefix("§aMod §7| §a");
		sup.setPrefix("§bSup §7| §b");
		builder.setPrefix("§eB §7| §e");
		youtuber.setPrefix("§5Y§fT §7| §5");
		Hoster.setPrefix("§2H §7| §2");
		supremium.setPrefix("§b");
		premium.setPrefix("§6");
		spieler.setPrefix("§7");
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			if(all.isOp() || all.hasPermission("pvpsucht.owner")){
				owner.addPlayer(all);
			}else if(all.hasPermission("pvpsucht.admin")) {
				admin.addPlayer(all);
			}else if(all.hasPermission("pvpsucht.dev")) {
				dev.addPlayer(all);
			}else if(all.hasPermission("pvpsucht.devlehrling")) {
				devlehrling.addPlayer(all);
			}else if(all.hasPermission("pvpsucht.mod")) {
				mod.addPlayer(all);
			}else if(all.hasPermission("pvpsucht.sup")) {
				sup.addPlayer(all);
			}else if(all.hasPermission("pvpsucht.builder")) {
				builder.addPlayer(all);
			}else if(all.hasPermission("pvpsucht.hostewr")) {
				Hoster.addPlayer(all);
			}else if(all.hasPermission("pvpsucht.supremium")) {
				supremium.addPlayer(all);
			}else if(all.hasPermission("pvpsucht.premium")) {
				premium.addPlayer(all);
			}else {
				spieler.addPlayer(all);
			}
		}
		
		obj.setDisplayName("§7✗ §aPvPSucht.de §7✗");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.getScore("§r").setScore(11);
		obj.getScore("§a✗ §8| §fDein Rang").setScore(10);
		
		if(p.isOp()) {
			obj.getScore("§7» §4Owner").setScore(9);
		}else if(p.hasPermission("pvpsucht.admin")) {
			obj.getScore("§7» §cAdmin").setScore(9);
		}else if(p.hasPermission("pvpsucht.dev")) {
			obj.getScore("§7» §3Developer").setScore(9);
		}else if(p.hasPermission("pvpsucht.devlehrling")) {
			obj.getScore("§7» §3Dev Lehrling").setScore(9);
		}else if(p.hasPermission("pvpsucht.mod")) {
			obj.getScore("§7» §aModerator").setScore(9);
		}else if(p.hasPermission("pvpsucht.sup")) {
			obj.getScore("§7» §bSupporter").setScore(9);
		}else if(p.hasPermission("pvpsucht.builder")) {
			obj.getScore("§7» §eBuilder").setScore(9);
		}else if(p.hasPermission("pvpsucht.hoster")) {
			obj.getScore("§7» §2Hoster").setScore(9);
		}else if(p.hasPermission("pvpsucht.youtuber")) {
			obj.getScore("§7» §5You§fTuber").setScore(9);
		}else if(p.hasPermission("pvpsucht.supremium")) {
			obj.getScore("§7» §bSupremium").setScore(9);
		}else if(p.hasPermission("pvpsucht.premium")) {
			obj.getScore("§7» §6Premium").setScore(9);
		}else {
			obj.getScore("§7» Spieler").setScore(9);
		}
		
		obj.getScore("§k").setScore(8);
		obj.getScore("§c✗ §8| §fOnline:").setScore(7);
		obj.getScore("§7» §c").setScore(6);
		saveScore(board, "§7» §c", String.valueOf(Bukkit.getOnlinePlayers().size()));
		obj.getScore("§l").setScore(5);
		obj.getScore("§e✗ §8| §fDiscord:").setScore(4);
		obj.getScore("§7» §evRMPg8B").setScore(3);
		obj.getScore("§1").setScore(2);
		obj.getScore("§b✗ §8| §fTeamspeak:").setScore(1);
		obj.getScore("§7» §bPvPSucht.de").setScore(0);
		p.setScoreboard(board);
		
		
		
	}
	
	public static void editScore(Player p, String Team, String message) {
			Scoreboard sb = p.getScoreboard();
			Team t = sb.getTeam(Team);
			if(t != null) {
				t.setSuffix(message);
			}
	}
	
	public static void saveScore(Scoreboard sb, String Score, String message) {
		Team t = sb.getTeam(Score);
		if(t == null) {
			t = sb.registerNewTeam(Score);
			t.addEntry(Score);
			t.setSuffix(message);
		}
	}
	
	public static Team getTeam(Scoreboard sb, String Team, String prefix, String suffix) {
        Team team = sb.getTeam(Team);
        if(team == null) {
            team =  sb.registerNewTeam(Team);
        }
        team.setPrefix(prefix);
        team.setSuffix(suffix);
        return team;
    }
	
	@SuppressWarnings("deprecation")
    public static void updateScore(Player p, String Team) {
        Scoreboard sb = p.getScoreboard();
        for(Player all : Bukkit.getOnlinePlayers()) {
            if(all.isOp()) {
                getTeam(sb, "001", "§4O §7| §4", "" + Team).addPlayer(all);
                }else if(p.hasPermission("pvpsucht.admin")) {
                    getTeam(sb, "015", "§cA §7| §c", ""+ Team).addPlayer(all); 
                }else if(p.hasPermission("pvpsucht.dev")) {
                    getTeam(sb, "020", "§3Dev §7| §3", ""+ Team).addPlayer(all); 
                }else if(p.hasPermission("pvpsucht.devlehrling")) {
                    getTeam(sb, "025", "§3Dev-L. §7| §3", ""+ Team).addPlayer(all);   
                }else if(p.hasPermission("pvpsucht.mod")) {
                    getTeam(sb, "030", "§aMod §7| §a", ""+ Team).addPlayer(all);   
                }else if(p.hasPermission("pvpsucht.sup")) {
                    getTeam(sb, "035", "§bSup §7| §b", ""+ Team).addPlayer(all);   
                }else if(p.hasPermission("pvpsucht.builder")) {
                    getTeam(sb, "040", "§eB §7| §e", ""+ Team).addPlayer(all);    
                }else if(p.hasPermission("pvpsucht.youtuber")) {
                    getTeam(sb, "045", "§5Y§fT §7| §5", ""+ Team).addPlayer(all);   
                }else if(p.hasPermission("pvpsucht.supremium")) {
                    getTeam(sb, "050", "§b", ""+ Team).addPlayer(all);    
                }else if(p.hasPermission("pvpsucht.premium")) {
                    getTeam(sb, "055", "§6", ""+ Team).addPlayer(all);    
                }else {
                    getTeam(sb, "060", "§7", ""+ Team).addPlayer(all);   
                }
            }
        }

}
