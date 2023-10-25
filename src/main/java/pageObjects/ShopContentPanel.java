package pageObjects;

import base.ActionsWithElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopContentPanel {

    public WebDriver driver;
    ActionsWithElement actions = new ActionsWithElement();

    By continueShoppingBtn = By.cssSelector(".btn.btn-secondary");
    By checkoutBtn = By.linkText("\uE876PROCEED TO CHECKOUT");

    public ShopContentPanel(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getContinueShopBtn() {
        return driver.findElement(continueShoppingBtn);
    }

    public WebElement getCheckoutBtn() {
        return driver.findElement(checkoutBtn);
    }

    public void clickOnProceedToCheckout() {
        actions.clickOnElement(getCheckoutBtn());
    }

    public void clickOnContinueShopping() {
        getContinueShopBtn().click();
    }

}
