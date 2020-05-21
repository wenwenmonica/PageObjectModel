package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.OfficialHomePage;
import com.crm.qa.pages.UserHomePage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {
    OfficialHomePage officialHomePage;
    LoginPage loginPage;
    UserHomePage userHomePage;
    ContactsPage contactsPage;
    String sheetName="Sheet1";

    public ContactsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        officialHomePage = new OfficialHomePage();
        loginPage = officialHomePage.clickLogin();
        userHomePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        contactsPage = userHomePage.clickOnContactsLink();
    }

    @Test(priority = 1)
    public void verifyContactsLabel() {
        Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label is missing on the page");
    }

    @Test(priority = 2)
    public void selectContactsTest() {
        contactsPage.selectContactsByName("test test test");
    }

    @Test(priority = 3)
    public void selectMultipleContactsTest() {
        contactsPage.selectContactsByName("momo momo");
        contactsPage.selectContactsByName("test test test");
    }

    @DataProvider
    public Object[][] getCRMTestData() {
        Object[][] data = TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 4, dataProvider = "getCRMTestData")
    public void validateCreateNewContactTest(String firstName, String lastName, String company) {
        contactsPage.clickOnNewContactLink();
        contactsPage.createNewContact(firstName, lastName, company);
    }

    @Test
    public void openCreateNewContactsPageTest() {
        contactsPage.clickOnNewContactLink();
    }

//    @Test
//    public void validateCreateNewContactTest() {
//        openCreateNewContactsPageTest();
//        contactsPage.createNewContact("Monica", "Y", "ABC");
//    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
