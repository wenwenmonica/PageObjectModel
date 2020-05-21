package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.nio.channels.SelectableChannel;

public class ContactsPage extends TestBase {
    // @FindBy(xpath = "//div[@class='ui header item mb5 light-black']/div[1]")
    @FindBy(xpath ="//div[@class='ui header item mb5 light-black']/div[1]/following::text()[contains(.,'Contacts').text]")
    WebElement contactsLabel;

    @FindBy(xpath = "//button[@class='ui linkedin button']/i[@class='edit icon']")
    WebElement newContactLink;

    @FindBy(xpath = "//button[@class='ui linkedin button']/i[@class='save icon']")
    WebElement saveBtn;

    @FindBy(name = "first_name")
    WebElement firstName;

    @FindBy(name = "last_name")
    WebElement lastName;

    @FindBy(xpath = "//input[@class='search' and @type='text']")
    WebElement company;




    // Initializing the Page Objects
    public ContactsPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyContactsLabel() {
        return contactsLabel.isDisplayed();
    }

    public void selectContactsByName(String name) {
        driver.findElement((By.xpath("//td[text()='"+name+"']"))).click();
    }

    public void clickOnNewContactLink() {
//        Actions action = new Actions(driver);
//        action.moveToElement(contactsLink).build().perform();
        newContactLink.click();
    }

    public void createNewContact(String ftName, String ltName, String comp) {
        //Dropdown list
//        Select select = new Select(driver.findElement(By.name("title")));
//        select.selectByVisibleText("");
        firstName.sendKeys(ftName);
        lastName.sendKeys(ltName);
        company.sendKeys(comp);
        saveBtn.click();
    }
}
