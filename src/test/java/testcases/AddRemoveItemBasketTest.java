package testcases;

import base.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;

@Listeners(base.Listeners.class)

public class AddRemoveItemBasketTest extends BasePage {

    public AddRemoveItemBasketTest() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() throws IOException {
        driver = getDriver();
        driver.get(getUrl());
    }

    @AfterTest
    public void afterTest() {
        if (driver != null) {
            try {
                takeSnapShot("Test_Failure_Screenshot");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                driver.quit();
                driver = null;
            }
        }
    }

    @Test
    public void addRemoveItem() throws IOException, InterruptedException {
        HomePage home = new HomePage(driver);
        home.openTestStore();

        ShopHomePage shopHome = new ShopHomePage(driver);
        shopHome.openProdOne();

        ShopProductPage shopProduct = new ShopProductPage(driver);
        shopProduct.increaseProductQuantity();
        shopProduct.selectSizeOption("M");
        shopProduct.addToCart();

        ShopContentPanel contentPanel = new ShopContentPanel(driver);
        contentPanel.clickOnContinueShopping();

        ShopProductPage productPage = new ShopProductPage(driver);
        productPage.clickOnHome();

        shopHome.openProdTwo();
        shopProduct.increaseProductQuantity();
        shopProduct.addToCart();
        contentPanel.clickOnProceedToCheckout();

        ShoppingCart shoppingCart = new ShoppingCart(driver);
        shoppingCart.deleteProductTwo();

        System.out.println(shoppingCart.getTotalAmountText());
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.invisibilityOf(shoppingCart.getDeleteItemTwo()));
        Assert.assertEquals(shoppingCart.getTotalAmountText(), "$45.214");
    }

}
