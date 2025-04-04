package com.leokenzley.templatesecapi.core.usecase.users.implementation;

import com.leokenzley.templatesecapi.core.dataprovider.CreateUserDataProvider;
import com.leokenzley.templatesecapi.core.domain.UserDomain;
import com.leokenzley.templatesecapi.core.usecase.users.CreateUserUseCase;

/**
 * Implementation of the CreateUserUseCase interface.
 */
public class CreateUserUseCaseImpl implements CreateUserUseCase {
  private final CreateUserDataProvider createUserDataProvider;

  /**
   * Constructor for CreateUserUseCaseImpl.
   *
   * @param createUserDataProvider the data provider for creating users
   */
  public CreateUserUseCaseImpl(CreateUserDataProvider createUserDataProvider) {
    this.createUserDataProvider = createUserDataProvider;
  }

  @Override
  public void execute(UserDomain userDomain) {
    createUserDataProvider.execute(userDomain);
  }
}
