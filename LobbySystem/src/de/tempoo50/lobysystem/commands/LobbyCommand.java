package de.tempoo50.lobysystem.commands;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.tempoo50.lobysystem.api.Item;
import de.tempoo50.lobysystem.main.LobbySystem;

public class LobbyCommand implements CommandExecutor {
	
	private static File file = new File("plugins//LobbySystem//Lobby.yml");
	private static YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
	
	private static File pfile = new File("plugins//LobbySystem//PremiumLobby.yml");
	private static YamlConfiguration pconfig = YamlConfiguration.loadConfiguration(pfile);
	
	private static File ifile = new File("plugins//LobbySystem//Items.yml");
	private static YamlConfiguration iconfig = YamlConfiguration.loadConfiguration(ifile);
	
	private static File pifile = new File("plugins//LobbySystem//PremiumItems.yml");
	private static YamlConfiguration piconfig = YamlConfiguration.loadConfiguration(pifile);
	
	public static Inventory inv = Bukkit.createInventory(null, 9 * 6, "Lobby-Übersicht");
	public static Inventory pinv = Bukkit.createInventory(null, 9 * 6, "Premium-Lobby-Übersicht");

	private static String name;
	
	private LobbySystem plugin;
	
	public LobbyCommand(LobbySystem plugin) {
		
		this.plugin = plugin;
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if(player.hasPermission("sys.lobby")) {
			
				if(args.length == 0) {
					
					player.sendMessage("/lobby <create/set>");
					
				}else {
						
					if(!file.exists()) {
					
						if(args[0].equalsIgnoreCase("create")) {
							// /lobby create <lobby invplace
							if(args.length == 4) {
							
								name = args[1];
								String item = args[2];
								 
								int slot = Integer.parseInt(args[3]);
								
								if(slot >= 0 && slot <= 53) {
									
									config.addDefault("Lobby." + name + ".World", player.getWorld().getName());
									config.addDefault("Lobby." + name + ".X", player.getLocation().getX());
									config.addDefault("Lobby." + name + ".Y", player.getLocation().getY());
									config.addDefault("Lobby." + name + ".Z", player.getLocation().getZ());
									config.addDefault("Lobby." + name + ".Yaw", player.getLocation().getYaw());
									config.addDefault("Lobby." + name + ".Pitch", player.getLocation().getPitch());
									config.addDefault("Lobby." + name + ".DisplayName", name);
									config.addDefault("Item.Angel", "Test");
									
									config.options().copyDefaults(true);
									
									if(item.equalsIgnoreCase("bed")) {
	
										inv.setItem(slot, new Item(Material.BED, 1).setDisplayname(name).build());
										
										saveInv(inv);
	
									}else if(item.equalsIgnoreCase("stick")) {
	
										inv.setItem(slot, new Item(Material.STICK, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("tnt")) {
	
										inv.setItem(slot, new Item(Material.TNT, 1).setDisplayname(name).build());
	
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("sword")) {
	
										inv.setItem(slot, new Item(Material.DIAMOND_SWORD, 1).setDisplayname(name).build());
	
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("glas")) {
	
										inv.setItem(slot, new Item(Material.GLASS, 1).setDisplayname(name).build());
	
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("compass")) {
										
										inv.setItem(slot, new Item(Material.COMPASS, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("chest")) {
										
										inv.setItem(slot, new Item(Material.CHEST, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("enderchest")) {
										
										inv.setItem(slot, new Item(Material.ENDER_CHEST, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("portal")) {
										
										inv.setItem(slot, new Item(Material.ENDER_PORTAL_FRAME, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("axe")) {
										
										inv.setItem(slot, new Item(Material.DIAMOND_AXE, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("pickaxe")) {
										
										inv.setItem(slot, new Item(Material.DIAMOND_PICKAXE, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("apple")) {
										
										inv.setItem(slot, new Item(Material.APPLE, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("chestplate")) {
										
										inv.setItem(slot, new Item(Material.DIAMOND_CHESTPLATE, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("sign")) {
										
										inv.setItem(slot, new Item(Material.SIGN, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("block")) {
										
										inv.setItem(slot, new Item(Material.BEDROCK,1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("string")) {
										
										inv.setItem(slot, new Item(Material.STRING, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("stairs")) {
										
										inv.setItem(slot, new Item(Material.WOOD_STAIRS, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}
									
									try {
										config.save(file);
									} catch (IOException e) {
										e.printStackTrace();
									}
										
									player.sendMessage("Spawn für " + args[1] + " gesetzt");
								
								}else
									
									player.sendMessage("Wähle einen anderen slot bereich!");
								
							}else
								
								player.sendMessage("/lobby create name item slot");
						}
						
					}
					
					if(file.exists()) {
						// /lobby set game item invplace
						if(args[0].equalsIgnoreCase("set")) {
							
							if(args.length == 2) {
								
								player.sendMessage("/lobby set <game item invslot>");
								
							}else if(args.length == 3) {
								
								player.sendMessage("/lobby set <game item 0-53>");
								
							}else if(args.length == 4) {
								
								name = args[1];
								String item = args[2];
								
								int slot = Integer.parseInt(args[3]);
								
								if(slot >= 0 && slot <= 53) {
								
									config.addDefault("Game." + name + ".World", player.getLocation().getWorld().getName());
									config.addDefault("Game." + name + ".X", player.getLocation().getX());
									config.addDefault("Game." + name + ".Y", player.getLocation().getY());
									config.addDefault("Game." + name + ".Z", player.getLocation().getZ());
									config.addDefault("Game." + name + ".Yaw", player.getLocation().getYaw());
									config.addDefault("Game." + name + ".Pitch", player.getLocation().getPitch());
									config.addDefault("Game." + name + ".DisplayName", name);
									
									config.options().copyDefaults(true);
									
									saveInv(inv);
									
									try {
										config.save(file);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									
									if(item.equalsIgnoreCase("bed")) {

										inv.setItem(slot, new Item(Material.BED, 1).setDisplayname(name).build());
										
										saveInv(inv);

									}else if(item.equalsIgnoreCase("stick")) {

										inv.setItem(slot, new Item(Material.STICK, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("tnt")) {

										inv.setItem(slot, new Item(Material.TNT, 1).setDisplayname(name).build());

										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("sword")) {

										inv.setItem(slot, new Item(Material.DIAMOND_SWORD, 1).setDisplayname(name).build());

										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("glas")) {

										inv.setItem(slot, new Item(Material.GLASS, 1).setDisplayname(name).build());

										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("compass")) {
										
										inv.setItem(slot, new Item(Material.COMPASS, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("chest")) {
										
										inv.setItem(slot, new Item(Material.CHEST, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("enderchest")) {
										
										inv.setItem(slot, new Item(Material.ENDER_CHEST, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("portal")) {
										
										inv.setItem(slot, new Item(Material.ENDER_PORTAL_FRAME, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("axe")) {
										
										inv.setItem(slot, new Item(Material.DIAMOND_AXE, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("pickaxe")) {
										
										inv.setItem(slot, new Item(Material.DIAMOND_PICKAXE, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("apple")) {
										
										inv.setItem(slot, new Item(Material.APPLE, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("chestplate")) {
										
										inv.setItem(slot, new Item(Material.DIAMOND_CHESTPLATE, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("sign")) {
										
										inv.setItem(slot, new Item(Material.SIGN, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("block")) {
										
										inv.setItem(slot, new Item(Material.BEDROCK,1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("string")) {
										
										inv.setItem(slot, new Item(Material.STRING, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}else if(item.equalsIgnoreCase("stairs")) {
										
										inv.setItem(slot, new Item(Material.WOOD_STAIRS, 1).setDisplayname(name).build());
										
										saveInv(inv);
										
									}
									
								}else {
									
								player.sendMessage("Zu großer Slot bereich!");	
								
								}
								
							}
				
							player.sendMessage("Spawn " + args[1] + " gesetzt");
								
						}
						
						if(args[0].equalsIgnoreCase("save")) {
							
							if(args.length == 1) {
								
								saveInv(inv);
								savePremiumInv(pinv);
								
								player.sendMessage("Das LobbyMenü wurde gespeichert");
								
							}
							
						}
							
					}
					
					if(!pfile.exists()) {
						
						if(args[0].equalsIgnoreCase("premium")) {
							
							if(args.length == 4) {
								
								name = args[1];
								String item = args[2];
								
								int slot = Integer.parseInt(args[3]);
								
								if(slot >= 0 && slot <= 53) {
									
									pconfig.addDefault("Premium." + name + ".World", player.getWorld().getName());
									pconfig.addDefault("Premium." + name + ".X", player.getLocation().getX());
									pconfig.addDefault("Premium." + name + ".Y", player.getLocation().getY());
									pconfig.addDefault("Premium." + name + ".Z", player.getLocation().getZ());
									pconfig.addDefault("Premium." + name + ".Yaw", player.getLocation().getYaw());
									pconfig.addDefault("Premium." + name + ".Pitch", player.getLocation().getPitch());
									pconfig.addDefault("Premium." + name + ".DisplayName", name);
									pconfig.addDefault("Item.Angel", "Test");
									
									pconfig.options().copyDefaults(true);
									
									if(item.equalsIgnoreCase("bed")) {
	
										pinv.setItem(slot, new Item(Material.BED, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
	
									}else if(item.equalsIgnoreCase("stick")) {
	
										pinv.setItem(slot, new Item(Material.STICK, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("tnt")) {
	
										pinv.setItem(slot, new Item(Material.TNT, 1).setDisplayname(name).build());
	
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("sword")) {
	
										pinv.setItem(slot, new Item(Material.DIAMOND_SWORD, 1).setDisplayname(name).build());
	
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("glas")) {
	
										pinv.setItem(slot, new Item(Material.GLASS, 1).setDisplayname(name).build());
	
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("compass")) {
										
										pinv.setItem(slot, new Item(Material.COMPASS, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("chest")) {
										
										pinv.setItem(slot, new Item(Material.CHEST, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("enderchest")) {
										
										pinv.setItem(slot, new Item(Material.ENDER_CHEST, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("portal")) {
										
										pinv.setItem(slot, new Item(Material.ENDER_PORTAL_FRAME, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("axe")) {
										
										pinv.setItem(slot, new Item(Material.DIAMOND_AXE, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("pickaxe")) {
										
										pinv.setItem(slot, new Item(Material.DIAMOND_PICKAXE, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("apple")) {
										
										pinv.setItem(slot, new Item(Material.APPLE, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("chestplate")) {
										
										pinv.setItem(slot, new Item(Material.DIAMOND_CHESTPLATE, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("sign")) {
										
										pinv.setItem(slot, new Item(Material.SIGN, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("block")) {
										
										pinv.setItem(slot, new Item(Material.BEDROCK,1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("string")) {
										
										pinv.setItem(slot, new Item(Material.STRING, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("stairs")) {
										
										pinv.setItem(slot, new Item(Material.WOOD_STAIRS, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}
									
									try {
										pconfig.save(pfile);
									} catch (IOException e) {
										e.printStackTrace();
									}
									
									player.sendMessage("Spawn " + args[1] + " gesetzt");
									
								}else {
									
									player.sendMessage("Zu großer Slot bereich!");
									
								}
								
							}
							
						}
						
					}
					
					if(pfile.exists()) {
						
						if(args[0].equalsIgnoreCase("pset")) {
							
							if(args.length == 4) {
								
								name = args[1];
								String item = args[2];
								
								int slot = Integer.parseInt(args[3]);
								
								if(slot >= 0 && slot <= 53) {
									
									pconfig.addDefault("GamePremium." + name + ".World", player.getWorld().getName());
									pconfig.addDefault("GamePremium." + name + ".X", player.getLocation().getX());
									pconfig.addDefault("GamePremium." + name + ".Y", player.getLocation().getY());
									pconfig.addDefault("GamePremium." + name + ".Z", player.getLocation().getZ());
									pconfig.addDefault("GamePremium." + name + ".Yaw", player.getLocation().getYaw());
									pconfig.addDefault("GamePremium." + name + ".Pitch", player.getLocation().getPitch());
									pconfig.addDefault("GamePremium." + name + ".DisplayName", name);
									
									pconfig.options().copyDefaults(true);
									
									if(item.equalsIgnoreCase("bed")) {
	
										pinv.setItem(slot, new Item(Material.BED, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
	
									}else if(item.equalsIgnoreCase("stick")) {
	
										pinv.setItem(slot, new Item(Material.STICK, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("tnt")) {
	
										pinv.setItem(slot, new Item(Material.TNT, 1).setDisplayname(name).build());
	
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("sword")) {
	
										pinv.setItem(slot, new Item(Material.DIAMOND_SWORD, 1).setDisplayname(name).build());
	
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("glas")) {
	
										pinv.setItem(slot, new Item(Material.GLASS, 1).setDisplayname(name).build());
	
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("compass")) {
										
										pinv.setItem(slot, new Item(Material.COMPASS, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("chest")) {
										
										pinv.setItem(slot, new Item(Material.CHEST, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("enderchest")) {
										
										pinv.setItem(slot, new Item(Material.ENDER_CHEST, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("portal")) {
										
										pinv.setItem(slot, new Item(Material.ENDER_PORTAL_FRAME, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("axe")) {
										
										pinv.setItem(slot, new Item(Material.DIAMOND_AXE, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("pickaxe")) {
										
										pinv.setItem(slot, new Item(Material.DIAMOND_PICKAXE, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("apple")) {
										
										pinv.setItem(slot, new Item(Material.APPLE, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("chestplate")) {
										
										pinv.setItem(slot, new Item(Material.DIAMOND_CHESTPLATE, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("sign")) {
										
										pinv.setItem(slot, new Item(Material.SIGN, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("block")) {
										
										pinv.setItem(slot, new Item(Material.BEDROCK,1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("string")) {
										
										pinv.setItem(slot, new Item(Material.STRING, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}else if(item.equalsIgnoreCase("stairs")) {
										
										pinv.setItem(slot, new Item(Material.WOOD_STAIRS, 1).setDisplayname(name).build());
										
										savePremiumInv(pinv);
										
									}
									
									try {
										pconfig.save(pfile);
									} catch (IOException e) {
										e.printStackTrace();
									}
									
									player.sendMessage("Spawn " + args[1] + " gesetzt");
									
								}else {
									
									player.sendMessage("Zu großer Slot bereich!");
									
								}
								
							}
							
						}
						
					}
					
				}
		
			}	
			
		}
		
		return false;
	
	}
	
	private static void saveInv(Inventory inv) {
		
		HashMap<String, Object> itemslots = new HashMap<>();
		
		ArrayList<ItemStack> list = new ArrayList<>();
		
		ItemStack[] contents = inv.getContents();
		
		for(int i = 0; i < contents.length; i++) {
			
			ItemStack item = contents[i];
			if(!(item ==  null)) {
				
				if(item.getType() != Material.AIR && item.getType() != Material.STAINED_GLASS_PANE) {
					
					itemslots.put("Slots." + i, item);
					
				}
				
			}
			
		}
		
		iconfig.set("LobbyInv", itemslots);

		try {
			iconfig.save(ifile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void savePremiumInv(Inventory pinv) {
		
		HashMap<String, Object> itemslots = new HashMap<>();
		
		ArrayList<ItemStack> list = new ArrayList<>();
		
		ItemStack[] contents = pinv.getContents();
		
		for(int i = 0; i < contents.length; i++) {
			
			ItemStack item = contents[i];
			if(!(item ==  null)) {
				
				if(item.getType() != Material.AIR && item.getType() != Material.STAINED_GLASS_PANE) {
					
					itemslots.put("Slots." + i, item);
					
				}
				
			}
			
		}
		
		piconfig.set("PremiumInv", itemslots);

		try {
			piconfig.save(pifile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void loadInv(Player player) {

		File ifile = new File("plugins//LobbySystem//Items.yml");
		YamlConfiguration iconfig = YamlConfiguration.loadConfiguration(ifile);
		
		for(String st : iconfig.getConfigurationSection("LobbyInv.Slots").getKeys(false)) {
			
			int slot = Integer.parseInt(st);
			
			ItemStack it = iconfig.getSerializable("LobbyInv.Slots." + st, ItemStack.class);
			
			if(slot >= 0 && slot <= 53) {
				
				if(inv.getItem(slot) == null) {
					
					for(int n = 0; n < 54; n++) {
					
						ItemStack in = new ItemStack(Material.STAINED_GLASS_PANE);
						ItemMeta meta = in.getItemMeta();
						meta.setDisplayName(" ");
						in.setItemMeta(meta);
						
						inv.setItem(n, in);
					
					}
					
				}else
					
					inv.setItem(slot, it);
			
			}

		}
		
		player.openInventory(inv);
		
	}
	
	public static void loadPremiumInv(Player player) {

		File ifile = new File("plugins//LobbySystem//PremiumItems.yml");
		YamlConfiguration iconfig = YamlConfiguration.loadConfiguration(ifile);
		
		for(String st : iconfig.getConfigurationSection("PremiumInv.Slots").getKeys(false)) {
			
			int slot = Integer.parseInt(st);
			
			ItemStack it = iconfig.getSerializable("PremiumInv.Slots." + st, ItemStack.class);
			
			if(slot >= 0 && slot <= 53) {
				
				if(pinv.getItem(slot) == null) {
					
					for(int n = 0; n < 54; n++) {
					
						ItemStack in = new ItemStack(Material.STAINED_GLASS_PANE);
						ItemMeta meta = in.getItemMeta();
						meta.setDisplayName(" ");
						in.setItemMeta(meta);
						
						pinv.setItem(n, in);
					
					}
					
				}else
					
					pinv.setItem(slot, it);
			
			}

		}
		
		player.openInventory(pinv);
		
	}
	
}
