package com.epam.lab.gmail.businesslogic;

import com.epam.lab.gmail.pageobjects.AuthorizationEmailPage;
import com.epam.lab.gmail.pageobjects.AuthorizationPasswordPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Login {
    private static final Logger LOGGER = LogManager.getLogger(Letters.class);

    public void login(String email, String password) {
        LOGGER.info("Authorization on Gmail");
        AuthorizationEmailPage authorizationEmailPage = new AuthorizationEmailPage();
        authorizationEmailPage.setEmail(email);
        authorizationEmailPage.clickSubmitButton();
        AuthorizationPasswordPage authorizationPasswordPage = new AuthorizationPasswordPage();
        authorizationPasswordPage.setPassword(password);
        authorizationPasswordPage.clickSubmitButton();
    }
}
