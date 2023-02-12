package com.tests;

import com.annotations.FrameworkAnnotations;
import com.page.LoginPage;
import com.utils.RandomUtils;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @FrameworkAnnotations(author = {"Rejeo"}, category = {"UI","Positive Test"})
    @Test(priority = 1)
    public void newLoginUserTest() {
        String userName = RandomUtils.generateRandomString( 7);
        String fullName = "Work Fusion";
        String password = "Admin123";
        LoginPage loginPage = new LoginPage();
        String status = loginPage.enterUserName(userName)
                .enterFullName(fullName)
                .enterPassWord(password)
                .clickLogin()
                .getLoginStatus();
        String userAdded = loginPage.getListOfStatus().stream().reduce((first, second) -> second).get();
        Assertions.assertThat(status).isEqualTo("Status: user "+userName+" was created");
        Assertions.assertThat(userAdded).isEqualTo("Name: "+fullName+" login: "+userName+" password "+password+"");
    }

    @FrameworkAnnotations(author = {"Rejeo"}, category = {"UI","Negative Test"})
    @Test(priority = 2)
    public void newLoginUserFailedTest() {
        String status = new LoginPage().enterUserName("")
                .enterFullName("")
                .enterPassWord("")
                .clickLogin()
                .getLoginStatus();
        Assertions.assertThat(status).isEqualTo("Status: Login cannot be empty");
    }

}
