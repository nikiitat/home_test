package pageobjects.shopPages;

import api.ProductAttributes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import supportfunctions.PageFunctionalities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikitatertytskyi on 26.08.17.
 */
public class MainPage extends PageFunctionalities {
    @FindBy(css = "a[href*=create_account]")
    private WebElement createAccount;

    @FindBy(css = "a[href*=logout]")
    private WebElement logout;

    @FindBy(name = "login")
    private WebElement login;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(css = "div#main div#notices-wrapper")
    private WebElement loginLogoutMessage;

    @FindBy(css = "div#box-campaigns.box ul.listing-wrapper.products a:first-child")
    private WebElement firstElementInCampaigns;

    @FindBy(css = "div#box-campaigns.box ul.listing-wrapper.products a:first-child div.name")
    private WebElement name;

    @FindBy(css = "div#box-campaigns.box ul.listing-wrapper.products a:first-child s.regular-price")
    private WebElement oldPrice1;

    @FindBy(css = "div#box-campaigns.box ul.listing-wrapper.products a:first-child strong.campaign-price")
    private WebElement newPrice1;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    public ProductAttributes getProductAttributes() {
        String title = getFieldValue(name);
        String oldPrice = getFieldValue(oldPrice1);
        String newPrice = getFieldValue(newPrice1);
        return new ProductAttributes(title, oldPrice, newPrice);
    }

    public List<String> firstItemAttribute() {
        waitForElementVisible(firstElementInCampaigns);
        List<String> firstItem = new ArrayList<>();
        firstItem.add(getFieldValue(name));
        firstItem.add(getFieldValue(oldPrice1));
        firstItem.add(getFieldValue(newPrice1));

        return (firstItem);
    }

    public void openMainPage() {
        getWebDriver().navigate().to("http://localhost/litecart/en/");
    }

    public ProductPage openProductPage() {
        waitForElementVisible(firstElementInCampaigns);
        firstElementInCampaigns.click();
        return new ProductPage(getWebDriver());
    }

    public SignUpPage createAccount() {
        waitForElementClickable(createAccount);
        createAccount.click();
        return new SignUpPage(getWebDriver());
    }

    public void logoutWithCreatedAccount() {
        waitForElementClickable(logout);
        logout.click();
    }

    public void loginWithCreatedAccount(String userEmail, String pass) {
        waitForElementVisible(email);
        email.click();
        email.clear();
        email.sendKeys(userEmail);
        password.click();
        password.clear();
        password.sendKeys(pass);
        waitForElementClickable(login);
        login.click();
    }

    public String getLoginLogoutMessage() {
        waitForElementVisible(loginLogoutMessage);
        return loginLogoutMessage.getText();
    }

    public boolean getLoginMessage() {
        waitForElementVisible(loginLogoutMessage);
        if (loginLogoutMessage.getText().contains("You are now logged in")) {
            return true;
        }
        return false;
    }
}
