package com.weborders.pages;

import com.weborders.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "ctl00_MainContent_username")
    private WebElement userName;

    @FindBy(id = "ctl00_MainContent_password")
    private WebElement password;

    public void login() {
        String usernameValue = ConfigurationReader.getProperty("username");
        String passwordValue = ConfigurationReader.getProperty("password");
        userName.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    public void login(String usernameValue, String passwordValue) {
        userName.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

}
