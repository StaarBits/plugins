package net.eduard.api.kits;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.API;
import net.eduard.api.gui.Kit;
import net.eduard.api.player.SoundEffect;

public class Vitality extends Kit {
	public ItemStack soup = API.newItem(Material.BROWN_MUSHROOM, "�6Sopa");
	
	public Vitality() {
		setIcon(Material.MUSHROOM_SOUP, "�fAo eliminar um Inimigo vai ganhar sopas");
		setSound(SoundEffect.create(Sound.LEVEL_UP));
	}

	@EventHandler
	public void event(EntityDeathEvent e) {
		if (e.getEntity().getKiller() instanceof Player) {
			Player p = e.getEntity().getKiller();
			if (p == null) {
				return;
			}
			API.fill(p.getInventory(), soup);
			if (hasKit(p)) {
				makeSound(p);
			}
			p.sendMessage(getMessage());
		}
	}
}
