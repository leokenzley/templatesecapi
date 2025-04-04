package com.leokenzley.templatesecapi.dataprovider.database.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserEntityTest {

    @Test
    public void testUserEntityGettersAndSetters() {
        UserEntity user = new UserEntity();

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
    public void testUserEntityConstructor() {
        Long id = 1L;
        String name = "John Doe";
        String email = "john.doe@example.com";
        String cpf = "123.456.789-00";

        UserEntity user = new UserEntity();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setCpf(cpf);

        assertNotNull(user);
        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
        assertEquals(cpf, user.getCpf());
    }
}