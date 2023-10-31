package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ShopLoginPage extends BasePage {

    public WebDriver driver;

    By email = By.cssSelector("input[name='email']");
    By password = By.cssSelector("input[name='password']");
    By submitBtn = By.cssSelector("button#submit-login");

    public ShopLoginPage() throws IOException {
        super();
    }

    public WebElement getEmail() {
        this.driver = getDriver();
        return driver.findElement(email);
    }

    public WebElement getPassword() {
        this.driver = getDriver();
        return driver.findElement(password);
    }

    public WebElement getSubmitBtn() {
        this.driver = getDriver();
        return driver.findElement(submitBtn);
    }

}
