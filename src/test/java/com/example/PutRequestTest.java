package com.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class PutRequestTest {

    @Test
    public void testPutRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        String requestBody = "{\"name\": \"Jane\", \"age\": 25}";

        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("json.name", equalTo("Jane"))
                .body("json.age", equalTo(25))
                .extract()
                .response();

        System.out.println(response.asString());
    }
}