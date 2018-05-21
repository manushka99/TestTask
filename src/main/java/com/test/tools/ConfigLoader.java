package com.test.tools;

import com.test.service.TestTaskServiceImpl;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    final static Logger logger = Logger.getLogger(ConfigLoader.class);

    public String getUrl() {
        return getProperty("URL");
    }

    public String getUserName() {
        return getProperty("USER_NAME");
    }

    public String getUserPasswd() {
        return getProperty("USER_PASSWORD");
    }

    private String getProperty(String name) {
        String result = "";
        FileInputStream fis;
        Properties property = new Properties();
        String propertyFile = "src//resources//TestTask.properties";

        try {
            fis = new FileInputStream(propertyFile);
            property.load(fis);
            result = property.getProperty(name);

        } catch (IOException e) {
            logger.info(e);
        }
        return result;

    }




}
