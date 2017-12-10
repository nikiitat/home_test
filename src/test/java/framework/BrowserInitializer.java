package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by nikitatertytskyi on 15.08.17.
 */
public class BrowserInitializer {
    private static WebDriver driver;
    private static String browser = "chrome";

//    public BrowserInitializer(){
//
//    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "/Users/nikitatertytskyi/Desktop/Web_server/Google/chromedriver");
                driver = new ChromeDriver();
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            PageFactory.initElements(driver, driver);
        }
        return driver;
    }

    public static void closeWebDriver() {
        driver.quit();
        driver = null;
    }
}
