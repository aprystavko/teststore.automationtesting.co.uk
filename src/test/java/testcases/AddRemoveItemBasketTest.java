package testcases;

import base.BasePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;

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
    public void tearDown() {
        driver.close();
        driver = null;
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
    }

}
