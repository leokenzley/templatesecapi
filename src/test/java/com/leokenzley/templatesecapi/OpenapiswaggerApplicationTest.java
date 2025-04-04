package com.leokenzley.templatesecapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class OpenapiswaggerApplicationTest {

  @Test
  public void testMain() {
    // Simula a execução do método main
    String[] args = {};
    ConfigurableApplicationContext context = SpringApplication.run(OpenapiswaggerApplication.class, args);
    assertNotNull(context, "O contexto da aplicação não deve ser nulo");
    context.close();
  }
}