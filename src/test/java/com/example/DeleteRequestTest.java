package com.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class DeleteRequestTest {

    @Test
    public void testDeleteRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        Response response = RestAssured
                .given()
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("url", equalTo("https://postman-echo.com/delete"))
                .extract()
                .response();

        System.out.println(response.asString());
    }
}