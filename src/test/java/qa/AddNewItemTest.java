package qa;

import api.ErrorMessage;
import pageobjects.AddNewProductPage;
import pageobjects.AdminPage;
import pageobjects.BrowserInitializer;
import pageobjects.CatalogPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by nikitatertytskyi on 04.09.17.
 */
public class AddNewItemTest extends TestBase {
    private final WebDriver webDriver;
    private AdminPage adminPage;
    private CatalogPage catalogPage;
    private AddNewProductPage addNewProductPage;
    private ErrorMessage errorMessage;

    public AddNewItemTest(){
        webDriver = BrowserInitializer.getWebDriver();
        adminPage = new AdminPage(webDriver);
        catalogPage = new CatalogPage(webDriver);
        addNewProductPage = new AddNewProductPage(webDriver);
        errorMessage = new ErrorMessage(webDriver);
    }

    @Test
    public void addNewItem(){
        adminPage.login();
        catalogPage = adminPage.openCatalogPage();
        addNewProductPage = catalogPage.addNewProduct();
        addNewProductPage.addNewProduct();
        Assert.assertEquals(errorMessage.getSaveMessage(), addNewProductPage.errorDisplaySaveMessage());
    }
}
