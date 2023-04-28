package com.benjrozen.bookcartDemo.selenium.pageobjects;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrdersPage extends BasePage{

    @Inject
    public OrdersPage(Provider<WebDriver> driver) {
        super(driver);
    }

    @FindBy(xpath = "//simple-snack-bar//span[text()='Order placed successfully!!!']")
    public WebElement successfulOrderSnackbar;


    public void verifyOrderSuccess() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(successfulOrderSnackbar));
    }
}
