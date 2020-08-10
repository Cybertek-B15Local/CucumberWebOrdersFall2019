package com.weborders.step_definitions;

import com.weborders.pages.ViewAllOrdersPage;
import com.weborders.utilities.BrowserUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

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
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify there is {int} orders")
    public void verify_there_is_orders(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify their names below")
    public void verify_their_names_below(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }



}
