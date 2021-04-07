package com.search.tests;

import com.flights.pages.FlightsSite;
import com.search.pages.SearchSite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;
    protected SearchSite searchSite;
    protected String keyword;


    @BeforeTest
    @Parameters({"keyword"})
    public void setupDriver(String keyword)  {
        this.keyword = keyword;
        driver = new ChromeDriver();
        searchSite = new SearchSite(driver);
    }

    @AfterTest
    public void dismissDriver() {
        driver.quit();
    }
}