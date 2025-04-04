package com.leokenzley.templatesecapi.dataprovider;

    import com.leokenzley.templatesecapi.core.domain.UserDomain;
    import com.leokenzley.templatesecapi.dataprovider.database.entity.UserEntity;
    import com.leokenzley.templatesecapi.dataprovider.database.repository.UserRepository;
    import com.leokenzley.templatesecapi.dataprovider.database.repository.mapper.UserMapper;
    import com.leokenzley.templatesecapi.dataprovider.handler.exception.DataProviderNotFoundException;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    import org.mockito.Mockito;

    import java.util.Optional;

    import static org.junit.jupiter.api.Assertions.assertThrows;
    import static org.mockito.Mockito.verify;
    import static org.mockito.Mockito.when;

    public class UpdateUserDataProviderImplTest {

        private UserRepository userRepository;
        private UserMapper userMapper;
        private UpdateUserDataProviderImpl updateUserDataProvider;

        @BeforeEach
        public void setUp() {
            userRepository = Mockito.mock(UserRepository.class);
            userMapper = Mockito.mock(UserMapper.class);
            updateUserDataProvider = new UpdateUserDataProviderImpl();

            setPrivateField(updateUserDataProvider, "userRepository", userRepository);
            setPrivateField(updateUserDataProvider, "userMapper", userMapper);
        }

        private void setPrivateField(Object target, String fieldName, Object value) {
            try {
                java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(target, value);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Test
        public void testExecute_UserExists() {
            Long userId = 1L;
            UserDomain userDomain = new UserDomain(userId, "John Doe", "john.doe@example.com", "123.456.789-00");
            UserEntity userEntity = new UserEntity();
            userEntity.setId(userId);

            when(userRepository.findById(userId)).thenReturn(Optional.of(userEntity));
            when(userMapper.toEntity(userDomain)).thenReturn(userEntity);

            updateUserDataProvider.execute(userId, userDomain);

            verify(userRepository).save(userEntity);
        }

        @Test
        public void testExecute_UserNotFound() {
            Long userId = 1L;
            UserDomain userDomain = new UserDomain(userId, "John Doe", "john.doe@example.com", "123.456.789-00");

            when(userRepository.findById(userId)).thenReturn(Optional.empty());

            assertThrows(DataProviderNotFoundException.class, () -> updateUserDataProvider.execute(userId, userDomain));
        }
    }