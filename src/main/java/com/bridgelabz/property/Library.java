package com.bridgelabz.property;

import com.bridgelabz.driver.Browser;

import java.io.FileInputStream;
import java.util.Properties;

public class Library extends Browser
{

    public static String getProperty(String CONFIG_PATH, String key)
    {
        String property = "";
        Properties prop = new Properties();

        try
        {
            prop.load(new FileInputStream(CONFIG_PATH));
            property = prop.getProperty(key);
        }
        catch(Exception e)
        {e.printStackTrace();}

        return property;
    }
}
