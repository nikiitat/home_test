package pageobjects;

import org.openqa.selenium.By;
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
        this.webDriverWait = new WebDriverWait(this.webDriver, Seconds);
    }
    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebElement waitForElementVisible(WebElement element){
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementVisibleByCss(String element){
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
    }

    public WebElement waitForElementClickable(WebElement element){
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementClickableByCss(String element){
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
    }

    public WebElement isElementPresent(WebElement element, String cssString){
        return webDriverWait.until(ExpectedConditions.visibilityOf(element.findElement(By.cssSelector(cssString))));
    }

    public String getFieldValue(WebElement element, final String field) {
        inputField = isElementPresent(element, field);
        return inputField.getAttribute("textContent");
    }

    public String getFieldValue(WebElement element) {
        return element.getAttribute("textContent");
    }
}
