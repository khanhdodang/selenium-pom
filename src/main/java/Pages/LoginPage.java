package Pages;

import Locators.LoginLocators;
import Objects.Account;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    LoginLocators locators = new LoginLocators();

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(Account account) {
        /*
        WebElement input_username = driver.findElement(locators.INPUT_USERNAME);
        input_username.sendKeys(account.getUsername());
         */
        setText(locators.INPUT_USERNAME, account.getUsername());
        setText(locators.INPUT_PASSWORD, account.getPassword());
        click(locators.BUTTON_LOGIN);
    }


}
