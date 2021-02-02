package com.mystore.utilities;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static volatile ConfigurationReader configurationReader;

    private ConfigurationReader() {
    }

    public static synchronized ConfigurationReader getInstance() {
        if (configurationReader == null) {
            configurationReader = new ConfigurationReader();
        }
        return configurationReader;
    }

    public String getProperty(String key) {
        Properties properties = new Properties();
        String filePath = "src/main/resources/configuration.properties";
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            properties.load(bufferedInputStream);
            inputStream.close();
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}
