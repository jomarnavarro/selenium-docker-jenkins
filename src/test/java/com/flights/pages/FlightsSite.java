package com.flights.pages;

import org.openqa.selenium.WebDriver;

public class FlightsSite {

    private WebDriver driver;

    private RegistrationPage registrationPage;
    private RegistrationConfirmationPage registrationConfirmationPage;
    private FlightDetailsPage flightDetailsPage;
    private FindFlightPage findFlightPage;
    private FlightConfirmationPage flightConfirmationPage;

    public FlightsSite(WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage registrationPage() {
        return new RegistrationPage(driver);
    }

    public RegistrationConfirmationPage registrationConfirmationPage() {
        return new RegistrationConfirmationPage(driver);
    }

    public FlightDetailsPage flightDetailsPage() {
        return new FlightDetailsPage(driver);
    }

    public FindFlightPage findFlightPage() {
        return new FindFlightPage(driver);
    }

    public FlightConfirmationPage flightConfirmationPage() {
        return new FlightConfirmationPage(driver);
    }
}
