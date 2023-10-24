package pageObjects;

import base.ActionsWithElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderFormShippingMethod {

    public WebDriver driver;

    By deliveryMsgTextarea = By.cssSelector("textarea#delivery_message");
    By continueBtn = By.cssSelector("[name='confirmDeliveryOption']");

    public OrderFormShippingMethod(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDeliveryMsgTextarea() {
        return driver.findElement(deliveryMsgTextarea);
    }

    public WebElement getContinueBtn() {
        return driver.findElement(continueBtn);
    }

    ActionsWithElement actions = new ActionsWithElement();

    public void fillTextareaAndContinue(String msg) {
        actions.addValueToInput(getDeliveryMsgTextarea(), msg);
        actions.clickOnElement(getContinueBtn());
    }
}
