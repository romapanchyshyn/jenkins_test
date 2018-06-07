package com.epam.lab.github.pageobjects;

import com.epam.lab.elements.Label;
import com.epam.lab.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject {
    @FindBy(className = "octicon-three-bars")
    private WebElement menu;
    @FindBy(css = "[href='/login']")
    private WebElement loginField;
    @FindBy(css = "[for='user[login]']")
    private Label userName;

    public void doSmthWithUserName() {
        System.out.println(userName.getId());
        System.out.println("Is text present:" + userName.isLableEmpty());

    }

    public void openMenu() {
        menu.click();
    }

    public void clickOnLogInField() {
        loginField.click();
    }


}
