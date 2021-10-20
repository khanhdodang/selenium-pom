package Pages;

import Locators.LogoutLocators;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage{
    LogoutLocators locators = new LogoutLocators();
    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        if (isDisplayed(locators.BUTTON_MENU)) {
            click(locators.BUTTON_MENU);
            click(locators.LINK_LOGOUT);
        }

    }
}
