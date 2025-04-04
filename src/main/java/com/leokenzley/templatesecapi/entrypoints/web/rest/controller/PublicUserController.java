package com.leokenzley.templatesecapi.entrypoints.web.rest.controller;

import com.leokenzley.templatesecapi.api.PublicApi;
import com.leokenzley.templatesecapi.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublicUserController implements PublicApi {
  /**
   * GET /public/users : Get all public users.
   * Get all public users.
   *
   * @return successful operation (status code 200)
   */
  @Override
  public ResponseEntity<List<UserResponse>> getAllPublicUsers() {
    return ResponseEntity.ok(null);
  }

  /**
   * GET /public/users/{id} : Get public user by user id.
   * Get public user detail based on id.
   *
   * @param id The id that needs to be fetched. Use user1 for testing (required)
   * @return successful operation (status code 200)
   * or Invalid username supplied (status code 400)
   * or User not found (status code 404)
   * or Unexpected error (status code 200)
   */
  @Override
  public ResponseEntity<UserResponse> getPublicUserById(Integer id) {
    return ResponseEntity.ok(null);
  }
}
