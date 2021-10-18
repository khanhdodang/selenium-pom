package ui;

import Data.Data;
import Objects.Account;
import Objects.Product;
import Pages.BasePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class TestProduct {

    protected WebDriver driver;
    BasePage basePage;
    LoginPage loginPage;
    ProductPage productPage;

    @BeforeClass
    @Parameters({"browserName"})
    public void setUp(@Optional("chrome") String browserName) {
        basePage = new BasePage(driver);
        driver = basePage.setupDriver(browserName);
        loginPage = new LoginPage(driver);
        loginPage.navigate(Constants.URL_UAT);
        Account standard_acc = Data.getDefaultAccount();
        loginPage.login(standard_acc);

        productPage = new ProductPage(driver);
    }

    @AfterClass
    public void tearDown() {
        basePage.quit();
    }

    @Test(priority = 1, groups = {"ui", "functional"}, description = "Verify Product list")
    public void testProductsDisplay() {
        ArrayList<Product> expectedProducts = Data.getProducts();
        ArrayList<Product> actualProducts = productPage.getProductItems();

        productPage.compareProducts(actualProducts, expectedProducts);
    }

    @Test(priority = 2, groups = {"ui", "functional"}, description = "Verify Add to Cart and Remove button")
    public void testAddToCart_Remove() {
        for (int i = 1; i < productPage.getProductItemsSize(); i++) {
            productPage.click_ProductItem(i, "add");
            // Verify Button Add to cart

            productPage.click_ProductItem(i, "remove");
            // Verify Button Remove
        }
    }


}
