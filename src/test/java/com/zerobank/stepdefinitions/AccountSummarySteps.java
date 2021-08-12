package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.Ha;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class AccountSummarySteps {
    @Then("page title should be {string}")
    public void page_title_should_be(String title) {
        Assert.assertEquals(title, Driver.get().getTitle());

    }

    @When("user is on {string} page")
    public void user_is_on_page(String pageSubtitle) {
        String partialUrl = pageSubtitle.toLowerCase().replace(" ", "-");
        new WebDriverWait(Driver.get(), 5).until(ExpectedConditions.urlContains(partialUrl));
        BrowserUtils.waitForVisibility(new AccountSummaryPage().getModuleElement(pageSubtitle), 5);

    }

    @Then("Account summary page should have the following account types")
    public void account_summary_page_should_have_the_following_account_types(List<String> expectedAccountTypes) {
        List<String> actualAccountTypes = BrowserUtils.getElementsText(new AccountSummaryPage().accountTypes);
        Assert.assertEquals(expectedAccountTypes, actualAccountTypes);
    }

    @Then("Credit Accounts table should have the columns of")
    public void credit_accounts_table_should_have_the_columns_of(List<String> expectedColumns) {
        List<String> actualColumns = BrowserUtils.getElementsText(new AccountSummaryPage().creditCardColumns);
        Assert.assertEquals(expectedColumns, actualColumns);
    }


}
