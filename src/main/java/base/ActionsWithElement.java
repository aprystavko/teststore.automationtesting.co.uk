package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionsWithElement {
    public WebDriver driver;

    public boolean isCheckboxSelected(String checkboxLocator) {
        return driver.findElement(By.cssSelector(checkboxLocator)).isSelected();
    }

    public boolean isElementVisible(String cssLocator) {
        return driver.findElement(By.cssSelector(cssLocator)).isDisplayed();
    }

    public boolean isButtonEnabled(String buttonLocator) {
        return driver.findElement(By.cssSelector(buttonLocator)).isEnabled();
    }

    public void clickOnCheckbox(String checkboxLocator) {
        boolean checkboxStatus = isCheckboxSelected(checkboxLocator);
        if (checkboxStatus) {
            driver.findElement(By.cssSelector(checkboxLocator)).click();
            System.out.println("Click on checkbox: " + checkboxLocator);
        } else {
            System.out.println("Can't uncheck checkbox");
        }
    }

    public void clickOnElement(WebElement locator) {
        String elementText = locator.getText();
        if (locator.isDisplayed()) {
            locator.click();
            System.out.println("Click on element: " + locator + " With text: " + elementText);
        } else {
            System.out.println("Can't click on element: " + locator);
        }
    }


    public void selectMenuItem(String menuLocator, String menuItem) {
        Select menuItems = new Select(driver.findElement(By.cssSelector(menuLocator)));
        menuItems.selectByVisibleText(menuItem);
        System.out.println("Menu item is selected: " + menuLocator + "with value: " + menuItem);
        menuItems.getFirstSelectedOption();
    }

    public void selectMenuItem(WebElement menu, String menuItem) {
        Select option = new Select(menu);
        option.selectByVisibleText(menuItem);
        System.out.println("Menu item is selected: " + menu + "with value: " + menuItem);
    }

    public void clickOnRadioButton(String buttonLocator) {
        boolean radioButtonStatus = driver.findElement(By.cssSelector(buttonLocator)).isDisplayed();
        if (radioButtonStatus) {
            driver.findElement(By.cssSelector(buttonLocator)).click();
            System.out.println("Click on radio button: " + buttonLocator);
        } else {
            System.out.println("Can't click on clicked radio button: " + buttonLocator);
        }
    }

}

