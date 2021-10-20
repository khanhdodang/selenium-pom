package ui;

import Objects.Account;
import Pages.BasePage;
import Pages.LoginPage;
import Pages.LogoutPage;
import Utils.Constants;
import Utils.Utility;
import Data.Data;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class TestLogin2 {
    WebDriver driver;
    BasePage basePage;
    LoginPage loginPage;
    LogoutPage logoutPage;

    @BeforeClass
    @Parameters({"browserName"})
    public void setUp(@Optional("chrome") String browserName) {
        basePage = new BasePage(driver);
        driver = basePage.setupDriver(browserName);
        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);

        loginPage.navigate(Constants.URL_UAT);
    }

    @AfterClass
    public void tearDown() {
        basePage.cleanUp();
    }
//
//    @Test(priority = 1, groups = {"ui", "regression", "functional"},
//            description = "Verify Login function with invalid credentials")
//    public void testLogin01() {
//        Account account = new Account();
//        account.setUsername("standard_user_1");
//        account.setPassword("secret_sauce_1");
//        loginPage.login(account);
//    }
//
//    @Test(priority = 2, groups = {"ui", "regression", "functional"},
//            description = "Verify Login function with empty username")
//    public void testLogin02() {
//        Account account = new Account();
//        account.setUsername("");
//        account.setPassword("secret_sauce");
//        loginPage.login(account);
//    }
//
//    @Test(priority = 3, groups = {"ui", "regression", "functional"},
//            description = "Verify Login function with valid credentials")
//    public void testLogin03() {
//        loginPage.login(Data.defaultAccount());
//    }

//    @Test(priority = 4, groups = {"ui", "regression", "functional"},
//            description = "Verify Login function")
//    public void testLogin04() {
//        for (Account account : Data.getAccounts()) {
//            loginPage.login(account);
//            logoutPage.logout();
//        }
//    }

    @Test(priority = 5, groups = {"ui", "regression", "functional"},
            description = "Verify Login function")
    public void testLogin05() throws InterruptedException {
        ArrayList<String> arrayList = Utility.readCSV(Constants.INVALID_ACCOUNTS_FILE);
        for (int i = 0; i < arrayList.size(); i++) {
            String[] array = arrayList.get(i).split(";");
            Account account = new Account();
            account.setUsername(array[0]);
            account.setPassword(array[1]);

            String expectedResult = array[2];
            System.out.println(expectedResult);

            loginPage.login(account);
            Thread.sleep(1000);

            String actualResult = loginPage.getLoginError();
            System.out.println(actualResult);
            Assert.assertTrue(actualResult.contains(expectedResult));

            logoutPage.logout();
        }
    }
}
