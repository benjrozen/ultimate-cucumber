package com.benjrozen.bookcartDemo.selenium.webdriver;

import com.google.inject.Provider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverProvider implements Provider<WebDriver> {

    public WebDriver get() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions());
    }

    private ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        return options;
    }
}
