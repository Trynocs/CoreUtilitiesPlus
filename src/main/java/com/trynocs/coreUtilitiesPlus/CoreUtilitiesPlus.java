package com.trynocs.coreUtilitiesPlus;

import com.trynocs.coreUtilitiesPlus.core.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class CoreUtilitiesPlus extends JavaPlugin {

    private ConfigManager configManager;

    @Override
    public void onEnable() {
        this.configManager = new ConfigManager(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}
