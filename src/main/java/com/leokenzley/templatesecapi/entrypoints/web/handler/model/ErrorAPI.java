package com.leokenzley.templatesecapi.entrypoints.web.handler.model;

import lombok.Data;

import java.util.List;

/**
 * Error model for API errors response.
 */
@Data
public class ErrorAPI {
  private String title;
  private Integer httpStatus;
  private List<String> erros;
}
