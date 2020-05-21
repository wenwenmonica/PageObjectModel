package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfficialHomePage extends TestBase {
    // Page Factory - OR:
    @FindBy(xpath = "//span[contains(text(), 'free')]")
    // @CacheLookup
    WebElement freeLogo;

    @FindBy(xpath = "//font[contains(text(), 'crm')]")
    WebElement crmLogo;

    @FindBy(xpath = "//span[contains(text(), 'Log In')]")
    WebElement logInBtn;

    @FindBy(xpath = "//a[contains(text(), 'Sign Up')]")
    WebElement signUpBtn;

    // Initialize Page Objects;
    public OfficialHomePage() {
        PageFactory.initElements(driver, this); // this means to initialize all the variables above, point to current class's object
    }

    //Actions:
    public String validateOfficialHomePageTitle() {
        return driver.getTitle();
    }

    public boolean validateImage() {
        return freeLogo.isDisplayed() && crmLogo.isDisplayed();
    }

    public LoginPage clickLogin() {
        logInBtn.click();
        return new LoginPage();
    }
}
