package com.benjrozen.bookcartDemo.restAssured;

import com.google.inject.Inject;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.Builder;

import static io.restassured.RestAssured.given;
import static io.restassured.http.Method.*;
import static io.restassured.http.Method.DELETE;

public class RestHttp {




    RequestSpecification requestSpec;

    @Inject
    public RestHttp() {
        this.requestSpec = given();
    }


    public RestHttp spec(RequestSpecification requestSpecification) {
        requestSpec = requestSpecification;
        return this;
    }


    public RestAssuredHttp get(String url) {
        return new RestAssuredHttp(requestSpec, url, GET);
    }

    public RestAssuredHttp post(String url) {
        return new RestAssuredHttp(requestSpec, url, POST);
    }

    public RestAssuredHttp put(String url) {
        return new RestAssuredHttp(requestSpec, url, PUT);
    }

    public RestAssuredHttp delete(String url) {
        return new RestAssuredHttp(requestSpec, url, DELETE);
    }


}
