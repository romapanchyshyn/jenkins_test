package com.epam.lab.github.businesslogic;

import com.epam.lab.github.pageobjects.NavigationBar;
import com.epam.lab.github.pageobjects.SearchResultPage;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Search {
    private static final String PRINT_RESULTS = "Printing results";
    private static final Logger LOGGER = LogManager.getLogger(Login.class);
    NavigationBar navigationBar = new NavigationBar();
    SearchResultPage searchResultPage = new SearchResultPage();

    public void searchText(String text) {
        LOGGER.info("4) In search input type '{}'", text);
        navigationBar.setSerchQuery(text);
    }

    public void printResults() {
        LOGGER.info("5) {}", PRINT_RESULTS);
        searchResultPage.printResults(LOGGER);
    }

    public void changeSorting(Integer number) {
        LOGGER.info("7) Changing sorting to other dropdown value");
        searchResultPage.openSortingBar();
        searchResultPage.chooseSortingOption(number);
    }

    public void verifiingTagForSearchResults(String tag) {
        LOGGER.info("Verifying that all search results has tag {}", tag);
        Assert.assertTrue(searchResultPage.isTagInAllResults(tag));
    }
}
