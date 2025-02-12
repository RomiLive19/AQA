package com.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;

public class PostRequestTest {

    @Test
    public void testPostRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        String requestBody = "{\"name\": \"John\", \"age\": 30}";

        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("json.name", equalTo("John"))
                .body("json.age", equalTo(30))
                .extract()
                .response();

        System.out.println(response.asString());
    }
}