package com.weborders.step_definitions;
import com.weborders.pages.OrderPage;
import com.weborders.pages.ViewAllOrdersPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.SynchronousQueue;

public class OrderStepDefinitions {
    OrderPage orderPage=new OrderPage();
    ViewAllOrdersPage viewAllOrders=new ViewAllOrdersPage();

    @Given("user clicks on \\{order} button")
    public void user_clicks_on_button() {
        viewAllOrders.login();
        orderPage.order.click();

    }

    @When("user choose {string} from drop down")
    public void user_choose_from_drop_down(String string) {
        Select select=new Select(orderPage.productOptions);
        List<WebElement> options=select.getOptions();
        for (WebElement option:options) {
            String text = option.getText();
            if(text.equalsIgnoreCase("mymoney")){
                select.selectByVisibleText("MyMoney");
                System.out.println(text+ " is selected");
            }
        }
              {

        }
    }

    @When("user type a quantity")
    public void user_type_a_quantity() {


        orderPage.quantity.click();
       // orderPage.quantity.clear();
        orderPage.quantity.sendKeys("80");

    }

    @When("user type a price")
    public void user_type_a_price() {
        orderPage.price.sendKeys("500");

    }

    @Then("user hit on {string} button")
    public void user_hit_on_button(String string) {

        orderPage.calculate.click();
    }


    @When("user sent {string}, {string}, {string}, {string}")
    public void userSent(String name, String street, String city, String zipcode) {

        orderPage.name.sendKeys(name);
        orderPage.street.sendKeys(street);
        orderPage.city.sendKeys(city);
        orderPage.zipcode.sendKeys(zipcode);

    }

    @When("user select a card from chexboxes")
    public void user_select_a_card_from_chexboxes() {
        List<WebElement> cardList = orderPage.cardList;
        int size = orderPage.cardList.size();
        System.out.println(size);



        for (WebElement card : cardList) {
            String text = card.getText();

            if (text.equals("MasterCard")) {
                card.click();
            }

        }
    }
    @When("type cardNumber")
    public void type_cardNumber() {
orderPage.cardNumber.sendKeys("1234567");
    }

    @When("type expire date")
    public void type_expire_date() {
        orderPage.expireDate.sendKeys("10/20");
    }

    @Then("click {string} button")
    public void click_button(String string) {
        orderPage.process.click();
    }

    @Then("user should be able to see that new order created")
    public void user_should_be_able_to_see_that_new_order_created() {
       String message= orderPage.message.getText();
       System.out.println(message);
       String actualMeesage="New order has been successfully added.";
       Assert.assertEquals(message,actualMeesage);







    }



}
