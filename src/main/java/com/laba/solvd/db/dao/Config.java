package com.laba.solvd.db.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum Config {
    URL("url"),
    DRIVER("driver"),
    USERNAME("username"),
    PASSWORD("password"),
    POOL_SIZE("poolsize", String.valueOf(1));

    private static final String CONFIG_FILE_NAME = "config.properties";
    private static final Properties PROPERTIES;

    static {
        PROPERTIES = loadProperties();
    }

    private final String key;
    private String defaultValue;

    Config(String key, String defaultValue) {
        this(key);
        this.defaultValue = defaultValue;
    }

    Config(String key) {
        this.key = key;
    }

    public String getValue() {
        return PROPERTIES.getProperty(key, defaultValue);
    }

    private static Properties loadProperties() {
        Properties config = new Properties();
        try {
            InputStream is = Config.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
        } catch (Exception e) {
            throw new RuntimeException("Unable to prepare config properties", e);
        }
        return config;
    }
}
