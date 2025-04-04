package com.leokenzley.templatesecapi.core.usecase.users;

import com.leokenzley.templatesecapi.core.domain.UserDomain;

import java.util.List;

/**
 * GetAllUsersUseCase interface defines the contract for retrieving all users.
 * It provides a method to execute the retrieval of all users and return a list of UserDomain objects.
 */
public interface GetAllUsersUseCase {
  /**
   * Executes the retrieval of all users and returns a list of UserDomain objects.
   *
   * @return a list of UserDomain objects representing all users
   */
  List<UserDomain> execute();
}
