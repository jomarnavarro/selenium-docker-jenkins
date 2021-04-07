package com.search.tests;

import com.search.tests.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    @Test
    public void searchTest() {
        searchSite.searchPage().goTo();
        searchSite.searchPage().search(this.keyword);
        searchSite.searchPage().goToVideos();
        assertTrue(searchSite.searchPage().getNumVideos() > 0);
    }
}
