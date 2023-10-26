package pageObjects;

import base.ActionsWithElement;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ShopProductPage extends BasePage {

    public WebDriver driver;
    ActionsWithElement actions = new ActionsWithElement();

    By sizeOption = By.cssSelector("[data-product-attribute='1']");
    By quantityIncrease = By.cssSelector(".touchspin-up");
    By quantityDecrease = By.cssSelector(".touchspin-down");
    By addToCartBtn = By.cssSelector(".add-to-cart.btn.btn-primary");
    By homepageLink = By.xpath("//span[.='Home']");

    public ShopProductPage() throws IOException {
        super();
    }

    public WebElement getSizeOption() {
        this.driver = getDriver();
        return driver.findElement(sizeOption);
    }

    public WebElement getQuantityIncrease() {
        this.driver = getDriver();
        return driver.findElement(quantityIncrease);
    }

    public WebElement getQuantityDecrease() {
        this.driver = getDriver();
        return driver.findElement(quantityDecrease);
    }

    public WebElement getAddToCartBtn() {
        this.driver = getDriver();
        return driver.findElement(addToCartBtn);
    }

    public WebElement getHomepageLink() {
        this.driver = getDriver();
        return driver.findElement(homepageLink);
    }

    public void increaseProductQuantity() {
        this.driver = getDriver();
        actions.clickOnElement(getQuantityIncrease());
    }

    public void selectSizeOption(String sizeOption) {
        this.driver = getDriver();
        actions.selectMenuItem(getSizeOption(), sizeOption);
    }

    public void addToCart() {
        this.driver = getDriver();
        actions.clickOnElement(getAddToCartBtn());
    }

    public void clickOnHome() {
        getHomepageLink().click();
    }
}
