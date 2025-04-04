package com.leokenzley.templatesecapi.core.dataprovider;

import com.leokenzley.templatesecapi.core.domain.UserDomain;

/**
 * Interface for getting a user data provider.
 * This interface defines the method for retrieving a user by ID.
 */
public interface GetUserDataProvider { UserDomain get(Long id); }
