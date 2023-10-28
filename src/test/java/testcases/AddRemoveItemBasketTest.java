package testcases;

import base.Hooks;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;

import java.io.IOException;

@Listeners(base.Listeners.class)
public class AddRemoveItemBasketTest extends Hooks {

    public AddRemoveItemBasketTest() throws IOException {
        super();
    }

    @Test
    public void addRemoveItem() throws IOException {
        HomePage home = new HomePage();
        home.openTestStore();

        ShopHomePage shopHome = new ShopHomePage();
        shopHome.openProdOne();

        ShopProductPage shopProduct = new ShopProductPage();
        shopProduct.increaseProductQuantity();
        shopProduct.selectSizeOption("M");
        shopProduct.addToCart();

        ShopContentPanel contentPanel = new ShopContentPanel();
        contentPanel.clickOnContinueShopping();

        ShopProductPage productPage = new ShopProductPage();
        productPage.clickOnHome();

        shopHome.openProdTwo();
        shopProduct.increaseProductQuantity();
        shopProduct.addToCart();
        contentPanel.clickOnProceedToCheckout();

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.deleteProductTwo();

        waitForElementInvisible(shoppingCart.getDeleteItemTwo(), 10);
        addBorderToElement(shoppingCart.getTotalAmount());
        Assert.assertEquals(shoppingCart.getTotalAmountText(), "$45.24");
    }

}
