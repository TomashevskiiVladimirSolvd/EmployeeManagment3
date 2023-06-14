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
    //if the poolsize property is not found or not specified in the
    // config.properties file, the default value to be used is 1.
    //The specific default value to use depends on the requirements
    // and logic of  application.

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
        try (InputStream is = Config.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME)) {
            if (is != null) {
                config.load(is);
            } else {
                throw new RuntimeException("Unable to find config.properties file");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error loading config properties", e);
        }
        return config;
    }
}
