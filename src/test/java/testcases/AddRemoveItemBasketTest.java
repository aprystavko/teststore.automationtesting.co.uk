package testcases;

import base.ExtendManager;
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
        ExtendManager.log("Starting AddRemoveItemBasketTest...");
        HomePage home = new HomePage();
        home.openTestStore();

        ShopHomePage shopHome = new ShopHomePage();
        ExtendManager.pass("Reached the shop homepage");
        shopHome.openProdOne();
        ExtendManager.pass("Have successfully opened product one");

        ShopProductPage shopProduct = new ShopProductPage();
        shopProduct.increaseProductQuantity();
        ExtendManager.pass("Have successfully increased quantity");
        shopProduct.selectSizeOption("M");
        ExtendManager.pass("Have successfully selected product size");
        shopProduct.addToCart();
        ExtendManager.pass("Have successfully added product to basket");

        ShopContentPanel contentPanel = new ShopContentPanel();
        contentPanel.clickOnContinueShopping();

        ShopProductPage productPage = new ShopProductPage();
        productPage.clickOnHome();
        ExtendManager.pass("Have successfully returned to the the shop homepage");

        shopHome.openProdTwo();
        ExtendManager.pass("Have successfully opened product two");
        shopProduct.increaseProductQuantity();
        ExtendManager.pass("Have successfully increased quantity");
        shopProduct.addToCart();
        ExtendManager.pass("Have successfully added product to basket");
        contentPanel.clickOnProceedToCheckout();

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.deleteProductTwo();
        ExtendManager.pass("Have successfully deleted product two from the basket");

        waitForElementInvisible(shoppingCart.getDeleteItemTwo(), 10);
        addBorderToElement(shoppingCart.getTotalAmount());
        Assert.assertEquals(shoppingCart.getTotalAmountText(), "$45.124");
        ExtendManager.pass("The total amount matches the expected amount.");
        ExtendManager.fail("The total amount did not match the expected amount.");
    }

}
