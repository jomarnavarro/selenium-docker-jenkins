package com.flights.tests;

import com.flights.pages.FlightsSite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;
    protected FlightsSite flightSite;
    protected String noOfPassengers;
    protected String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers", "expectedPrice"})
    public void setupDriver(String noOfPassengers, String expectedPrice)  {
        this.noOfPassengers = noOfPassengers;
        this.expectedPrice = expectedPrice;
        driver = new ChromeDriver();
        flightSite = new FlightsSite(driver);
    }

    @AfterTest
    public void dismissDriver() {
        driver.quit();
    }
}