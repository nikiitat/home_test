package pageobjects.shopPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import supportfunctions.PageFunctionalities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by nikitatertytskyi on 26.08.17.
 */
public class SignUpPage extends PageFunctionalities {
    public static final String MAIL_TAIL = "@seleniumTest.com";
    public static final String MAIL_Head = "TESTUSER";
    private static final int TIMEOUT = 10;

    private String pass = "1234";
    private String userEmail;

    private final String loginMessage = "";


    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(name = "address1")
    private WebElement address1;

    @FindBy(name = "postcode")
    private WebElement postcode;

    @FindBy(name = "city")
    private WebElement city;

    @FindBy(css = "span.selection")
    private WebElement selector;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "phone")
    private WebElement phone;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "confirmed_password")
    private WebElement confirmedPass;

    @FindBy(name = "create_account")
    private WebElement createAccountB;

    @FindBy(css = "div#main div#notices-wrapper")
    private WebElement loginM;

    public SignUpPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    public MainPage createTestAccount() {
        type(firstName, "Test");
        type(lastName, "Test");
        type(address1, "Street1");
        type(postcode, "09100");
        type(city, "Alabama");

        Actions actions = new Actions(getWebDriver());
        actions.moveToElement(waitForElementClickable(selector, TIMEOUT));
        actions.click();
        actions.sendKeys("United States");
        actions.sendKeys(Keys.ENTER);
        actions.perform();

        userEmail = generateUserEmail();
        type(email, userEmail);
        type(phone, "123456789");
        type(password, pass);
        type(confirmedPass, pass);
        click(createAccountB);
        System.out.print(userEmail);
        return new MainPage(getWebDriver());
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPass() {
        return pass;
    }

    public String getLoginMessage() {
        return loginMessage;
    }

    private String generateUserEmail() {
        final SimpleDateFormat formater = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
        final Calendar calendar = Calendar.getInstance();
        final String autoGenerateEmail = MAIL_Head + formater.format(calendar.getTime()) + MAIL_TAIL;
        return autoGenerateEmail;
    }
}
