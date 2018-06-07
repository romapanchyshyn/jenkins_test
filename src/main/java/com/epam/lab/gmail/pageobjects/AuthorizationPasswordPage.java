package com.epam.lab.gmail.pageobjects;

import com.epam.lab.PageObject;
import com.epam.lab.utiles.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationPasswordPage extends PageObject{
    @FindBy(css = "input[type = 'password']")
    private WebElement passwordField;
    @FindBy(id = "passwordNext")
    private WebElement submitPasswordButton;
    private WebDriver driver;
    private WebDriverWait wait = new WebDriverWait(Driver.getWebDriver(), 7);

    public AuthorizationPasswordPage setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
        return this;
    }

    public void clickSubmitButton() {
        submitPasswordButton.click();
    }
}
