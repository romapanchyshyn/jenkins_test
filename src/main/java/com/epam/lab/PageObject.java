package com.epam.lab;

import com.epam.lab.decorator.MyFieldDecorator;
import com.epam.lab.utiles.Driver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public abstract class PageObject {

    public PageObject() {
        PageFactory.initElements(
                new MyFieldDecorator(
                        new DefaultElementLocatorFactory(Driver.getWebDriver())
                ), this);
    }

}
