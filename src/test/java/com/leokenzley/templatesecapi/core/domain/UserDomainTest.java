package com.leokenzley.templatesecapi.core.domain;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserDomainTest {

  @Test
  public void testUserDomain() {
    // Gerar uma instância de UserDomain usando o Instancio
    UserDomain user = Instancio.create(UserDomain.class);

    // Verificar se os getters e setters estão funcionando corretamente
    Long id = 1L;
    String name = "John Doe";
    String email = "john.doe@example.com";
    String cpf = "123.456.789-00";

    user.setId(id);
    user.setName(name);
    user.setEmail(email);
    user.setCpf(cpf);

    assertEquals(id, user.getId());
    assertEquals(name, user.getName());
    assertEquals(email, user.getEmail());
    assertEquals(cpf, user.getCpf());
  }

  @Test
  public void testUserDomainConstructor() {
    Long id = 1L;
    String name = "John Doe";
    String email = "john.doe@example.com";
    String cpf = "12345678901";

    UserDomain user = new UserDomain(id, name, email, cpf);

    assertNotNull(user);
    assertEquals(id, user.getId());
    assertEquals(name, user.getName());
    assertEquals(email, user.getEmail());
    assertEquals(cpf, user.getCpf());
  }
}