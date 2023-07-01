package com.benjrozen.bookcartDemo.restAssured;

import com.benjrozen.bookcartDemo.restAssured.models.ShoppingCartLine;
import com.benjrozen.bookcartDemo.restAssured.requests.CheckoutRequest;
import com.benjrozen.bookcartDemo.restAssured.requests.LoginRequest;
import com.benjrozen.bookcartDemo.restAssured.responses.LoginResponse;
import com.google.inject.Inject;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static io.restassured.config.LogConfig.logConfig;

public class BookCartApiExecutor {

    RestHttp http;
    String token;

    @Inject
    public BookCartApiExecutor(RestHttp http) {
        this.http = http;
    }

    RequestSpecification baseSpecification() {
        return given().baseUri("https://bookcart.azurewebsites.net/api/")
                      .header("Content-Type", "application/json");
    }

    private RestHttp baseSpec() {
        return http.spec(baseSpecification());
    }

    private RestHttp authenticatedSpec() {
        return baseSpec().spec(baseSpecification().config(config().logConfig(logConfig().blacklistHeader("Authorization")))
                         .header("Authorization", "bearer " + token));
    }

    @SneakyThrows
    public LoginResponse login(String bookcartUsername, String bookcartPassword) {
        LoginRequest loginPayload = LoginRequest.builder()
                                                .username(bookcartUsername)
                                                .password(bookcartPassword)
                                                .build();

        LoginResponse loginResponse = baseSpec().post("Login")
                                                .payload(loginPayload)
                                                .execute(LoginResponse.class);
        token = loginResponse.getToken();
        return loginResponse;
    }

    public void addBookToCart(String userId, String bookId) {
        authenticatedSpec().post(String.format("shoppingcart/addToCart/%s/%s", userId, bookId))
                           .execute();
    }

    public ShoppingCartLine[] getCartDetails(String userId) {
        return authenticatedSpec().get("shoppingcart/" + userId)
                                  .execute(ShoppingCartLine[].class);
    }

    public void checkout(String userId, ShoppingCartLine[] shoppingCart) {
        CheckoutRequest orderDetails = CheckoutRequest.builder()
                                                      .shoppingCart(shoppingCart).build();
        authenticatedSpec().post("CheckOut/" + userId)
                           .payload(orderDetails)
                           .execute();
    }
}
