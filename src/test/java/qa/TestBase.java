package qa;

import framework.BrowserInitializer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


/**
 * Created by nikitatertytskyi on 15.08.17.
 */
public class TestBase {

    @BeforeClass
    public void start() {
        BrowserInitializer.getWebDriver();
    }
    @AfterClass
    public void stop(){
        BrowserInitializer.closeWebDriver();
    }
}
