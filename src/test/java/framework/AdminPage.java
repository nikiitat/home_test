package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by nikitatertytskyi on 15.08.17.
 */
public class AdminPage extends PageFunctionalities {
    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "login")
    private WebElement login;

    @FindBy(css = "a[href='http://localhost/litecart/admin/?app=catalog&doc=catalog']")
    private WebElement catalog;

    public AdminPage (WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    public void login(){
        getWebDriver().navigate().to("http://localhost/litecart/admin/");
        waitForElementVisible(username);
        username.clear();
        username.sendKeys("admin");

        waitForElementVisible(password);
        password.clear();
        password.sendKeys("admin");

        waitForElementClickable(login);
        login.click();
//        assertTrue(isElementPresent(By.cssSelector("img[alt=\"My Store\"]")));
    }

    public CatalogPage openCatalogPage(){
        waitForElementClickable(catalog);
        catalog.click();
        return new CatalogPage(getWebDriver());
    }
}
