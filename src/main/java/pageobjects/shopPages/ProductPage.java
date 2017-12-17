package pageobjects.shopPages;

import api.ProductAttributes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.PageFunctionalities;

/**
 * Created by nikitatertytskyi on 17.12.17.
 */
public class ProductPage extends PageFunctionalities {
    @FindBy(css = "div#box-product.box h1.title")
    private WebElement titleItem;

    @FindBy(css = "div.price-wrapper")
    private WebElement priceBox;

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    public ProductAttributes getProductAttributes() {
        waitForElementVisible(titleItem);
        String title = getFieldValue(titleItem);
        String oldPrice = getFieldValue(priceBox, "s.regular-price");
        String newPrice = getFieldValue(priceBox, "strong.campaign-price");
        return new ProductAttributes(title, oldPrice, newPrice);
    }
}