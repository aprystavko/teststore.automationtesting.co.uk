package testcases;

import base.BasePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;

public class OrderCompleteTest extends BasePage {

    public OrderCompleteTest() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() throws IOException {
        driver = getDriver();
        driver.get(getUrl());
        HomePage home = new HomePage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver = null;
    }

    @Test
    public void endToEndTest() throws IOException, InterruptedException {
        HomePage home = new HomePage(driver);
        home.openTestStore();

        ShopHomePage shopHome = new ShopHomePage(driver);
        shopHome.openProdOne();

        ShopProductPage shopProduct = new ShopProductPage(driver);
        shopProduct.increaseProductQuanty();
        shopProduct.selectSizeOption("XL");
        shopProduct.addToCart();

        ShopContentPanel contentPanel = new ShopContentPanel(driver);
        contentPanel.clickOnProceedToCheckout();

        ShoppingCart cart = new ShoppingCart(driver);
        cart.addPromo("20OFF");
        cart.clickOnCheckoutBtn();
    }

}

