package pageObjects;

import base.ActionsWithElement;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ShopContentPanel extends BasePage {

    public WebDriver driver;
    ActionsWithElement actions = new ActionsWithElement();

    By continueShoppingBtn = By.cssSelector(".btn.btn-secondary");
    By checkoutBtn = By.linkText("\uE876PROCEED TO CHECKOUT");

    public ShopContentPanel() throws IOException {
        super();
    }

    public WebElement getContinueShopBtn() {
        this.driver = getDriver();
        return driver.findElement(continueShoppingBtn);
    }

    public WebElement getCheckoutBtn() {
        this.driver = getDriver();
        return driver.findElement(checkoutBtn);
    }

    public void clickOnProceedToCheckout() {
        actions.clickOnElement(getCheckoutBtn());
    }

    public void clickOnContinueShopping() {
        getContinueShopBtn().click();
    }

}
