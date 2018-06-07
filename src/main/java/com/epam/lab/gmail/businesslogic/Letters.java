package com.epam.lab.gmail.businesslogic;

import com.epam.lab.gmail.pageobjects.PersonalPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class Letters {
    private PersonalPage personalPage = new PersonalPage();
    private static final Logger LOGGER = LogManager.getLogger(Letters.class);


    public void deleteLetters(Integer lettersNumber) {
        LOGGER.info("Selecting {} messages from inbox using checkboxes", lettersNumber);
        personalPage.markLettersCheckbox(lettersNumber);
        LOGGER.info("Clicking on 'delete' button");
        personalPage.clickDeleteButton();
        LOGGER.info("Clicking on the undo button");
        personalPage.clickUndoButton();

    }

    public void verifyThatLettersNotDeleted() {
        LOGGER.info("Verifying that messages are not deleted");
        Assert.assertTrue(personalPage.verifyLettersNotDeleted());
    }
}
