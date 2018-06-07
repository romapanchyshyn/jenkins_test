package com.epam.lab.decorator;

import com.epam.lab.elements.IElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.*;
import java.util.List;

public class MyFieldDecorator extends DefaultFieldDecorator {

    public MyFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        Class<IElement> decoratableClass = decoratableClass(field);
        if (decoratableClass != null) {
            ElementLocator locator = factory.createLocator(field);
            if (locator == null) {
                return null;
            }

            if (List.class.isAssignableFrom(field.getType())) {
                return createList(loader, locator, decoratableClass);
            }

            return createElement(loader, locator, decoratableClass);
        }
        return super.decorate(loader, field);
    }


    private Class<IElement> decoratableClass(Field field) {

        Class<?> clazz = field.getType();

        if (List.class.isAssignableFrom(clazz)) {

            if (field.getAnnotation(FindBy.class) == null &&
                    field.getAnnotation(FindBys.class) == null &&
                    field.getAnnotation(FindAll.class) == null) {
                return null;
            }

            Type genericType = field.getGenericType();
            if (!(genericType instanceof ParameterizedType)) {
                return null;
            }

            clazz = (Class<?>) ((ParameterizedType) genericType).
                    getActualTypeArguments()[0];
        }

        if (IElement.class.isAssignableFrom(clazz)) {
            return (Class<IElement>) clazz;
        } else {
            return null;
        }
    }


    private IElement createElement(ClassLoader loader,
                                   ElementLocator locator,
                                   Class<IElement> clazz) {
        WebElement proxy = proxyForLocator(loader, locator);
        return WrapperFactory.createInstance(clazz, proxy);
    }


    private List<IElement> createList(ClassLoader loader,
                                      ElementLocator locator,
                                      Class<IElement> clazz) {
        InvocationHandler handler = new ListHandler(locator, clazz);
        List<IElement> elements =
                (List<IElement>) Proxy.newProxyInstance(
                        loader, new Class[]{List.class}, handler);
        return elements;
    }
}

