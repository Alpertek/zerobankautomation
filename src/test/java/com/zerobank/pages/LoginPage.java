package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(id = "user_login")
    public WebElement usernameInput;
    @FindBy(id = "user_password")
    public WebElement passwordInput;
    @FindBy(css = "input[name=submit]")
    public WebElement signInBtn;
    @FindBy(css = "div.alert-error")
    public WebElement errorMessage;

    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInBtn.click();
    }
}
