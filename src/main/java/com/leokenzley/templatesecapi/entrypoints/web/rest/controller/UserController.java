package com.leokenzley.templatesecapi.entrypoints.web.rest.controller;

import com.leokenzley.templatesecapi.api.UsersApi;
import com.leokenzley.templatesecapi.application.mapper.UserApplicationMapper;
import com.leokenzley.templatesecapi.core.usecase.users.*;
import com.leokenzley.templatesecapi.model.UserRequest;
import com.leokenzley.templatesecapi.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserController
 *
 * @author leokenzley
 * @date 2023/10/12
 */
@RestController
public class UserController implements UsersApi {

  private final CreateUserUseCase createUserUseCase;
  private final UpdateUserUseCase updateUserUseCase;
  private final GetAllUsersUseCase getAllUsersUseCase;
  private final GetUserUserCase getUserUserCase;
  private final DeleteUserUseCase deleteUserUseCase;
  private final UserApplicationMapper mapper;

  public UserController(
      CreateUserUseCase createUserUseCase,
      UpdateUserUseCase updateUserUseCase,
      GetAllUsersUseCase getAllUsersUseCase,
      GetUserUserCase getUserUserCase,
      DeleteUserUseCase deleteUserUseCase,
      UserApplicationMapper mapper) {
    this.createUserUseCase = createUserUseCase;
    this.updateUserUseCase = updateUserUseCase;
    this.getAllUsersUseCase = getAllUsersUseCase;
    this.getUserUserCase = getUserUserCase;
    this.deleteUserUseCase = deleteUserUseCase;
    this.mapper = mapper;
  }

  @Override
  public ResponseEntity<UserResponse> addUser(UserRequest userRequest) {
    createUserUseCase.execute(mapper.toDomain(userRequest));
    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity<Void> deleteUserById(Integer id) {
    deleteUserUseCase.execute(Long.valueOf(id));
    return ResponseEntity.noContent().build();
  }

  /**
   * GET /users : Get all users.
   * Get all users.
   *
   * @return successful operation (status code 200)
   */
  @Override
  public ResponseEntity<List<UserResponse>> getAllUsers() {
    return ResponseEntity.ok(getAllUsersUseCase.execute().stream().map(mapper::toResponse).toList());
  }

  @Override
  public ResponseEntity<UserResponse> getUserById(Integer id) {
    return ResponseEntity.ok(mapper.toResponse(getUserUserCase.execute(Long.valueOf(id))));
  }

  @Override
  public ResponseEntity<UserResponse> updateUser(Integer id, UserRequest userRequest) {
    updateUserUseCase.execute(Long.valueOf(id), mapper.toDomain(userRequest));
    return ResponseEntity.noContent().build();
  }


}
