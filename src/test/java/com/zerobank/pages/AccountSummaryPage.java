package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class AccountSummaryPage extends BasePage{

    @FindBy(css = "h2.board-header")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "//th[.='Credit Card']/../th")
    public List<WebElement> creditCardColumns;

    @FindBy(xpath = "(//td/a[.='Savings'])[1]")
    public WebElement savings;
    @FindBy(xpath = "//td/a[.='Brokerage']")
    public WebElement brokerage;
    @FindBy(xpath = "//td/a[.='Checking']")
    public WebElement checking;
    @FindBy(xpath = "//td/a[.='Credit Card']")
    public WebElement creditCard;
    @FindBy(xpath = "//td/a[.='Loan']")
    public WebElement loan;

    public void clickOnAccountType(String accountType){
        switch (accountType){
            case "Savings":
                savings.click();
                break;
            case "Brokerage":
                brokerage.click();
                break;case "Checking":
                checking.click();
                break;case "Credit Card":
                creditCard.click();
                break;case "Loan":
                loan.click();
                break;
        }
    };

}
