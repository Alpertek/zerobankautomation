package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.DashboardPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

import java.util.List;

public class AccountActivitySteps {
    @When("user clicks on {string} menu tab")
    public void user_clicks_on_menu_tab(String menuTitle) {

        new DashboardPage().navigateToModule(menuTitle);
        BrowserUtils.waitForPageToLoad(2);
    }


    @Then("Savings should be default option in the Account dropdown")
    public void savingsShouldBeDefaultOptionInTheAccountDropdown() {
        Select select = new Select(new AccountActivityPage().dropdown);
        Assert.assertEquals("Savings",select.getFirstSelectedOption().getText());
    }

    @Then("user should be able to see following options under Account dropdown")
    public void user_should_be_able_to_see_following_options_under_Account_dropdown(List<String> expectedOptions) {
        Select select = new Select(new AccountActivityPage().dropdown);
        Assert.assertEquals(expectedOptions,BrowserUtils.getElementsText(select.getOptions()));

    }

    @Then("user should be able to see following column names in Transactions table")
    public void userShouldBeAbleToSeeFollowingColumnNamesInTransactionsTable(List<String> expectedHeaders) {
        Assert.assertEquals(expectedHeaders,BrowserUtils.getElementsText(new AccountActivityPage().transactionTableHeaders));

    }
}
