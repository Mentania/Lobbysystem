package de.tempoo50.lobysystem.listener;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import de.tempoo50.lobysystem.commands.LobbyCommand;

public class LobbyEvent implements Listener {
	
	@EventHandler
	public void handleClick(InventoryClickEvent event) {
		
		Player player = (Player) event.getWhoClicked();

		event.setCancelled(true);
		
		if(event.getInventory().getName().equalsIgnoreCase("Lobby-Übersicht")) {
			
			event.setCancelled(true);
			
			File file = new File("plugins//LobbySystem//Lobby.yml");
			YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
			
			for(String name : config.getConfigurationSection("Lobby").getKeys(false)) {
			
				if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase((String) config.get("Lobby." + name + ".DisplayName"))) {
					
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
			
			for(String nam : config.getConfigurationSection("Game").getKeys(false)) {
				
				if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase((String) config.get("Game." + nam + ".DisplayName"))) {
				
					World world = Bukkit.getWorld((String) config.get("Game." + nam + ".World"));
					double x = config.getDouble("Game." + nam + ".X");
					double y = config.getDouble("Game." + nam + ".Y");
					double z = config.getDouble("Game." + nam + ".Z");
					float yaw = (float) config.getDouble("Game." + nam + ".Yaw");
					float pitch = (float) config.getDouble("Game." + nam + ".Pitch");
					Location location = new Location(world, x, y, z, yaw, pitch);
					
					player.teleport(location);
					
				}
				
			}
			
		}
		
		if(event.getInventory().getName().equalsIgnoreCase("Premium-Lobby-Übersicht")) {

			event.setCancelled(true);
			
			File file = new File("plugins//LobbySystem//PremiumLobby.yml");
			YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
			
			for(String na : config.getConfigurationSection("GamePremium").getKeys(false)) {
				
				if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase((String) config.get("GamePremium." + na + ".DisplayName"))) {
				
					World world = Bukkit.getWorld((String) config.get("GamePremium." + na + ".World"));
					double x = config.getDouble("GamePremium." + na + ".X");
					double y = config.getDouble("GamePremium." + na + ".Y");
					double z = config.getDouble("GamePremium." + na + ".Z");
					float yaw = (float) config.getDouble("GamePremium." + na + ".Yaw");
					float pitch = (float) config.getDouble("GamePremium." + na + ".Pitch");
					Location location = new Location(world, x, y, z, yaw, pitch);
					
					player.teleport(location);
					
				}
				
			}

			for(String n : config.getConfigurationSection("Premium").getKeys(false)) {
			
				if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase((String) config.get("Premium." + n + ".DisplayName"))) {
					
					World world = Bukkit.getWorld((String) config.get("Premium." + n + ".World"));
					double x = config.getDouble("Premium." + n + ".X");
					double y = config.getDouble("Premium." + n + ".Y");
					double z = config.getDouble("Premium." + n + ".Z");
					float yaw = (float) config.getDouble("Premium." + n + ".Yaw");
					float pitch = (float) config.getDouble("Premium." + n + ".Pitch");
					Location location = new Location(world, x, y, z, yaw, pitch);
					
					player.teleport(location);
					
				}
				
			}
			
		}
		
	}
	
	@EventHandler
	public void handleRightClick(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR) {
			
			ItemStack item = player.getItemInHand();
			
			if(item.getItemMeta().getDisplayName().equalsIgnoreCase("Lobby-Übersicht")) {
				
				LobbyCommand.loadInv(player);
				
			}
			
			if(item.getItemMeta().getDisplayName().equalsIgnoreCase("Premium-Lobby-Übersicht")) {
				
				LobbyCommand.loadPremiumInv(player);
				
			}
			
		}else if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			
			ItemStack item = player.getItemInHand();
			
			if(item.getItemMeta().getDisplayName().equalsIgnoreCase("Lobby-Übersicht")) {
				
				LobbyCommand.loadInv(player);
				
			}
			
			if(item.getItemMeta().getDisplayName().equalsIgnoreCase("Premium-Lobby-Übersicht")) {
				
				LobbyCommand.loadPremiumInv(player);
				
			}
			
		}
		
	}
	
	@EventHandler
	public void handleInvdrop(PlayerDropItemEvent event) {
		
		event.setCancelled(true);
		
	}
	
	@EventHandler
	public void handleFoodChange(FoodLevelChangeEvent event) {
		
		event.setCancelled(true);
		
	}
	
	@EventHandler
	public void handleDamge(EntityDamageEvent event) {
		
		event.setCancelled(true);
		
	}
	
	@EventHandler
	public void handleFoodLevelChange(FoodLevelChangeEvent event) {
		
		event.setCancelled(true);
		
	}
	
	@EventHandler
	public void handlePlayerMove(PlayerMoveEvent event) {
		
		Player player = event.getPlayer();
		
		if(player.getLocation().getBlock().getType() == Material.GOLD_PLATE) {
			
			if(player.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.EMERALD_BLOCK) {
				
				Vector v = player.getLocation().getDirection().multiply(3D).setY(1D);
				player.setVelocity(v);
				player.playEffect(player.getLocation(), Effect.ENDER_SIGNAL, 3);
				player.playSound(player.getLocation(), Sound.ENTITY_ENDERDRAGON_FLAP, 3, 2);
				
			}
			
		}
		
	}

}
