package com.leokenzley.templatesecapi.core.usecase.users.implementation;

        import com.leokenzley.templatesecapi.core.dataprovider.GetUserDataProvider;
        import com.leokenzley.templatesecapi.core.domain.UserDomain;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.mockito.Mockito;

        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.mockito.Mockito.when;

        public class GetUserUseCaseImplTest {

            private GetUserDataProvider getUserDataProvider;
            private GetUserUseCaseImpl getUserUseCase;

            @BeforeEach
            public void setUp() {
                getUserDataProvider = Mockito.mock(GetUserDataProvider.class);
                getUserUseCase = new GetUserUseCaseImpl(getUserDataProvider);
            }

            @Test
            public void testExecute() {
                Long userId = 1L;
                UserDomain expectedUser = new UserDomain();
                expectedUser.setId(userId);

                when(getUserDataProvider.get(userId)).thenReturn(expectedUser);

                UserDomain actualUser = getUserUseCase.execute(userId);

                assertEquals(expectedUser, actualUser);
            }
        }