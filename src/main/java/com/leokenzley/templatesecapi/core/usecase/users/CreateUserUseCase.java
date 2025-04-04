package com.leokenzley.templatesecapi.core.usecase.users;

import com.leokenzley.templatesecapi.core.domain.UserDomain;

/**
 * CreateUserUseCase interface defines the contract for creating a user.
 * It provides a method to execute the creation of a user with the given UserDomain object.
 */
public interface CreateUserUseCase {
  /**
   * Executes the creation of a user with the given UserDomain object.
   *
   * @param userDomain the UserDomain object representing the user to be created
   */
  void execute(UserDomain userDomain);
}
