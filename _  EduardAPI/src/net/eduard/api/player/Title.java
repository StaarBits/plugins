package net.eduard.api.player;

import org.bukkit.entity.Player;

import net.eduard.api.config.Save;
import net.eduard.api.config.Section;
import net.eduard.api.manager.RexAPI;

public class Title implements Save {

	private int fadeIn;

	private int stay;

	private int fadeOut;

	private String title;
	private String subTitle;

	public String getTitle() {
		return title;
	}

	public Title setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public Title setSubTitle(String subTitle) {
		this.subTitle = subTitle;
		return this;
	}

	public Title() {
	}

	public Title(int fadeIn, int stay, int fadeOut, String title, String subTitle) {
		super();
		this.fadeIn = fadeIn;
		this.stay = stay;
		this.fadeOut = fadeOut;
		this.title = title;
		this.subTitle = subTitle;
	}

	public Title create(Player player) {
		RexAPI.sendTitle(player, title, subTitle, fadeIn, stay, fadeOut);
		return this;
	}

	public int getFadeIn() {

		return fadeIn;
	}

	public int getFadeOut() {

		return fadeOut;
	}

	public int getStay() {

		return stay;
	}

	public Title setFadeIn(int fadeIn) {

		this.fadeIn = fadeIn;
		return this;
	}

	public Title setFadeOut(int fadeOut) {

		this.fadeOut = fadeOut;
		return this;
	}

	public Title setStay(int stay) {

		this.stay = stay;
		return this;
	}

	public void save(Section section, Object value) {

	}

	public Object get(Section section) {
		return null;
	}

}
