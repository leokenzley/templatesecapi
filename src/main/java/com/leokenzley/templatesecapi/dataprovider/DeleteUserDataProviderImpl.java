package com.leokenzley.templatesecapi.dataprovider;

import com.leokenzley.templatesecapi.core.dataprovider.DeleteUserDataProvider;
import com.leokenzley.templatesecapi.dataprovider.database.repository.UserRepository;
import com.leokenzley.templatesecapi.dataprovider.handler.exception.DataProviderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementation of the DeleteUserDataProvider interface.
 * This class is responsible for deleting user data.
 */
@Component
public class DeleteUserDataProviderImpl implements DeleteUserDataProvider {
  @Autowired
  private UserRepository userRepository;

  /**
   * Deletes a user by ID.
   *
   * @param id the ID of the user to delete
   */
  @Override
  public void execute(Long id) {
    var userEntity = userRepository.findById(id)
        .orElseThrow(() -> new DataProviderNotFoundException("Usuário não encontrado"));
    userRepository.delete(userEntity);
  }
}
