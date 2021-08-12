package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityNavigationSteps {

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String accountType) {
       new AccountSummaryPage().clickOnAccountType(accountType);
        BrowserUtils.waitForPageToLoad(3);
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String accountType) {
        Select accountDropdown = new Select(new AccountActivityPage().dropdown);
        Assert.assertEquals(accountType,accountDropdown.getFirstSelectedOption().getText());
    }


}
