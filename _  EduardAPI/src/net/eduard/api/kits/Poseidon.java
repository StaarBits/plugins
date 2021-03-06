package net.eduard.api.kits;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

import net.eduard.api.gui.Kit;
import net.eduard.api.player.Potions;

public class Poseidon extends Kit {

	public Poseidon() {
		setIcon(Material.WATER_BUCKET, "�fFique mais forte na agua");
		getPotions().add(new Potions(PotionEffectType.SPEED, 1, 20 * 5));
		getPotions().add(new Potions(PotionEffectType.INCREASE_DAMAGE, 0, 20 * 5));
	}

	@EventHandler
	public void event(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (hasKit(p)) {
			Material type = e.getTo().getBlock().getRelative(BlockFace.DOWN).getType();
			if (type == Material.WATER | type == Material.STATIONARY_WATER) {
				givePotions(p);
			}
		}
	}

}
