
package net.eduard.teleportbow.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.eduard.teleportbow.Main;

public class TeleportBowReloadCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label,
		String[] args) {
		Main.reload();
		sender.sendMessage("�aAs configura��es do TeleportBow foram recarregadas!");
		return true;
	}

}
