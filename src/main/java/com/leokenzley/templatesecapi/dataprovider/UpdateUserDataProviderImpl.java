package com.leokenzley.templatesecapi.dataprovider;

import com.leokenzley.templatesecapi.core.dataprovider.UpdateUserDataProvider;
import com.leokenzley.templatesecapi.core.domain.UserDomain;
import com.leokenzley.templatesecapi.dataprovider.database.repository.UserRepository;
import com.leokenzley.templatesecapi.dataprovider.database.repository.mapper.UserMapper;
import com.leokenzley.templatesecapi.dataprovider.handler.exception.DataProviderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementation of the UpdateUserDataProvider interface.
 */
@Repository
public class UpdateUserDataProviderImpl implements UpdateUserDataProvider {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserMapper userMapper;

  @Override
  public void execute(Long id, UserDomain userDomain) {
    var entity = userRepository.findById(id).orElseThrow(
        () -> new DataProviderNotFoundException("Usuário não encontrado"));
    userDomain.setId(id);
    userRepository.save(userMapper.toEntity(userDomain));
  }
}
