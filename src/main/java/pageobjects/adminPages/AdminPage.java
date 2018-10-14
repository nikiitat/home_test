package pageobjects.adminPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import supportfunctions.PageFunctionalities;

/**
 * Created by nikitatertytskyi on 15.08.17.
 */
public class AdminPage extends PageFunctionalities {
    private static final int TIMEOUT = 10;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "login")
    private WebElement login;

    @FindBy(css = ".header a:nth-child(2)")
    private WebElement home;

    @FindBy(css = "a[href='http://localhost/litecart/admin/?app=catalog&doc=catalog']")
    private WebElement catalog;

    @FindBy(css = "a[href='http://localhost/litecart/admin/?app=countries&doc=countries']")
    private WebElement countries;

    public AdminPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    public void login() {
        getWebDriver().navigate().to("http://localhost/litecart/admin/");
        if (!waitForElementToBeVisible(home, TIMEOUT)) {
            type(username, "admin");
            type(password, "admin");
            click(login);
        } else {
            home.click();
        }
//        assertTrue(isElementPresent(By.cssSelector("img[alt=\"My Store\"]")));
    }

    public CatalogPage openCatalogPage() {
        click(catalog);
        return new CatalogPage(getWebDriver());
    }

    public CountriesPage openCountriesPage() {
        click(countries);
        return new CountriesPage(getWebDriver());
    }
}
