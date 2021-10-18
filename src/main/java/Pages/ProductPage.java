package Pages;

import Locators.ProductLocators;
import Objects.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static Utils.Utility.convertProductFromString;

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

    public ArrayList<Product> getProductItems() {
        ArrayList<Product> products = new ArrayList<>();
        for (int i = 1; i <= getProductItemsSize(); i++) {
            products.add(getProductItem(i));
        }
        return products;
    }

    public int getProductItemsSize() {
       return getElementsSize(locators.LIST_PRODUCTS);
    }

    public void compareProduct(Product actual, Product expected) {
        Assert.assertEquals(actual.getTitle(), expected.getTitle());
        Assert.assertEquals(actual.getDesc(), expected.getDesc());
        Assert.assertEquals(actual.getPrice(), expected.getPrice());
    }

    public void compareProducts(ArrayList<Product> actual, ArrayList<Product> expected) {
        Assert.assertEquals(actual.size(), expected.size());

        for (int i = 0; i < expected.size(); i++) {
            compareProduct(actual.get(i), expected.get(i));
        }
    }
}
