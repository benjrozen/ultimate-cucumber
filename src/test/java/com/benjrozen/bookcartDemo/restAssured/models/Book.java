package com.benjrozen.bookcartDemo.restAssured.models;

import lombok.Data;

@Data
public class Book {
    int bookId;
    String title;
    String author;
    String category;
    int price;
    String coverFileName;
}
