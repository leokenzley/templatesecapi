package com.leokenzley.templatesecapi.entrypoints.web.rest.controller;

import com.leokenzley.templatesecapi.application.mapper.UserApplicationMapper;
import com.leokenzley.templatesecapi.core.domain.UserDomain;
import com.leokenzley.templatesecapi.core.usecase.users.*;
import com.leokenzley.templatesecapi.model.UserRequest;
import com.leokenzley.templatesecapi.model.UserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    private CreateUserUseCase createUserUseCase;
    private UpdateUserUseCase updateUserUseCase;
    private GetAllUsersUseCase getAllUsersUseCase;
    private GetUserUserCase getUserUserCase;
    private DeleteUserUseCase deleteUserUseCase;
    private UserApplicationMapper mapper;
    private UserController userController;

    @BeforeEach
    public void setUp() {
        createUserUseCase = Mockito.mock(CreateUserUseCase.class);
        updateUserUseCase = Mockito.mock(UpdateUserUseCase.class);
        getAllUsersUseCase = Mockito.mock(GetAllUsersUseCase.class);
        getUserUserCase = Mockito.mock(GetUserUserCase.class);
        deleteUserUseCase = Mockito.mock(DeleteUserUseCase.class);
        mapper = Mockito.mock(UserApplicationMapper.class);
        userController = new UserController(createUserUseCase, updateUserUseCase, getAllUsersUseCase, getUserUserCase, deleteUserUseCase, mapper);
    }

    @Test
    public void testAddUser() {
        UserRequest userRequest = new UserRequest();
        UserDomain userDomain = new UserDomain();
        when(mapper.toDomain(userRequest)).thenReturn(userDomain);

        ResponseEntity<UserResponse> response = userController.addUser(userRequest);

        verify(createUserUseCase).execute(userDomain);
        assertEquals(ResponseEntity.noContent().build(), response);
    }

    @Test
    public void testDeleteUserById() {
        ResponseEntity<Void> response = userController.deleteUserById(1);

        verify(deleteUserUseCase).execute(1L);
        assertEquals(ResponseEntity.noContent().build(), response);
    }

    @Test
    public void testGetAllUsers() {
        UserDomain userDomain = new UserDomain();
        UserResponse userResponse = new UserResponse();
        when(getAllUsersUseCase.execute()).thenReturn(List.of(userDomain));
        when(mapper.toResponse(userDomain)).thenReturn(userResponse);

        ResponseEntity<List<UserResponse>> response = userController.getAllUsers();

        assertEquals(ResponseEntity.ok(List.of(userResponse)), response);
    }

    @Test
    public void testGetUserById() {
        UserDomain userDomain = new UserDomain();
        UserResponse userResponse = new UserResponse();
        when(getUserUserCase.execute(1L)).thenReturn(userDomain);
        when(mapper.toResponse(userDomain)).thenReturn(userResponse);

        ResponseEntity<UserResponse> response = userController.getUserById(1);

        assertEquals(ResponseEntity.ok(userResponse), response);
    }

    @Test
    public void testUpdateUser() {
        UserRequest userRequest = new UserRequest();
        UserDomain userDomain = new UserDomain();
        when(mapper.toDomain(userRequest)).thenReturn(userDomain);

        ResponseEntity<UserResponse> response = userController.updateUser(1, userRequest);

        verify(updateUserUseCase).execute(1L, userDomain);
        assertEquals(ResponseEntity.noContent().build(), response);
    }
}