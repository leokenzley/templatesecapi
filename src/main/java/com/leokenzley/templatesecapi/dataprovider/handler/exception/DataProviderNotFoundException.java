package com.leokenzley.templatesecapi.dataprovider.handler.exception;

/**
 * Exception thrown when a data provider is not found.
 */
public class DataProviderNotFoundException extends RuntimeException {
  /**
   * Constructs a new DataProviderNotFoundException with the specified detail message.
   *
   * @param message the detail message
   */
  public DataProviderNotFoundException(String message) {
    super(message);
  }
}
