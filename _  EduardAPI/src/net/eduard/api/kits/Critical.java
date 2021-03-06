package net.eduard.api.kits;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import net.eduard.api.API;
import net.eduard.api.gui.Kit;
import net.eduard.api.player.Effects;

public class Critical extends Kit {
	public double chance = 0.3;
	public double damage = 4;
	public String critMessage = "�6Voce levou um critico";
	@SuppressWarnings("deprecation")
	public Effects effect = new Effects(Effect.STEP_SOUND, Material.REDSTONE_BLOCK.getId());

	public Critical() {
		setIcon(Material.GOLDEN_APPLE, "�fCause criticos em seus inimigos");
		setMessage("�6Voce causou critico");
	}

	@EventHandler
	public void event(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			if (hasKit(p)) {
				if (API.getChance(chance)) {
					e.setDamage(e.getDamage() + damage);
					effect.create(p, 10);
					p.sendMessage(getMessage());
					if (e.getEntity() instanceof Player) {
						Player player = (Player) e.getEntity();
						player.sendMessage(critMessage);
					}
					// p.getWorld().playEffect(p.getLocation(),
					// Effect.STEP_SOUND, Material.REDSTONE_BLOCK, 10);
				}
			}
		}
	}

}
