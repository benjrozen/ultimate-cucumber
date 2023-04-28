package com.benjrozen.bookcartDemo.selenium.pageobjects;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {

    @Inject
    public HomePage(Provider<WebDriver> driver) {
        super(driver);
    }

    @FindBy(css = ".mat-card-content:not(.mat-card-content.image-card)")
    public List<WebElement> bookDetailCards;

    @FindBy(css = "[alt='Book cover image']")
    public WebElement bookCoverImage;

    public void addBookToCart(String bookTitle) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(bookCoverImage));

        for (WebElement bookDetailCard : bookDetailCards) {
            if (bookDetailCard.getAttribute("innerHTML").contains(bookTitle)) {
                bookDetailCard.findElement(By.cssSelector("app-addtocart > button")).click();
            }
        }
    }
}
