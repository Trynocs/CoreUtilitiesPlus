package com.trynocs.coreUtilitiesPlus.core;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {

    private final JavaPlugin plugin;
    private FileConfiguration config;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    public void loadConfig() {
        plugin.saveDefaultConfig();
        this.config = plugin.getConfig();
    }

    public String getPrefix() {
        return config.getString("prefix", "[Core]");
    }

    public int getCooldown() {
        return config.getInt("cooldown", 10);
    }

    public void setPrefix(String prefix) {
        config.set("prefix", prefix);
        plugin.saveConfig();
    }

    public void setCooldown(int cooldown) {
        config.set("cooldown", cooldown);
        plugin.saveConfig();
    }

    public void reloadConfig() {
        plugin.reloadConfig();
        this.config = plugin.getConfig();
    }


}
