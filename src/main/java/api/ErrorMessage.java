package api;

import pageobjects.PageFunctionalities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by nikitatertytskyi on 24.09.17.
 */
public class ErrorMessage extends PageFunctionalities {
    private String saveMessage = "Changes were successfully saved.";
    private String accountCreated = "Your customer account has been created.";
    private String loginMessage = "You are now logged in";
    private String logoutMessage = "You are now logged out.";

    public ErrorMessage (WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }
    public String getSaveMessage(){
        return saveMessage;
    }

    public String getAccountCreatedMessage(){
        return accountCreated;
    }

    public String getLogoutMessage(){
        return logoutMessage;
    }
    public String getLoginMessage(){
        return loginMessage;
    }
}
