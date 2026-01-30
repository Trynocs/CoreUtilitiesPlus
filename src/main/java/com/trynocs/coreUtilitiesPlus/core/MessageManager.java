package com.trynocs.coreUtilitiesPlus.core;

import com.trynocs.coreUtilitiesPlus.CoreUtilitiesPlus;
import com.trynocs.coreUtilitiesPlus.utils.Message;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nullable;
import java.io.File;
import java.util.Map;

public class MessageManager {

    private JavaPlugin plugin;
    private ConfigManager configManager;
    private FileConfiguration messages;

    public MessageManager(JavaPlugin plugin, ConfigManager configManager) {
        this.configManager = configManager;
        this.plugin = plugin;
        loadMessages();
    }

    public void sendMessage(Player player, Message message, Map<String, String> placeholders) {
        String msg = ChatColor.translateAlternateColorCodes('&',
                (getPrefix() + getStringFromMessage(message)));

        for (Map.Entry<String, String> entry : placeholders.entrySet()) {
            msg = msg.replace(
                    "{" + entry.getKey() + "}",
                    entry.getValue()
            );
        }
        player.sendMessage(msg);
    }

    public void loadMessages() {
        String configName = "messages_" + configManager.getLanguage().toLowerCase() + ".yml";
        File file = new File(plugin.getDataFolder(), configName);
        if (!file.exists()) plugin.saveResource(configName, false);
        this.messages = YamlConfiguration.loadConfiguration(file);
    }

    public String getStringFromMessage(Message message) {
        return messages.getString(message.getPath(), "Message not found for path: " + message.getPath());
    }

    public String getPrefix() {
        return messages.getString("prefix", "") + " ";
    }
}
