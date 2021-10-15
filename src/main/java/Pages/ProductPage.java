package Pages;

import Locators.ProductLocators;
import Objects.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage{
    ProductLocators locators = new ProductLocators();

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Click on Product item
     * @param index starts from 1 to the length of the list
     * @param action includes 'add' or 'remove'
     */
    public void click_ProductItem(int index, String action) {
        List<WebElement> elementList = driver.findElements(locators.LIST_PRODUCTS);
        if (index > 0 && index <= elementList.size()) {
            WebElement element = driver.findElement(locators.PRODUCT_BUTTON(index));
            String text = element.getText();
            if (action.equalsIgnoreCase("add") && text.equalsIgnoreCase("Add to cart")) {
                element.click();
            }
            if (action.equalsIgnoreCase("remove") && text.equalsIgnoreCase("Remove")) {
                element.click();
            }
        }
    }

    public Product getProductItem(int index) {
        Product product = new Product();
        product.setTitle(getText(locators.LABEL_PRODUCT_NAME(index)));
        product.setDesc(getText(locators.LABEL_PRODUCT_DESC(index)));
        product.setPrice(getText(locators.LABEL_PRODUCT_PRICE(index)));
        return product;
    }

    public int getProductItems() {
       return getElementsSize(locators.LIST_PRODUCTS);
    }
}
