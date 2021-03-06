
package net.eduard.api.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.api.API;
import net.eduard.api.manager.Commands;

public class UnMuteCommand extends Commands {

	public String messageTarget = "�6O jogador �e$player �6foi desmutado por �a$sender";
	public String message = "�aVoce foi desmutado!";
public UnMuteCommand() {
	super("unmute");
	setPermission("eduardapi.command.unmute");
}
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (args.length == 0) {
			return false;
		}

		if (API.existsPlayer(sender, args[0])) {
			Player target = API.getPlayer(args[0]);
			target.removeMetadata("muted", getPlugin());
			API.broadcast(
					messageTarget.replace("$player", target.getDisplayName())
							.replace("$sender", sender.getName()));
			API.chat(target,message);

		}
		return true;
	}
}
