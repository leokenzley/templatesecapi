package com.leokenzley.templatesecapi.core.usecase.users.implementation;

import com.leokenzley.templatesecapi.core.dataprovider.DeleteUserDataProvider;
import com.leokenzley.templatesecapi.core.dataprovider.GetUserDataProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class DeleteUserUseCaseImplTest {

    private DeleteUserDataProvider deleteUserDataProvider;
    private GetUserDataProvider getUserDataProvider;
    private DeleteUserUseCaseImpl deleteUserUseCase;

    @BeforeEach
    public void setUp() {
        deleteUserDataProvider = Mockito.mock(DeleteUserDataProvider.class);
        getUserDataProvider = Mockito.mock(GetUserDataProvider.class);
        deleteUserUseCase = new DeleteUserUseCaseImpl(deleteUserDataProvider, getUserDataProvider);
    }

    @Test
    public void testExecute() {
        Long userId = 1L;

        deleteUserUseCase.execute(userId);

        verify(deleteUserDataProvider, times(1)).execute(userId);
    }
}