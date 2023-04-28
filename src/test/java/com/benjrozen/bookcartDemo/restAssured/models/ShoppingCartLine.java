package com.benjrozen.bookcartDemo.restAssured.models;

import lombok.Data;

@Data
public class ShoppingCartLine {
    Book book;
    int quantity;
}
