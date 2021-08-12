package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.time.Instant;
import java.util.Date;

public class PayBillsSteps {

    @When("user enters an amount {string}")
    public void user_enters_an_amount(String amount) {

        new PayBillsPage().amount.sendKeys(amount);

    }
    @And("user selects a date")
    public void userSelectsADate() {

        new PayBillsPage().selectDay("12");
    }
    @When("user clicks on Pay button")
    public void user_clicks_on_Pay_button() {
        new PayBillsPage().payBtn.click();
    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals(expectedMessage,new PayBillsPage().successfulPayMessage.getText());
    }

    @And("user does not enter amount and enters a date")
    public void userDoesNotEnterAmountAndEntersADate() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.selectDay("15");
        payBillsPage.payBtn.click();
    }
    @Then("user should get {string} message under {string}")
    public void userShouldGetMessageUnder(String expectedMessage, String inputName) {
        String actualMessage = "";
        if(inputName.equals("amount")){
            actualMessage = new PayBillsPage().amount.getAttribute("validationMessage");
        }else{
            actualMessage = new PayBillsPage().date.getAttribute("validationMessage");
        }
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @And("user does not enter date and enters an amount")
    public void userDoesNotEnterDateAndEntersAnAmount() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.amount.sendKeys("1500");
        payBillsPage.payBtn.click();
    }

    @And("user enters a non-number value in the amount input")
    public void userEntersANonNumberValueInTheAmountInput() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.amount.sendKeys("abc(1((");
        payBillsPage.selectDay("12");
        payBillsPage.payBtn.click();
    }



    @And("user enters an invalid value in the date input")
    public void userEntersAnInvalidValueInTheDateInput() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.date.sendKeys("ab-/+pl0");

    }

    @Then("{string} message should not be displayed")
    public void messageShouldNotBeDisplayed(String unexpectedMessage) {
        PayBillsPage payBillsPage = new PayBillsPage();
        Assert.assertFalse(payBillsPage.successfulPayMessage.isDisplayed());
    }


}
