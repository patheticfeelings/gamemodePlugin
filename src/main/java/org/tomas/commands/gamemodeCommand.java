package org.tomas.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Este comando apenas pode ser executado por jogadores!");
            return false;
        }

        Player player = (Player) sender;

        if (!command.getName().equalsIgnoreCase("gm")) return false;

        if (args.length == 0) {
            player.sendMessage("Você precisa inserir o gamemode que deseja entrar!");
            return false;
        }

        String argumentos = args[0].toLowerCase();

        if (argumentos.equals("0") || argumentos.equals("1")) {
            GameMode gamemode = argumentos.equals("1") ? GameMode.CREATIVE : GameMode.SURVIVAL;

            if (player.getGameMode() != gamemode) {
                player.setGameMode(gamemode);
                player.sendMessage("[SUCESSO] Você entrou no " + gamemode.toString().toLowerCase());
            } else {
                player.sendMessage("[ERRO] Você já está no " + gamemode.toString().toLowerCase());
            }
        } else {
            return false;
        }
        return true;
    }
}
