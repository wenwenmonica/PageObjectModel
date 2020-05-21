package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.OfficialHomePage;
import com.crm.qa.pages.UserHomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserHomePageTest extends TestBase {
    OfficialHomePage officialUserHomePage;
    LoginPage loginPage;
    UserHomePage userHomePage;
    ContactsPage contactPages;

    public UserHomePageTest() {
        super();
    }

    // test cases should be separated - independent with each other
    // before each test case - launch the browser and login
    // @test - execute test case
    // after each test case - delete cookie and close the browse
    @BeforeMethod
    public void setUp() {
        initialization();
        officialUserHomePage = new OfficialHomePage();
        loginPage = officialUserHomePage.clickLogin();
        userHomePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyUserHomePageTitleTest() {
        String userHomePageTitle =  userHomePage.verifyHomePageTitle();
        // Print the error message in the third parameter when the test is failed
        Assert.assertEquals(userHomePageTitle, "Cogmento CRM", "User Home page title not matched");
    }

    @Test(priority = 2)
    public void verifyCorrectUserNameTest() {
        Assert.assertTrue(userHomePage.verifyCorrectUserName());
    }

    @Test(priority = 3)
    public void verifyContactsLinkTest() {
        contactPages = userHomePage.clickOnContactsLink();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
