package pageObjects;

import base.ActionsWithElement;
import base.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShoppingCart {

    public WebDriver driver;

    By havePromo = By.cssSelector(".promo-code-button .collapse-button");
    By promoTextBox = By.cssSelector("input[name='discount_name']");
    By promoAddBtn = By.cssSelector(".promo-code button");
    By proceedToCheckoutBtn = By.cssSelector(".cart-detailed-actions .btn-primary");
    By deleteItemOne = By.cssSelector(".cart-items .cart-item:nth-of-type(1) .float-xs-left");
    By deleteItemTwo = By.cssSelector(".cart-items .cart-item:nth-of-type(2) .float-xs-left");
    By totalValue = By.cssSelector(".cart-total .value");
    By clickOnHome = By.cssSelector("ol > li:nth-of-type(1) > a > span");

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHavePromo() {
        return driver.findElement(havePromo);
    }

    public WebElement getPromoTextBox() {
        return driver.findElement(promoTextBox);
    }

    public WebElement getPromoAddBtn() {
        return driver.findElement(promoAddBtn);
    }

    public WebElement getProceedCheckoutBtn() {
        return driver.findElement(proceedToCheckoutBtn);
    }

    public WebElement getDeleteItemOne() {
        return driver.findElement(deleteItemOne);
    }

    public WebElement getDeleteItemTwo() {
        return driver.findElement(deleteItemTwo);
    }

    public WebElement getTotalAmount() {
        return driver.findElement(totalValue);
    }

    public WebElement getClickOnHome() {
        return driver.findElement(clickOnHome);
    }

    ActionsWithElement actions = new ActionsWithElement();

    public void addPromo(String promoCode) throws InterruptedException {
        actions.clickOnElement(getHavePromo());
        getPromoTextBox().clear();
        getPromoTextBox().sendKeys(promoCode);
        actions.clickOnElement(getPromoAddBtn());
    }

    public void clickOnCheckoutBtn() {
        actions.clickOnElement(getProceedCheckoutBtn());
    }

    public void deleteProductTwo() {
        actions.clickOnElement(getDeleteItemTwo());
    }

    public String getTotalAmountText() {
        return getTotalAmount().getText();
    }

}
