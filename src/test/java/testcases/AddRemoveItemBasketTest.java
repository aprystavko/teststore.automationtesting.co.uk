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
        extendManager.log("Starting AddRemoveItemBasketTest...");
        HomePage home = new HomePage();
        home.openTestStore();

        ShopHomePage shopHome = new ShopHomePage();
        extendManager.pass("Reached the shop homepage");
        shopHome.openProdOne();
        extendManager.pass("Have successfully opened product one");

        ShopProductPage shopProduct = new ShopProductPage();
        shopProduct.increaseProductQuantity();
        extendManager.pass("Have successfully increased quantity");
        shopProduct.selectSizeOption("M");
        extendManager.pass("Have successfully selected product size");
        shopProduct.addToCart();
        extendManager.pass("Have successfully added product to basket");

        ShopContentPanel contentPanel = new ShopContentPanel();
        contentPanel.clickOnContinueShopping();

        ShopProductPage productPage = new ShopProductPage();
        productPage.clickOnHome();
        extendManager.pass("Have successfully returned to the the shop homepage");

        shopHome.openProdTwo();
        extendManager.pass("Have successfully opened product two");
        shopProduct.increaseProductQuantity();
        extendManager.pass("Have successfully increased quantity");
        shopProduct.addToCart();
        extendManager.pass("Have successfully added product to basket");
        contentPanel.clickOnProceedToCheckout();

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.deleteProductTwo();
        extendManager.pass("Have successfully deleted product two from the basket");

        waitForElementInvisible(shoppingCart.getDeleteItemTwo(), 10);
        addBorderToElement(shoppingCart.getTotalAmount());
        Assert.assertEquals(shoppingCart.getTotalAmountText(), "$45.124");
        extendManager.pass("The total amount matches the expected amount.");
        extendManager.fail("The total amount did not match the expected amount.");
    }

}
