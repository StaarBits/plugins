package net.eduard.api.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.API;
import net.eduard.api.click.Click;
import net.eduard.api.config.Section;
import net.eduard.api.player.Cooldown;

public class Kit extends Cooldown {

	private String name;
	private double price;
	private ItemStack icon;
	private boolean activeCooldownOnPvP;
	private int times = 1;
	private transient Click click;
	private transient Map<Player, Integer> timesUsed = new HashMap<>();
	private transient List<String> kits = new ArrayList<>();
	private transient List<Player> players = new ArrayList<>();

	public Kit() {
		this("");

	}
	public Kit(String name) {
		if (name.isEmpty()) {
			setName(getClass().getSimpleName());

		} else
			setName(name);
		setPermission(name.toLowerCase());
	}

	public ItemStack add(ItemStack item) {
		getItems().add(API.setName(item, "�b" + name));
		return item;
	}

	public Kit add(KitType subKit) {
		kits.add(subKit.name());
		return this;
	}

	public ItemStack add(Material material) {
		return add(material, 0);
	}

	public ItemStack add(Material material, int data) {
		return add(new ItemStack(material, 1, (short) data));
	}

	public Kit add(Player player) {
		players.add(player);
		return this;
	}

	public Kit add(String kit) {
		kits.add(kit);
		return this;
	}

	@Override
	public boolean cooldown(Player player) {
		if (onCooldown(player)) {
			sendOnCooldown(player);
			return false;
		}
		int x = 0;
		if (timesUsed.containsKey(player)) {
			x = timesUsed.get(player);
		}
		x++;
		if (x == times) {
			setOnCooldown(player);
			sendStartCooldown(player);
			timesUsed.remove(player);
		} else {
			timesUsed.put(player, x);
		}
		return true;
	}

	@EventHandler
	public void event(EntityDamageByEntityEvent e) {
		if (activeCooldownOnPvP) {
			if (e.getEntity() instanceof Player) {
				Player p = (Player) e.getEntity();
				if (hasKit(p)) {
					setOnCooldown(p);
				}
			}
		}
	}

	@Override
	public Object get(Section section) {
		return null;
	}

	public ItemStack getIcon() {
		return icon;
	}


	public List<String> getKits() {
		return kits;
	}

	public String getName() {
		return name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public double getPrice() {
		return price;
	}

	public int getTimes() {
		return times;
	}

	public boolean hasKit(Player player) {
		return players.contains(player);
	}

	public boolean isActiveCooldownOnPvP() {
		return activeCooldownOnPvP;
	}

	@Override
	public void save(Section section, Object value) {
	}

	public Kit setActiveCooldownOnPvP(boolean activeCooldownOnPvP) {
		this.activeCooldownOnPvP = activeCooldownOnPvP;
		return this;
	}

	public Kit setIcon(ItemStack icon) {
		this.icon = icon;
		return this;
	}

	public Kit setIcon(Material material, int data, String... lore) {
		icon = new ItemStack(material);
		API.setName(icon, "�6Kit " + name);
		API.setLore(icon, lore);
		API.add(icon, Enchantment.DURABILITY, 10);
		return this;
	}

	public Kit setIcon(Material material, String... lore) {
		return setIcon(material, 0, lore);
	}

	public Kit setName(String name) {
		this.name = name;
		return this;
	}

	public Kit setPlayers(ArrayList<Player> players) {
		this.players = players;
		return this;
	}

	public Kit setPrice(double price) {
		this.price = price;
		return this;
	}
	public Kit setTimes(int times) {
		this.times = times;
		return this;
	}
	public Click getClick() {
		return click;
	}
	public void setClick(Click click) {
		this.click = click;
	}
}
