package com.epam.lab.github.pageobjects;

import com.epam.lab.elements.Button;
import com.epam.lab.elements.TextField;
import com.epam.lab.PageObject;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends PageObject {
    @FindBy(id = "login_field")
    private TextField loginField;
    @FindBy(id = "password")
    private TextField passwordField;
    @FindBy(name = "commit")
    private Button submitButton;


    public AuthorizationPage setLogin(String email) {
        loginField.sendKeys(email);
        return this;
    }

    public AuthorizationPage setPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public void clickSubmmitButton() {
        submitButton.click();
    }

}
