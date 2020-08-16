package com.weborders.step_definitions;

import com.weborders.pages.ViewAllOrdersPage;
import com.weborders.utilities.BrowserUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ViewAllOrdersStepDefinitions {
    ViewAllOrdersPage viewAllOrders=new ViewAllOrdersPage();
    @Given("user is logged in")
    public void user_is_logged_in() {
        viewAllOrders.login();
    }

    @Given("user clicks on {string} tab")
    public void user_clicks_on_tab(String string) {
       viewAllOrders.clickTab();
    }

    @Then("verify title of page is List of All Orders")
    public void verify_title_of_page_is_List_of_All_Orders() {
        Assert.assertTrue(viewAllOrders.getTitle().contains("List of All Orders"));
    }

    @When("user clicks on {string} button")
    public void user_clicks_on_button(String buttonName) {
       viewAllOrders.clickButton(buttonName);
       BrowserUtilities.wait(3);
    }

    @Then("verify all orders are selected")
    public void verifyAllOrdersAreSelected() {
        int c=0;
        for (WebElement checkbox : viewAllOrders.getCheckboxes()) {
            if(checkbox.isSelected()) c++;
        }
        Assert.assertEquals(viewAllOrders.getCheckboxes().size(),c);

    }



    @Then("verify all orders are unselected")
    public void verifyAllOrdersUnselected() {
        for (WebElement checkbox : viewAllOrders.getCheckboxes()) {
            Assert.assertFalse(checkbox.isSelected());
        }
    }


    @When("user selects only orders from {string}")
    public void user_selects_only_orders_from(String string) {
        for (int i = 0; i < viewAllOrders.getState().size(); i++) {
           if(viewAllOrders.getState().get(i).getText().equals("US")){
               viewAllOrders.getCheckboxes().get(i).click();


           }
        }
    }

    @Then("verify there is {int} orders")
    public void verify_there_is_orders(int orderNum) {
        int c=0;
        for (WebElement checkbox : viewAllOrders.getCheckboxes()) {
            if(checkbox.isSelected())
                c++;
        }
        Assert.assertEquals(orderNum,c);
    }

    @Then("verify their names below")
    public void verify_their_names_below(List<String> list) {
        for (int i = 0,n=0; i < viewAllOrders.getCheckboxes().size(); i++) {
            if(viewAllOrders.getCheckboxes().get(i).isSelected()){
                Assert.assertEquals(list.get(n),viewAllOrders.getNames().get(i).getText());
                n++;
            }

        }
    }



}
