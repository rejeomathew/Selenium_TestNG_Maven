package com.driver;

import com.enums.ConfigProperties;
import com.factories.DriverFactory;
import com.utils.PropertyUtils;

import java.net.MalformedURLException;
import java.util.Objects;

public final class Driver {

    private Driver(){

    }

    public static void initDriver(String browser) {
        if(Objects.isNull(DriverManager.getDriver())) { // Checking driver == null
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser));
            } catch (MalformedURLException e) {
                throw new RuntimeException("Please check the capabilities of browser");
            }
            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        }
    }

    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())) { // Checking driver != null
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
