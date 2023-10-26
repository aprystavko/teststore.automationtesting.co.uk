package pageObjects;

import base.ActionsWithElement;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class OrderFormDelivery extends BasePage {

    public WebDriver driver;

    By firstNameField = By.cssSelector("input[name='firstname']");
    By lastNameField = By.cssSelector("input[name='lastname']");
    By companyNameField = By.cssSelector("input[name='company']");
    By addressField = By.cssSelector("input[name='address1']");
    By addressComplementField = By.cssSelector("input[name='address2']");
    By cityField = By.cssSelector("input[name='city']");
    By stateDropdown = By.cssSelector("select[name='id_state']");
    By postcodeField = By.cssSelector("input[name='postcode']");
    By countryDropdown = By.cssSelector("select[name='id_country']");
    By phoneField = By.cssSelector("input[name='phone']");
    By invoiceSameAddCheckbox = By.cssSelector("input#use_same_address");
    By continueBtn = By.cssSelector("button[name='confirm-addresses']");

    public OrderFormDelivery() throws IOException {
        super();
    }

    public WebElement getFirstNameField() {
        this.driver = getDriver();
        return driver.findElement(firstNameField);
    }

    public WebElement getLastnameField() {
        this.driver = getDriver();
        return driver.findElement(lastNameField);
    }

    public WebElement getCompanyField() {
        this.driver = getDriver();
        return driver.findElement(companyNameField);
    }

    public WebElement getAddressField() {
        this.driver = getDriver();
        return driver.findElement(addressField);
    }

    public WebElement getAddressCompField() {
        this.driver = getDriver();
        return driver.findElement(addressComplementField);
    }

    public WebElement getCityField() {
        this.driver = getDriver();
        return driver.findElement(cityField);
    }

    public WebElement getStateDropdown() {
        this.driver = getDriver();
        return driver.findElement(stateDropdown);
    }

    public WebElement getPostcodeField() {
        this.driver = getDriver();
        return driver.findElement(postcodeField);
    }

    public WebElement getCountryDropdown() {
        this.driver = getDriver();
        return driver.findElement(countryDropdown);
    }

    public WebElement getPhoneField() {
        this.driver = getDriver();
        return driver.findElement(phoneField);
    }

    public WebElement getInvoiceSameAddCheckbox() {
        this.driver = getDriver();
        return driver.findElement(invoiceSameAddCheckbox);
    }

    public WebElement getContinueBtn() {
        this.driver = getDriver();
        return driver.findElement(continueBtn);
    }

    ActionsWithElement actions = new ActionsWithElement();

    public void fillMandatoryFields(String company, String address, String city, String state, String postCode) {
        actions.addValueToInput(getCompanyField(), company);
        actions.addValueToInput(getAddressField(), address);
        actions.addValueToInput(getCityField(), city);
        actions.selectMenuItem(getStateDropdown(), state);
        actions.addValueToInput(getPostcodeField(), postCode);
    }

    public void sendAddressForm() {
        actions.clickOnElement(getContinueBtn());
    }

}

