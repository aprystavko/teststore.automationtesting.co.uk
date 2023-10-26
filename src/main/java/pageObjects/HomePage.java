package pageObjects;

import base.ActionsWithElement;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class HomePage extends BasePage {

    public WebDriver driver;

    By toggle = By.cssSelector(".toggle");
    By homeLink = By.linkText("HOMEPAGE");
    By accordionLink = By.linkText("ACCORDION");
    By browserTabLink = By.linkText("BROWSER TABS");
    By buttonsLink = By.linkText("BUTTONS");
    By calcLink = By.linkText("CALCULATOR (JS)");
    By contactUsLink = By.linkText("CONTACT US FORM TEST");
    By datePickerLink = By.linkText("DATE PICKER");
    By dropdownLink = By.linkText("DROPDOWN CHECKBOX & RADIO");
    By fileUpload = By.linkText("FILE UPLOAD");
    By hiddenElementsLink = By.linkText("HIDDEN ELEMENTS");
    By iFrameLink = By.linkText("IFRAME");
    By loaderLink = By.linkText("LOADER");
    By loginPortalLink = By.linkText("LOGIN PORTAL TEST");
    By mouseLink = By.linkText("MOUSE MOVEMENT");
    By popupLink = By.linkText("POP UPS & ALERTS");
    By predictiveLink = By.linkText("PREDICTIVE SEARCH");
    By tablesLink = By.linkText("TABLES");
    By testStoreLink = By.linkText("TEST STORE");
    By aboutMeLink = By.linkText("ABOUT ME");
    By cookie = By.cssSelector(".close-cookie-warning > span");

    public HomePage() throws IOException {
        super();
    }

    public WebElement getToggle() {
        this.driver = getDriver();
        return driver.findElement(toggle);
    }

    public WebElement getHomepageLink() {
        this.driver = getDriver();
        return driver.findElement(homeLink);
    }

    public WebElement getAccordionLink() {
        this.driver = getDriver();
        return driver.findElement(accordionLink);
    }

    public WebElement getBrowserTabLink() {
        this.driver = getDriver();
        return driver.findElement(browserTabLink);
    }

    public WebElement getButtonLink() {
        this.driver = getDriver();
        return driver.findElement(buttonsLink);
    }

    public WebElement getCalcLink() {
        this.driver = getDriver();
        return driver.findElement(calcLink);
    }

    public WebElement getContactUsLink() {
        this.driver = getDriver();
        return driver.findElement(contactUsLink);
    }

    public WebElement getDatePickerLink() {
        this.driver = getDriver();
        return driver.findElement(datePickerLink);
    }

    public WebElement getDropdownLink() {
        this.driver = getDriver();
        return driver.findElement(dropdownLink);
    }

    public WebElement getFileUploadLink() {
        this.driver = getDriver();
        return driver.findElement(fileUpload);
    }

    public WebElement getHiddenElementsLink() {
        this.driver = getDriver();
        return driver.findElement(hiddenElementsLink);
    }

    public WebElement getIframeLink() {
        this.driver = getDriver();
        return driver.findElement(iFrameLink);
    }

    public WebElement getLoaderLink() {
        this.driver = getDriver();
        return driver.findElement(loaderLink);
    }

    public WebElement getLoginPortalLink() {
        this.driver = getDriver();
        return driver.findElement(loginPortalLink);
    }

    public WebElement getMouseLink() {
        this.driver = getDriver();
        return driver.findElement(mouseLink);
    }

    public WebElement getPopupLink() {
        this.driver = getDriver();
        return driver.findElement(popupLink);
    }

    public WebElement getPredictiveLink() {
        this.driver = getDriver();
        return driver.findElement(predictiveLink);
    }

    public WebElement getTablesLink() {
        this.driver = getDriver();
        return driver.findElement(tablesLink);
    }

    public WebElement getTestStoreLink() {
        this.driver = getDriver();
        return driver.findElement(testStoreLink);
    }

    public WebElement getAboutMeLink() {
        this.driver = getDriver();
        return driver.findElement(aboutMeLink);
    }

    public WebElement getCookie() throws IOException {
        this.driver = getDriver();
        return driver.findElement(cookie);
    }

    ActionsWithElement actions = new ActionsWithElement();

    public void closeCookie() throws IOException {
        actions.clickOnElement(getCookie());
    }

    public void openTestStore() throws IOException {
        closeCookie();
        actions.clickOnElement(getToggle());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getTestStoreLink());
        getTestStoreLink().click();

    }


}

