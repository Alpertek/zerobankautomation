package com.zerobank.stepdefinitions;

import com.github.javafaker.Faker;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LoginSteps {
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        new LoginPage().login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
        new WebDriverWait(Driver.get(),10).until(ExpectedConditions.titleContains("Privacy"));
        Driver.get().findElement(By.cssSelector("button#details-button")).click();
        Driver.get().findElement(By.cssSelector("a#proceed-link")).click();

    }

    @Then("{string} page should be displayed")
    public void page_should_be_displayed(String pageTitle) {
        // Write code here that turns the phrase above into concrete actions
        //new WebDriverWait(Driver.get(),5).until(ExpectedConditions.titleContains(pageTitle));
        BrowserUtils.waitForPageToLoad(3000);
        Assert.assertTrue(Driver.get().getTitle().endsWith(pageTitle));

    }

    @When("user enters an invalid username and a valid password")
    public void userEntersAnInvalidUsernameAndAValidPassword() {
        Faker jf = new Faker();
        String randomUsername = jf.name().username();
        String password = ConfigurationReader.get("password");
        new LoginPage().login(randomUsername,password);
    }

    @Then("login should fail and error message {string} should be displayed")
    public void loginShouldFailAndErrorMessageShouldBeDisplayed(String errorMessage) {
        BrowserUtils.waitForPageToLoad(3);
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage,loginPage.errorMessage.getText());
    }
    @When("user enters {string} {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        new LoginPage().login(username,password);
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        new LoginPage().login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
        new WebDriverWait(Driver.get(),10).until(ExpectedConditions.titleContains("Privacy"));
        Driver.get().findElement(By.cssSelector("button#details-button")).click();
        Driver.get().findElement(By.cssSelector("a#proceed-link")).click();
        BrowserUtils.waitForPageToLoad(3);
        Assert.assertTrue(Driver.get().getTitle().endsWith("Account Summary"));
    }
}
