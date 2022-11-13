package com.workenlive.utils;

import com.workenlive.constant.Constant;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    public ConfigReader() {
        try {
            InputStream fis = this.getClass().getClassLoader().getResourceAsStream(Constant.configFile);
            properties.load(fis);
        } catch(Exception e)
        {
            System.out.println("Exception is" + e.getMessage());
        }
    }


    public String getApplicationURL() {
        return properties.getProperty("baseURL");
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getDBUrl() {
        return properties.getProperty("dbUrl");
    }

    public String getDBUsername() {
        return properties.getProperty("dbUsername");
    }

    public String getDBPassword() {
        return properties.getProperty("dbPassword");
    }

    public String getChromepath()
    {
        String chromepath = properties.getProperty("chromepath");
        return chromepath;
    }

    public String getBrowserName() {
        return properties.getProperty("browser");
    }
}
