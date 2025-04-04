package com.leokenzley.templatesecapi.core.usecase.users.implementation;

import com.leokenzley.templatesecapi.core.dataprovider.GetAllUsersDataProvider;
import com.leokenzley.templatesecapi.core.domain.UserDomain;
import com.leokenzley.templatesecapi.core.usecase.users.GetAllUsersUseCase;
import java.util.List;

/**
 * This class implements the use case for retrieving all users.
 * It is part of the core use case layer of the application.
 * The implementation details are not provided in this snippet.
 */
public class GetAllUserUseCaseImpl implements GetAllUsersUseCase {
  private final GetAllUsersDataProvider getAllUsersDataProvider;

  /**
   * Constructor for GetAllUserUseCaseImpl.
   *
   * @param getAllUsersDataProvider the use case for retrieving all users
   */
  public GetAllUserUseCaseImpl(GetAllUsersDataProvider getAllUsersDataProvider) {
    this.getAllUsersDataProvider = getAllUsersDataProvider;
  }

  /**
   * Executes the retrieval of all users and returns a list of UserDomain objects.
   *
   * @return a list of UserDomain objects representing all users
   */
  @Override
  public List<UserDomain> execute() {
    return getAllUsersDataProvider.get();
  }
}
