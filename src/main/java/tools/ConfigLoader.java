package tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static final Logger logger = LogManager.getLogger();

    public String getProperty(String name) {
        String result = "";
        FileInputStream fis;
        Properties property = new Properties();
        String propertyFile = "src/test/resources/TestTask.properties";

        try {
            fis = new FileInputStream(propertyFile);
            property.load(fis);

            result = property.getProperty(name);


        } catch (IOException e) {
            logger.debug(e);
        }
        return result;
    }

}