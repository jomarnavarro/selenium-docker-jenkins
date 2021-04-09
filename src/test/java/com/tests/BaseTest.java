package com.tests;

import com.flights.pages.FlightsSite;
import com.search.pages.SearchSite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;
    protected SearchSite searchSite;
    protected FlightsSite flightSite;


    @BeforeTest
    public void setupDriver() throws MalformedURLException {
        //BROWSER is either firefox or chrome
        //HUB_HOST is a hostname, like localhost, or host ip

        String host = "localhost";
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        if(System.getProperty("BROWSER") != null
            && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            dc = DesiredCapabilities.firefox();
        }

        if(System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        String completeURL = String.format("http://%s:4444/wd/hub", host);
        driver = new RemoteWebDriver(new URL(completeURL), dc);
        searchSite = new SearchSite(driver);
        flightSite = new FlightsSite(driver);
    }

    @AfterTest
    public void dismissDriver() {
        driver.quit();
    }
}