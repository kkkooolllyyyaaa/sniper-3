package com.tsypk.sniper3.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author tsypk on 14.11.2021 23:02
 * @project sniper-3
 */
public class PropertyFactory {
    public static String getProperty(String propertiesName, String property) {
        String propertyValue = "";
        Properties properties = new Properties();
        try (InputStream inputStream = PropertyFactory.class.getResourceAsStream(propertiesName)) {
            properties.load(inputStream);
            propertyValue = properties.getProperty(property);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return propertyValue;
    }
}
