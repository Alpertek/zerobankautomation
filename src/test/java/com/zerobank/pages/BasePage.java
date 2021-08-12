package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "ul.nav.nav-tabs>li")
    public List<WebElement> modules;

    public WebElement getModuleElement(String moduleTitle){
        for (WebElement module : modules) {
            if (moduleTitle.equalsIgnoreCase(module.getText().trim())) {
                BrowserUtils.waitForStaleElement(module);
                return module;
            }

        }
        return null;
    }
    public void navigateToModule(String moduleTitle) {
        for (WebElement module : modules) {
            BrowserUtils.waitForStaleElement(module);
            if (moduleTitle.equalsIgnoreCase(module.getText().trim())) {
                module.click();
                break;
            }
        }
    }

    public void openSubModule(String module,String subModule){
        navigateToModule(module);
        BrowserUtils.waitForClickability(By.xpath("//div[@id='tabs']/ul/li[.='"+subModule+"']"),3);
        WebElement subModuleElement = Driver.get().findElement(By.xpath("//div[@id='tabs']/ul/li[.='"+subModule+"']"));
        subModuleElement.click();

    }
}
