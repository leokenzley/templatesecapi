package com.leokenzley.templatesecapi.dataprovider;

    import com.leokenzley.templatesecapi.dataprovider.database.repository.UserRepository;
    import com.leokenzley.templatesecapi.dataprovider.database.entity.UserEntity;
    import com.leokenzley.templatesecapi.dataprovider.handler.exception.DataProviderNotFoundException;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    import org.mockito.Mockito;

    import java.lang.reflect.Field;
    import java.util.Optional;

    import static org.junit.jupiter.api.Assertions.assertThrows;
    import static org.mockito.Mockito.verify;
    import static org.mockito.Mockito.when;

    public class DeleteUserDataProviderImplTest {

        private UserRepository userRepository;
        private DeleteUserDataProviderImpl deleteUserDataProvider;

        @BeforeEach
        public void setUp() throws Exception {
            userRepository = Mockito.mock(UserRepository.class);
            deleteUserDataProvider = new DeleteUserDataProviderImpl();
            setPrivateField(deleteUserDataProvider, "userRepository", userRepository);
        }

        private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
            Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        }

        @Test
        public void testExecute_UserExists() {
            Long userId = 1L;
            UserEntity userEntity = new UserEntity();
            userEntity.setId(userId);

            when(userRepository.findById(userId)).thenReturn(Optional.of(userEntity));

            deleteUserDataProvider.execute(userId);

            verify(userRepository).delete(userEntity);
        }

        @Test
        public void testExecute_UserNotFound() {
            Long userId = 1L;

            when(userRepository.findById(userId)).thenReturn(Optional.empty());

            assertThrows(DataProviderNotFoundException.class, () -> deleteUserDataProvider.execute(userId));
        }
    }