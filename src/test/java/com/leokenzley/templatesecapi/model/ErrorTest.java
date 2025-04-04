package com.leokenzley.templatesecapi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ErrorTest {

    @Test
    public void testConstructorAndGetters() {
        String code = "404";
        String message = "Not Found";

        Error error = new Error(code, message);

        assertEquals(code, error.getCode());
        assertEquals(message, error.getMessage());
    }

    @Test
    public void testSetters() {
        String code = "500";
        String message = "Internal Server Error";

        Error error = new Error();
        error.setCode(code);
        error.setMessage(message);

        assertEquals(code, error.getCode());
        assertEquals(message, error.getMessage());
    }

    @Test
    public void testEqualsAndHashCode() {
        String code = "400";
        String message = "Bad Request";

        Error error1 = new Error(code, message);
        Error error2 = new Error(code, message);

        assertEquals(error1, error2);
        assertEquals(error1.hashCode(), error2.hashCode());
    }

    @Test
    public void testNotEquals() {
        String code1 = "400";
        String message1 = "Bad Request";
        String code2 = "401";
        String message2 = "Unauthorized";

        Error error1 = new Error(code1, message1);
        Error error2 = new Error(code2, message2);

        assertNotEquals(error1, error2);
    }

    @Test
    public void testToString() {
        String code = "403";
        String message = "Forbidden";

        Error error = new Error(code, message);
        String expectedString = "class Error {\n" +
                "    code: " + code + "\n" +
                "    message: " + message + "\n" +
                "}";

        assertEquals(expectedString, error.toString());
    }
}