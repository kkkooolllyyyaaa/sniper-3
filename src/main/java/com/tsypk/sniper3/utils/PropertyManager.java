package com.tsypk.sniper3.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author tsypk on 16.11.2021 20:26
 * @project sniper-3
 */
public class PropertyManager {
    public static String getProperty(String propertyName) {
        try {
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/app.properties");
            properties.load(fis);
            return properties.getProperty(propertyName);
        } catch (IOException unexpected) {
            return null;
        }
    }
}
