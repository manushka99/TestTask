package com.test.tools;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@ComponentScan(value = "com.test.*")
@PropertySource("classpath:values.properties")
public class ConfigLoader {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Value("${value.url}")
    public static String url;

    @Value("${value.user.name}")
    public static String name;

    @Value("${value.user.password}")
    public static String password;




//    public String getUrl() {
//        return getProperty("URL");
//    }
//
//    public String getUserName() {
//        return getProperty("USER_NAME");
//    }
//
//    public String getUserPasswd() {
//        return getProperty("USER_PASSWORD");
//    }
//
//    private String getProperty(String name) {
//        String result = "";
//        FileInputStream fis;
//        Properties property = new Properties();
//        String propertyFile = "src//resources//values.properties";
//
//        try {
//            fis = new FileInputStream(propertyFile);
//            property.load(fis);
//            result = property.getProperty(name);
//
//        } catch (IOException e) {
//           log.debug("getProperty", e);
//        }
//        return result;

//    }
}
