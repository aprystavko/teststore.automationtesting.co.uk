package base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class Hooks extends BasePage {
    public ExtendManager extendManager = new ExtendManager();
    public Hooks() throws IOException {
    }

    @BeforeTest
    public void setup() throws IOException {
        getDriver().get(getUrl());
    }

    @AfterTest
    public void tearDown() {
        WebDriverInstance.cleanupDriver();
    }

}
