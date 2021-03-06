package net.eduard.api.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.API;
import net.eduard.api.gui.Kit;

public class Archer extends Kit {
	public Archer() {
		setIcon(Material.BOW, "�fGanhe uma flecha ao voc� acertar ao player a flecha ser� teleportado at� seu inventario.");
		add(API.add(new ItemStack(Material.BOW), Enchantment.ARROW_DAMAGE, 1));
		add(new ItemStack(Material.ARROW, 10));

	}
	@EventHandler
	public void event(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Arrow) {
			Arrow arrow = (Arrow) e.getDamager();
			if (arrow.getShooter() instanceof Player) {
				Player p = (Player) arrow.getShooter();
				if (hasKit(p)) {
					p.getInventory().addItem(new ItemStack(Material.ARROW));
				}

			}

		}
	}

}
