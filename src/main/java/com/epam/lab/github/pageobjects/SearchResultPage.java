package com.epam.lab.github.pageobjects;

import com.epam.lab.elements.Label;
import com.epam.lab.PageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends PageObject {
    @FindBy(css = "h3 a")
    private List<Label> resultTitles;

    @FindBy(className = "select-menu-button")
    private WebElement sortingBar;

    @FindBy(className = "select-menu-item")
    private List<WebElement> searhcOptions;

    @FindBy(css = "div[class = 'd-flex flex-justify-between border-bottom pb-3'] > h3")
    private WebElement totalResultCount;

    @FindBy(css = "div[class='repo-list-item d-flex flex-justify-start py-4 public source']")
    private List<WebElement> resultSections;

    @FindBy(css = "div[class = 'topics-row-container col-9 d-inline-flex flex-wrap flex-items-center f6 my-1']")
    private List<WebElement> tagSections;

    public void openSortingBar() {
        sortingBar.click();
    }

    public void chooseSortingOption(int optionNumber) {
        searhcOptions.get(optionNumber).click();
    }

    public void printResults(Logger logger) {
        resultTitles.forEach(x -> logger.info(x.getText()));
        logger.info(String.format("%s \n", totalResultCount.getText()));
    }

    public boolean isTagInAllResults(String tag) {
        if (resultSections.size() != tagSections.size())
            return false;
        return resultSections.stream().allMatch((x) -> x.findElement(By
                .cssSelector("div[class = 'topics-row-container col-9 d-inline-flex flex-wrap flex-items-center f6 my-1']"))
                .getText().contains(tag));
    }
}
