package com.epam.lab.decorator;

import com.epam.lab.elements.IElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ListHandler implements InvocationHandler {
    private final ElementLocator locator;
    private final Class<IElement> clazz;

    public ListHandler(ElementLocator locator,
                       Class<IElement> clazz) {
        this.locator = locator;
        this.clazz = clazz;
    }

    public Object invoke(Object object, Method method,
                         Object[] objects) throws Throwable {
        List<WebElement> elements = locator.findElements();
        List<IElement> customs = new ArrayList<>();

        for (WebElement element : elements) {
            customs.add(WrapperFactory.createInstance(clazz, element));
        }
        try {
            return method.invoke(customs, objects);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }
}
