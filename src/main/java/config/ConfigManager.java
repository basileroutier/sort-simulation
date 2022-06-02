/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The ConfigManager class is a singleton that loads a properties file and
 * provides a method to get a
 * property value
 */
public class ConfigManager {

    private static final String FILE = "./sort/config.properties";
    private final Properties prop;
    private final String url;

    private ConfigManager() {
        prop = new Properties();
        url = getClass().getClassLoader().getResource(FILE).getFile();
    }

    /**
     * The function load() is used to load the properties file
     */
    public void load() throws IOException {
        try (InputStream input = new FileInputStream(url)) {
            prop.load(input);
        } catch (IOException ex) {
            throw new IOException("Chargement configuration impossible " + ex.getMessage());
        }
    }

    /**
     * This function takes a string as an argument and returns the value of the
     * property with the same
     * name as the string
     * 
     * @param name The name of the property to get.
     * @return The value of the property.
     */
    public String getProperties(String name) {
        return prop.getProperty(name);
    }

    public static ConfigManager getInstance() {
        return ConfigManagerHolder.INSTANCE;
    }

    private static class ConfigManagerHolder {

        private static final ConfigManager INSTANCE = new ConfigManager();
    }
}
