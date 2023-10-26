package pageObjects;

import base.ActionsWithElement;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class OrderFormPersInfo extends BasePage {

    public WebDriver driver;

    By genderMr = By.cssSelector("label:nth-of-type(1) > .custom-radio > input[name='id_gender']");
    By genderMrs = By.cssSelector("label:nth-of-type(2) > .custom-radio > input[name='id_gender']");
    By firstNameField = By.cssSelector("input[name='firstname']");
    By lastNameField = By.cssSelector("input[name='lastname']");
    By emailField = By.cssSelector("form#customer-form > section input[name='email']");
    By passwordField = By.cssSelector("form#customer-form > section input[name='password']");
    By birthDateField = By.cssSelector("input[name='birthday']");
    By receiveOffersCheckbox = By.cssSelector("div:nth-of-type(7)  span > label > span");
    By newsletterCheckbox = By.cssSelector("div:nth-of-type(8)  span > label > span");
    By termsConditionsCheckbox = By.cssSelector(".custom-checkbox input[name='psgdpr']");
    By continueBtn = By.cssSelector("form#customer-form  button[name='continue']");

    public OrderFormPersInfo() throws IOException {
        super();
    }

    public WebElement getGenderMr() {
        this.driver = getDriver();
        return driver.findElement(genderMr);
    }

    public WebElement getGenderMrs() {
        this.driver = getDriver();
        return driver.findElement(genderMrs);
    }

    public WebElement getFirstNameField() {
        this.driver = getDriver();
        return driver.findElement(firstNameField);
    }

    public WebElement getLastnameField() {
        this.driver = getDriver();
        return driver.findElement(lastNameField);
    }

    public WebElement getEmailField() {
        this.driver = getDriver();
        return driver.findElement(emailField);
    }

    public WebElement getPasswordField() {
        this.driver = getDriver();
        return driver.findElement(passwordField);
    }

    public WebElement getBirthDateField() {
        this.driver = getDriver();
        return driver.findElement(birthDateField);
    }

    public WebElement getRecOfferCheckbox() {
        this.driver = getDriver();
        return driver.findElement(receiveOffersCheckbox);
    }

    public WebElement getNewsletterCheckbox() {
        this.driver = getDriver();
        return driver.findElement(newsletterCheckbox);
    }

    public WebElement getTermsConditionsCheckbox() {
        this.driver = getDriver();
        return driver.findElement(termsConditionsCheckbox);
    }

    ActionsWithElement actions = new ActionsWithElement();

    public WebElement getContinueBtn() {
        return driver.findElement(continueBtn);
    }

    public void fillMandatoryFields(String socialTitle, String firstName, String lastName, String email) {
        if (socialTitle.equals("Mr")) {
            actions.clickOnRadioButton(getGenderMr());
        } else {
            actions.clickOnRadioButton(getGenderMrs());
        }
        actions.addValueToInput(getFirstNameField(), firstName);
        actions.addValueToInput(getLastnameField(), lastName);
        actions.addValueToInput(getEmailField(), email);
    }

    public void sendDeliveryForm() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getTermsConditionsCheckbox());
        actions.clickOnCheckbox(getTermsConditionsCheckbox());
        actions.clickOnElement(getContinueBtn());
    }

}
