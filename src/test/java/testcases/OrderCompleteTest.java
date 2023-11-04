package testcases;

import base.ExtendManager;
import base.Hooks;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;

@Listeners(base.Listeners.class)

public class OrderCompleteTest extends Hooks {

    public OrderCompleteTest() throws IOException {
        super();
    }

    @Test
    public void endToEndTest() throws IOException, InterruptedException {

        ExtendManager.log("Starting OrderCompleteTest...");
        HomePage home = new HomePage();
        home.openTestStore();

        ExtendManager.pass("Have successfully reached store homepage");
        ShopHomePage shopHome = new ShopHomePage();
        ExtendManager.pass("Have successfully clicked on the product one");
        shopHome.openProdOne();

        ExtendManager.pass("Have successfully reached shop product page");
        ShopProductPage shopProduct = new ShopProductPage();
        shopProduct.increaseProductQuantity();
        ExtendManager.pass("Have successfully increased product quantity");
        shopProduct.selectSizeOption("XL");
        ExtendManager.pass("Have successfully selected product size");
        shopProduct.addToCart();
        ExtendManager.pass("Have successfully added item to cart");

        ShopContentPanel contentPanel = new ShopContentPanel();
        contentPanel.clickOnProceedToCheckout();

        ShoppingCart cart = new ShoppingCart();
        cart.addPromo("20OFF");
        ExtendManager.pass("Have successfully selected the promo button");
        cart.clickOnCheckoutBtn();
        ExtendManager.pass("Have successfully clicked the check out button");

        OrderFormPersInfo personalInfo = new OrderFormPersInfo();
        personalInfo.fillMandatoryFields("Mr", "John", "Smith", "test123@java.com");
        personalInfo.sendDeliveryForm();
        ExtendManager.pass("Have successfully entered customer details");

        OrderFormDelivery orderDelivery = new OrderFormDelivery();
        orderDelivery.fillMandatoryFields("Soft", "55 Big Avenue", "BigCity", "Texas", "23232");
        orderDelivery.sendAddressForm();
        ExtendManager.pass("Have successfully entered delivery info");

        OrderFormShippingMethod shippingMethod = new OrderFormShippingMethod();
        shippingMethod.fillTextareaAndContinue("Lorem ipsum my delivery");
        ExtendManager.pass("Have successfully selected the shipping method");

        OrderFormPayment payment = new OrderFormPayment();
        payment.payByCheckAndContinue();
        ExtendManager.pass("Have successfully placed order");

    }

}

