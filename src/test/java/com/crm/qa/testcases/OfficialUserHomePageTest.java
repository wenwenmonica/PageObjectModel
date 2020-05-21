package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.OfficialHomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OfficialUserHomePageTest extends TestBase {
    OfficialHomePage officialHomePage;

    public OfficialUserHomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        officialHomePage = new OfficialHomePage();
    }

    @Test(priority = 1)
    public void officialHomePageTestTitleTest() {
        String title = officialHomePage.validateOfficialHomePageTitle();
        Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
    }

    @Test(priority = 2)
    public void logoImageTest() {
        boolean flag = officialHomePage.validateImage();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void clickLogin() {
        LoginPage loginPage = officialHomePage.clickLogin();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
