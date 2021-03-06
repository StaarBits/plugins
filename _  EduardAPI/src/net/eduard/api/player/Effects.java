package net.eduard.api.player;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import net.eduard.api.config.Save;
import net.eduard.api.config.Section;

public class Effects implements Save {

	private int data;

	private Effect type;

	public Effects() {
	}

	public Effects(Effect type) {
		this(type, 0);
	}

	public Effects(Effect type, int data) {
		this.data = data;
		this.type = type;
	}

	
	public int getData() {

		return data;
	}

	
	public Effect getType() {

		return type;
	}


	public Effects setData(int data) {

		this.data = data;
		return this;
	}

	public Effects setType(Effect type) {

		this.type = type;
		return this;
	}

	public Effects create(Entity entity, int radius) {
		create(entity.getLocation(), radius);
		return this;
	}

	public Effects create(Location loc) {
		return create(loc, 0);
	}

	
	public Effects create(Location loc, int radius) {
		loc.getWorld().playEffect(loc, type, data, radius);
		return this;
	}

	

	@SuppressWarnings("deprecation")
	public Effects create(Player p) {

		p.playEffect(p.getLocation(), type, data);
		return this;
	}

	public void save(Section section, Object value) {
	}

	public Object get(Section section) {
		return null;
	}

	public String toString() {
		return "Effects [data=" + data + ", type=" + type + "]";
	}
	public static Effects newEffects(String toString) {
		String[] split = toString.substring(toString.indexOf("["),toString.lastIndexOf("]")).split(", ");
		int data = Integer.valueOf(split[0].split("=")[1]);
		Effect effect = Effect.valueOf(split[1].split("=")[1]);
		return new Effects(effect, data);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Effects other = (Effects) obj;
		if (data != other.data)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
