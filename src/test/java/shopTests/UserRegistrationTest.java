package shopTests;


import Base.TestBase;
import modules.ErrorMessages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.shopPages.MainPage;
import pageobjects.shopPages.SignUpPage;
import supportfunctions.BrowserInitializer;

import static junit.framework.TestCase.assertTrue;


/**
 * Created by nikitatertytskyi on 26.08.17.
 */
public class UserRegistrationTest extends TestBase {
    private final WebDriver webDriver;
    private MainPage mainPage;
    private SignUpPage signUpPage;
    private ErrorMessages errorMessages;

    public UserRegistrationTest(){
        webDriver = BrowserInitializer.getWebDriver();
        mainPage = new MainPage(webDriver);
        signUpPage = new SignUpPage(webDriver);
        errorMessages = new ErrorMessages(webDriver);
    }
    @Test
    public void registrationTest(){
        mainPage.openMainPage();
        signUpPage = mainPage.createAccount();
        mainPage = signUpPage.createTestAccount();
        Assert.assertEquals(errorMessages.getAccountCreatedMessage(), mainPage.getLoginLogoutMessage());
        mainPage.logoutWithCreatedAccount();
        Assert.assertEquals(errorMessages.getLogoutMessage(), mainPage.getLoginLogoutMessage());
        mainPage.loginWithCreatedAccount(signUpPage.getUserEmail(), signUpPage.getUserPass());
        assertTrue(mainPage.getLoginMessage());
        mainPage.logoutWithCreatedAccount();
        Assert.assertEquals(errorMessages.getLogoutMessage(), mainPage.getLoginLogoutMessage());
    }
}
