package com.weborders.step_definitions;

import com.weborders.pages.OrderPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class OrderStepDefinitions {

    OrderPage orderPage = new OrderPage();

    // | Card | Card Nr:    | Expire date (mm/yy) |
    @When("user enters payment information:")
    public void user_enters_payment_information(List<Map<String, String>> dataTable) {
        Map<String, String> paymentInfo = dataTable.get(0);
        orderPage.enterPaymentInformation(paymentInfo.get("Card"),
                paymentInfo.get("Card Nr:"),
                paymentInfo.get("Expire date (mm/yy)"));
    }

    @When("user click on process button")
    public void user_click_on_process_button() {
        orderPage.clickOnProcessButton();
    }

    //| Customer name | Street  | City     | State    | Zip   |
    @When("user enters address information:")
    public void user_enters_address_information(List<Map<String, String>> dataTable) {
        Map<String, String> values = dataTable.get(0);
        orderPage.enterAddressInformation(values.get("Customer name"),
                values.get("Street"),
                values.get("City"),
                values.get("State"),
                values.get("Zip"));

    }

    //      | Product     | Quantity | Price per unit | Discount |
    @When("user enters product information:")
    public void user_enters_product_information(List<Map<String, String>> dataTable) {
        Map<String, String> values = dataTable.get(0);
        orderPage.setProductType(values.get("Product"));
        orderPage.enterQuantity(values.get("Quantity"));
        orderPage.enterPricePerUnit(values.get("Price per unit"));
        orderPage.enterDiscount(values.get(""));
    }

    @When("user click on calculate button")
    public void user_click_on_calculate_button() {
        orderPage.clickToCalculate();
    }

    @Then("user should verify that total {int} is displayed")
    public void user_should_verify_that_total_is_displayed(Integer int1) {
        Assert.assertEquals(String.valueOf(int1), orderPage.getTotal());
    }


}
