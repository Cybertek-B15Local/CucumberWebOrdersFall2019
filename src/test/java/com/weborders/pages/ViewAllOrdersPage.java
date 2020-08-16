package com.weborders.pages;

import com.weborders.utilities.BrowserUtilities;
import com.weborders.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ViewAllOrdersPage extends BasePage {
    @FindBy(id = "ctl00_MainContent_username")
    private WebElement userName;

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    private WebElement checkAll;

    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    private WebElement uncheckAll;

    @FindBy(id = "ctl00_MainContent_password")
    private WebElement password;

    @FindBy(xpath = "//ul[@id='ctl00_menu']//li//a[text()='View all orders']")
    private WebElement tab;

    @FindBy(xpath = "//h2")
    private WebElement title;

    @FindBy(xpath = "//td//input[@type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//tr//td[8]")
    private List<WebElement> state;

    @FindBy(xpath = "//tr//td//input[@type='checkbox']/../following-sibling::td[1]")
    private List<WebElement> names;

    public List<WebElement> getNames(){

        return names;
    }

    public List<WebElement> getState(){
        return state;
    }


    public List<WebElement> getCheckboxes(){

        return checkboxes;
    }

    public String getTitle(){
        return title.getText();
    }

    //btnCheckAll
    //btnUncheckAll
    public void clickButton(String name) {

        driver.findElement(By.id("ctl00_MainContent_btn" + name)).click();
    }

    public void clickTab() {
        tab.click();
    }

    public void login() {
        driver.get(ConfigurationReader.getProperty("url"));
        String usernameValue = ConfigurationReader.getProperty("username");
        String passwordValue = ConfigurationReader.getProperty("password");
        userName.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }
}
