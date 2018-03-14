package supportfunctions;

import org.openqa.selenium.By;
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
    private final WebDriverWait webDriverWait;
    private final int Seconds = 10;
    private WebElement inputField;

    public PageFunctionalities(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Seconds);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebElement waitForElementVisible(WebElement element) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isElementPresent(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public WebElement isElementPresent(WebElement element, String cssString) {
        WebElement el = webDriverWait.until(ExpectedConditions.visibilityOf(element));
        return webDriverWait.until(ExpectedConditions.visibilityOf((WebElement) new By.ByCssSelector(cssString)));
    }

    public WebElement waitForElementClickable(WebElement element) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public String getFieldValue(WebElement element, final String field) {
        inputField = isElementPresent(element, field);
        return inputField.getAttribute("textContent");
    }

    public String getFieldValue(WebElement element) {
        return element.getAttribute("textContent");
    }
}
