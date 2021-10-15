package Locators;

import org.openqa.selenium.By;

public class ProductLocators {
    String locator = "//div[@class='inventory_item']";
    public By LIST_PRODUCTS = By.xpath(locator);

    public By PRODUCT_BUTTON(int index) {
        return By.xpath(locator + "[" + index + "]//button");
    }

    public By LABEL_PRODUCT_NAME(int index) {
        return By.xpath(locator + "[" + index + "]//div[@class='inventory_item_name']");
    }

    public By LABEL_PRODUCT_DESC(int index) {
        return By.xpath(locator + "[" + index + "]//div[@class='inventory_item_desc']");
    }

    public By LABEL_PRODUCT_PRICE(int index) {
        return By.xpath(locator + "[" + index + "]//div[@class='inventory_item_price']");
    }
}
