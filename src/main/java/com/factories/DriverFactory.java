package com.factories;

import java.net.MalformedURLException;
import java.net.URL;

import com.enums.ConfigProperties;
import com.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public final class DriverFactory {

    private DriverFactory() {}
    public static WebDriver getDriver(String browser) throws MalformedURLException {

        WebDriver driver=null;
        String runmode = PropertyUtils.get(ConfigProperties.RUNMODE);
        if(browser.equalsIgnoreCase("chrome")) {
            if(runmode.equalsIgnoreCase("remote")) {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName(BrowserType.CHROME);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--headless");
                options.addArguments("--disable-dev-shm-usage");
                options.merge(desiredCapabilities);
                driver =new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), options);
            }
            else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }
        else if(browser.equalsIgnoreCase("firefox")) {

            if(runmode.equalsIgnoreCase("remote")) {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName(BrowserType.FIREFOX);
                driver =new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), desiredCapabilities);
            } else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }

}