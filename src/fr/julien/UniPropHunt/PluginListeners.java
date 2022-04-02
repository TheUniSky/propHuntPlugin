package fr.julien.UniPropHunt;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import net.md_5.bungee.api.ChatColor;

public class PluginListeners implements Listener{

	Main main;
	public PluginListeners(Main main) {
		this.main =main;
	}
	
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onMenu (InventoryClickEvent e ) {
		if (e.getCurrentItem()==null) {
			return;
		}
		 if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§8Prop Hunt")) {
			Inventory inv = Bukkit.createInventory(e.getWhoClicked(), 9, ChatColor.AQUA+"Prop hunt");
			ItemStack free = new ItemStack(Material.POPPY,1);
			ItemMeta i2 = free.getItemMeta();
			i2.setDisplayName("§6propHunt sandBox");
			i2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			i2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			
			free.setItemMeta(i2);
			inv.setItem(3, free);
			ItemStack party = new ItemStack(Material.NETHER_STAR,1);
			 i2 = party.getItemMeta();
			 i2.addEnchant(Enchantment.DIG_SPEED, 1, true);
			i2.setDisplayName("§7Prop Hunt Party");
			i2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			i2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			
			party.setItemMeta(i2);
			inv.setItem(4, party);
		
			e.getWhoClicked().openInventory(inv);
			
		}
		 if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6propHunt sandBox")) {
			Inventory inv = Bukkit.createInventory((InventoryHolder) e.getWhoClicked(), 54,ChatColor.DARK_BLUE+"Prop Hunt SandBox");
			
			int x = 0;
			while (x != 6) {
				if (main.getConfig().getString("PropHuntSandBoxWorld.PropHunt" + (x + 1) + ".WorldName") == "") {

				} else {
					if (Bukkit
							.getWorld(
									main.getConfig().getString("PropHuntSandBoxWorld.PropHunt" + (x + 1) + ".WorldName"))
							.getPlayers().size() > main.getConfig()
									.getInt("PropHuntSandBoxWorld.PropHunt" + (x + 1) + ".MaxPlayerOnWorld")) {
						ItemStack i = new ItemStack(Material.RED_CONCRETE, 1);
						
						ItemMeta i2 = i.getItemMeta();
						i2.setLore(Arrays.asList(""
								+ Bukkit.getWorld(main.getConfig()
										.getString("PropHuntSandBoxWorld.PropHunt" + (x + 1) + ".WorldName"))
										.getPlayers().size()
								+ " / " + main.getConfig()
										.getInt("PropHuntSandBoxWorld.PropHunt" + (x + 1) + ".MaxPlayerOnWorld")));
						i2.setDisplayName("§8propHunt numéro "+(x+1));
						i.setItemMeta(i2);
						inv.setItem(19 + x, i);
						;
					} else {
						ItemStack i = new ItemStack(Material.GREEN_CONCRETE, 1);
						ItemMeta i2 = i.getItemMeta();
						i2.setLore(Arrays.asList(""
								+ Bukkit.getWorld(main.getConfig()
										.getString("PropHuntSandBoxWorld.PropHunt" + (x + 1) + ".WorldName"))
										.getPlayers().size()
								+ " / "
								+ main.getConfig().getInt("PropHuntSandBoxWorld.PropHunt" + (x +1)+ ".MaxPlayerOnWorld")));
						i2.setDisplayName("§8propHunt  numéro "+(x+1));
						i.setItemMeta(i2);
						inv.setItem(19 + x, i);
						;
					}

				}

				x++;
			}
			((Player) e.getWhoClicked()).openInventory(inv);
			}
		 
		 if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§8propHunt numéro ")) {
			 Player p = (Player) e.getWhoClicked();
			 ItemStack i = e.getCurrentItem();
			 String[] numbrs = i.getItemMeta().getDisplayName().split("o ");
				int numberPVPBox = Integer.parseInt(numbrs[1]);
				double x = main.getConfig()
						.getDouble("PropHuntSandBoxWorld.PropHunt" + (numberPVPBox) + ".PvPBoxSpawnLocation.x");
				double y = main.getConfig()
						.getDouble("PropHuntSandBoxWorld.PropHunt" + (numberPVPBox) + ".PvPBoxSpawnLocation.y");
				double z =main.getConfig()
						.getDouble("PropHuntSandBoxWorld.PropHunt" + (numberPVPBox) + ".PvPBoxSpawnLocation.z");

				Location l = new Location(
						Bukkit.getWorld(
								main.getConfig().getString("PropHuntSandBoxWorld.PropHunt" + (numberPVPBox) + ".WorldName")),
						x, y, z);
				p.teleport(l);
				
				if (main.getConfig().getBoolean("PropHuntSandBoxWorld.PropHunt" + (numberPVPBox) +".PVPBoxMessageIsTitle")) {
					p.sendTitle(main.getConfig().getString("PropHuntSandBoxWorld.PropHunt" + (numberPVPBox)+".PVPBoxEnterMessage").replace("&", "§"), "");
					
				}
				p.setGameMode(GameMode.SURVIVAL
						);
				p.setHealth(20);
				p.sendMessage(main.getConfig().getString("PropHuntSandBoxWorld.PropHunt" + (numberPVPBox)+".PVPBoxEnterMessage").replace("&", "§"));
				p.getInventory().clear();
				ItemStack pop = new ItemStack(Material.POPPY,1);
				pop.getItemMeta().setDisplayName("§5JOUER");
				pop.getItemMeta().addItemFlags(ItemFlag.HIDE_ENCHANTS);
				pop.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
				p.getInventory().addItem(pop);
			
			 
		 }
		 
		 if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§5JOUER")) {
			 Inventory inv = Bukkit.createInventory(e.getWhoClicked(), 9,"EQUIPE");
			 Player p = (Player)e.getWhoClicked();
			 p.openInventory(inv);
			 ItemStack  Sword = new ItemStack(Material.IRON_SWORD);
			 Sword.getItemMeta().setDisplayName("Hunter");
			 ItemStack pop = new ItemStack(Material.POPPY,1);
				pop.getItemMeta().setDisplayName("Props");
				pop.getItemMeta().addItemFlags(ItemFlag.HIDE_ENCHANTS);
				pop.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
			 
			 
		 }
		 
		 //ajouter le choix prop ou hunt avec un if get display et penser a ajouter dans le UserList
	}

	
}
