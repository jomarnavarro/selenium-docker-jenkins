package com.tests;

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
    protected FlightsSite flightSite;


    @BeforeTest
    public void setupDriver()  {
        driver = new ChromeDriver();
        searchSite = new SearchSite(driver);
        flightSite = new FlightsSite(driver);
    }

    @AfterTest
    public void dismissDriver() {
        driver.quit();
    }
}