package pageObjects;

import base.ActionsWithElement;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ShopHomePage extends BasePage {

    public WebDriver driver;

    By productOne = By.linkText("Hummingbird Printed T-Shirt");
    By productTwo = By.linkText("Hummingbird Printed Sweater");
    By productThree = By.linkText("The Best Is Yet To Come'...");
    By productFour = By.linkText("The Adventure Begins Framed...");
    By productFive = By.linkText("Today Is A Good Day Framed...");
    By productSix = By.linkText("Mug The Best Is Yet To Come");
    By productSeven = By.linkText("Mug The Adventure Begins");
    By productEight = By.linkText("Mug Today Is A Good Day");
    By loginBtn = By.cssSelector("[title] .hidden-sm-down");

    public ShopHomePage() throws IOException {
        super();
    }

    public WebElement getProdOne() {
        this.driver = getDriver();
        return driver.findElement(productOne);
    }

    public WebElement getProdTwo() {
        this.driver = getDriver();
        return driver.findElement(productTwo);
    }

    public WebElement getProdThree() {
        this.driver = getDriver();
        return driver.findElement(productThree);
    }

    public WebElement getProdFour() {
        this.driver = getDriver();
        return driver.findElement(productFour);
    }

    public WebElement getProdFive() {
        this.driver = getDriver();
        return driver.findElement(productFive);
    }

    public WebElement getProdSix() {
        this.driver = getDriver();
        return driver.findElement(productSix);
    }

    public WebElement getProdSeven() {
        this.driver = getDriver();
        return driver.findElement(productSeven);
    }

    public WebElement getProdEight() {
        this.driver = getDriver();
        return driver.findElement(productEight);
    }

    public WebElement getLoginBtn() {
        this.driver = getDriver();
        return driver.findElement(loginBtn);
    }

    ActionsWithElement actions = new ActionsWithElement();

    public void openProdOne() {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getProdOne());
        actions.clickOnElement(getProdOne());
    }

    public void openProdTwo() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getProdTwo());
        actions.clickOnElement(getProdTwo());
    }
}
