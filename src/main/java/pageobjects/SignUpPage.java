package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by nikitatertytskyi on 26.08.17.
 */
public class SignUpPage extends PageFunctionalities {
    public static final String MAIL_TAIL = "@seleniumTest.com";
    public static final String MAIL_Head = "TESTUSER";

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

    public SignUpPage (WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    public MainPage createTestAccount(){
        fillFields(firstName, "Test");
        fillFields(lastName, "Test");
        fillFields(address1, "Street1");
        fillFields(postcode, "09100");
        fillFields(city,"Alabama");

        Actions actions = new Actions(getWebDriver());
        actions.moveToElement(waitForElementClickable(selector));
        actions.click();
        actions.sendKeys("United States");
        actions.sendKeys(Keys.ENTER);
        actions.perform();

        userEmail = generateUserEmail();
        fillFields(email, userEmail);
        fillFields(phone,"123456789");
        fillFields(password, pass);
        fillFields(confirmedPass, pass);
        clickSignButton();
        System.out.print(userEmail);
        return new MainPage(getWebDriver());
    }

    public String getUserEmail(){return userEmail;}

    public String getUserPass(){return pass;}

    public String getLoginMessage(){
        return loginMessage;
    }

    private String generateUserEmail(){
        final SimpleDateFormat formater = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
        final Calendar calendar = Calendar.getInstance();
        final String autoGenerateEmail = MAIL_Head + formater.format(calendar.getTime()) + MAIL_TAIL;
        return autoGenerateEmail;
    }

    private void fillFields (WebElement element, String string){
        waitForElementVisible(element);
        element.click();
        element.clear();
        element.sendKeys(string);
    }

    private void clickSignButton(){
        waitForElementVisible(createAccountB);
        createAccountB.click();
    }
}
