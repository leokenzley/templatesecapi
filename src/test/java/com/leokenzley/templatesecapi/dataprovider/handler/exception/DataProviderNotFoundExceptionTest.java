package com.leokenzley.templatesecapi.dataprovider.handler.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DataProviderNotFoundExceptionTest {

    @Test
    public void testExceptionMessage() {
        String message = "Data provider not found";
        DataProviderNotFoundException exception = assertThrows(DataProviderNotFoundException.class, () -> {
            throw new DataProviderNotFoundException(message);
        });

        assertEquals(message, exception.getMessage());
    }

    @Test
    public void testExceptionWithoutMessage() {
        DataProviderNotFoundException exception = new DataProviderNotFoundException(null);
        assertEquals(null, exception.getMessage());
    }
}