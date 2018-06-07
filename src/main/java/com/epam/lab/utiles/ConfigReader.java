package com.epam.lab.utiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public Properties readConfig(String filePath) {
        Properties properties = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            properties = new Properties();
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
