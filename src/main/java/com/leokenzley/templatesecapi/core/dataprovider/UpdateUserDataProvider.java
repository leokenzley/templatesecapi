package com.leokenzley.templatesecapi.core.dataprovider;

import com.leokenzley.templatesecapi.core.domain.UserDomain;

/**
 * Interface for updating a user data provider.
 * This interface defines the method for updating a user.
 */
public interface UpdateUserDataProvider { void execute(Long id, UserDomain userDomain); }
