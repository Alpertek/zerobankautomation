package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends BasePage{
    @FindBy(id = "sp_amount")
    public WebElement amount;
    @FindBy(id = "sp_date")
    public WebElement date;
    @FindBy(id = "pay_saved_payees")
    public WebElement payBtn;
    @FindBy(css = "#alert_content>span")
    public WebElement successfulPayMessage;

    public void selectDay(String day){
        date.click();
        Driver.get().findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='"+day+"']/..")).click();
    }
}
