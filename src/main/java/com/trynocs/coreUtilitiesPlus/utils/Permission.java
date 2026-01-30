package com.trynocs.coreUtilitiesPlus.utils;

public enum Permission {

    CORE_RELOAD("core.reload"),
    CORE_ADMIN("core.admin"),
    CORE_DEBUG("core.debug");

    private final String node;

    Permission(String node) {
        this.node = node;
    }

    public String getNode() {
        return node;
    }
}
