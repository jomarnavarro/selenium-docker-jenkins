package com.flights.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BookFlightTest extends com.tests.BaseTest {

    @Test
    @Parameters({"noOfPassengers", "expectedPrice"})
    public void endToEnd(String noOfPassengers, String expectedPrice) {
        flightSite.registrationPage().goTo();
        flightSite.registrationPage().enterUserDetails("selenium", "docker");
        flightSite.registrationPage().enterUserCredentials("selenium", "docker");
        flightSite.registrationPage().submit();

        flightSite.registrationConfirmationPage().goToFlightDetailsPage();
        flightSite.flightDetailsPage().selectPassengers(noOfPassengers);
        flightSite.flightDetailsPage().goToFindFlightsPage();

        flightSite.findFlightPage().submitFindFlightPage();
        flightSite.findFlightPage().goToFlightConfirmationPage();

//        flightSite.flightConfirmationPage().printConfirmation();
        String actualPrice = flightSite.flightConfirmationPage().getPrice();
        assertEquals(actualPrice, expectedPrice);

    }
}