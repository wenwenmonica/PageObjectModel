package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    // Page Factory - OR:
    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//div[contains(text(), 'Login')]")
    WebElement logInBtn;

    // Initialize the page Objects:
    public LoginPage() {
        PageFactory.initElements(driver, this); // this means to initialize all the variables above, point to current class's object
    }

    //Actions:
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public UserHomePage login(String eml, String pw) {
        email.sendKeys(eml);
        password.sendKeys(pw);
        logInBtn.click();
        return new UserHomePage();
    }




}
