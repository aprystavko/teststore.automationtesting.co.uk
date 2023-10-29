package testcases;

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

        extendManager.log("Starting OrderCompleteTest...");
        HomePage home = new HomePage();
        home.openTestStore();

        extendManager.pass("Have successfully reached store homepage");
        ShopHomePage shopHome = new ShopHomePage();
        extendManager.pass("Have successfully clicked on the product one");
        shopHome.openProdOne();

        extendManager.pass("Have successfully reached shop product page");
        ShopProductPage shopProduct = new ShopProductPage();
        shopProduct.increaseProductQuantity();
        extendManager.pass("Have successfully increased product quantity");
        shopProduct.selectSizeOption("XL");
        extendManager.pass("Have successfully selected product size");
        shopProduct.addToCart();
        extendManager.pass("Have successfully added item to cart");

        ShopContentPanel contentPanel = new ShopContentPanel();
        contentPanel.clickOnProceedToCheckout();

        ShoppingCart cart = new ShoppingCart();
        cart.addPromo("20OFF");
        extendManager.pass("Have successfully selected the promo button");
        cart.clickOnCheckoutBtn();
        extendManager.pass("Have successfully clicked the check out button");

        OrderFormPersInfo personalInfo = new OrderFormPersInfo();
        personalInfo.fillMandatoryFields("Mr", "John", "Smith", "test123@java.com");
        personalInfo.sendDeliveryForm();
        extendManager.pass("Have successfully entered customer details");

        OrderFormDelivery orderDelivery = new OrderFormDelivery();
        orderDelivery.fillMandatoryFields("Soft", "55 Big Avenue", "BigCity", "Texas", "23232");
        orderDelivery.sendAddressForm();
        extendManager.pass("Have successfully entered delivery info");

        OrderFormShippingMethod shippingMethod = new OrderFormShippingMethod();
        shippingMethod.fillTextareaAndContinue("Lorem ipsum my delivery");
        extendManager.pass("Have successfully selected the shipping method");

        OrderFormPayment payment = new OrderFormPayment();
        payment.payByCheckAndContinue();
        extendManager.pass("Have successfully placed order");

    }

}

