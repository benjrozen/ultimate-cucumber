package com.benjrozen.bookcartDemo.selenium.pageobjects;

import com.github.javafaker.Faker;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{

    @Inject
    public CheckoutPage(Provider<WebDriver> driver) {
        super(driver);
    }

    @FindBy(css = "[formcontrolname='name']")
    public WebElement checkoutFormName;

    @FindBy(css = "[formcontrolname='addressLine1']")
    public WebElement checkoutFormAddressLine1;

    @FindBy(css = "[formcontrolname='addressLine2']")
    public WebElement checkoutFormAddressLine2;

    @FindBy(css = "[formcontrolname='pincode']")
    public WebElement checkoutFormPincode;

    @FindBy(css = "[formcontrolname='state']")
    public WebElement checkoutFormState;

    @FindBy(xpath = "//span[text()='Place Order']")
    public WebElement placeOrderButton;

    public void navigateToCheckout(String baseUrl) {
        driver.get(baseUrl + "checkout");

    }

    public void enterShippingDetailsAndCheckout(Faker faker) {
        checkoutFormName.sendKeys(faker.funnyName().name());
        checkoutFormAddressLine1.sendKeys(faker.address().streetAddress());
        checkoutFormAddressLine2.sendKeys(faker.address().cityName());
        checkoutFormPincode.sendKeys("123456");
        checkoutFormState.sendKeys(faker.address().state());

        placeOrderButton.click();
    }
}
