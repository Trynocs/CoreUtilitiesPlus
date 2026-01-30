package com.trynocs.coreUtilitiesPlus.core;

import com.trynocs.coreUtilitiesPlus.utils.Message;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private final JavaPlugin plugin;
    private FileConfiguration config;
    private FileConfiguration messages;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    public void loadConfig() {
        plugin.saveDefaultConfig();
        this.config = plugin.getConfig();
    }

    public String getLanguage() {
        return config.getString("language", "en");
    }

    public int getCooldown() {
        return config.getInt("cooldown", 10);
    }

    public void setCooldown(int cooldown) {
        config.set("cooldown", cooldown);
        plugin.saveConfig();
    }


    public void reload() {
        plugin.reloadConfig();
        this.config = plugin.getConfig();
    }


}
