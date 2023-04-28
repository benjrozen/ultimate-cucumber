package com.benjrozen.bookcartDemo.stepdefinitions;

import com.benjrozen.bookcartDemo.Context;
import com.benjrozen.bookcartDemo.selenium.pageobjects.CheckoutPage;
import com.benjrozen.bookcartDemo.selenium.pageobjects.HomePage;
import com.benjrozen.bookcartDemo.selenium.pageobjects.LoginPage;
import com.benjrozen.bookcartDemo.selenium.pageobjects.OrdersPage;
import com.github.javafaker.Faker;
import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderBookUiFlow {

    Context context;
    LoginPage loginPage;
    HomePage homePage;
    CheckoutPage checkoutPage;
    OrdersPage ordersPage;

    @Inject
    public OrderBookUiFlow(Context context,
                           LoginPage loginPage,
                           HomePage homePage,
                           CheckoutPage checkoutPage,
                           OrdersPage ordersPage) {
        this.context = context;
        this.loginPage = loginPage;
        this.homePage = homePage;
        this.checkoutPage = checkoutPage;
        this.ordersPage = ordersPage;
    }


    @Given("the user is logged in")
    public void theUserHasLoggedIn() {
        loginPage.login(context.getBookcartBaseUrl(), context.getBookcartUsername(), context.getBookcartPassword());
    }

    @When("the user adds book {string} to cart from homepage")
    public void theAddsBookToCartFromHomepage(String bookTitle) {
        homePage.addBookToCart(bookTitle);
    }

    @And("completes checkout flow")
    public void completesCheckoutFlow() {
        checkoutPage.navigateToCheckout(context.getBookcartBaseUrl());

        Faker faker = new Faker();
        checkoutPage.enterShippingDetailsAndCheckout(faker);
    }

    @Then("he should be notified that the order was placed successfully")
    public void heShouldBeNotifiedThatTheOrderWasPlacedSuccessfully() {
        ordersPage.verifyOrderSuccess();
    }

}
