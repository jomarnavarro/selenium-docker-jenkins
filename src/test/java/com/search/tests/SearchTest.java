package com.search.tests;

import com.tests.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchTest extends com.tests.BaseTest {

    @Test
    @Parameters({"keyword"})
    public void searchTest(String keyword) {
        searchSite.searchPage().goTo();
        searchSite.searchPage().search(keyword);
        searchSite.searchPage().goToVideos();
        assertTrue(searchSite.searchPage().getNumVideos() > 0);
    }
}
