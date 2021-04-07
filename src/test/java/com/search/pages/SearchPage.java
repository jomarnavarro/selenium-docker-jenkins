package com.search.pages;

import com.flights.pages.BasePage;
import com.flights.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(name="q")
    WebElement searchTxt;

    @FindBy(id="search_button_homepage")
    WebElement searchBtn;

    @FindBy(linkText = "Videos")
    WebElement videosLink;

    @FindBy(className = "tile--vid")
    List<WebElement> videoLinks;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        driver.get(Constants.DUCK_URL);
    }

    public void search(String keyword) {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchTxt));
        this.searchTxt.sendKeys(keyword);
        this.searchBtn.click();
    }

    public void goToVideos() {
        this.wait.until(ExpectedConditions.visibilityOf(this.videosLink)).click();
    }

    public int getNumVideos() {
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.cssSelector(".tile--vid"), 0));
        return videoLinks.size();
    }
}
