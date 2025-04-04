package com.leokenzley.templatesecapi.entrypoints.web.rest.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.greaterThan;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntTest {
  @LocalServerPort
  private int port;

  @BeforeEach
  public void setUp() {
    RestAssured.port = port;
  }

  @Test
  public void testAddUser() {
    String userRequestJson = """
            {
                "name": "John Doe",
                "email": "john.doe@example.com",
                "cpf": "123.456.789-00"
            }
        """;

    given()
      .contentType(ContentType.JSON)
      .body(userRequestJson)
      .when()
      .post("/users")
      .then()
      .statusCode(HttpStatus.NO_CONTENT.value());
  }

  @Test
  public void testGetAllUsers() {
    Response response = given()
      .contentType(ContentType.JSON)
      .when()
      .get("/users")
      .then()
      .statusCode(HttpStatus.OK.value())
      .extract().response();

    // Verifique a resposta conforme necessário
    // Exemplo: Verifique se a lista de usuários não está vazia
    response.then().body("size()", greaterThan(0)); // Ajuste conforme necessário
  }

  @Test
  public void testDeleteUserById() {
    int userId = 1;

    given()
      .contentType(ContentType.JSON)
      .when()
      .delete("/users/{id}", userId)
      .then()
      .statusCode(HttpStatus.NO_CONTENT.value());
  }
}
