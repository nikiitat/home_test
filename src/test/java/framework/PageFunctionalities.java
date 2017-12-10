package framework;

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

    public PageFunctionalities(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(this.webDriver, Seconds);
    }
    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebElement waitForElementVisible(WebElement element){
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementClickable(WebElement element){
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
