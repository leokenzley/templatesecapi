package com.leokenzley.templatesecapi.core.usecase.users.implementation;

import com.leokenzley.templatesecapi.core.dataprovider.GetAllUsersDataProvider;
import com.leokenzley.templatesecapi.core.domain.UserDomain;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GetAllUserUseCaseImplTest {

    private GetAllUsersDataProvider getAllUsersDataProvider;
    private GetAllUserUseCaseImpl getAllUserUseCase;

    @BeforeEach
    public void setUp() {
        getAllUsersDataProvider = Mockito.mock(GetAllUsersDataProvider.class);
        getAllUserUseCase = new GetAllUserUseCaseImpl(getAllUsersDataProvider);
    }

    @Test
    public void testExecute() {
        UserDomain user1 = Instancio.create(UserDomain.class);
        UserDomain user2 =  Instancio.create(UserDomain.class);
        List<UserDomain> expectedUsers = Arrays.asList(user1, user2);

        when(getAllUsersDataProvider.get()).thenReturn(expectedUsers);

        List<UserDomain> actualUsers = getAllUserUseCase.execute();

        assertEquals(expectedUsers, actualUsers);
    }
}