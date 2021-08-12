package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FindTransactionsPage extends AccountActivityPage{

    @FindBy(id = "aa_fromDate")
    public WebElement startDate;
    @FindBy(id = "aa_toDate")
    public WebElement endDate;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[1]")
    public List<WebElement> resultDates;



    @FindBy(xpath = "//button[text()='Find']")
    public WebElement findBtn;

    public boolean areInRange(List<WebElement> resultElements,String startDate,String endDate){
        LocalDate start_date = LocalDate.parse(startDate);
        LocalDate end_date = LocalDate.parse(endDate);
        List<Boolean> checkedDates = new ArrayList<>();
        for (WebElement resultDate:resultDates) {
            LocalDate result_date = LocalDate.parse(resultDate.getText());

            boolean fromStart = result_date.isEqual(start_date) || result_date.isAfter(start_date);
            boolean fromEnd = result_date.isBefore(end_date) || result_date.isEqual(end_date);
            checkedDates.add(fromStart && fromEnd);
        }
        return !checkedDates.contains(false);
    }
}
