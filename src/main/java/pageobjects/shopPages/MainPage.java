package pageobjects.shopPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.PageFunctionalities;

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

    public MainPage (WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }
    public void openMainPage(){
        getWebDriver().navigate().to("http://localhost/litecart/en/");
    }

    public SignUpPage createAccount(){
        waitForElementClickable(createAccount);
        createAccount.click();
        return new SignUpPage(getWebDriver());
    }

    public void logoutWithCreatedAccount(){
        waitForElementClickable(logout);
        logout.click();
    }

    public void loginWithCreatedAccount(String userEmail, String pass){
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

    public String getLoginLogoutMessage(){
        waitForElementVisible(loginLogoutMessage);
        return loginLogoutMessage.getText();
    }

    public boolean getLoginMessage(){
        waitForElementVisible(loginLogoutMessage);
        if (loginLogoutMessage.getText().contains("You are now logged in")) {
            return true;
        } return false;
    }
}
