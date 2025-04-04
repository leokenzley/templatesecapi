package com.leokenzley.templatesecapi.dataprovider;

        import com.leokenzley.templatesecapi.core.domain.UserDomain;
        import com.leokenzley.templatesecapi.dataprovider.database.entity.UserEntity;
        import com.leokenzley.templatesecapi.dataprovider.database.repository.UserRepository;
        import com.leokenzley.templatesecapi.dataprovider.database.repository.mapper.UserMapper;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.mockito.Mockito;

        import java.lang.reflect.Field;
        import java.util.Arrays;
        import java.util.List;

        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.mockito.Mockito.when;

        public class GetAllUsersDataProviderImplTest {

            private UserRepository userRepository;
            private UserMapper userMapper;
            private GetAllUsersDataProviderImpl getAllUsersDataProvider;

            @BeforeEach
            public void setUp() {
                userRepository = Mockito.mock(UserRepository.class);
                userMapper = Mockito.mock(UserMapper.class);
                getAllUsersDataProvider = new GetAllUsersDataProviderImpl();

                setPrivateField(getAllUsersDataProvider, "userRepository", userRepository);
                setPrivateField(getAllUsersDataProvider, "mapper", userMapper);
            }

            private void setPrivateField(Object target, String fieldName, Object value) {
                try {
                    Field field = target.getClass().getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(target, value);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            @Test
            public void testGet() {
                UserEntity userEntity1 = new UserEntity();
                userEntity1.setId(1L);
                userEntity1.setName("John Doe");
                userEntity1.setEmail("john.doe@example.com");
                userEntity1.setCpf("123.456.789-00");

                UserEntity userEntity2 = new UserEntity();
                userEntity2.setId(2L);
                userEntity2.setName("Jane Doe");
                userEntity2.setEmail("jane.doe@example.com");
                userEntity2.setCpf("987.654.321-00");

                List<UserEntity> userEntities = Arrays.asList(userEntity1, userEntity2);

                when(userRepository.findAll()).thenReturn(userEntities);
                when(userMapper.toDomain(userEntity1)).thenReturn(new UserDomain(1L, "John Doe", "john.doe@example.com", "123.456.789-00"));
                when(userMapper.toDomain(userEntity2)).thenReturn(new UserDomain(2L, "Jane Doe", "jane.doe@example.com", "987.654.321-00"));

                List<UserDomain> users = getAllUsersDataProvider.get();

                assertEquals(2, users.size());
                assertEquals("John Doe", users.get(0).getName());
                assertEquals("Jane Doe", users.get(1).getName());
            }
        }