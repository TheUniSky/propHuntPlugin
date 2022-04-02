package fr.julien.UniPropHunt;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new PluginListeners(this), this);
	}
	
}
