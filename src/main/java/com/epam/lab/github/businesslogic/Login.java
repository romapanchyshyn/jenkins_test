package com.epam.lab.github.businesslogic;

import com.epam.lab.github.pageobjects.AuthorizationPage;
import com.epam.lab.github.pageobjects.MainPage;
import com.epam.lab.utiles.Driver;
import junit.framework.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Login {
    private static final Logger LOGGER = LogManager.getLogger(Login.class);

    public void login(String name, String password) {
        String siteGitHub = "https://github.com/";
        AuthorizationPage authorizationPage = new AuthorizationPage();
        MainPage mainPage = new MainPage();
//        mainPage.openMenu();
        LOGGER.info(" Clicking sign in to GitHub");
        mainPage.clickOnLogInField();
        LOGGER.info(" Typing login and password and clicking sign in");
        authorizationPage.setLogin(name);
        authorizationPage.setPassword(password);
        authorizationPage.clickSubmmitButton();
        LOGGER.info(" Verifying that test has successfully signed in");
        Assert.assertEquals(Driver.getWebDriver().getCurrentUrl(), siteGitHub);
    }

}
