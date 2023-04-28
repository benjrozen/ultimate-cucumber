package com.benjrozen.bookcartDemo.restAssured;

import com.benjrozen.bookcartDemo.logging.ObjectMappingProvider;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Method;
import io.restassured.internal.mapping.Jackson2Mapper;
import io.restassured.parsing.Parser;
import io.restassured.path.json.mapper.factory.Jackson2ObjectMapperFactory;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import lombok.Builder;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.val;

import java.lang.reflect.Type;
import java.util.HashMap;

import static com.benjrozen.bookcartDemo.logging.Log.Log;
import static io.restassured.RestAssured.given;

public class RestAssuredHttp {


    RequestSpecification requestSpec;
    String url;
    Method httpMethod;
    Object payload;



    public RestAssuredHttp(RequestSpecification requestSpec, String url, Method httpMethod) {
        this.requestSpec = requestSpec;
        this.url = url;
        this.httpMethod = httpMethod;
    }

    protected RestAssuredHttp header(String key, String value) {
        return new RestAssuredHttp(requestSpec.header(key, value), url, httpMethod);
    }

    protected RestAssuredHttp headers(HashMap<String, String> headers) {
        return new RestAssuredHttp(requestSpec.headers(headers), url, httpMethod);
    }

    @SneakyThrows
    protected <T> RestAssuredHttp payload(T payload) {
     //   this.payload = new RestAssuredHttp(payload);
        return new RestAssuredHttp(requestSpec.body(payload), url, httpMethod).savePayload(payload);
    }

    @SneakyThrows
    public <T> RestAssuredHttp savePayload(T payload) {
        this.payload = payload;
        return this;
    }


    protected void execute() {
        logRequest();
        Response response = requestSpec.request(httpMethod, url);
        logPayload(this.payload);
        logRawResponse(response);
    }

    protected <T> T execute(Class<T> responseClass) {
        logRequest();
        T response = requestSpec.request(httpMethod, url).getBody().as(responseClass);

       logPayload(this.payload);
        logResponse(response);
        return response;
    }

    private void logRequest() {
        requestSpec.log().method();
        requestSpec.log().uri();
        requestSpec.log().headers();
    }

    @SneakyThrows
    private <T> void logPayload(T payloadObject) {
        if (payloadObject != null) {
            val json = new ObjectMappingProvider().get().writerWithDefaultPrettyPrinter().writeValueAsString(payloadObject);
            Log.info("Payload: \n" + json);
        }
    }

    @SneakyThrows
    private  void logRawResponse(Response response) {
        Log.info("Response: \n" + response.getBody().asPrettyString());
    }

    @SneakyThrows
    private <T> void logResponse(T responseObject) {
        val responseJson = new ObjectMappingProvider().get().writerWithDefaultPrettyPrinter().writeValueAsString(responseObject);
        Log.info("Response: \n" + responseJson);
    }




}
