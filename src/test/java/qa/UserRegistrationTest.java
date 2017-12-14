package qa;


import api.ErrorMessage;
import pageobjects.BrowserInitializer;
import pageobjects.shopPages.MainPage;
import pageobjects.shopPages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


/**
 * Created by nikitatertytskyi on 26.08.17.
 */
public class UserRegistrationTest extends TestBase {
    private final WebDriver webDriver;
    private MainPage mainPage;
    private SignUpPage signUpPage;
    private ErrorMessage errorMessage;

    public UserRegistrationTest(){
        webDriver = BrowserInitializer.getWebDriver();
        mainPage = new MainPage(webDriver);
        signUpPage = new SignUpPage(webDriver);
        errorMessage = new ErrorMessage(webDriver);
    }
    @Test
    public void registrationTest(){
        mainPage.openMainPage();
        signUpPage = mainPage.createAccount();
        mainPage = signUpPage.createTestAccount();
        Assert.assertEquals(errorMessage.getAccountCreatedMessage(), mainPage.getLoginLogoutMessage());
        mainPage.logoutWithCreatedAccount();
        Assert.assertEquals(errorMessage.getLogoutMessage(), mainPage.getLoginLogoutMessage());
        mainPage.loginWithCreatedAccount(signUpPage.getUserEmail(), signUpPage.getUserPass());
        assertTrue(mainPage.getLoginMessage());
        mainPage.logoutWithCreatedAccount();
        Assert.assertEquals(errorMessage.getLogoutMessage(), mainPage.getLoginLogoutMessage());
    }
}
