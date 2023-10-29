package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class BasePage {
    private String url;
    private Properties prop;
    private ChromeOptions options = new ChromeOptions();
    public static String screenShotDestinationPath;

    public BasePage() throws IOException {
        prop = new Properties();
        FileInputStream data = new FileInputStream(
                "./src/test/resources/config.properties");
        prop.load(data);
    }

    public static WebDriver getDriver() {
        return WebDriverInstance.getDriver();
    }

    public String getUrl() {
        url = prop.getProperty("url");
        return url;
    }

    public static String takeSnapShot(String name) {
        if (getDriver() != null) {
            File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            // System.getProperty("user.dir") +
            String destFile = System.getProperty("user.dir") + "/logs/screenshots/" + timestamp() + ".png";
            screenShotDestinationPath = destFile;
            try {
                FileUtils.copyFile(srcFile, new File(destFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return name;
    }

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public static String getScreenshotDestinationPath() {
        return screenShotDestinationPath;
    }

    Utils utils = new Utils();

    public void addBorderToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        String elem = utils.getStringWebElement(element);
        js.executeScript("document.querySelector(\"" + elem + "\").style.border = \"thick solid #df3079\";");
    }

    public void waitForElementInvisible(WebElement element, int timer) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timer);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

}
