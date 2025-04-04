package com.leokenzley.templatesecapi.entrypoints.web.handler;

import com.leokenzley.templatesecapi.entrypoints.web.handler.model.ErrorAPI;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Exception handler for web layer.
 */
@ControllerAdvice
public class WebExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
      errors.put(error.getField(), error.getDefaultMessage());
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
  }

  /**
   * Captura exceções de validação de RequestParam
   *
   * @param ex ConstraintViolationException
   * @return ResponseEntity com os erros de validação
   */
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorAPI> handleConstraintViolationException(ConstraintViolationException ex) {
    var apiErrors = new ErrorAPI();
    apiErrors.setTitle("Erro de Validação");
    apiErrors.setHttpStatus(HttpStatus.BAD_REQUEST.value());
    apiErrors.setErros(ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrors);
  }

  /**
   * @param ex
   * @return
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleGenericException(Exception ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro inesperado. Tente novamente mais tarde.");
  }
}
