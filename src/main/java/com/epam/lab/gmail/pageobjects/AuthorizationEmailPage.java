package com.epam.lab.gmail.pageobjects;

import com.epam.lab.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AuthorizationEmailPage extends PageObject {
    @FindBy(css = "input[type = 'email']")
    private WebElement emailField;
    @FindBy(id = "identifierNext")
    private WebElement submitEmailButton;

    public AuthorizationEmailPage setEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }


    public void clickSubmitButton() {
        submitEmailButton.click();
    }

}
