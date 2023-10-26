package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver driver;
    private String url;
    private Properties prop;
    private ChromeOptions options = new ChromeOptions();

    public BasePage() throws IOException {
        prop = new Properties();
        FileInputStream data = new FileInputStream(
                "./src/test/resources/config.properties");
        prop.load(data);
    }

    public WebDriver getDriver() {
        if (prop.getProperty("browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            options.addArguments("--start-maximized");

            options.addArguments("--disable-web-security");
            options.addArguments("--no-proxy-server");

            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

            driver = new ChromeDriver(options);
        } else if (prop.getProperty("browser").equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public String getUrl() {
        url = prop.getProperty("url");
        return url;
    }

    public void takeSnapShot(String name) throws IOException {
        if (driver != null) {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File("./logs/screenshots/" + timestamp() + ".png");
            FileUtils.copyFile(srcFile, destFile);
        }
    }

    public String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    Utils utils = new Utils();

    public void addBorderToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String elem = utils.getStringWebElement(element);
        js.executeScript("document.querySelector(\"" + elem + "\").style.border = \"thick solid #df3079\";");
    }

}
