package qa;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import pageobjects.BrowserInitializer;


/**
 * Created by nikitatertytskyi on 15.08.17.
 */
public class TestBase {

    @BeforeSuite
    public void start() {
        BrowserInitializer.getWebDriver();
    }

    @AfterTest(alwaysRun = true)
    public void stop() {
        BrowserInitializer.closeWebDriver();
    }
}
