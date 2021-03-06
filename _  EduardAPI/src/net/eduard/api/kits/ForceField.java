package net.eduard.api.kits;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

import net.eduard.api.click.Click;
import net.eduard.api.click.ClickEffect;
import net.eduard.api.gui.Kit;
import net.eduard.api.manager.EventAPI;


public class ForceField extends Kit{
	
	public void run() {
		for (Player player : force){
			field(player);
		}
		
	}
	public double damage = 3;
	public double range = 5;
	public int effectSeconds  = 5;
	
	public void field(Player player){
		for (Entity entity: player.getNearbyEntities(range, range, range)){
			if (entity instanceof LivingEntity){
				LivingEntity livingEntity = (LivingEntity) entity;
				livingEntity.damage(damage, player);
			}
		}
	}
	public void force(Player player){
	
		for (LivingEntity entity: 	player.getWorld().getLivingEntities()){
			if (entity.getLocation().distance(player.getLocation())<range){
				entity.damage(damage, player);
			}
		}
	}
	public static ArrayList<Player> force = new ArrayList<>();
	public ForceField() {
		setIcon(Material.NETHER_FENCE, "�fAtive Force Field nos Inimigos");
		add(Material.NETHER_FENCE);
		setMessage("�6Force field desativado!");
		setTime(30);
		setClick(new Click(Material.NETHER_FENCE, new ClickEffect() {
			
			@Override
			public void effect(PlayerInteractEvent e) {
				Player p = e.getPlayer();
				if (hasKit(p)){
					if (cooldown(p)){
						force.add(p);
						delay(effectSeconds*20, new Runnable() {
							
							@Override
							public void run() {
								force.remove(p);
								sendMessage(p);
							}
						});
					}
				}
			}
			
			@Override
			public void effect(PlayerInteractEntityEvent e) {
				// TODO Auto-generated method stub
				
			}
		}));
	}
	public EventAPI register(Plugin plugin) {
		setPlugin(plugin);
		timer(1,this);
		return super.register(plugin);
	}

}
