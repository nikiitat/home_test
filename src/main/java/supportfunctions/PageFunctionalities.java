package supportfunctions;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by nikitatertytskyi on 15.08.17.
 */
public class PageFunctionalities {
    private final WebDriver webDriver;
    private static final int TIMEOUT = 10;
    private WebElement inputField;

    public PageFunctionalities(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public boolean waitForElementToBeVisible(WebElement element, int TIMEOUT) {
        try {
            new WebDriverWait(webDriver, TIMEOUT).until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public WebElement waitForElementClickable(WebElement element, int TIMEOUT) {
        return new WebDriverWait(webDriver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));
    }

    public String getFieldValue(WebElement element) {
        return element.getAttribute("textContent");
    }

    public void type(WebElement element, String text) {
        click(element);
        element.clear();
        element.sendKeys(text);
    }

    public void click(WebElement element) {
        waitForElementClickable(element, TIMEOUT);
        element.click();
    }
}
