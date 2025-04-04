package com.leokenzley.templatesecapi.entrypoints.web.handler.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ErrorAPITest {

    @Test
    public void testErrorAPISettersAndGetters() {
        // Cria uma instância de ErrorAPI
        ErrorAPI errorAPI = new ErrorAPI();

        // Define os valores dos campos
        String title = "Erro de Validação";
        Integer httpStatus = 400;
        List<String> erros = List.of("Campo obrigatório", "Formato inválido");

        errorAPI.setTitle(title);
        errorAPI.setHttpStatus(httpStatus);
        errorAPI.setErros(erros);

        // Verifica se os getters estão retornando os valores corretos
        assertEquals(title, errorAPI.getTitle());
        assertEquals(httpStatus, errorAPI.getHttpStatus());
        assertEquals(erros, errorAPI.getErros());

        // Verifica se a instância não é nula
        assertNotNull(errorAPI);
    }

    @Test
    public void testErrorAPIConstructor() {
        // Cria uma instância de ErrorAPI usando o construtor padrão
        ErrorAPI errorAPI = new ErrorAPI();

        // Verifica se a instância não é nula
        assertNotNull(errorAPI);
    }

    @Test
    public void testErrorAPIToString() {
        // Cria uma instância de ErrorAPI
        ErrorAPI errorAPI = new ErrorAPI();

        // Define os valores dos campos
        String title = "Erro de Validação";
        Integer httpStatus = 400;
        List<String> erros = List.of("Campo obrigatório", "Formato inválido");

        errorAPI.setTitle(title);
        errorAPI.setHttpStatus(httpStatus);
        errorAPI.setErros(erros);

        // Verifica se o método toString não retorna nulo
        assertNotNull(errorAPI.toString());
    }

    @Test
    public void testErrorAPIEqualsAndHashCode() {
        // Cria duas instâncias de ErrorAPI com os mesmos valores
        ErrorAPI errorAPI1 = new ErrorAPI();
        ErrorAPI errorAPI2 = new ErrorAPI();

        String title = "Erro de Validação";
        Integer httpStatus = 400;
        List<String> erros = List.of("Campo obrigatório", "Formato inválido");

        errorAPI1.setTitle(title);
        errorAPI1.setHttpStatus(httpStatus);
        errorAPI1.setErros(erros);

        errorAPI2.setTitle(title);
        errorAPI2.setHttpStatus(httpStatus);
        errorAPI2.setErros(erros);

        // Verifica se as instâncias são iguais
        assertEquals(errorAPI1, errorAPI2);
        assertEquals(errorAPI1.hashCode(), errorAPI2.hashCode());
    }
}