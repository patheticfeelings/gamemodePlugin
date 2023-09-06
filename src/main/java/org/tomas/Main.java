package org.tomas;

import org.bukkit.plugin.java.JavaPlugin;
import org.tomas.commands.gamemodeCommand;


public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("[GmPlugin] Inicializado com sucesso! ");
        this.getCommand("gm").setExecutor(new gamemodeCommand());
    }

    @Override
    public void onDisable() {
        System.out.println("[GmPlugin] Encerrado com sucesso! ");
    }
}
