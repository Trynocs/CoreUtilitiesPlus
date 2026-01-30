package com.trynocs.coreUtilitiesPlus.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PermissionHelper {

    public boolean has(Player player, Permission permission) {
        return has(player, permission, false);
    }

    public boolean has(Player player, Permission permission, boolean debug) {
        boolean result = player.hasPermission(permission.getNode());

        if (debug) {
            Bukkit.getLogger().info(
                    "[PermDebug] " + player.getName() +
                            " -> " + permission.getNode() +
                            " = " + result
            );
        }

        return result;
    }

}
