package adminTests;

import Base.TestBase;
import modules.ErrorMessages;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.adminPages.AddNewProductPage;
import pageobjects.adminPages.AdminPage;
import pageobjects.adminPages.CatalogPage;
import supportfunctions.BrowserInitializer;

/**
 * Created by nikitatertytskyi on 04.09.17.
 */
public class AddNewItemTest extends TestBase {
    private final WebDriver webDriver;
    private AdminPage adminPage;
    private CatalogPage catalogPage;
    private AddNewProductPage addNewProductPage;
    private ErrorMessages errorMessages;

    public AddNewItemTest() {
        webDriver = BrowserInitializer.getWebDriver();
        adminPage = new AdminPage(webDriver);
        catalogPage = new CatalogPage(webDriver);
        addNewProductPage = new AddNewProductPage(webDriver);
        errorMessages = new ErrorMessages(webDriver);
    }

    @Test
    public void addNewItem() {
        adminPage.login();
        catalogPage = adminPage.openCatalogPage();
        addNewProductPage = catalogPage.addNewProduct();
        addNewProductPage.addNewProduct();
        Assert.assertEquals(errorMessages.getSaveMessage(), addNewProductPage.errorDisplaySaveMessage());
    }
}
