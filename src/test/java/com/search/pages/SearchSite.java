package com.search.pages;

import org.openqa.selenium.WebDriver;

public class SearchSite {

    WebDriver driver;
    SearchPage searchPage;

    public SearchSite(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPage searchPage() {
        return new SearchPage(driver);
    }
}
