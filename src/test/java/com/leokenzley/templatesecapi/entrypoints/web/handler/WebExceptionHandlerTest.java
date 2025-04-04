package com.leokenzley.templatesecapi.entrypoints.web.handler;

  import com.leokenzley.templatesecapi.entrypoints.web.handler.model.ErrorAPI;
  import jakarta.validation.ConstraintViolation;
  import jakarta.validation.ConstraintViolationException;
  import org.junit.jupiter.api.BeforeEach;
  import org.junit.jupiter.api.Test;
  import org.mockito.Mockito;
  import org.springframework.http.HttpStatus;
  import org.springframework.http.ResponseEntity;
  import org.springframework.validation.BindException;
  import org.springframework.validation.BindingResult;
  import org.springframework.validation.FieldError;
  import org.springframework.web.bind.MethodArgumentNotValidException;

  import java.util.HashMap;
  import java.util.List;
  import java.util.Map;
  import java.util.Set;

  import static org.junit.jupiter.api.Assertions.assertEquals;
  import static org.mockito.Mockito.mock;

  public class WebExceptionHandlerTest {

      private WebExceptionHandler webExceptionHandler;

      @BeforeEach
      public void setUp() {
          webExceptionHandler = new WebExceptionHandler();
      }

      @Test
      public void testHandleValidationException() {
          BindingResult bindingResult = new BindException(new Object(), "objectName");
          FieldError fieldError = new FieldError("objectName", "field", "defaultMessage");
          bindingResult.addError(fieldError);
          MethodArgumentNotValidException ex = new MethodArgumentNotValidException(null, bindingResult);

          ResponseEntity<Map<String, String>> response = webExceptionHandler.handleValidationException(ex);

          Map<String, String> expectedErrors = new HashMap<>();
          expectedErrors.put("field", "defaultMessage");

          assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
          assertEquals(expectedErrors, response.getBody());
      }

      @Test
      public void testHandleConstraintViolationException() {
          ConstraintViolation<?> violation = mock(ConstraintViolation.class);
          Mockito.when(violation.getMessage()).thenReturn("violation message");
          ConstraintViolationException ex = new ConstraintViolationException(Set.of(violation));

          ResponseEntity<ErrorAPI> response = webExceptionHandler.handleConstraintViolationException(ex);

          ErrorAPI expectedErrorAPI = new ErrorAPI();
          expectedErrorAPI.setTitle("Erro de Validação");
          expectedErrorAPI.setHttpStatus(HttpStatus.BAD_REQUEST.value());
          expectedErrorAPI.setErros(List.of("violation message"));

          assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
          assertEquals(expectedErrorAPI, response.getBody());
      }

      @Test
      public void testHandleGenericException() {
          Exception ex = new Exception("Generic error");

          ResponseEntity<String> response = webExceptionHandler.handleGenericException(ex);

          assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
          assertEquals("Ocorreu um erro inesperado. Tente novamente mais tarde.", response.getBody());
      }
  }