package com.leokenzley.templatesecapi.core.usecase.users.implementation;

    import com.leokenzley.templatesecapi.core.dataprovider.CreateUserDataProvider;
    import com.leokenzley.templatesecapi.core.domain.UserDomain;
    import org.instancio.Instancio;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    import org.mockito.Mockito;

    import static org.mockito.Mockito.verify;
    import static org.mockito.Mockito.times;

    public class CreateUserUseCaseImplTest {

        private CreateUserDataProvider createUserDataProvider;
        private CreateUserUseCaseImpl createUserUseCase;

        @BeforeEach
        public void setUp() {
            createUserDataProvider = Mockito.mock(CreateUserDataProvider.class);
            createUserUseCase = new CreateUserUseCaseImpl(createUserDataProvider);
        }

        @Test
        public void testExecute() {
            UserDomain user = Instancio.create(UserDomain.class);

            createUserUseCase.execute(user);

            verify(createUserDataProvider, times(1)).execute(user);
        }
    }