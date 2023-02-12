package com.tests;

import com.driver.Driver;
import com.enums.ConfigProperties;
import com.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected BaseTest() {
    }

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
    }

    @BeforeMethod
    public void setUp()  {
        Driver.initDriver(PropertyUtils.get(ConfigProperties.BROWSER));
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

    @AfterSuite
    public void afterSuite() {
    }
}
