package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebDriverInstance {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            try {
                driver.set(createDriver());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return driver.get();
    }

    public static WebDriver createDriver() throws IOException {
        WebDriver driver = null;
        ChromeOptions options = new ChromeOptions();
        Properties prop = new Properties();
        FileInputStream data = new FileInputStream(
                System.getProperty("user.dir") + "./src/test/resources/config.properties");
        prop.load(data);

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

    public static void cleanupDriver() {
        driver.get().quit();
        driver.remove();
    }

}