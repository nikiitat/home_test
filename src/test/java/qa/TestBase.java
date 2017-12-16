package qa;

import org.testng.annotations.AfterClass;
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

    @AfterClass
    public void stop() {
        BrowserInitializer.closeWebDriver();
    }
}
