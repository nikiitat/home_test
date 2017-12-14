package qa;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.BrowserInitializer;
import pageobjects.shopPages.MainPage;

/**
 * Created by nikitatertytskyi on 14.12.17.
 */
public class ItemValidationTest extends TestBase {
    private final WebDriver webDriver;
    private MainPage mainPage;

    public ItemValidationTest(){
        webDriver = BrowserInitializer.getWebDriver();
        mainPage = new MainPage(webDriver);
    }

    @Test
    public void checkItem(){

    }
}