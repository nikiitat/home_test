package qa;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import supportfunctions.BrowserInitializer;


/**
 * Created by nikitatertytskyi on 15.08.17.
 */
public class TestBase {

    @BeforeSuite
    public void start() {
        String browser = System.getProperty("browser", BrowserType.CHROME);
        BrowserInitializer.getWebDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void stop() {
        BrowserInitializer.closeWebDriver();
    }
}
