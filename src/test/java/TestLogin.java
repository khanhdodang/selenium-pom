import Data.Data;
import Objects.Account;
import Pages.BasePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestLogin {

    protected WebDriver driver;
    BasePage basePage;
    LoginPage loginPage;
    ProductPage productPage;

    @BeforeClass
    public void setUp() {
        basePage = new BasePage(driver);
        driver = basePage.setupDriver("chrome");
        loginPage = new LoginPage(driver);
        loginPage.navigate(Constants.URL_UAT);
        productPage = new ProductPage(driver);
    }

    @AfterClass
    public void tearDown() {
        basePage.quit();
    }

    @Test
    public void testLogin() {
        Account standard_acc = Data.getDefaultAccount();
        loginPage.login(standard_acc);

        Assert.assertTrue(loginPage.getUrl().contains("inventory"));

        productPage.click_ProductItem(1, "add");
        productPage.click_ProductItem(2, "add");

        System.out.println(productPage.getProductItem(1));
        Assert.assertEquals(productPage.getProductItems(), 5);
    }
}
