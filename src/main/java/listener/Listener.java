package listener;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Created by nikitatertytskyi on 14.12.17.
 */
public class Listener extends TestListenerAdapter {

    public void onTestStart(ITestResult tr){
        System.out.println("Test Started");
    }
    public void onTestSuccess(ITestResult tr){
        System.out.println("Test Passed");
    }

    public void onTestFailure (ITestResult tr){
        System.out.println("Test Failed");
    }

    public void onTestSkipped (ITestResult tr){
        System.out.println("Test Skipped");
    }
}
