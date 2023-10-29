package base;

import org.testng.ITestContext;
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
    public synchronized void onStart(ITestContext context) {
        ExtendManager.getReport();
        ExtendManager.createTest(context.getName(), context.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtendManager.getTest().fail(result.getThrowable());
        try {
            System.out.println("Test failed: " + result.getName());
            basePage.takeSnapShot(result.getMethod().getMethodName());
            ExtendManager.attachImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void onFinish(ITestContext context) {
        ExtendManager.flushReport();
    }

}
