package shopTests;

import Base.TestBase;
import modules.ProductAttributes;
import org.hamcrest.core.Is;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.shopPages.MainPage;
import pageobjects.shopPages.ProductPage;
import supportfunctions.BrowserInitializer;

import static org.junit.Assert.assertThat;

/**
 * Created by nikitatertytskyi on 14.03.2018.
 */
public class ItemValidationTest extends TestBase {
    private final WebDriver webDriver;
    private MainPage mainPage;
    private ProductPage productPage;

    public ItemValidationTest() {
        this.webDriver = BrowserInitializer.getWebDriver();
        mainPage = new MainPage(webDriver);
        productPage = new ProductPage(webDriver);
    }

    @Test
    public void checkItemDescription() {
        mainPage.openMainPage();
        final ProductAttributes mainPageItem = mainPage.getProductAttributes();
        productPage = mainPage.openProductPage();
        final ProductAttributes productPageItem = productPage.getProductAttributes();
        assertThat(productPageItem, Is.is(mainPageItem));
    }
}
