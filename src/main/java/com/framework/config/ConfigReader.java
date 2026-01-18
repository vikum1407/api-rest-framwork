package com.framework.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            properties = new Properties();
            InputStream input = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config/qa.properties");

        }catch (Exception e){
            throw new RuntimeException("Failed to load config file");
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
