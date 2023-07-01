package com.benjrozen.bookcartDemo.selenium.pageobjects;

import com.google.inject.Provider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage(Provider<WebDriver> driver) {
        this.driver = driver.get();
        PageFactory.initElements(driver.get(), this);
    }
}
