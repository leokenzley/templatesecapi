package com.leokenzley.templatesecapi.core.usecase.users.implementation;

import com.leokenzley.templatesecapi.core.dataprovider.GetUserDataProvider;
import com.leokenzley.templatesecapi.core.dataprovider.UpdateUserDataProvider;
import com.leokenzley.templatesecapi.core.domain.UserDomain;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class UpdateUserUseCaseImplTest {

    private GetUserDataProvider getUserDataProvider;
    private UpdateUserDataProvider updateUserDataProvider;
    private UpdateUserUseCaseImpl updateUserUseCase;

    @BeforeEach
    public void setUp() {
        getUserDataProvider = Mockito.mock(GetUserDataProvider.class);
        updateUserDataProvider = Mockito.mock(UpdateUserDataProvider.class);
        updateUserUseCase = new UpdateUserUseCaseImpl(getUserDataProvider, updateUserDataProvider);
    }

    @Test
    public void testExecute() {
        Long userId = 1L;
        UserDomain user = Instancio.create(UserDomain.class);

        updateUserUseCase.execute(userId, user);

        verify(updateUserDataProvider, times(1)).execute(userId, user);
    }
}