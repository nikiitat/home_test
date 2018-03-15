package pageobjects.shopPages;

import api.ProductAttributes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import supportfunctions.PageFunctionalities;

/**
 * Created by nikitatertytskyi on 17.12.17.
 */
public class ProductPage extends PageFunctionalities {
    @FindBy(css = "div#box-product.box h1.title")
    private WebElement titleItem;

    @FindBy(css = "div.price-wrapper")
    private WebElement priceBox;

    @FindBy(css = "div.price-wrapper s.regular-price")
    private WebElement regularPrice;

    @FindBy(css = "div.price-wrapper strong.campaign-price")
    private WebElement campaignPrice;

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    public ProductAttributes getProductAttributes() {
        waitForElementVisible(titleItem);
        String title = getFieldValue(titleItem);
        String oldPrice = getFieldValue(regularPrice);
        String newPrice = getFieldValue(campaignPrice);
        return new ProductAttributes(title, oldPrice, newPrice);
    }
}