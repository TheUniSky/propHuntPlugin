package fr.julien.UniPropHunt;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class GameLauncher {

	private static List<Player> l = new ArrayList<Player>();
	public static void addPlayer(Main main,Player player) {
		if (l.contains(player)) {}
		else {
			
		}
	}
	public static void removePlayer(Player player) {
		l.remove(player);
	}
	public static boolean isInGame(Player player) {
		if (l.contains(player)) {
			return true;
		}
			
		return false;
	}
	
}
