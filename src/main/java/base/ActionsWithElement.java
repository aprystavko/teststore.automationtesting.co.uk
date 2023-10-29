package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionsWithElement {
    public WebDriver driver;
    Utils utils = new Utils();

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
            System.out.println("Click on checkbox: " + utils.getStringWebElement(checkbox));
        } else {
            System.out.println("Can't click on checkbox");
        }
    }

    public void clickOnElement(WebElement locator) {
        String elementText = locator.getText();
        if (locator.isDisplayed()) {
            locator.click();
            System.out.println("Click on element " + "[" + utils.getStringWebElement(locator) + "]" + " with text " + "\"" +
                    elementText + "\"");
        } else {
            System.out.println("Can't click on element " + "[" + utils.getStringWebElement(locator) + "]");
        }
    }

    public void selectMenuItem(WebElement menu, String menuItem) {
        Select option = new Select(menu);
        option.selectByVisibleText(menuItem);
        System.out.println("Menu item is selected " + "[" + utils.getStringWebElement(menu) + "]" + " with value " + "\"" + menuItem + "\"");
    }

    public void clickOnRadioButton(WebElement radioButton) {
        boolean radioButtonStatus = radioButton.isEnabled();
        if (radioButtonStatus) {
            radioButton.click();
            System.out.println("Click on radio button " + "[" + utils.getStringWebElement(radioButton) + "]");
        } else {
            System.out.println("Can't click on radio button " + "[" + utils.getStringWebElement(radioButton) + "]");
        }
    }

    public void addValueToInput(WebElement input, String value) {
        if (input.isDisplayed()) {
            input.click();
            input.clear();
            input.sendKeys(value);
            System.out.println("Added value " + "\"" + value + "\"" + " into " + "[" + utils.getStringWebElement(input) + "]");
        } else {
            System.out.println("Can't add value " + "\"" + value + "\"" + "into " + "[" + utils.getStringWebElement(input) + "]");
        }
    }

}

