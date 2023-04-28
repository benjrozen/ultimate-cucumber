package com.benjrozen.bookcartDemo.selenium.pageobjects;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @Inject
    public LoginPage(Provider<WebDriver> driver) {
        super(driver);
    }

    @FindBy(css = "[data-placeholder='Username']")
    public WebElement usernameInput;


    @FindBy(css = "[data-placeholder='Password']")
    public WebElement passwordInput;


    @FindBy(xpath = "//mat-card//*[text()='Login']")
    public WebElement loginButton;


    public void login(String baseUrl, String username, String password) {
        driver.get(baseUrl + "login");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}
