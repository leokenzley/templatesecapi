package com.leokenzley.templatesecapi.dataprovider.handler;

    import com.leokenzley.templatesecapi.dataprovider.handler.exception.DataProviderNotFoundException;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ProblemDetail;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.context.request.WebRequest;

    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.mockito.Mockito.mock;

    public class DataProviderExceptionHandlerTest {

        private DataProviderExceptionHandler exceptionHandler;

        @BeforeEach
        public void setUp() {
            exceptionHandler = new DataProviderExceptionHandler();
        }

        @Test
        public void testHandleGenericNotFoundException() {
            String errorMessage = "Data provider not found";
            DataProviderNotFoundException exception = new DataProviderNotFoundException(errorMessage);
            WebRequest request = mock(WebRequest.class);

            ResponseEntity<ProblemDetail> response = exceptionHandler.handleGenericNotFoundException(exception, request);

            assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
            assertEquals(errorMessage, response.getBody().getDetail());
        }
    }