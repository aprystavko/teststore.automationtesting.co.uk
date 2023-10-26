package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Question {
    WebDriver driver;

    @BeforeSuite
    public void setup() {
        ChromeOptions options = new ChromeOptions();
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://teststore.automationtesting.co.uk/login?back=my-account");
        driver.manage().deleteAllCookies();
    }

    @Test
    public void signIn() throws InterruptedException {
        driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test11@test11.com");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("test123");
        driver.findElement(By.cssSelector("button#submit-login")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}