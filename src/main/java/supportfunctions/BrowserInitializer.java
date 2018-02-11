package supportfunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by nikitatertytskyi on 15.08.17.
 */
public class BrowserInitializer {
    private static WebDriver driver;
    private static String browser = "chrome";

    public BrowserInitializer() {

    }

//    public static void initBrowser(final String browserName) {
//        browser = browserName;
//    }

    public static WebDriver getWebDriver() {
        if (browser.equals(BrowserType.FIREFOX)) {
            System.setProperty("webdriver.firefox.bin", "/Applications/Firefox 2.app/Contents/MacOS/firefox-bin");
            driver = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        } else if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.SAFARI)) {
            driver = new SafariDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, driver);
        return driver;
    }

    public static void closeWebDriver() {
        driver.quit();
    }
}
