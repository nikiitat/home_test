package qa;

import api.ProductAttributes;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.BrowserInitializer;
import pageobjects.shopPages.MainPage;
import pageobjects.shopPages.ProductPage;

/**
 * Created by nikitatertytskyi on 14.12.17.
 */
public class ItemValidationTest extends TestBase {
    private final WebDriver webDriver;
    private MainPage mainPage;
    private ProductPage productPage;

    public ItemValidationTest(){
        webDriver = BrowserInitializer.getWebDriver();
        mainPage = new MainPage(webDriver);
        productPage = new ProductPage(webDriver);
    }

    @Test
    public void checkItem(){
        mainPage.openMainPage();
        final ProductAttributes mainPageItem = mainPage.getProductAttributes();
        productPage = mainPage.openProductPage();
        final ProductAttributes productPageItem = productPage.getProductAttributes();
        Assert.assertThat(productPageItem, Is.is(mainPageItem));
    }
}