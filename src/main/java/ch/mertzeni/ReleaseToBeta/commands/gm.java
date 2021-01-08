package ch.mertzeni.ReleaseToBeta.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gm implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Player p = (Player) sender;
        p.getGameMode().toString();
        if (p.isOp()) {
            if (p.getGameMode() == GameMode.SURVIVAL) {
                p.setGameMode(GameMode.CREATIVE);
            } else {
                p.setGameMode(GameMode.SURVIVAL);
            }
        }

        return false;
    }

}
