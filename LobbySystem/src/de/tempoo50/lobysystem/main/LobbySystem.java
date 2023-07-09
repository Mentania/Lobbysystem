package de.tempoo50.lobysystem.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.tempoo50.lobysystem.commands.LobbyCommand;
import de.tempoo50.lobysystem.commands.test;
import de.tempoo50.lobysystem.listener.JoinListener;
import de.tempoo50.lobysystem.listener.LobbyEvent;

public class LobbySystem extends JavaPlugin {
	
	private static LobbySystem plugin;

	@Override
	public void onEnable() {

		plugin = this;

		try {
			
			loadFiles();
			loadCommands();
			loadListener(Bukkit.getPluginManager());
			loadMySQL();
			
		}catch(Exception e1) {
			
			e1.printStackTrace();
			log("§4Fehler: Plugin konnte nicht geladen werden!");
			Bukkit.getPluginManager().disablePlugin(this);
			
		}
			
		log("§aPlugin erfolgreich geladen!");
		log("§agecodet von Tempoo50");
		
	}
	
	@Override
	public void onDisable() {
		
		log("§aPlugin wird nun beendet!");
		
	}
	
	private void loadFiles() {
		
	}
	
	private void loadCommands() {
		
		getCommand("lobby").setExecutor(new LobbyCommand(this));
		getCommand("test").setExecutor(new test());
		
	}
	
	private void loadListener(PluginManager pm) {
		
		pm.registerEvents(new LobbyEvent(), this);
		pm.registerEvents(new JoinListener(), this);
		
	}

	private void loadMySQL() {

	}
	
	public static void log(String msg) {
		
		Bukkit.getConsoleSender().sendMessage("§4[LobbySystem]: " + msg);
		
	}
	
	public static LobbySystem getPlugin() {
	
		return plugin;
	
	}
	
}
