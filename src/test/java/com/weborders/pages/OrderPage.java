package com.weborders.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class OrderPage extends BasePage {

    @FindBy(xpath="//a[contains(text(),'Order')]")
    public WebElement order;

    @FindBy(css="select[id='ctl00_MainContent_fmwOrder_ddlProduct']")
    public WebElement productOptions;

    @FindBy(xpath="//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")
    public WebElement quantity;

    @FindBy(xpath="//input[@id='ctl00_MainContent_fmwOrder_txtUnitPrice']")
    public WebElement price;

    @FindBy(xpath = "//ol//input[@class='btn_dark']")
    public WebElement calculate;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_txtName']")
    public WebElement name;

    @FindBy(name= "ctl00$MainContent$fmwOrder$TextBox2")
    public WebElement street;

    @FindBy(css="#ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement city;

    @FindBy(xpath="//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")
    public WebElement zipcode;

    @FindBy(xpath="//*[@id=\"ctl00_MainContent_fmwOrder_cardList\"]/tbody/tr/td")
    public List<WebElement> cardList;

    @FindBy(xpath="//body//td//td[2]")
    public WebElement masterCard;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")
    public WebElement cardNumber;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")
    public WebElement expireDate;

    @FindBy(xpath = " //a[@id='ctl00_MainContent_fmwOrder_InsertButton']")
    public WebElement process;

    @FindBy(xpath="//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td")
    public List<WebElement> newOrder;

    //*[@id="ctl00_MainContent_fmwOrder"]/tbody/tr/td/div/strong
    @FindBy(xpath="//strong[contains(text(),'New order has been successfully added.')]")
    public WebElement message;





}
