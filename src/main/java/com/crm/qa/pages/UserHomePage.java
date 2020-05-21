package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage extends TestBase {

    @FindBy(xpath = "//span[contains(text(), 'Monica n/a')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//span[contains(text(), 'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath = "//span[contains(text(), 'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath = "//span[contains(text(), 'Tasks')]")
    WebElement tasksLink;

    public UserHomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public boolean verifyCorrectUserName() {
        return userNameLabel.isDisplayed();
    }

    public ContactsPage clickOnContactsLink() {
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealsLink() {
        dealsLink.click();
        return new DealsPage();
    }

    public TasksPage clickOnTasksLink() {
        tasksLink.click();
        return new TasksPage();
    }
}
