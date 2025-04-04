package com.leokenzley.templatesecapi.dataprovider.handler;

import com.leokenzley.templatesecapi.dataprovider.handler.exception.DataProviderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * Exception handler for data provider exceptions.
 */
@ControllerAdvice
public class DataProviderExceptionHandler {
  /**
   * Handle DataProviderNotFoundException.
   *
   * @param ex the exception
   * @param request the request
   * @return the response entity
   */
  @ExceptionHandler(DataProviderNotFoundException.class)
  public ResponseEntity<ProblemDetail> handleGenericNotFoundException(
        DataProviderNotFoundException ex,
        WebRequest request) {
    ProblemDetail problemDetail
        = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    return new ResponseEntity<>(problemDetail, HttpStatus.NOT_FOUND);
  }
}