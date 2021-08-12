package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(id = "aa_accountId")
    public WebElement dropdown;
    @FindBy(css = "#all_transactions_for_account>table>thead>tr>th")
    public List<WebElement> transactionTableHeaders;














    public static void main(String[] args) {
        Driver.get().get("http://zero.webappsecurity.com/login.html");
        new LoginPage().login("username","password");
        new WebDriverWait(Driver.get(),3).until(ExpectedConditions.titleContains("Privacy"));
        Driver.get().findElement(By.cssSelector("button#details-button")).click();
        Driver.get().findElement(By.cssSelector("a#proceed-link")).click();
        BrowserUtils.waitForPageToLoad(3);
        new AccountSummaryPage().openSubModule("Account Activity","Find Transactions");
        BrowserUtils.waitFor(2);
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        String startingDate = "2012-09-01";
        String endingDate ="2012-09-06";
        findTransactionsPage.startDate.sendKeys(startingDate);
        findTransactionsPage.endDate.sendKeys(endingDate);
        findTransactionsPage.findBtn.click();
        Assert.assertTrue(findTransactionsPage.areInRange(findTransactionsPage.resultDates,startingDate,endingDate));


    }
}
