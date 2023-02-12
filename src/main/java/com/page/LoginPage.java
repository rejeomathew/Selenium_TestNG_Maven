package com.page;

import com.enums.WaitStrategy;
import org.openqa.selenium.By;

import java.util.List;

public final class LoginPage extends BasePage{


    private final By textBoxUsername = By.id("username");

    private final By textBoxFullName = By.id("name");
    private final By textBoxPassword = By.id("password");
    private final By buttonLogin = By.id("submit");
    private final By statusText = By.id("status");
    private final By listOfUsersAdded = By.id("users");



    public LoginPage enterUserName(String userName) {

        sendKeys(textBoxUsername, userName, WaitStrategy.PRESENCE,"Username");
        return this;
    }

    public LoginPage enterFullName(String fullName) {

        sendKeys(textBoxFullName, fullName, WaitStrategy.PRESENCE,"Username");
        return this;
    }

    public LoginPage enterPassWord(String password) {
        sendKeys(textBoxPassword, password, WaitStrategy.PRESENCE,"Password");
        return this;
    }

    public LoginPage clickLogin() {
        click(buttonLogin, WaitStrategy.PRESENCE, "Login Button");
        return this;
    }

    public String getLoginStatus() {
       return getText(statusText, WaitStrategy.PRESENCE);
    }

    public List<String> getListOfStatus() {
        return getListOfTexts(listOfUsersAdded, WaitStrategy.PRESENCE);
    }
    public String getTitle() {
        return getPageTitle();
    }


}