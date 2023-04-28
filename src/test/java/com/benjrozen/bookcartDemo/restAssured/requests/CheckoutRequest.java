package com.benjrozen.bookcartDemo.restAssured.requests;


import com.benjrozen.bookcartDemo.restAssured.models.ShoppingCartLine;
import lombok.Builder;
import lombok.Data;

import java.util.Arrays;

@Data
public class CheckoutRequest {

    ShoppingCartLine[] shoppingCart;
    int cartTotal;


    @Builder
    public CheckoutRequest(ShoppingCartLine[] shoppingCart) {
        this.shoppingCart = shoppingCart;
        this.cartTotal = Arrays.stream(shoppingCart).mapToInt(bookDetail -> bookDetail.getBook().getPrice()).sum();
    }
}
