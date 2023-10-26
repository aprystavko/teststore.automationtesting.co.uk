package base;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener {
    BasePage basePage = new BasePage();

    public Listeners() throws IOException {
        super();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test is executed successfully: " + result.getInstanceName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            basePage.takeSnapShot(result.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
