package com.com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {
    private Properties properties;

    public ConfigReader(){
        properties = new Properties();
    }

    public void loadProperties() throws IOException{
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
        properties.load(fileInputStream);
        fileInputStream.close();
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
