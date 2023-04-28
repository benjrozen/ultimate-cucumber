package com.benjrozen.bookcartDemo.stepdefinitions;

import com.google.inject.Inject;
import com.google.inject.Provider;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class TestHook {
    protected WebDriver driver;

    @Inject
    public TestHook(Provider<WebDriver> driver) {
        this.driver = driver.get();
    }

    @After("@selenium")
    public void after(){
        driver.quit();
    }
}
