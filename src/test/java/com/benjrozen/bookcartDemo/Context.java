package com.benjrozen.bookcartDemo;


import com.benjrozen.bookcartDemo.restAssured.models.ShoppingCartLine;
import lombok.Data;

import java.util.Optional;

@Data
public class Context {
    public String getEnvironmentVariable(String environmentVariableName) {
        return Optional.ofNullable(System.getProperty(environmentVariableName))
                       .orElse(System.getenv(environmentVariableName));
    }

    String bookcartBaseUrl = getEnvironmentVariable("BASE_URL");
    String bookcartUsername = getEnvironmentVariable("USERNAME");
    String bookcartPassword = getEnvironmentVariable("PASSWORD");

    String userId;

    ShoppingCartLine[] shoppingCart;
}
