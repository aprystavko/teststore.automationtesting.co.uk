package testcases;

import base.BasePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;

@Listeners(base.Listeners.class)

public class OrderCompleteTest extends BasePage {

    public OrderCompleteTest() throws IOException {
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
    public void endToEndTest() throws IOException, InterruptedException {
        HomePage home = new HomePage(driver);
        home.openTestStore();

        ShopHomePage shopHome = new ShopHomePage(driver);
        shopHome.openProdOne();

        ShopProductPage shopProduct = new ShopProductPage(driver);
        shopProduct.increaseProductQuantity();
        shopProduct.selectSizeOption("XL");
        shopProduct.addToCart();

        ShopContentPanel contentPanel = new ShopContentPanel(driver);
        contentPanel.clickOnProceedToCheckout();

        ShoppingCart cart = new ShoppingCart(driver);
        cart.addPromo("20OFF");
        cart.clickOnCheckoutBtn();

        OrderFormPersInfo personalInfo = new OrderFormPersInfo(driver);
        personalInfo.fillMandatoryFields("Mr", "John", "Smith", "test123@java.com");
        personalInfo.sendDeliveryForm();

        OrderFormDelivery orderDelivery = new OrderFormDelivery(driver);
        orderDelivery.fillMandatoryFields("Soft", "55 Big Avenue", "BigCity", "Texas", "23232");
        orderDelivery.sendAddressForm();

        OrderFormShippingMethod shippingMethod = new OrderFormShippingMethod(driver);
        shippingMethod.fillTextareaAndContinue("Lorem ipsum my delivery");

        OrderFormPayment payment = new OrderFormPayment(driver);
        payment.payByCheckAndContinue();
        Thread.sleep(5000);

    }

}

