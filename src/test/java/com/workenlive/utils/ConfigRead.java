package com.workenlive.utils;

import com.workenlive.constant.Constant;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

public class ConfigRead {
    private static final Properties properties = new Properties();

    public ConfigRead() {
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

    public String getUsername()
    {
        String username = properties.getProperty("username");
        return username;
    }

    public String getPassword()
    {
        String password = properties.getProperty("password");
        return password;
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
