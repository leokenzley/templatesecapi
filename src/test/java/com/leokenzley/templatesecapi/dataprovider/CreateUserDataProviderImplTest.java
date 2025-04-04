package com.leokenzley.templatesecapi.dataprovider;

import com.leokenzley.templatesecapi.core.domain.UserDomain;
import com.leokenzley.templatesecapi.dataprovider.database.entity.UserEntity;
import com.leokenzley.templatesecapi.dataprovider.database.repository.UserRepository;
import com.leokenzley.templatesecapi.dataprovider.database.repository.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CreateUserDataProviderImplTest {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private CreateUserDataProviderImpl createUserDataProvider;

    @BeforeEach
    public void setUp() throws Exception {
        userRepository = Mockito.mock(UserRepository.class);
        userMapper = Mockito.mock(UserMapper.class);
        createUserDataProvider = new CreateUserDataProviderImpl();

        setPrivateField(createUserDataProvider, "userRepository", userRepository);
        setPrivateField(createUserDataProvider, "userMapper", userMapper);
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    @Test
    public void testExecute() {
        UserDomain userDomain = new UserDomain();
        UserEntity userEntity = new UserEntity();

        when(userMapper.toEntity(userDomain)).thenReturn(userEntity);

        createUserDataProvider.execute(userDomain);

        verify(userRepository).save(userEntity);
    }
}