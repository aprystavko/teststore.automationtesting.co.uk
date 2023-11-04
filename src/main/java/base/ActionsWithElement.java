package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActionsWithElement {
    public WebDriver driver;
    Utils utils = new Utils();
    protected static final Logger logger = LogManager.getLogger();

    public boolean isCheckboxSelected(String checkboxLocator) {
        return driver.findElement(By.cssSelector(checkboxLocator)).isSelected();
    }

    public boolean isElementVisible(String cssLocator) {
        return driver.findElement(By.cssSelector(cssLocator)).isDisplayed();
    }

    public boolean isButtonEnabled(String buttonLocator) {
        return driver.findElement(By.cssSelector(buttonLocator)).isEnabled();
    }

    public void clickOnCheckbox(WebElement checkbox) {
        boolean checkboxStatus = checkbox.isSelected();
        if (!checkboxStatus) {
            checkbox.click();
            logger.info("Click on checkbox: " + utils.getStringWebElement(checkbox));
        } else {
            logger.info("Can't click on checkbox");
        }
    }

    public void clickOnElement(WebElement locator) {
        String elementText = locator.getText();
        if (locator.isDisplayed()) {
            locator.click();
            logger.info("Click on element " + "[" + utils.getStringWebElement(locator) + "]" + " with text " + "\"" +
                    elementText + "\"");
        } else {
            logger.info("Can't click on element " + "[" + utils.getStringWebElement(locator) + "]");
        }
    }

    public void selectMenuItem(WebElement menu, String menuItem) {
        Select option = new Select(menu);
        option.selectByVisibleText(menuItem);
        logger.info("Menu item is selected " + "[" + utils.getStringWebElement(menu) + "]" + " with value " + "\"" + menuItem + "\"");
    }

    public void clickOnRadioButton(WebElement radioButton) {
        boolean radioButtonStatus = radioButton.isEnabled();
        if (radioButtonStatus) {
            radioButton.click();
            logger.info("Click on radio button " + "[" + utils.getStringWebElement(radioButton) + "]");
        } else {
            logger.info("Can't click on radio button " + "[" + utils.getStringWebElement(radioButton) + "]");
        }
    }

    public void addValueToInput(WebElement input, String value) {
        if (input.isDisplayed()) {
            input.click();
            input.clear();
            input.sendKeys(value);
            logger.info("Added value " + "\"" + value + "\"" + " into " + "[" + utils.getStringWebElement(input) + "]");
        } else {
            logger.info("Can't add value " + "\"" + value + "\"" + "into " + "[" + utils.getStringWebElement(input) + "]");
        }
    }

}