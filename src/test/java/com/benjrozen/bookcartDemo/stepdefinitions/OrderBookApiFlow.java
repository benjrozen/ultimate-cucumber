package com.benjrozen.bookcartDemo.stepdefinitions;

import com.benjrozen.bookcartDemo.Context;
import com.benjrozen.bookcartDemo.restAssured.BookCartApiExecutor;
import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.val;

public class OrderBookApiFlow {

    Context context;
    BookCartApiExecutor bookCartApiExecutor;

    @Inject
    public OrderBookApiFlow(Context context, BookCartApiExecutor bookCartApiExecutor) {
        this.context = context;
        this.bookCartApiExecutor = bookCartApiExecutor;
    }

    @Given("the user is authenticated")
    public void theUserIsAuthenticatedForFlow() {
        val loginResponse = bookCartApiExecutor.login(context.getBookcartUsername(), context.getBookcartPassword());

        context.setUserId(String.valueOf(loginResponse.getUserDetails().getUserId()));
    }

    @And("he adds bookId {string} to cart")
    public void addBookToCart(String bookId) {
        bookCartApiExecutor.addBookToCart(context.getUserId(), bookId);

        val getShoppingCart = bookCartApiExecutor.getCartDetails(context.getUserId());

        context.setShoppingCart(getShoppingCart);
    }

    @When("he completes checkout")
    public void heCompletesCheckout() {
        bookCartApiExecutor.checkout(context.getUserId(), context.getShoppingCart());
    }
}
