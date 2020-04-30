package com.weborders.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OrderPage extends BasePage {

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    private WebElement product;

    @FindBy(name = "ctl00$MainContent$fmwOrder$txtQuantity")
    private WebElement quantityInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtUnitPrice")
    private WebElement pricePerUnitInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtDiscount")
    private WebElement discountInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtTotal")
    private WebElement totalInput;

    @FindBy(css = "input[type='submit']")
    private WebElement calculateButton;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    private WebElement customerNameInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    private WebElement streetInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    private WebElement cityInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    private WebElement stateInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    private WebElement zipCodeInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    private WebElement visaCheckboxCheckbox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
    private WebElement masterCardCheckbox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_2")
    private WebElement amexCardCheckbox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    private WebElement cardNumberInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    private WebElement expireDateInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    private WebElement processButton;

    @FindBy(css = "input[type='reset']")
    private WebElement resetButton;

    public void setProductType(String productToSelect) {
        Select select = new Select(product);
        select.selectByVisibleText(productToSelect);
        System.out.println("Select product :: " + productToSelect);
    }

    public void enterQuantity(String quantity) {
        quantityInput.sendKeys(quantity);
        System.out.println("Enter quantity :: " + quantity);
    }

    public void enterPricePerUnit(String price) {
        pricePerUnitInput.sendKeys(price);
        System.out.println("Enter price per unit :: " + price);
    }

    public void enterDiscount(String discount) {
        discountInput.sendKeys(discount);
        System.out.println("Enter discount :: " + discount);
    }

    public void clickToCalculate() {
        calculateButton.click();
    }

    public void enterAddressInformation(String name, String street, String city, String state, String zip) {
        customerNameInput.sendKeys(name);
        streetInput.sendKeys(street);
        cityInput.sendKeys(city);
        stateInput.sendKeys(state);
        zipCodeInput.sendKeys(zip);
        System.out.println("::: Enter address information ::: ");
        System.out.println("Enter customer name :: " + name);
        System.out.println("Enter street :: " + street);
        System.out.println("Enter city :: " + city);
        System.out.println("Enter state :: " + state);
        System.out.println("Enter zip :: " + zip);
    }

    public void enterPaymentInformation(String card, String cardNumber, String expirationDate) {
        if (card.equalsIgnoreCase("visa")) {
            visaCheckboxCheckbox.click();
            System.out.println("Select visa");
        } else if (card.equalsIgnoreCase("master card")) {
            masterCardCheckbox.click();
            System.out.println("Select master card");
        } else {
            amexCardCheckbox.click();
            System.out.println("Select amex");
        }
        cardNumberInput.sendKeys(cardNumber);
        expireDateInput.sendKeys(expirationDate);
        System.out.println("Enter card number :: " + cardNumber);
        System.out.println("Enter expiration date :: " + expirationDate);
    }

    public void clickOnProcessButton() {
        processButton.click();
        System.out.println("Click on process button");
    }

    public String getTotal() {
        return totalInput.getAttribute("value");
    }

}
