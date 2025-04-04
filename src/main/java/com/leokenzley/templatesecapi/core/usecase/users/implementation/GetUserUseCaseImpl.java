package com.leokenzley.templatesecapi.core.usecase.users.implementation;

import com.leokenzley.templatesecapi.core.dataprovider.GetUserDataProvider;
import com.leokenzley.templatesecapi.core.domain.UserDomain;
import com.leokenzley.templatesecapi.core.usecase.users.GetUserUserCase;

/**
 * This class implements the use case for retrieving a user.
 * It is part of the core use case layer of the application.
 * The implementation details are not provided in this snippet.
 */
public class GetUserUseCaseImpl implements GetUserUserCase {
  private final GetUserDataProvider getUserDataProvider;

  /**
   * Constructor for GetUserUseCaseImpl.
   *
   * @param getUserDataProvider the data provider for retrieving users
   */
  public GetUserUseCaseImpl(GetUserDataProvider getUserDataProvider) {
    this.getUserDataProvider = getUserDataProvider;
  }

  /**
   * Executes the retrieval of a user by ID and returns a UserDomain object.
   *
   * @param id the ID of the user to be retrieved
   * @return a UserDomain object representing the retrieved user
   */
  @Override
  public UserDomain execute(Long id) {
    return getUserDataProvider.get(id);
  }
}
