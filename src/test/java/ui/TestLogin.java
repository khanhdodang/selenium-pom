package ui;

import Data.Data;
import Objects.Account;
import Objects.Product;
import Pages.BasePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Utils.Constants;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class TestLogin {

    protected WebDriver driver;
    BasePage basePage;
    LoginPage loginPage;

    @BeforeTest
    @Parameters({"browserName"})
    public void setUp(@Optional("chrome") String browserName) {
        basePage = new BasePage(driver);
        driver = basePage.setupDriver(browserName);
        loginPage = new LoginPage(driver);
        loginPage.navigate(Constants.URL_UAT);
    }

    @AfterTest
    public void tearDown() {
        basePage.quit();
    }

    @Test(priority = 2, groups = {"ui", "regression"}, description = "Verify Login Successfully")
    public void testLoginSuccess() {
        Account standard_acc = Data.getDefaultAccount();
        loginPage.login(standard_acc);

        Assert.assertTrue(loginPage.getUrl().contains("inventory"));
    }

    @Test(priority = 1, groups = {"ui", "regression"}, description = "Verify Login Unsuccessfully")
    public void testLoginInvalidCredentials() {
        Account invalidAccount = new Account();
        invalidAccount.setUsername("khanh");
        invalidAccount.setPassword("do");
        loginPage.login(invalidAccount);

        // get error message
        //compare
    }

}
