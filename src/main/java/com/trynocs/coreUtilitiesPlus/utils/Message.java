package com.trynocs.coreUtilitiesPlus.utils;

public enum Message {

    NO_PERMISSION("no-permission"),
    RELOAD_SUCCESS("reload-success"),
    COOLDOWN_ACTIVE("cooldown-active");


    private final String path;

    Message(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
