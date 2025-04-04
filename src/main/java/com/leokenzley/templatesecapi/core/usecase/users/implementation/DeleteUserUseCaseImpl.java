package com.leokenzley.templatesecapi.core.usecase.users.implementation;

import com.leokenzley.templatesecapi.core.dataprovider.DeleteUserDataProvider;
import com.leokenzley.templatesecapi.core.dataprovider.GetUserDataProvider;
import com.leokenzley.templatesecapi.core.usecase.users.DeleteUserUseCase;

/**
 * Implementation of the DeleteUserUseCase interface.
 */
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {
  private final DeleteUserDataProvider deleteUserDataProvider;
  private final GetUserDataProvider getUserDataProvider;
  /**
   * Constructor for DeleteUserUseCaseImpl.
   *
   * @param deleteUserDataProvider the data provider for deleting users
   */
  public DeleteUserUseCaseImpl(
    DeleteUserDataProvider deleteUserDataProvider,
    GetUserDataProvider getUserDataProvider) {
    this.getUserDataProvider = getUserDataProvider;
    this.deleteUserDataProvider = deleteUserDataProvider;
  }


  @Override
  public void execute(Long id) {
    deleteUserDataProvider.execute(id);
  }
}
