package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Reporter;

import java.util.List;

public class BasePage {

    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver setupDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("opera")) {
            driver = new OperaDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        return driver;
    }

    /**
     * Navigate to the URL
     *
     * @param url Input the URL to navigate
     */
    public void navigate(String url) {
        driver.get(url);
    }

    /**
     * Get current URL
     */
    public String getUrl() {
        Reporter.log("Get current URL");
        return driver.getCurrentUrl();
    }

    /**
     * Get text of an element
     *
     * @param by receive the element
     */
    public String getText(By by) {
        Reporter.log("Get text on the element by locator " + by.toString());
        WebElement element = driver.findElement(by);
        return element.getText();
    }

    /**
     * Click on an element
     *
     * @param by receive the element
     */
    public void click(By by) {
        Reporter.log("Click on the element by locator " + by.toString());
        WebElement element = driver.findElement(by);
        element.click();
    }

    /**
     * Set text into element
     *
     * @param by   the element
     * @param text the value
     */
    public void setText(By by, String text) {
        Reporter.log("Set text on the element by locator " + by.toString() + " with the value: " + text);
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Get element size
     *
     * @param by   the element
     */
    public int getElementsSize(By by) {
        int result = 0;
        try {
            List<WebElement> elementList = driver.findElements(by);
            result = elementList.size();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    /**
     * Terminate test session
     */
    public void quit() {
        driver.quit();
    }
}
