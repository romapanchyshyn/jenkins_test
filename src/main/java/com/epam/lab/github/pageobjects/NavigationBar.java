package com.epam.lab.github.pageobjects;

import com.epam.lab.elements.TextField;
import com.epam.lab.PageObject;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends PageObject {
    @FindBy(name = "q")
    private TextField searchField;

    public void setSerchQuery(String query) {
        searchField.clear();
        searchField.sendKeys(query, "\n");
    }
}
