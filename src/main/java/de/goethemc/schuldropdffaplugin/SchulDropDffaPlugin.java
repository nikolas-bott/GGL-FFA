package de.goethemc.schuldropdffaplugin;

import de.goethemc.schuldropdffaplugin.commands.ArenaCommand;
import de.goethemc.schuldropdffaplugin.listeners.*;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class SchulDropDffaPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(ChatColor.GREEN + "funzt");

        getConfig().options().copyDefaults(true);
        saveConfig();

        this.getCommand("arena").setExecutor(new ArenaCommand(this));

        getServer().getPluginManager().registerEvents(new MenuListener(this), this);
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new DisableMiningOnSpawnListener(this), this);
        getServer().getPluginManager().registerEvents(new DisablePvpOnSpawnListener(this), this);
        getServer().getPluginManager().registerEvents(new DisableFallDamageListener(this),this);
        getServer().getPluginManager().registerEvents(new BlockPlace(this),this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
