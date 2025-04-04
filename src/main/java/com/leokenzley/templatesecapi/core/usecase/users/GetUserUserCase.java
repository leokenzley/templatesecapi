package com.leokenzley.templatesecapi.core.usecase.users;

import com.leokenzley.templatesecapi.core.domain.UserDomain;

/**
 * GetUserUserCase interface defines the contract for retrieving a user by ID.
 * It provides a method to execute the retrieval of a user and return a UserDomain object.
 */
public interface GetUserUserCase {
  /**
   * Executes the retrieval of a user by ID and returns a UserDomain object.
   *
   * @param id the ID of the user to be retrieved
   * @return a UserDomain object representing the retrieved user
   */
  UserDomain execute(Long id);
}
