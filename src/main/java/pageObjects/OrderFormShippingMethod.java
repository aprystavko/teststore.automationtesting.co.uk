package pageObjects;

import base.ActionsWithElement;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class OrderFormShippingMethod extends BasePage {

    public WebDriver driver;

    By deliveryMsgTextarea = By.cssSelector("textarea#delivery_message");
    By continueBtn = By.cssSelector("[name='confirmDeliveryOption']");

    public OrderFormShippingMethod() throws IOException {
        super();
    }

    public WebElement getDeliveryMsgTextarea() {
        this.driver = getDriver();
        return driver.findElement(deliveryMsgTextarea);
    }

    public WebElement getContinueBtn() {
        this.driver = getDriver();
        return driver.findElement(continueBtn);
    }

    ActionsWithElement actions = new ActionsWithElement();

    public void fillTextareaAndContinue(String msg) {
        actions.addValueToInput(getDeliveryMsgTextarea(), msg);
        actions.clickOnElement(getContinueBtn());
    }
}
