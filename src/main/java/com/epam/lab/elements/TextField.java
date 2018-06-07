package com.epam.lab.elements;

import org.openqa.selenium.WebElement;

public class TextField extends Element {

    public TextField(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(String... smth) {
        webElement.sendKeys(smth);
    }

    public void clear() {
        webElement.clear();
    }
}
