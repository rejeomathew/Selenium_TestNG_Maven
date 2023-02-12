package com.page;

import com.driver.DriverManager;
import com.enums.WaitStrategy;
import com.factories.ExplicitWaitFactory;
import com.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy,String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        element.click();
        try {
            ExtentLogger.pass(elementName + " is clicked", true);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    protected void sendKeys(By by, String value, WaitStrategy waitStrategy,String elementName) {
        WebElement element =ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        element.sendKeys(value);
        try {
            ExtentLogger.pass(elementName + " is typed", true);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    protected String getText(By by, WaitStrategy waitStrategy){
        WebElement element =ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        return element.getText();
    }

    protected List<String> getListOfTexts(By by, WaitStrategy waitStrategy){
        List<String> listOfTexts = new ArrayList<>();
        ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        List<WebElement> webElements = DriverManager.getDriver().findElements(by);
        for(WebElement webElement: webElements){
            listOfTexts.add(webElement.getText());
        }
        return listOfTexts;
    }

}