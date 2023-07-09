package de.tempoo50.lobysystem.listener;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import de.tempoo50.lobysystem.api.Item;

public class JoinListener implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void handlePlayerJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		
		if(player.hasPermission("sys.admin")) {
			
			File pfile = new File("plugins//LobbySystem//PremiumLobby.yml");
			YamlConfiguration pconfig = YamlConfiguration.loadConfiguration(pfile);
			
			player.setGameMode(GameMode.CREATIVE);
			
			player.getInventory().clear();

			if(pfile.exists()) {
				
				player.getInventory().setItem(0, new Item(Material.COMPASS, 1).setDisplayname("Premium-Lobby-Übersicht").build());
				player.getInventory().setItem(4, new Item(Material.FISHING_ROD, 1).setDisplayname((String) pconfig.get("Item.Angel")).addEnchantment(Enchantment.DURABILITY, 999999, true).build());
				
				for(String name : pconfig.getConfigurationSection("Premium").getKeys(false)) {
					
					World world = Bukkit.getWorld((String) pconfig.get("Premium." + name + ".World"));
					double x = pconfig.getDouble("Premium." + name + ".X");
					double y = pconfig.getDouble("Premium." + name + ".Y");
					double z = pconfig.getDouble("Premium." + name + ".Z");
					float yaw = (float) pconfig.getDouble("Premium." + name + ".Yaw");
					float pitch = (float) pconfig.getDouble("Premium." + name + ".Pitch");
					Location location = new Location(world, x, y, z, yaw, pitch);
					
					player.teleport(location);
					
				}
				
			}else {
				
				File file = new File("plugins//LobbySystem//Lobby.yml");
				YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
		
				player.getInventory().setItem(0, new Item(Material.COMPASS, 1).setDisplayname("Lobby-Übersicht").build());
				player.getInventory().setItem(4, new Item(Material.FISHING_ROD, 1).setDisplayname((String) config.get("Item.Angel")).addEnchantment(Enchantment.DURABILITY, 999999, true).build());
				
				if(file.exists()) {
		
					for(String name : config.getConfigurationSection("Lobby").getKeys(false)) {
						
						World world = Bukkit.getWorld((String) config.get("Lobby." + name + ".World"));
						double x = config.getDouble("Lobby." + name + ".X");
						double y = config.getDouble("Lobby." + name + ".Y");
						double z = config.getDouble("Lobby." + name + ".Z");
						float yaw = (float) config.getDouble("Lobby." + name + ".Yaw");
						float pitch = (float) config.getDouble("Lobby." + name + ".Pitch");
						Location location = new Location(world, x, y, z, yaw, pitch);
						
						player.teleport(location);
						
					}
				}
			}

			event.setJoinMessage("");
			
		}else if(player.hasPermission("lobby.premium")) {
			
			File pfile = new File("plugins//LobbySystem//PremiumLobby.yml");
			YamlConfiguration pconfig = YamlConfiguration.loadConfiguration(pfile);
			
			player.setGameMode(GameMode.ADVENTURE);
			
			player.getInventory().clear();
			
			if(pfile.exists()) {
				
				player.getInventory().setItem(0, new Item(Material.COMPASS, 1).setDisplayname("Premium-Lobby-Übersicht").build());
				player.getInventory().setItem(4, new Item(Material.FISHING_ROD, 1).setDisplayname((String) pconfig.get("Item.Angel")).addEnchantment(Enchantment.DURABILITY, 999999, true).build());
				
				for(String name : pconfig.getConfigurationSection("Premium").getKeys(false)) {
					
					World world = Bukkit.getWorld((String) pconfig.get("Premium." + name + ".World"));
					double x = pconfig.getDouble("Premium." + name + ".X");
					double y = pconfig.getDouble("Premium." + name + ".Y");
					double z = pconfig.getDouble("Premium." + name + ".Z");
					float yaw = (float) pconfig.getDouble("Premium." + name + ".Yaw");
					float pitch = (float) pconfig.getDouble("Premium." + name + ".Pitch");
					Location location = new Location(world, x, y, z, yaw, pitch);
					
					player.teleport(location);
					
				}
			}

			event.setJoinMessage("");
			
		}else {
		
			File file = new File("plugins//LobbySystem//Lobby.yml");
			YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
			
			player.setGameMode(GameMode.ADVENTURE);
			
			player.getInventory().clear();
			
			player.getInventory().setItem(0, new Item(Material.COMPASS, 1).setDisplayname("Lobby-Übersicht").build());
			player.getInventory().setItem(4, new Item(Material.FISHING_ROD, 1).setDisplayname((String) config.get("Item.Angel")).addEnchantment(Enchantment.DURABILITY, 999999, true).build());
	
			if(file.exists()) {
				
				for(String name : config.getConfigurationSection("Lobby").getKeys(false)) {
					
					World world = Bukkit.getWorld((String) config.get("Lobby." + name + ".World"));
					double x = config.getDouble("Lobby." + name + ".X");
					double y = config.getDouble("Lobby." + name + ".Y");
					double z = config.getDouble("Lobby." + name + ".Z");
					float yaw = (float) config.getDouble("Lobby." + name + ".Yaw");
					float pitch = (float) config.getDouble("Lobby." + name + ".Pitch");
					Location location = new Location(world, x, y, z, yaw, pitch);
					
					player.teleport(location);
					
				}
				
			}
	
			event.setJoinMessage("");
			
		}
		
	}
	
	@EventHandler
	public void handlePlayerQuit(PlayerQuitEvent event) {
		
		event.setQuitMessage("");
		
	}
	
	@EventHandler
	public void handlePlayerDeath(PlayerDeathEvent event) {
		
		event.setDeathMessage("");
		
	}

}
