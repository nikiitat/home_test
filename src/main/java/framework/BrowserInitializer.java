package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import utils.GetPropertyValues;

import java.io.IOException;
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
            try {
                final GetPropertyValues getPropertyValues = new GetPropertyValues();
                if (browser.equalsIgnoreCase("firefox")) {

                    System.setProperty("webdriver.gecko.driver", getPropertyValues.getFireFoxDriverPath());
                    driver = new FirefoxDriver();

                } else if (browser.equalsIgnoreCase("chrome")) {

//                    DesiredCapabilities caps = new DesiredCapabilities();
                    System.setProperty("webdriver.chrome.driver", getPropertyValues.getChromeDriverPath());
                    driver = new ChromeDriver();

                } else {
                    throw new RuntimeException("Unsupported Browser" + browser);
                }

                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                PageFactory.initElements(driver, driver);

            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void closeWebDriver() {
        driver.quit();
        driver = null;
    }
}
