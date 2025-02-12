package com.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class GetRequestTest {

    @Test
    public void testGetRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        Response response = RestAssured
                .given()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .extract()
                .response();

        System.out.println(response.asString());
    }
}