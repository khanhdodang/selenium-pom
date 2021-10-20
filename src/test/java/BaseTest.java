import Pages.BasePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    BasePage basePage;
    LoginPage loginPage;
    @BeforeClass
    public void setUp() {
        basePage = new BasePage(driver);
        driver = basePage.setupDriver("opera");
    }

    @AfterClass
    public void tearDown() {
        basePage.cleanUp();
    }
}
