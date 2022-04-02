package fr.julien.UniPropHunt;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

public class UserList {
	private static Map<Player, Boolean> Sand1 = new HashMap<Player, Boolean>();
	private static Map<Player, Boolean> Sand2 = new HashMap<Player, Boolean>();
	private static Map<Player, Boolean> Sand3 = new HashMap<Player, Boolean>();
	private static Map<Player, Boolean> Sand4 = new HashMap<Player, Boolean>();
	private static Map<Player, Boolean> Sand5 = new HashMap<Player, Boolean>();
	private static Map<Player, Boolean> Sand6 = new HashMap<Player, Boolean>();
	
	public static boolean isHunter(int x, Player player) {
		switch ( x) {
		case 1:
			return Sand1.get(player);
		case 2:
			return Sand2.get(player);
		case 3:
			return Sand3.get(player);
		case 4:
			return Sand4.get(player);
		case 5:
			return Sand5.get(player);
		case 6:
			return Sand6.get(player);
		}
		
		return false;
		
	}
	
	public static void addPlayer(int x, Player player,boolean Hunter) {
		switch ( x) {
		case 1:
			Sand1.put(player, Hunter);
		case 2:
			Sand1.put(player, Hunter);
		case 3:
			Sand1.put(player, Hunter);
		case 4:
			Sand1.put(player, Hunter);
		case 5:
			Sand1.put(player, Hunter);
		case 6:
			Sand1.put(player, Hunter);
		}
		
		
		
	}
	
	
}
