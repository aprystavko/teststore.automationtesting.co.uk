package pageObjects;

import base.ActionsWithElement;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class OrderFormPayment extends BasePage {

    public WebDriver driver;

    By payByCheck = By.xpath("//span[.='Pay by Check']");
    By payByWire = By.xpath("//span[.='Pay by bank wire']");
    By termsAndConditions = By.xpath("//input[@id='conditions_to_approve[terms-and-conditions]']");
    By orderBtn = By.xpath("//div[@id='payment-confirmation']//button[@type='submit']");

    public OrderFormPayment() throws IOException {
        super();
    }

    public WebElement getPayByCheckRadioBtn() {
        this.driver = getDriver();
        return driver.findElement(payByCheck);
    }

    public WebElement getPayByWireRadioBtn() {
        this.driver = getDriver();
        return driver.findElement(payByWire);
    }

    public WebElement getTermsConditionsCheckbox() {
        this.driver = getDriver();
        return driver.findElement(termsAndConditions);
    }

    public WebElement getOrderBtn() {
        this.driver = getDriver();
        return driver.findElement(orderBtn);
    }

    ActionsWithElement actions = new ActionsWithElement();

    public void payByCheckAndContinue() {
        actions.clickOnRadioButton(getPayByCheckRadioBtn());
        actions.clickOnCheckbox(getTermsConditionsCheckbox());
        actions.clickOnElement(getOrderBtn());
    }
}
